package src;

import java.util.ArrayList;
import java.util.Date;

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
     * Constructor for Club Experience with all fields except role
     * 
     * @param title     the title of the experience
     * @param details   details of the experience
     * @param startDate start date of the experience
     * @param endDate   end date of the experience
     */
    public ClubExperience(String title, ArrayList<String> details, Date startDate, Date endDate) {
        super(title, details, startDate, endDate);
    }

    /**
     * Constructor for Club Experience with all fields including role
     * 
     * @param title     the title of the experience
     * @param details   details of the experience
     * @param startDate start date of the experience
     * @param endDate   end date of the experience
     * @param role      the position the student held within the club
     */
    public ClubExperience(String title, ArrayList<String> details, Date startDate, Date endDate, String role) {
        super(title, details, startDate, endDate);
        this.role = role;
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
     * Converts a Club Experience to a JSON object
     * 
     * @return Club Experience as a JSON object
     */
    public String toJSON() {
        return "{\"id\": " + this.id + ",\"title\": \"" + this.title + "\",\"details\": [" + String.join(",", details)
                + "],\"startDate\": \"" + startDate.toString() + "\",\"endDate\": \"" + endDate.toString()
                + "\",\"role\": \"" + role + "\"}";
    }
}