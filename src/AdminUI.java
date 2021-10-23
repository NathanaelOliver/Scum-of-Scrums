package src;

import java.util.Scanner;

/**
 * Admin User Interface Front-facing commands for Administrator users
 * 
 * @author Jack Oberman
 */
public class AdminUI extends InternshipUI {
    public Admin admin;
    private boolean loggedIn = true;
    private final String[] UNVERIFIED_USERS_MENU;
    private final String[] EDIT_ACCOUNT_MENU;

    public AdminUI(Scanner scanner) {
        super(scanner);
        this.mainMenuOptions = new String[]{"View Unverified Users", "Edit Account", "Log Out"};
        this.UNVERIFIED_USERS_MENU = new String[]{"Verify User", "Remove User", "Go to Next User", "Return to Main Menu"};
        this.EDIT_ACCOUNT_MENU = new String[]{"First Name","Last Name","Delete Account", "Return to Main Menu"};
    }

    public AdminUI(Scanner scanner, Admin admin) {
        this(scanner);
        this.admin = admin;
    }

    public void run() {
        while (loggedIn) {
            int mainMenuOption = readMenu(this.mainMenuOptions);
            flush();
            switch(mainMenuOption) {
                case 1:
                    viewUnverifiedUsers();
                    break;
                case 2:
                    editAccount();
                    break;
                case 3:
                    logout();
                    this.loggedIn = false;
            }
        }
    }

    public void createUser() {
        String username = readUsername();
        String password = readPassword();
        String firstName = readWord("Please enter your first name");
        String lastName = readWord("Please enter your last name");
        this.admin = new Admin(username, password, firstName, lastName);
    }
    
    private void viewUnverifiedUsers() {
        for (User user: Database.unverifiedUsers) {
            flush();
            System.out.println(user);
            int menuOption = readMenu(this.UNVERIFIED_USERS_MENU);
            switch(menuOption) {
                case 1:
                    user.verifyUser();
                    break;
                case 2:
                    Database.removeUnverifiedUser(user.ID);
                    break;
                case 4: break;
                default: 
            }
        }
        System.out.println("No more unverified users to verify at this time.");
    }

    private void editAccount() {
        flush();
        int menuOption = readMenu(this.EDIT_ACCOUNT_MENU);
        switch(menuOption) {
            case 1: 
                System.out.println("Your current first name is " + this.admin.getFirstName());
                admin.setFirstName(readWord("Please enter your first name"));
                break;
            case 2: 
                System.out.println("Your current last name is " + this.admin.getLastName());
                admin.setLastName(readWord("Please enter your last name"));
                break;
            case 3: //TODO Do we want a y/n prompt to make sure they're sure they want to delete? - Jack
                Database.removeAdmin(this.admin.ID);
                this.loggedIn = false;
                break;
            default:
                flush();
        }
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
