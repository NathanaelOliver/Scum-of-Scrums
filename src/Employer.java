package src;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Employer Class The profile for the Employer
 * 
 * @author Nathanael Oliver
 */
public class Employer extends User {
    private String title;
    private String description;
    private ArrayList<Listing> listings;

    /**
     * Creates an employer
     * 
     * @param id    the id for the employer
     * @param title the company title
     */
    public Employer(String title) {
        super(UserType.employer);
        this.title = title;
        listings = new ArrayList<Listing>();
    }

    /**
     * Creates and adds a Listing to listings TODO - Similar to work experience
     * adding a reference, do we want to ask for input in this method? or do we want
     * to send in all the required data? - Nathanael
     */
    public void addListing() {
    }

    /**
     * Gets the Employer's Job Listings
     * 
     * @return the Employer's job Listings
     */
    public ArrayList<Listing> getListings() {
        return listings;
    }

    /**
     * Gets the Listing with the specified ID
     * 
     * @param id the ID to search for
     * @return The listing with the specified ID, if none, null
     */
    public Listing getListingById(UUID id) {
        for (Listing e : listings) {
            if (e.getId() == id) {
                return e;
            }
        }
        return null;
    }

    /**
     * Gets the employer title
     * 
     * @return the employer title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the company title
     * 
     * @param title the new title of the company
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets the description for the employer
     * 
     * @return the employer description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the employer's description
     * 
     * @param description the new description for the employer
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Deletes a listing
     * 
     * @param listing the listing to get deleted
     */
    public void deleteListing(Listing listing) {
        listings.remove(listing);
    }

    /**
     * Gets a JSON representation of an Employer
     * 
     * @return JSON representation of an Employer
     */
    public String toJSON() {
        return null;
    }
}