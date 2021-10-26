package src;

/**
 * ClubExperience Class Contains the information related to a club experience
 * 
 * @author Noah MacBride
 */
public class ClubExperience extends Experience {
    private String role;

    /**
     * Constructor for Club Experience with only a title
     * 
     * @param title the title of the club experience
     */
    public ClubExperience(String title) {
        super(title);
    }

    /**
     * Gets the role the student held
     * 
     * @return the role the student held
     */
    public String getRole() {
        return this.role;
    }

    /**
     * Sets the role the student held in the club
     * 
     * @param role the role the student held
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * Converts a Club Experience to a JSON object
     * 
     * @return Club Experience as a JSON object
     */
    public String toJSON() {
        return "{\"id\":" + ID.toString() + "\",\"title\":\"" + title + "\",\"details\":"
                + JSONhelper.stringsToJSON(details) + ",\"startDate\":\"" + startDate.toString()
                + "\",\"endDate\":\"" + endDate.toString() + "\",\"role\":\"" + role + "\"}";
    }
}
