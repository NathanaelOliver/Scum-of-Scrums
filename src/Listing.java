import java.util.Date;
import java.util.ArrayList;

public class Listing {
    private double payRate;
    private String location;
    private ArrayList<String> description;
    private Date startDate;
    private Date endDate;
    private String siteLink;
    private ArrayList<Skills> skills;
    private ArrayList<Student> applicants;
    private final int id;

    public Listing(int id) {
        this.id = id;
    }

    /**
     * Converts a job listing to JSON
     * TODO - complete toJSON method
     * @return the JSON representation of a job listing
     */
    public String toJSON() {
        return null;
    }

    /**
     * Gets the ID for the listing
     * @return the listing ID
     */
    public int getID() {
        return id;
    }

    /**
     * Gets the pay rate of the job listing
     * @return the job listing's pay rate
     */
    public double getPayRate() {
        return this.payRate;
    }

    /**
     * Sets the pay rate of the job listing
     * @param payRate the pay rate of the job listing
     */
    public void setPayRate(double payRate) {
        this.payRate = payRate;
    }

    /**
     * Gets the Location of the job listing
     * @return the location of the job listing
     */
    public String getLocation() {
        return this.location;
    }

    /**
     * Sets the location of the job listing
     * @param location the location of the job listing
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * Gets the description of the job listing
     * @return the description of the job listing
     */
    public ArrayList<String> getDescription() {
        return this.description;
    }

    /**
     * Sets the description of the job listing
     * @param description the new description of the job listing
     */
    public void setDescription(ArrayList<String> description) {
        this.description = description;
    }

    /**
     * Gets the start Date of the job listing
     * @return the start date of the job listing
     */
    public Date getStartDate() {
        return this.startDate;
    }

    /**
     * Sets the start date of the job listing
     * @param startDate the start date of the job listing
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * Gets the end date of the job listing
     * @return the end date of the job listing
     */
    public Date getEndDate() {
        return this.endDate;
    }

    /**
     * Sets the end date of the job listing
     * @param endDate the end date of the job listing
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    /**
     * gets the site link for the job listing
     * @return the site link for the job listing
     */
    public String getSiteLink() {
        return this.siteLink;
    }

    /**
     * Sets the site link for the job listing
     * @param siteLink the site link for the job listing
     */
    public void setSiteLink(String siteLink) {
        this.siteLink = siteLink;
    }

    /**
     * Gets the recommended skills for the job listing
     * @return the recommended skills for the job listing
     */
    public ArrayList<Skills> getSkills() {
        return this.skills;
    }

    /**
     * Sets the recommended skills for the job listing
     * @param skills the recommended skills for the job listing
     */
    public void setSkills(ArrayList<Skills> skills) {
        this.skills = skills;
    }

    /**
     * Gets the Students who have applied for the job
     * @return the students who have applied for the job
     */
    public ArrayList<Student> getApplicants() {
        return this.applicants;
    }
}