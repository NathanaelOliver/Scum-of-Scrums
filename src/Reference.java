package src;

import java.util.HashMap;

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

    public String toString() {
        return firstName + " " + lastName + "\n" + email + "\n" + Database.phoneNumberToString(phoneNumber);
    }

    /**
     * Converts a Reference to a JSON object
     * 
     * @return JSON representation of a reference
     */
    public String toJSON() {
        return "{\"firstName\":\"" + firstName + "\",\"lastName\":\"" + lastName + "\",\"phoneNumber\":\"" + phoneNumber
                + "\",\"email\":\"" + email + "\"}";
    }

    /**
     * Creates a Reference from a JSON object
     * 
     * @param json the json object
     * @return a Reference created from the json object
     */
    public static Reference fromJSON(String json) {
        HashMap<String, String> dict = DataLoader.dictFromBrace(json);
        return new Reference(dict.get("firstName"), dict.get("lastName"), dict.get("phoneNumber"), dict.get("email"));
    }

    /**
     * Checks to see if this is equal to another object
     * 
     * @param o the other object
     */
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Reference))
            return false;
        Reference rhs = (Reference) o;
        return this.firstName.equals(rhs.firstName) && this.lastName.equals(rhs.lastName)
                && this.phoneNumber.equals(rhs.phoneNumber) && this.email.equals(rhs.email);
    }
}
