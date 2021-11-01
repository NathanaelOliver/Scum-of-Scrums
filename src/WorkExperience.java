package src;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

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
     * Private Constructor for use in generating Work Experience from JSON
     * 
     * @param id         the id
     * @param title      the title
     * @param details    the details of the work experience
     * @param startDate  the start date
     * @param endDate    the end date
     * @param references the reference for the work experience
     */
    private WorkExperience(UUID id, String title, ArrayList<String> details, Date startDate, Date endDate,
            ArrayList<Reference> references) {
        super(id, title, details, startDate, endDate);
        this.references = references;
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

    public String toString() {
        String str = "";
        str += title + " (" + startDate + " - " + endDate + ")";
        for (String detail : details)
            str += "\n * " + detail;

        str += "\n\nReferences:";
        for (Reference ref : references) {
            str += "\n--------------------";
            str += "\n" + ref;
        }
        
        return str;
    }

    /**
     * Converts a Work Experience to a JSON object
     * 
     * @return Work Experience as a JSON object
     */
    public String toJSON() {
        return "{\"id\":\"" + ID.toString() + "\",\"title\":\"" + title + "\",\"details\":"
                + DataWriter.stringsToJSON(details) + ",\"startDate\":\"" + startDate.toString() + "\",\"endDate\":\""
                + endDate.toString() + "\",\"references\":" + DataWriter.toJSON(references) + "}";
    }

    /**
     * Creates a work experience from a json object
     * 
     * @param json the json object
     * @return the work experience created from the json object
     */
    public static WorkExperience fromJSON(String json) {
        HashMap<String, String> dict = DataLoader.dictFromBrace(json);
        ArrayList<Reference> references = new ArrayList<Reference>();
        for (String e : DataLoader.dictFromBracket(dict.get("references"))) {
            references.add(Reference.fromJSON(e));
        }
        return new WorkExperience(dict.get("title"), DataLoader.dictFromBracket(dict.get("details")),
                Date.fromString(dict.get("startDate")), Date.fromString(dict.get("endDate")), references);
    }

}

