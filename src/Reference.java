package src;

/**
 * Reference Class Stores the data for a work reference
 * 
 * @author Nathanael Oliver
 */
public class Reference implements JSONable {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;

    /**
     * Constructor for the Reference class
     * 
     * @param firstName   first name of the reference
     * @param lastName    last name of the reference
     * @param phoneNumber phone number of the reference
     * @param email       email of the reference
     */
    public Reference(String firstName, String lastName, String phoneNumber, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    /**
     * Gets the first name of the reference
     * 
     * @return the first name of the reference
     */
    public String getFirstName() {
        return this.firstName;
    }

    /**
     * Sets the first name of the reference
     * 
     * @param firstName the first name of the reference
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the last name of the reference
     * 
     * @return the last name of the reference
     */
    public String getLastName() {
        return this.lastName;
    }

    /**
     * Sets the last name of the reference
     * 
     * @param lastName the last name of the reference
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets the phone number of the reference
     * 
     * @return the phone number of the reference
     */
    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    /**
     * Sets the phone number of the reference
     * 
     * @param phoneNumber the phone number of the reference
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Gets the email address of the reference
     * 
     * @return the email address of the reference
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * Sets the email address of the reference
     * 
     * @param email the email address of the reference
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Converts a Reference to a JSON object
     * 
     * @return JSON representation of a reference
     */
    public String toJSON() {
        return "{\"firstName\":\"" + firstName + "\",\"lastName\":\"" + lastName + "\",\"phoneNumber\":"
                + phoneNumber + ",\"email\":\"" + email + "\"}";
    }
}
