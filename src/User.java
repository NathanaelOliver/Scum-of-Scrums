package src;

import java.util.UUID;

/**
 * User class Stores an ID and password to log in to the system
 * 
 * @author Jack Oberman
 */
public abstract class User {
    private String username;
    protected String password;
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

    public User(String username, String password, UserType userType) {
        this.ID = UUID.randomUUID();
        this.username = username;
        this.password = password;
        this.userType = userType;
    }

    public String getUsername() {
        return this.username;
    }

    /**
     * Sets the users password
     * 
     * @param password
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
    public boolean verifyPassword(String password) {
        return this.password.equals(password);
    }

    /**
     * Gets the user id
     * 
     * @return the id
     */
    public UUID getID() {
        return this.ID;
    }

    /**
     * Converts a user into JSON to be stored in the database
     * 
     * @return a JSON representation of the USER
     */
    public abstract String toJSON();
}
