package src;

import java.util.HashMap;
import java.util.UUID;

/**
 * Admin Class is a User with Administrator rights
 * 
 * @author Jack Oberman
 */
public class Admin extends User {
    private String firstName;
    private String lastName;

    /**
     * Constructor for admin
     * 
     * @param username  is the admin's username
     * @param password  is the admin's password
     * @param firstName is the admin's first name
     * @param lastName  is the admin's last name
     */
    public Admin(String username, String password, String firstName, String lastName) {
        super(username, password, UserType.admin);
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * Constructor for admin
     * 
     * @param id         is the admin's user id
     * @param isVerified boolean for whether the admin is verified
     * @param username   is the admin's username
     * @param password   is the admin's password
     * @param firstname  is the admin's first name
     * @param lastName   is the admin's last name
     */
    public Admin(UUID id, boolean isVerified, String username, String password, String firstname, String lastName) {
        super(id, UserType.admin, isVerified, username, password);
        this.firstName = firstname;
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
     * Sets admin's first name
     * 
     * @param firstName admin's new first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
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
     * Sets admin's last name
     * 
     * @param lastName admin's new last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets JSON representation of the admin
     * 
     * @return the JSON representation of the admin
     */
    public String toJSON() {
        return "\"id\":\"" + ID.toString() + "\",\"username\":\"" + getUsername() + "\",\"password\":\"" + password
                + "\",\"userType\":\"" + userType.toString() + "\",\"isVerified\":" + isVerified + ",\"firstName\":\""
                + firstName + "\",\"lastName\":\"" + lastName + "\"}";
    }

    /**
     * Creates an admin from a JSON object
     * 
     * @param json the json object
     * @return an Admin
     */
    public static Admin fromJSON(String json) {
        HashMap<String, String> dict = DataLoader.dictFromBrace(json);
        return new Admin(UUID.fromString(dict.get("id")), dict.get("isVerified").equals("true"), dict.get("username"),
                dict.get("password"), dict.get("firstName"), dict.get("lastName"));
    }

    /**
     * Gets a string representation of the admin
     * 
     * @return string representation of admin
     */
    public String toString() {
        return firstName + " " + lastName;
    }
}
