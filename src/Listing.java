package src;

import java.util.UUID;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Listing class stores a posted job listing
 * 
 * @author Noah MacBride
 */
public class Listing implements JSONable {
    public final UUID ID;
    private final UUID EMPLOYER_ID;
    private double payRate;
    private ArrayList<String> description;
    private Date startDate, endDate;
    private String siteLink, title, location;
    private ArrayList<Skills> skills;
    private ArrayList<UUID> applicants;

    /**
     * Creates an empty Listing with only an id
     *
     * @param title        the title of the listing
     * @param employerName the name of the employer offering the job
     */
    public Listing(String title, UUID employerId) {
        this.title = title;
        this.ID = UUID.randomUUID();
        this.EMPLOYER_ID = employerId;
        this.applicants = new ArrayList<UUID>();
    }

    /**
     * Creates a copy of a listing based on
     * 
     * @param listing
     */
    public Listing(Listing listing) {
        this.ID = listing.ID;
        this.EMPLOYER_ID = listing.EMPLOYER_ID;
        this.payRate = listing.getPayRate();
        this.description = listing.getDescription();
        this.startDate = listing.getStartDate();
        this.endDate = listing.getEndDate();
        this.siteLink = listing.getSiteLink();
        this.title = listing.getTitle();
        this.location = listing.getLocation();
        this.skills = listing.getSkills();
        this.applicants = listing.getApplicants();
    }

    /**
     * Creates a listing with all propeerties
     * 
     * @param title the title of the job listing
     * @param payRate      the pay rate of the job listing
     * @param location     the location of the job
     * @param description  a description of the job
     * @param startDate    the start date of the job
     * @param endDate      the end date of the job
     * @param siteLink     a link to the company website
     * @param skills       the skills recommended for this job
     * @param employerName the name of the employer offering the job
     */
    Listing(String title, double payRate, String location, ArrayList<String> description, Date startDate, Date endDate,
            String siteLink, ArrayList<Skills> skills, UUID employerId) {
        this.ID = UUID.randomUUID();
        this.title = title;
        this.payRate = payRate;
        this.location = location;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.siteLink = siteLink;
        this.skills = skills;
        this.EMPLOYER_ID = employerId;
        this.applicants = new ArrayList<UUID>();
    }

    /**
     * Creates a listing with all propeerties
     * 
     * @param id the id of the job listing
     * @par title the title of the job listing
     * @param payRate      the pay rate of the job listing
     * @param location     the location of the job
     * @param description  a description of the job
     * @param startDate    the start date of the job
     * @param endDate      the end date of the job
     * @param siteLink     a link to the company website
     * @param skills       the skills recommended for this job
     * @param employerName the name of the employer offering the job
     */
    Listing(UUID id, String title, double payRate, String location, ArrayList<String> description, Date startDate,
            Date endDate, String siteLink, ArrayList<Skills> skills, UUID employerId) {
        this.ID = id;
        this.title = title;
        this.payRate = payRate;
        this.location = location;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.siteLink = siteLink;
        this.title = title;
        this.skills = skills;
        this.EMPLOYER_ID = employerId;
        this.applicants = new ArrayList<UUID>();
    }

    /**
     * Converts a job listing to JSON
     * 
     * note: The EMPLOYER_NAME variable is not included, I assume it can be
     * retrieved when parsing JSON from the employer to avoid storing duplicate
     * values in the JSON
     * 
     * @return the JSON representation of a job listing
     */
    public String toJSON() {
        return "{\"id\":\"" + ID.toString() + "\",\"payRate\":" + payRate + ",\"location\":\"" + location
                + "\",\"title\":\"" + title + "\",\"description\":" + DataWriter.stringsToJSON(description)
                + ",\"startDate\":\"" + startDate.toString() + "\",\"endDate\":\"" + endDate.toString()
                + "\",\"siteLink\":\"" + siteLink + "\",\"skills\":" + DataWriter.skillsToJSON(skills)
                + "\",\"applicants\":" + DataWriter.idsToJSON(applicants) + "}";
    }

    /**
     * Creates an Listing from JSON
     * 
     * @param json the json string that an employer is being created from
     * @return the employer represented by the JSON
     */
    public static Listing fromJSON(String json) {
        HashMap<String, String> dict = DataLoader.dictFromBrace(json);
        ArrayList<Skills> skills = new ArrayList<Skills>();
        for (String e : DataLoader.dictFromBracket(dict.get("skills"))) {
            skills.add(Skills.valueOf(e));
        }
        Listing listing = new Listing(UUID.fromString(dict.get("id")), dict.get("title"),
                Double.parseDouble(dict.get("payRate")), dict.get("location"),
                DataLoader.dictFromBracket(dict.get("description")), Date.fromString(dict.get("startDate")),
                Date.fromString(dict.get("endDate")), dict.get("siteLink"), skills,
                UUID.fromString(dict.get("employerId")));
        for (String e : DataLoader.dictFromBracket(dict.get("applicants"))) {
            listing.apply(Resume.fromJSON(e));
        }
        return listing;
    }

