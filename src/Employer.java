package src;

import java.util.ArrayList;

/**
 * Employer Class The profile for the Employer
 * 
 * @author Nathanael Oliver
 */
public class Employer extends User {
    private String title;
    private ArrayList<String> description;
    private ArrayList<Listing> listings;

    /**
     * Creates an employer
     * 
     * @param title the company title
     */
    public Employer(String title) {
        super(UserType.employer);
        this.title = title;
        this.listings = new ArrayList<Listing>();
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
        return this.listings;
    }

    /**
     * Gets the Listing with the specified ID
     * 
     * @param id the ID to search for
     * @return The listing with the specified ID, if none, null
     */
    public Listing getListingById(int id) {
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
        return this.title;
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
    public ArrayList<String> getDescription() {
        return this.description;
    }

    /**
     * Sets the employer's description
     * 
     * @param description the new description for the employer
     */
    public void setDescription(ArrayList<String> description) {
        this.description = description;
    }

    /**
     * Adds an item to the description
     * 
     * @param descript the string to be added to the description
     */
    public void addDescription(String descript) {
        this.description.add(descript);
    }

    /**
     * Deletes a listing
     * 
     * @param listing the listing to get deleted
     */
    public void deleteListing(Listing listing) {
        this.listings.remove(listing);
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