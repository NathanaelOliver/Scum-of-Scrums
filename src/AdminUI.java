package src;

import java.util.Scanner;

/**
 * Admin User Interface Front-facing commands for Administrator users
 * 
 * @author William Hobbs
 */
public class AdminUI extends InternshipUI {
    public Admin admin;

    public AdminUI(Scanner scanner) {
        super(scanner);
    }

    public AdminUI(Scanner scanner, Admin admin) {
        super(scanner);
        this.admin = admin;
    }

    public void run() {

    }

    public void createUser() {
        String username = readUsername();
        String password = readPassword();
        String firstName = readWord("first name");
        String lastName = readWord("last name");
        admin = new Admin(username, password, firstName, lastName);
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
