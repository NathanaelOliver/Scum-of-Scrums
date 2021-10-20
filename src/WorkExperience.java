package src;

import java.util.ArrayList;
import java.util.Date;

/**
 * WorkExperience Class Contains the information related to a work experience
 * 
 * @author Nathanael Oliver
 */
public class WorkExperience extends Experience {
    private ArrayList<Reference> references;

    /**
     * Constructor for Work Experience with only a title
     * 
     * @param title the title of the work experience
     */
    public WorkExperience(String title) {
        super(title);
        references = new ArrayList<Reference>();
    }

    /**
     * Constructor for Work Experience with all fields except references
     * 
     * @param title     the title of the experience
     * @param details   details of the experience
     * @param startDate start date of the experience
     * @param endDate   end date of the experience
     */
    public WorkExperience(String title, ArrayList<String> details, Date startDate, Date endDate) {
        super(title, details, startDate, endDate);
        references = new ArrayList<Reference>();
    }

    /**
     * Constructor for Work Experience with all fields including references
     * 
     * @param title     the title of the experience
     * @param details   details of the experience
     * @param startDate start date of the experience
     * @param endDate   end date of the experience
     */
    public WorkExperience(String title, ArrayList<String> details, Date startDate, Date endDate,
            ArrayList<Reference> references) {
        super(title, details, startDate, endDate);
        this.references = references;
    }

    /**
     * Adds a reference to the references
     * 
     * @param reference the reference to be added to the reference list
     */
    public void addReference(Reference reference) {
        this.references.add(reference);
    }

    /**
     * Gets the references for the Work Experience
     * 
     * @return the references for the work experience
     */
    public ArrayList<Reference> getReferences() {
        return references;
    }

    /**
     * Converts a Work Experience to a JSON object
     * 
     * @return Work Experience as a JSON object
     */
    public String toJSON() {
        return "{\"id\": \"" + ID.toString() + "\",\"title\": \"" + title + "\",\"details\":"
                + JSONhelper.stringsToJSON(details) + ",\"startDate\": \"" + startDate.toString()
                + "\",\"endDate\": \"" + endDate.toString() + "\",\"references\":" + JSONhelper.toJson(references)
                + "}";
    }

}