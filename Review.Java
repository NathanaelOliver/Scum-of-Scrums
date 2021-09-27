
/**
 * Review Class
 * Stores a Review for a User
 * @author Nathanael Oliver
 */
public class Review {
    private int rating;
    private String description;
    private User rater;

    /**
     * Constructor for the Rating class
     * @param rater the User who created the rating
     * @param rating the rating
     * @param description a comment to explain the rating
     */
    public Rating(User rater, int rating, String description) {
        this.rater = rater;
        this.rating = rating;
        this.description = description;
    }

    /**
     * Gets the rating
     * @return the rating
     */
    public int getRating() {
        return rating;
    }

    /**
     * Gets the description
     * @return the description of the rating
     */
    public String getDescription() {
        return description;
    }

    /**
     * Gets the user who created the rating
     * @return the user who created the rating
     */
    public User getRater() {
        return Rater;
    }

    /**
     * Sets the rating to a new value
     * @param rating the new rating
     */
    public void setRating(int rating) {
        this.rating = rating;
    }

    /**
     * Sets the description to a new value
     * @param description the new description
     */
    public void setDescription(String description) {
        this.description = description;
    }
}