    /**
     * Gets the name of the employer offering this job listing
     * 
     * @return the name of the job listing's employer
     */
    public UUID getEmployerId() {
        return this.EMPLOYER_ID;
    }

    /**
     * Gets the pay rate of the job listing
     * 
     * @return the job listing's pay rate
     */
    public double getPayRate() {
        return this.payRate;
    }

    /**
     * Sets the pay rate of the job listing
     * 
     * @param payRate the pay rate of the job listing
     */
    public void setPayRate(double payRate) {
        this.payRate = payRate;
    }

    /**
     * Gets the Location of the job listing
     * 
     * @return the location of the job listing
     */
    public String getLocation() {
        return this.location;
    }

    /**
     * Sets the location of the job listing
     * 
     * @param location the location of the job listing
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * Gets the title of the job listing
     * 
     * @return the title of the job listing
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * Sets the title of the job listing
     * 
     * @param title the title of the job listing
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets the description of the job listing
     * 
     * @return the description of the job listing
     */
    public ArrayList<String> getDescription() {
        return this.description;
    }

    /**
     * Sets the description of the job listing
     * 
     * @param description the new description of the job listing
     */
    public void setDescription(ArrayList<String> description) {
        this.description = description;
    }

    /**
     * Gets the start Date of the job listing
     * 
     * @return the start date of the job listing
     */
    public Date getStartDate() {
        return this.startDate;
    }

    /**
     * Sets the start date of the job listing
     * 
     * @param startDate the start date of the job listing
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * Gets the end date of the job listing
     * 
     * @return the end date of the job listing
     */
    public Date getEndDate() {
        return this.endDate;
    }

    /**
     * Sets the end date of the job listing
     * 
     * @param endDate the end date of the job listing
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    /**
     * gets the site link for the job listing
     * 
     * @return the site link for the job listing
     */
    public String getSiteLink() {
        return this.siteLink;
    }

    /**
     * Sets the site link for the job listing
     * 
     * @param siteLink the site link for the job listing
     */
    public void setSiteLink(String siteLink) {
        this.siteLink = siteLink;
    }

    /**
     * Gets the recommended skills for the job listing
     * 
     * @return the recommended skills for the job listing
     */
    public ArrayList<Skills> getSkills() {
        return this.skills;
    }

    /**
     * Sets the recommended skills for the job listing
     * 
     * @param skills the recommended skills for the job listing
     */
    public void setSkills(ArrayList<Skills> skills) {
        this.skills = skills;
    }

    /**
     * Gets the Students who have applied for the job
     * 
     * @return the students who have applied for the job
     */
    public ArrayList<UUID> getApplicants() {
        return this.applicants;
    }

    /**
     * Adds a resume id to the list of applicants
     * 
     * @param resume the student resume to be added to the list of applicants
     */
    public void apply(Resume resume) {
        this.applicants.add(resume.ID);
    }

    /**
     * Adds a resume id to the list of applicants
     * @param resumeId is id of the resume to be added to the list of applicants
     */
    public void apply(UUID resumeId) {
        this.applicants.add(resumeId);
    }

    /**
     * Displays a listing
     * 
     * @param isEmployer boolean to determine whether the information is being shown
     *                   to a student or an employer - we would show different types
     *                   of users different things
     * @return a displayed listing
     */
    public String toString(boolean isEmployer) {
        String result = EMPLOYER_ID.toString();
        if (!title.isEmpty())
            result += " - " + title;
        result += "\n********************";

        if (isEmployer && applicants.size() > 0) {
            result += "\nApplicants:";
            for (UUID id : applicants)
                result += "\n" + id;
            result += "\n";
        }

        for (String d : description)
            result += "\n" + d;
        result += "\n";

        if (!location.isEmpty())
            result += "\nLocation: " + location;
        if (payRate != 0)
            result += "\nPay Rate: " + payRate;

        if (startDate != null)
            result += "\nStart Date: " + startDate;
        if (endDate != null)
            result += "\nEnd Date: " + endDate;

        if (skills.size() > 0) {
            result += "\n\nRequired Skills:";
            for (Skills s : skills)
                result += "\n" + s.toString();
        }

        if (!siteLink.isEmpty())
            result += "\n\n" + siteLink;

        return result;
    }
}
