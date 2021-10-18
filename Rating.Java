import java.util.uuid;
/**
 * Rating Class
 * Stores a Rating for a User
 * @author Nathanael Oliver
 */
public class Rating {
    private final UUID id;
    private int rating;
    private String comment;
    private UUID receiverId;
    private UUID writerId;

    /**
     * Constructor for the Rating class
     * @param comment a comment to explain the rating
     * @param rating the rating
     * @param writerId the id of the User who created the rating
     * @param receiverId the id of the user receiving the Rating
     */
    public Rating(String comment, int rating, UUID writerId, UUID receiverId) {
        this.id = UUID.randomUUID()
        this.comment = comment;
        this.rating = rating;
        this.writerId = writerId;
        this.receiverId = receiverId;
    }

    /**
     * Gets the rating
     * @return the rating
     */
    public int getRating() {
        return rating;
    }

    /**
     * Gets the comment
     * @return the comment of the rating
     */
    public String getComment() {
        return comment;
    }

    /**
     * Gets the id of user who created the rating
     * @return the id of the user who created the rating
     */
    public UUID getWriterId() {
        return writerId;
    }

    /**
     * Sets the rating to a new value
     * @param rating the new rating
     */
    public void setRating(int rating) {
        this.rating = rating;
    }

    /**
     * Sets the comment to a new value
     * @param comment the new comment
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * Gets the id of the user receiving the rating
     * @return the user receiving the rating
     */
    public UUID getReceiverId() {
        return receiverId;
    }

    /**
     * Gets the id of the rating
     * @return the id of the rating
     */
    public UUID getId() {
        return this.id;
    }

    /**
     * Displays the rating
     * @return the rating as a string
     */
    public String toString() {
        /**
         * TODO - display rating method
         * We are going to run into a problem displaying the title/name 
         * of the writer and the reciever as we do not know what type of user
         * they are, and they do not share a common name from the parent User 
         * class. Unless we want to display the username, we are probably going
         * to have to change something, or I could just make a complicated workaround.
         */
        return "";
    }

    /**
     * Converts the Rating to a JSON object
     * @return JSON representation of a rating
     */
    public String toJSON() {
        // TODO - complete JSON method
        return "";
    }
}