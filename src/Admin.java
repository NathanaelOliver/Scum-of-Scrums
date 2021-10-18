package src;

/**
 * Admin Class A User with Administrator rights
 * 
 * @author Nathanael Oliver
 */
public class Admin extends User {
    private String firstName;
    private String lastName;

    /**
     * Constructor for the admin class
     * 
     * @param firstName the first name of the admin
     * @param lastName  the last name of the admin
     */
    public Admin(String id, String firstName, String lastName) {
        super(UserType.admin);
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * Gets the first name of the admin
     * 
     * @return the first name of the admin
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Gets the last name of the admin
     * 
     * @return the last name of the admin
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * verifies the user TODO - Im not entirely sure if this method should be in
     * here or in the database method; I may move it later - Nathanael
     * 
     * @param id                 the id of the user to be verified
     * @param verificationStatus the verification status of the user
     */
    public void verifyUser(String id, boolean verificationStatus) {
        Database.getUserByID(id).isVerified = verificationStatus;
    }

    /**
     * Gets JSON representation of the admin
     * 
     * @return the JSON representation of the admin
     */
    public String toJSON() {
        return "";
    }
}