import java.util.Scanner;

public class LoginScreen {
    private static final String ADMIN_USERNAME = "sinem";
    private static final String ADMIN_PASSWORD = "123";

    private static final Scanner scanner = new Scanner(System.in);

    public static boolean authenticate() {

        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        if (username.equals(ADMIN_USERNAME) && password.equals(ADMIN_PASSWORD)) {
            System.out.println("Login successful. Welcome, Admin!");
            return true;
        } else {
            System.out.println("Login failed. Invalid username or password.");
            return false;
        }
    }
}