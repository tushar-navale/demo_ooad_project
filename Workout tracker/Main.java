import model.DataManager;
import view.LoginView;

public class Main {
    public static void main(String[] args) {
        // Pre-register a default user
        DataManager dataManager = DataManager.getInstance();
        dataManager.registerUser("Test User", "test@example.com", "1234");

        // Launch the login view
        new LoginView().setVisible(true);
    }
}
