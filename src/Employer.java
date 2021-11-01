package src;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

/**
 * Employer Class The profile for the Employer
 * 
 * @author Nathanael Oliver, William Hobbs
 */
public class Employer extends User {
    private String title;
    private ArrayList<String> description;
    private ArrayList<Listing> listings;
    private ArrayList<Rating> ratings;
    
    /**
     * Employer Constructor
     * @param username employer's username
     * @param password employer's password
     * @param title employer's title
     */
    public Employer(String username, String password, String title) {
        super(username, password, UserType.employer);
        this.title = title;
        this.description = new ArrayList<String>();
        this.listings = new ArrayList<Listing>();
        this.ratings = new ArrayList<Rating>();
    }

    /**
     * Employer Constructor
     * @param id employer's user id
     * @param isVerified boolean for if employer is verified
     * @param username employer's username
     * @param password employer's password
     * @param title employer's title
     * @param description employer's description
     * @param listings employer's list of listings
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

    public void setListings(ArrayList<Listing> listings) {
        this.listings = listings;
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
     * Adds a rating to the employer's list of ratings
     * 
     * @param rating the rating being added to this employer
     */
    public void addRating(Rating rating) {
        this.ratings.add(rating);
    }

    /**
     * Adds a rating to the employer's list of ratings
     * 
     * @param score   the score (out of 5) the rating received
     * @param comment a note from the student about this employer
     * @param student the student reviewing this employer
     */
    public void addRating(int score, String comment, Student student) {
        this.ratings.add(new Rating(comment, score, student.ID, this.ID));
    }

    /**
     * Gets all of this employer's ratings
     * 
     * @return this employer's ratings
     */
    public ArrayList<Rating> getRatings() {
        return this.ratings;
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
        // TODO - run this through a json validator, think it may be missing a comma
        String ret = "{\"title\":\"" + this.title + "\",";
        ret += DataWriter.stringsToJSON(this.description);
        ret += ",";
        // TODO - this whole thing is broken due to changes in the architecture of Employer
        ret += ",";
        return ret;
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

    /**
     * return a string representation
     * @return string representation
     */
    public String toString() {
        String ret = "Title: " + title;
        for (String detail: description) {
            ret += "\n * " + detail;
        }
        return ret;
    }
}