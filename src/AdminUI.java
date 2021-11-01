package src;

import java.util.Scanner;

/**
 * Admin User Interface Front-facing commands for Administrator users
 * 
 * @author Jack Oberman
 */
public class AdminUI extends InternshipUI {
    public Admin admin;
    private boolean loggedIn;
    private final String[] UNVERIFIED_USERS_MENU;
    private final String[] EDIT_ACCOUNT_MENU;

    /**
     * Constructor for AdminUI. Initializes menus
     * 
     * @param scanner is the scanner from Driver
     */
    public AdminUI(Scanner scanner) {
        super(scanner);
        this.mainMenuOptions = new String[] { "View Unverified Users", "Edit Account", "Log Out" };
        this.UNVERIFIED_USERS_MENU = new String[] { "Verify User", "Remove User", "Go to Next User",
                "Return to Main Menu" };
        this.EDIT_ACCOUNT_MENU = new String[] { "First Name", "Last Name", "Delete Account", "Return to Main Menu" };
        this.loggedIn = true;
    }

    /**
     * Constructor for adminUI with an admin.
     * 
     * @param scanner is the scanner from Driver
     * @param admin   is the admin experiencing the interface
     */
    public AdminUI(Scanner scanner, Admin admin) {
        this(scanner);
        this.admin = admin;
    }

    /**
     * runs the admin interface, serves as a loop for mainMenu
     */
    public void run() {
        while (loggedIn) {
            int mainMenuOption = readMenu(this.mainMenuOptions);
            flush();
            switch (mainMenuOption) {
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

    /**
     * runs sub menu for viewing unverified users
     */
    private void viewUnverifiedUsers() {
        for (User user : Database.unverifiedUsers) {
            flush();
            System.out.println(user);
            int menuOption = readMenu(this.UNVERIFIED_USERS_MENU);
            switch (menuOption) {
            case 1:
                user.verifyUser();
                break;
            case 2:
                Database.removeUnverifiedUser(user.ID);
                break;
            case 4:
                break;
            default:
            }
        }
        System.out.println("No more unverified users to verify at this time.");
    }

    /**
     * runs sub menu for editing account
     */
    private void editAccount() {
        flush();
        int menuOption = readMenu(this.EDIT_ACCOUNT_MENU);
        switch (menuOption) {
        case 1:
            System.out.println("Your current first name is " + this.admin.getFirstName());
            admin.setFirstName(readWord("Please enter your first name"));
            break;
        case 2:
            System.out.println("Your current last name is " + this.admin.getLastName());
            admin.setLastName(readWord("Please enter your last name"));
            break;
        case 3: 
            if (readBoolean("Are you sure you would like to delete your account?")) {
                Database.removeAdmin(this.admin.ID);
                this.loggedIn = false;
            } else editAccount();
            break;
        default:
            flush();
        }
    }

    /**
     * Creates a new admin
     */
    public void createUser() {
        String username = readUsername();
        String password = readPassword();
        String firstName = readWord("Please enter your first name");
        String lastName = readWord("Please enter your last name");
        this.admin = new Admin(username, password, firstName, lastName);
    }
}
