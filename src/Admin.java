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
    public Admin(String username, String password, String firstName, String lastName) {
        super(username, password, UserType.admin);
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

    public String toString() {
        return "Admin toString result";
    }
}
