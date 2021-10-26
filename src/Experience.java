package src;

import java.util.ArrayList;
import java.util.UUID;

public abstract class Experience implements JSONable {
    public final UUID ID;
    protected String title;
    protected ArrayList<String> details;
    protected Date startDate, endDate;

    /**
     * Constructor for Experience with only title
     * 
     * @param title the title of the experience
     */
    public Experience(String title) {
        this.ID = UUID.randomUUID();
        this.title = title;
        details = new ArrayList<String>();
    }

    /**
     * Gets the title of the experience
     * 
     * @return the title of the experience
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * sets the title of the experience
     * 
     * @param title the new title of the experience
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets the details of the Experience
     * 
     * @return the details of the experience
     */
    public ArrayList<String> getDetails() {
        return this.details;
    }

    /**
     * Sets the details of the experience
     * 
     * @param details the new details of the experience
     */
    public void setDetails(ArrayList<String> details) {
        this.details = details;
    }

    /**
     * Adds a detail to the experience
     * 
     * @param detail the new detail to be added to the experience
     */
    public void addDetail(String detail) {
        this.details.add(detail);
    }

    /**
     * Gets the start date for the experience
     * 
     * @return the start date for the experience
     */
    public Date getStartDate() {
        return this.startDate;
    }

    /**
     * Sets the start date of the experience
     * 
     * @param startDate the new start date of the experience
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * Gets the end date of the experience
     * 
     * @return the end date of the experience
     */
    public Date getEndDate() {
        return this.endDate;
    }

    /**
     * Sets the end date of the experience
     * 
     * @param endDate the end date of the experience
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}