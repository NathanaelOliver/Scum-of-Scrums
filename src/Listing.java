package src;

import java.util.Date;
import java.util.UUID;
import java.util.ArrayList;

public class Listing implements JSONable {
    private double payRate;
    private String location;
    private ArrayList<String> description;
    private Date startDate;
    private Date endDate;
    private String siteLink;
    private ArrayList<Skills> skills;
    private ArrayList<Resume> applicants;
    private final UUID id;

    /**
     * Creates an empty Listing with only an id
     */
    public Listing() {
        this.id = UUID.randomUUID();
    }

    /**
     * Creates a listing with all propeerties
     * 
     * @param payRate     the pay rate of the job listing
     * @param location    the location of the job
     * @param description a description of the job
     * @param startDate   the start date of the job
     * @param endDate     the end date of the job
     * @param siteLink    a link to the company website
     * @param skills      the skills recommended for this job
     */
    Listing(double payRate, String location, ArrayList<String> description, Date startDate, Date endDate,
            String siteLink, ArrayList<Skills> skills) {
        this.id = UUID.randomUUID();
        this.payRate = payRate;
        this.location = location;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.siteLink = siteLink;
        this.skills = skills;
    }

    /**
     * Converts a job listing to JSON
     * 
     * @return the JSON representation of a job listing
     */
    public String toJSON() {
        // TODO - complete toJSON method
        return null;
    }

    /**
     * Gets the ID for the listing
     * 
     * @return the listing ID
     */
    public UUID getId() {
        return id;
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
    public ArrayList<Resume> getApplicants() {
        return this.applicants;
    }

    /**
     * Adds a student to the list of applicants
     * 
     * @param student the student to be added to the list of applicants
     */
    public void apply(Resume resume) {
        this.applicants.add(resume);
    }
}