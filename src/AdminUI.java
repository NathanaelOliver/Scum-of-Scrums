package src;

import java.util.Scanner;

/**
 * Admin User Interface Front-facing commands for Administrator users
 * 
 * @author Jack Oberman
 */
public class AdminUI extends InternshipUI {
    private boolean loggedIn = true;

    public AdminUI(Scanner scanner) {
        super(scanner);
        this.mainMenuOptions = new String[]{"View Unverified Users", "Edit Account", "Log Out"};
    }

    public AdminUI(Scanner scanner, Admin admin) {
        this(scanner);
        this.currentUser = admin;
    }

    public void run() {
        while (loggedIn) {
            int mainMenuOption = readMainMenu();
            switch(mainMenuOption) {
                case 1: viewUnverifiedUsers();
                case 2: editAccount();
                case 3: logout();
            }
        }
    }

    public void createUser() {
        String username = readUsername();
        String password = readPassword();
        String firstName = readWord("Please enter your first name");
        String lastName = readWord("Please enter your last name");
        this.currentUser = new Admin(username, password, firstName, lastName);
    }
    
    private void viewUnverifiedUsers() {

    }

    private void editAccount() {
        
    }
 
    /**
     * searchEmployer searches all of the users assigned to user type 'employer'
     */
    private void searchEmployer() {

    }

    /**
     * searchAdmin searches all of the users assigned to user type 'admin'
     */
    private void searchAdmin() {

    }

    /**
     * Moves a user from unverifiedUsers into their respective group Allows user to
     * perform user-y tasks
     */
    private void validateUser() {

    }

    /**
     * searchListing searches the posted job listings
     */
    private void searchListing() {

    }

    /**
     * deleteListings is used to remove an [inappropriate] job listing
     */
    private void deleteListing() {

    }

    /**
     * deleteUser removes a user from the system
     */
    private void deleteUser() {

    }

    /**
     * editListings is used to edit the private variables of a listing
     */
    private void editListing() {

    }
}
