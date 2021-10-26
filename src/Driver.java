package src;

import java.util.Scanner;

/**
 * Driver runs the internship program for all users and commands
 * 
 * @author William Hobbs, Noah MacBride, and Jack Oberman
 */
public class Driver {
    /**
     * userInterface is assigned based on the login credentials and type of the user
     * 
     * @param userInterface is the assigned UI to the user
     */
    private static InternshipUI userInterface;
    private static Scanner scanner;

    /**
     * login accepts a user credentials and assigns an interface
     */
    private static void login() {
        boolean loggingIn;
        String username, password;
        do {
            loggingIn = false;
            System.out.println("Please enter your username:");
            username = scanner.nextLine();
            System.out.println("Please enter your password:");
            password = scanner.nextLine();

            userInterface = Database.verifyLoginCredentials(scanner, username, password);
            loggingIn = (userInterface == null);
        } while (loggingIn);
    }

    /**
     * Signup accepts a user credentials assigns an interface
     */
    private static void signup() {
        boolean signingUp;
        do {
            signingUp = false;
            System.out.println("Are you a:\n1) Student\n2) Employer\n3) Administrator");
            int input = Integer.parseInt(scanner.nextLine());
            switch (input) {
            case 1:
                userInterface = new StudentUI(scanner);
            case 2:
                userInterface = new EmployerUI(scanner);
            case 3:
                userInterface = new AdminUI(scanner);
            default:
                signingUp = true;
            }
        } while (signingUp);
        userInterface.createUser();
    }

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        Database.fromJSON(DataLoader.getJSON());
        boolean loggingIn;
        do {
            loggingIn = false;
            System.out.println("Hello. Do you have an account? (y/n) ");
            String input = scanner.nextLine();

            // If user has account, calls log-in function, if user wants account,
            // calls sign-up function, otherwise repeats for valid input.
            if (input.equalsIgnoreCase("y"))
                login();
            else if (input.equalsIgnoreCase("n"))
                signup();
            else
                loggingIn = true;

        } while (loggingIn);

        userInterface.run();
        System.out.println("Thanks for using our service. Goodbye!");
    }
}
