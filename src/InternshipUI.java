package src;

/**
 * Intership User Interface
 * This user interface runs the front-end of the Internship system.
 * @author William Hobbs and Jack Oberman
 */

import java.util.Scanner;

public abstract class InternshipUI {
    protected User currentUser;
    protected Scanner scanner;
    protected String[] mainMenuOptions;

    public InternshipUI(Scanner scanner) {
        this.scanner = scanner;
    }

    /**
     * Runs the internship user interface
     */
    public abstract void run();

    /**
     * Logs a user out of the system and clears data
     */
    protected void logout() {
        //TO-DO: DataWriter.save();
    }

    protected String displayMainMenu() {
        String display = "";
        for (int i = 0; i < this.mainMenuOptions.length; ++i) {
            display += (i+1) + ") " + this.mainMenuOptions[i] + "\n";
        }
        return display + "Pick 1 through " + this.mainMenuOptions.length;
    }

    protected int readMainMenu() {
        boolean reading;
        int option;
        do {
            reading = false;
            System.out.println(displayMainMenu());
            option = Integer.parseInt(scanner.nextLine());
            if (option < 1 || option > this.mainMenuOptions.length)
                reading = !error("Please enter a valid number from 1 through " + this.mainMenuOptions.length);
        } while (reading);

        return option;
    }

    protected String readString(String message) {
        System.out.println(message);
        return scanner.nextLine();
    }

    protected int readInt(String message) {
        System.out.println(message);
        return Integer.parseInt(scanner.nextLine());
    }

    protected double readDouble(String message) {
        System.out.println(message);
        return Double.parseDouble(scanner.nextLine());
    }

    protected boolean readBoolean(String message) {
        boolean reading;
        do {
            reading = false;
            System.out.println(message + " (y/n)");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("y"))
                return true;
            else if (input.equalsIgnoreCase("n"))
                return false;
            else reading = true;
        } while (reading);

        return false;
    }

    protected String readWord(String message) {
        boolean reading;
        String word;

        do {
            reading = false;
            System.out.println(message);
            word = scanner.nextLine();

            if (word.contains(" "))
                reading = !error("Please enter only a single word");
            else if (word.length() > 40)
                reading = !error("Please enter less than 21 characters");
        } while (reading);

        return word;
    }

    protected String readUsername() {
        boolean reading;
        String username;

        do {
            reading = false;
            System.out.println("Please enter a username:");
            username = scanner.nextLine();
            reading = !Database.isAvailable(username);
            if (reading) System.err.println("Your username is taken, please enter another username:");
        } while (reading);

        return username;
    }

    protected String readPassword() {
        boolean reading;
        String password;

        do {
            flush();
            reading = false;
            System.out.println("Please enter a password:");
            password = scanner.nextLine();
            reading = !isValidPassword(password);
        } while (reading);

        return password;
    }

    /**
     * Creates a user when they are signing up, called by Driver
     */
    public abstract void createUser();

    /**
     * Ensure password has a length between 8 and 16, has a number, a lowercase letter, a capital letter, and a symbol with no spaces
     * 
     * @param password password to be verified
     * @return true if password is valid, false otherwise
     */
    private boolean isValidPassword(String password) {
        if (password.length() <= 8)
            return error("Password must be at least 8 characters");
        if (password.length() > 16)
            return error("Password must be less than 17 characters");
        if (!password.matches(".*[a-z].*"))
            return error("Password must contain a lowercase letter");
        if (!password.matches(".*[A-Z].*"))
            return error("Password must contain a uppercase letter");
        if (!password.matches(".*[0-9].*"))
            return error("Password must contain a number");
        if (!password.matches(".*[!-&].*"))
            return error("Password must contain a special character");
        if (password.matches(".*/\\s/g.*"))
            return error("Password may not have any spaces");
    
        return true;
    }

    protected boolean error(String message) {
        System.err.println(message);
        return false;
    }

    /**
     * Clears dialogue from terminal
     */
    protected void flush() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}
