package src;

import java.util.HashMap;
import java.util.UUID;

/**
 * Admin Class A User with Administrator rights
 * 
 * @author Jack Oberman
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
    public Admin(String firstName, String lastName) {
        super(UserType.admin);
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * Constructor for the admin class with all fields
     * 
     * @return
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
     * Gets the last name of the admin
     * 
     * @return the last name of the admin
     */
    public String getLastName() {
        return lastName;
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
                dict.get("password"), dict.get("firstname"), dict.get("lastName"));
    }
}
