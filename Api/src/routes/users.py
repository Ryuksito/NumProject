# src/routes/users.py

from fastapi import APIRouter, Depends, HTTPException, status
from sqlalchemy.orm import Session
from pydantic import BaseModel, Field
from src.db.db import get_db
from src.models.models import User, GameLevel

router = APIRouter()

class UserCreate(BaseModel):
    username: str = Field(..., max_length=50)
    password: str
    game_level: GameLevel

@router.post("/users/", response_model=UserCreate, status_code=status.HTTP_201_CREATED)
def create_user(user: UserCreate, db: Session = Depends(get_db)):
    db_user = db.query(User).filter(User.username == user.username).first()
    if db_user:
        raise HTTPException(status_code=400, detail="Username already registered")

    new_user = User(username=user.username, password=user.password, game_level=user.game_level)
    db.add(new_user)
    db.commit()
    db.refresh(new_user)
    return new_user

@router.put("/users/{username}/game_level", response_model=UserCreate)
def update_game_level(username: str, game_level: GameLevel, db: Session = Depends(get_db)):
    db_user = db.query(User).filter(User.username == username).first()
    if db_user is None:
        raise HTTPException(status_code=404, detail="User not found")
    
    # Actualiza el nivel de juego
    db_user.game_level = game_level
    db.commit()
    db.refresh(db_user)
    
    return db_user

@router.get("/users/{username}", response_model=UserCreate)
def get_user(username: str, db: Session = Depends(get_db)):
    db_user = db.query(User).filter(User.username == username).first()
    if db_user is None:
        raise HTTPException(status_code=404, detail="User not found")
    return db_user
