
/**
 * User class
 * Stores an ID and password to login to the system
 * @author Nathanael Oliver
 */
public abstract class User {
    private String password;
    private String id;
    public UserType userType;
    public boolean isVerified = false;

    /**
     * Constructor for the User Class
     * @param id the id of the user
     * @param userType the user type
     */
    public User(String id, UserType userType) {
        this.id = id;
        this.userType = userType;
    }

    /**
     * Sets the users password
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * verifies the password
     * @param password the password to verify
     * @return true if it is the users password, otherwise false
     */
    public boolean verfiyPassword(String password) {
        return this.password.equals(password);
    }

    /**
     * Gets the user id
     * @return the id
     */
    public String getID() {
        return id;
    }

    /**
     * IM NOT ENTIRELY SURE WHAT THIS METHOD IS FOR
     * @param user
     * @return
     */
    // public abstract void verifyUser(User user);

    /**
     * Converts a user into JSON to be stored in the database
     * @return a JSON representation of the USER
     */
    public abstract String toJSON();
}

enum UserType {
    student,
    employer,
    admin
}