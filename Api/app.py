# app.py

from fastapi import FastAPI
from src.db.db import Base, engine
from src.routes import users

# Crear las tablas en la base de datos
Base.metadata.create_all(bind=engine)

app = FastAPI()

# Incluir el router de usuarios
app.include_router(users.router)

@app.get('/')
def home():
    return {"message": "Welcome to the User API"}