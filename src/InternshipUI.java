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

    /**
     * Displays main menu options for the user
     */
    protected void displayMainMenu() {
        for (int i = 0; i < this.mainMenuOptions.length; ++i) {
            System.out.println((i+1) + ") " + this.mainMenuOptions[i]);
        }
        System.out.println("Pick 1 through " + this.mainMenuOptions.length);
    };

    /**
     * Creates a user when they are signing up, called by Driver
     */
    public abstract void createUser();

}
