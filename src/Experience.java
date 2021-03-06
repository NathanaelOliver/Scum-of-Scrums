package src;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Experience Class
 * 
 * @author Jack Oberman
 */
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
        this.details = new ArrayList<>();
    }

    /**
     * Constructor for Experience with only title and a position
     * 
     * @param title    the title of the experience
     * @param position the position of the user in a company (for work experience)
     */
    public Experience(String title, String position) {
        this.ID = UUID.randomUUID();
        this.title = title;
        this.details = new ArrayList<String>();
        this.details.add(position);
    }

    /**
     * Protected Constructor for use in generating Experiences from JSON
     * 
     * @param id        the id
     * @param title     the title
     * @param details   the details of the experience
     * @param startDate the start date
     * @param endDate   the end date
     */
    protected Experience(UUID id, String title, ArrayList<String> details, Date startDate, Date endDate) {
        this.ID = id;
        this.title = title;
        this.details = details;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    /**
     * Constructor for Experience with all fields
     * 
     * @param title     the title of the experience
     * @param details   details of the experience
     * @param startDate start date of the experience
     * @param endDate   end date of the experience
     */
    public Experience(String title, ArrayList<String> details, Date startDate, Date endDate) {
        this.ID = UUID.randomUUID();
        this.title = title;
        this.details = details;
        this.startDate = startDate;
        this.endDate = endDate;
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

    /**
     * Returns a string representation of an experience
     * 
     * @return string representation
     */
    public abstract String toString();

    /**
     * Checks if two Experiences are equal to each other
     * 
     * @param o the object that is being checked to make sure they are equal
     */
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof Experience)) {
            return false;
        }
        Experience e = (Experience) o;
        if (details.size() != e.details.size()) {
            return false;
        }
        for (int i = 0; i < details.size(); i++) {
            if (details.get(i) != e.details.get(i))
                return false;
        }
        return this.ID.equals(e.ID) && this.title.equals(e.title) && this.startDate.equals(e.startDate)
                && this.endDate.equals(e.endDate);
    }
}