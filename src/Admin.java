package src;

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
        return "{\"firstName\":" + firstName + "\",lastName\": " + lastName + ",\"userType\": \"" + userType +
        "\",\"id\": [" + ID + "],\"username\": [" + getUsername() + "],\"password\": [" + password +
        "],\"isVerified\": [" + isVerified + "]}";
    }
}