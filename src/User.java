package src;

import java.util.UUID;

/**
 * User class Stores an ID and password to log in to the system
 * 
 * @author Nathanael Oliver
 */
public abstract class User {
    private String password;
    private final UUID id;
    public UserType userType;
    public boolean isVerified = false;

    /**
     * Constructor for the User Class
     * 
     * @param userType the user type
     */
    public User(UserType userType) {
        this.id = UUID.randomUUID();
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

    /**
     * verifies the password
     * 
     * @param password the password to verify
     * @return true if it is the users password, otherwise false
     */
    public boolean verfiyPassword(String password) {
        return this.password.equals(password);
    }

    /**
     * Gets the user id
     * 
     * @return the id
     */
    public UUID getID() {
        return this.id;
    }

    /**
     * TODO - IM NOT ENTIRELY SURE WHAT THIS METHOD IS FOR
     * 
     * @param user
     * @return
     */
    // public abstract void verifyUser(User user);

    /**
     * Converts a user into JSON to be stored in the database
     * 
     * @return a JSON representation of the USER
     */
    public abstract String toJSON();
}

enum UserType {
    student, employer, admin
}