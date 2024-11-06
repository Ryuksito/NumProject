# src/db/db.py

from sqlalchemy import create_engine
from sqlalchemy.orm import declarative_base, sessionmaker
from sqlalchemy.exc import SQLAlchemyError
from sqlalchemy import text

DATABASE_URL = "postgresql://postgres:13Ha7ka713@localhost:5432/game_db"

engine = create_engine(DATABASE_URL)
SessionLocal = sessionmaker(autocommit=False, autoflush=False, bind=engine)
Base = declarative_base()

# Dependencia para obtener una sesión de base de datos
def get_db():
    db = SessionLocal()
    try:
        yield db
    finally:
        db.close()

# Bloque para probar la conexión
if __name__ == '__main__':
    try:
        # Intentar crear las tablas de la base de datos
        Base.metadata.create_all(bind=engine)
        print("Conexión exitosa a la base de datos y tablas creadas (si no existían).")
        
        # Crear una nueva sesión para consultar la base de datos
        db = SessionLocal()

        # Ejecutar una consulta para obtener todos los usuarios
        result = db.execute(text("SELECT * FROM users;")).fetchall()
        
        if result:
            print("Usuarios en la base de datos:")
            for row in result:
                print(row)
        else:
            print("No hay usuarios en la base de datos.")
        
        # Cerrar la sesión
        db.close()

    except SQLAlchemyError as e:
        print(f"Error al conectar a la base de datos: {e}")
