from pydantic import BaseModel, constr
from sqlalchemy import Column, Integer, String, Enum
from enum import Enum as PyEnum
from sqlalchemy.ext.declarative import declarative_base

Base = declarative_base()

class GameLevel(PyEnum):
    basic = "basic"
    intermediate = "intermediate"
    advanced = "advanced"

# Definición del modelo de usuario
class User(Base):
    __tablename__ = "users"

    id = Column(Integer, primary_key=True, index=True)
    username = Column(String, unique=True, index=True, nullable=False)
    password = Column(String, nullable=False)
    game_level = Column(Enum(GameLevel), nullable=False)

class UserResponse(BaseModel):
    id: int
    username: str
    game_level: GameLevel

    class Config:
        orm_mode = True  # Esto indica que puede ser usado con SQLAlchemy

class UserCreate(BaseModel):
    username: str = constr(max_length=50)
    password: str
    game_level: GameLevel
