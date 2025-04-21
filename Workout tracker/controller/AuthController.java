package controller;

import model.DataManager;
import model.User;

public class AuthController {
    private DataManager dataManager;

    public AuthController() {
        dataManager = DataManager.getInstance();
    }

    public boolean register(String name, String email, String password) {
        return dataManager.registerUser(name, email, password);
    }

    public User login(String email, String password) {
        return dataManager.loginUser(email, password);
    }
}

