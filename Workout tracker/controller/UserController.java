package controller;

import model.DataManager;
import model.User;

public class UserController {
    private DataManager dataManager;

    public UserController() {
        this.dataManager = DataManager.getInstance();
    }

    // Login method
    public User loginUser(String email, String password) {
        return dataManager.loginUser(email, password);
    }

    // Register method
    public boolean registerUser(String name, String email, String password) {
        return dataManager.registerUser(name, email, password);
    }
}
