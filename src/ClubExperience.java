package src;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

/**
 * ClubExperience Class Contains the information related to a club experience
 * 
 * @author Noah MacBride
 */
public class ClubExperience extends Experience {
    private String role;

    /**
     * 
     * @param id        club experience uuid
     * @param title     the title of the club experience
     * @param details   a list of the details of the club
     * @param startDate when the student joined the club
     * @param endDate   when the student left the club
     * @param role      the student's role in the club
     */
    public ClubExperience(UUID id, String title, ArrayList<String> details, Date startDate, Date endDate, String role) {
        super(id, title, details, startDate, endDate);
        this.role = role;
    }

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
        return "{\"id\":\"" + ID.toString() + "\",\"title\":\"" + title + "\",\"details\":"
                + DataWriter.stringsToJSON(details) + ",\"startDate\":\"" + startDate.toString() + "\",\"endDate\":\""
                + endDate.toString() + "\",\"role\":\"" + role + "\"}";
    }

    /**
     * Creates a club experience from JSON
     * 
     * @param json is JSON representation of club experience
     * @return new club experience
     */
    public static ClubExperience fromJSON(String json) {
        HashMap<String, String> dict = DataLoader.dictFromBrace(json);
        return new ClubExperience(UUID.fromString(dict.get("id")), dict.get("title"),
                DataLoader.dictFromBracket(dict.get("details")), Date.fromString(dict.get("startDate")),
                Date.fromString(dict.get("endDate")), dict.get("role"));
    }

    /**
     * String representation of a club experience
     * 
     * @return string representation
     */
    public String toString() {
        String str = "";
        str += title + " (" + startDate + " - " + endDate + ")\n" + role;
        for (String detail : details) {
            str += "\n *  " + detail;
        }
        return str;
    }
}
