package src;

import java.util.UUID;

/**
 * User class Stores an ID and password to log in to the system
 * 
 * @author Jack Oberman
 */
public abstract class User implements JSONable{
    public final UUID ID;
    public boolean isVerified;
    protected String password;
    private String username;

    public User() {
        this.ID = UUID.randomUUID();
    }

    /**
     * Constructor for the User Class
     * 
     * @param userType the user type
     */
    public User(String username, String password) {
        this();
        this.username = username;
        this.password = password;
    }

    /**
     * Sets the user's username
     * 
     * @param username the user's new username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Get user's username
     * @return username of user
     */
    public String getUsername() {
        return this.username;
    }

    /**
     * Sets the user's password
     * 
     * @param password the user's new password
     */
    public void setPassword(String password) {
        this.password = password;
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

    public abstract String toString();
}
