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
    private InternshipUI userInterface;

    /**
     * login accepts a user credentials and assigns an interface
     */
    private static void login() {
        
    }

    /**
     * Signup accepts a user credentials assigns an interface
     */
    private static void signup() {

    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // DataLoader.loadDatabase();
        boolean loggingIn;
        do {
            loggingIn = false;
            System.out.println("Hello. Do you have an account? (y/n) ");
            String input = scan.nextLine();

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
