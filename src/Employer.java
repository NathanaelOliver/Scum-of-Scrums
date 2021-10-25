package src;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

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
        listings = new ArrayList<Listing>();
    }

    /**
     * Creates an employer
     * 
     * @param id    the id for the employer
     * @param title the company title
     */
    public Employer(UUID id, boolean isVerified, String username, String password, String title,
            ArrayList<String> description, ArrayList<Listing> listings) {
        super(id, UserType.employer, isVerified, username, password);
        this.title = title;
        this.listings = listings;
        this.description = description;
    }

    /**
     * Creates and adds a Listing to listings
     * 
     * @param listing adds listing to listings
     */
    public void addListing(Listing listing) {
        this.listings.add(listing);
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
            if (e.ID == id) {
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
    public ArrayList<String> getDescription() {
        return description;
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
     * Adds an element to the employer's description
     * 
     * @param description
     */
    public void addDescription(String description) {
        this.description.add(description);
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

    /**
     * Creates an employer from JSON
     * 
     * @param json the json string that an employer is being created from
     * @return the employer represented by the JSON
     */
    public static Employer fromJSON(String json) {
        HashMap<String, String> dict = DataLoader.dictFromBrace(json);
        ArrayList<Listing> listings = new ArrayList<Listing>();
        for (String listing : DataLoader.dictFromBracket(dict.get("listings"))) {
            listings.add(Listing.fromJSON(listing));
        }
        return new Employer(UUID.fromString(dict.get("id")), dict.get("isVerified").equals("true"),
                dict.get("username"), dict.get("password"), dict.get("title"),
                DataLoader.dictFromBracket(dict.get("description")), listings);
    }
}