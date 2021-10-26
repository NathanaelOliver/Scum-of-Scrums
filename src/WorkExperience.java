package src;

import java.util.ArrayList;

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
        return "{\"id\":\"" + ID.toString() + "\",\"title\":\"" + title + "\",\"details\":"
                + JSONhelper.stringsToJSON(details) + ",\"startDate\":\"" + startDate.toString()
                + "\",\"endDate\":\"" + endDate.toString() + "\",\"references\":" + JSONhelper.toJson(references)
                + "}";
    }

}