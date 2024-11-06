import requests

BASE_URL = "http://localhost:8000"  # Cambia el puerto si es necesario

# Función para crear un usuario
def create_user(username, password, game_level):
    url = f"{BASE_URL}/users/"
    user_data = {
        "username": username,
        "password": password,
        "game_level": game_level
    }
    response = requests.post(url, json=user_data)

    if response.status_code == 200:
        print("User created successfully:", response.json())
    elif response.status_code == 400:
        print("Error:", response.json()["detail"])
    else:
        print("Unexpected error:", response.status_code, response.text)

# Función para obtener un usuario
def get_user(username):
    url = f"{BASE_URL}/users/{username}"
    response = requests.get(url)

    if response.status_code == 200:
        print("User found:", response.json())
    elif response.status_code == 404:
        print("Error: User not found")
    else:
        print("Unexpected error:", response.status_code, response.text)

def modify_game_level(username, game_level):
    url = f'http://localhost:8000/users/{username}/game_level'  # Asegúrate de reemplazar {username} correctamente

    headers = {
        'accept': 'application/json',
    }

    params = {
        'game_level': game_level,
    }

    response = requests.put(url, params=params, headers=headers)


    if response.status_code == 200:
        print("User updated successfully:", response.json())
    else:
        print(f"Failed to update user: {response.status_code}, {response.text}")

# Ejemplo de uso
if __name__ == "__main__":
    # Cambia estos valores según sea necesario
    create_user("testuser", "mypassword", "basic")  # Cambia el nivel según tu enumeración
    get_user("testuser")
    modify_game_level("testuser", "advanced")  # Cambia el nivel según tu enumeración
