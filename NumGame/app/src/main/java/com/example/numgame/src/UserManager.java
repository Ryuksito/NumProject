package com.example.numgame.src;

import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UserManager {

    private static UserManager instance;

    private String username;
    private String gameLevel;
    private String password;

    private UserManager() {}

    public static UserManager getInstance() {
        if (instance == null) {
            instance = new UserManager();
        }
        return instance;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setGameLevel(String gameLevel) {
        this.gameLevel = gameLevel;
        Log.d("GameMode", gameLevel);
        modifyGameLevel(username, gameLevel);
    }

    public String getGameLevel() {
        return gameLevel;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void clearUserData() {
        this.username = null;
        this.gameLevel = null;
    }

    // Método para realizar la solicitud PUT en segundo plano usando ExecutorService
    public void modifyGameLevel(String username, String gameLevel) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    // Formar la URL correctamente con el parámetro en la URL
                    URL url = new URL("http://10.0.2.2:8000/users/" + username + "/game_level?game_level=" + gameLevel);
                    Log.d("Url", url + "");

                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("PUT");
                    connection.setRequestProperty("Accept", "application/json");

                    // No es necesario establecer Content-Type si no estamos enviando un cuerpo
                    connection.setDoOutput(false); // No es necesario enviar contenido en el cuerpo de la solicitud

                    int responseCode = connection.getResponseCode();

                    if (responseCode == HttpURLConnection.HTTP_OK) {
                        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                        StringBuilder response = new StringBuilder();
                        String line;
                        while ((line = reader.readLine()) != null) {
                            response.append(line);
                        }
                        reader.close();
                        Log.d("UserManager", "User updated successfully: " + response.toString());
                    } else {
                        // En caso de error en la respuesta
                        Log.e("UserManager", "Failed to update user: " + responseCode);
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                    Log.e("UserManager", "Error during PUT request: " + e.getMessage());
                }
            }
        });
    }
}
