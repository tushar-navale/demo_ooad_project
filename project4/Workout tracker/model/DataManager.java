package model;

import java.util.HashMap;

public class DataManager {
    private static DataManager instance;
    private HashMap<String, User> users; // email -> User

    private DataManager() {
        users = new HashMap<>();
    }

    public static synchronized DataManager getInstance() {
        if (instance == null) {
            instance = new DataManager();
        }
        return instance;
    }

    public boolean registerUser(String name, String email, String password) {
        if (users.containsKey(email)) return false; // User already exists
        users.put(email, new User(name, email, password));
        return true;  // User registered successfully
    }

    public User loginUser(String email, String password) {
        if (users.containsKey(email) && users.get(email).getPassword().equals(password)) {
            return users.get(email);  // Return user on successful login
        }
        return null;  // Login failed
    }
}
