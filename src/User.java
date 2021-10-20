package src;

import java.util.UUID;

/**
 * User class Stores an ID and password to log in to the system
 * 
 * @author Jack Oberman
 */
public abstract class User {
    private String password;
    public final UUID ID;
    public UserType userType;
    public boolean isVerified = false;

    /**
     * Constructor for the User Class
     * 
     * @param userType the user type
     */
    public User(UserType userType) {
        this.ID = UUID.randomUUID();
        this.userType = userType;
    }

    /**
     * Sets the users password
     * 
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    public static boolean isValidPassword(String password) {
        // ensure password has a length between 8 and 16, has a number,
        // a lowercase letter, a capital letter, and a symbol
        // with no spaces
        return password.length() > 8 && password.length() <= 16 &&
               password.matches(".*[a-z].*") &&
               password.matches(".*[A-Z].*") &&
               password.matches(".*[0-9].*") &&
               password.matches(".*[!-&].*") &&
               !password.matches(".*/\s/g.*");
    }

    /**
     * verifies the password
     * 
     * @param password the password to verify
     * @return true if it is the users password, otherwise false
     */
    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }

    /**
     * Sets isVerified to true
     * 
     */
    public void verifyUser() {
        this.isVerified = true;
    }

    /**
     * Converts a user into JSON to be stored in the database
     * 
     * @return a JSON representation of the USER
     */
    public abstract String toJSON();
}
