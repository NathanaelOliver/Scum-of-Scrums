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
        flush();
        boolean loggingIn;
        String username, password;
        do {
            loggingIn = false;
            System.out.println("Please enter your username:");
            username = scanner.nextLine().trim();
            System.out.println("Please enter your password:");
            password = scanner.nextLine().trim();

            userInterface = Database.verifyLoginCredentials(scanner, username, password);
            loggingIn = (userInterface == null);
        } while (loggingIn);
    }

    /**
     * Signup accepts a user credentials assigns an interface
     */
    private static void signup() {
        flush();
        boolean signingUp;
        do {
            signingUp = false;
            System.out.println("Are you a:\n1) Student\n2) Employer\n3) Administrator");
            int input = Integer.parseInt(scanner.nextLine());
            switch (input) {
            case 1:
                userInterface = new StudentUI(scanner);
                break;
            case 2:
                userInterface = new EmployerUI(scanner);
                break;
            case 3:
                userInterface = new AdminUI(scanner);
                break;
            default:
                signingUp = true;
            }
        } while (signingUp);
        userInterface.createUser();
    }

    /**
     * main method
     * 
     * @param args n/a
     */
    public static void main(String[] args) {
        flush();
        scanner = new Scanner(System.in);

        Database.fromJSON(DataLoader.getJSON("data/Users.json"));

        boolean loggingIn;
        boolean newUser = false;
        do {
            loggingIn = false;
            System.out.println("Hello. Do you have an account? (y/n) ");
            String input = scanner.nextLine();

            // If user has account, calls log-in function, if user wants account,
            // calls sign-up function, otherwise repeats for valid input.
            if (input.equalsIgnoreCase("y"))
                login();
            else if (input.equalsIgnoreCase("n")) {
                signup();
                newUser = true;
            } else
                loggingIn = true;

        } while (loggingIn);

        if (newUser || userInterface == null)
            System.out.println(
                    "Your account must now be verified before it is activated. Thank you for signing up to our service!");
        else
            userInterface.run();

        flush();
        System.out.println("Thank you for using our service!");
    }

    /**
     * flushes the terminal
     */
    private static void flush() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
