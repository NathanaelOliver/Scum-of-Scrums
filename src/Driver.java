package src;

import java.util.Scanner;

import javax.lang.model.util.ElementScanner14;

/**
 * Driver runs the internship program for all users and commands
 * 
 * @author William Hobbs
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
            switch(input) {
                case 1: userInterface = new StudentUI();
                case 2: userInterface = new EmployerUI();
                case 3: userInterface = new AdminUI();
                default: signingUp = true;

                userInterface.createUser();
            }
        } while (signingUp);
    }

    public static void main(String[] args) {
        scanner = new Scanner(System.in);

        // DataLoader.loadDatabase();
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
            else loggingIn = true;

        } while (loggingIn);

        System.out.println("Thanks for using our service. Goodbye!");
    }
}
