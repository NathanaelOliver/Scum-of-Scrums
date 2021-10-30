package src;

import java.util.UUID;

/**
 * Rating Class Stores a Rating for a User
 * 
 * @author Nathanael Oliver
 */
public class Rating {
    public final UUID ID;
    private final UUID RECEIVER_ID;
    private final UUID WRITER_ID;
    private int rating;
    private String comment;

    /**
     * Constructor for the Rating class
     * 
     * @param comment    a comment to explain the rating
     * @param rating     the rating
     * @param writerId   the id of the User who created the rating
     * @param receiverId the id of the user receiving the Rating
     */
    public Rating(String comment, int rating, UUID writerId, UUID receiverId) {
        this.ID = UUID.randomUUID();
        this.comment = comment;
        this.rating = rating;
        this.WRITER_ID = writerId;
        this.RECEIVER_ID = receiverId;
    }

    /**
     * Gets the rating
     * 
     * @return the rating
     */
    public int getRating() {
        return this.rating;
    }

    /**
     * Gets the comment
     * 
     * @return the comment of the rating
     */
    public String getComment() {
        return this.comment;
    }

    /**
     * Gets the id of user who created the rating
     * 
     * @return the id of the user who created the rating
     */
    public UUID getWriterId() {
        return this.WRITER_ID;
    }

    /**
     * Sets the rating to a new value
     * 
     * @param rating the new rating
     */
    public void setRating(int rating) {
        this.rating = rating;
    }

    /**
     * Sets the comment to a new value
     * 
     * @param comment the new comment
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * Gets the id of the user receiving the rating
     * 
     * @return the user receiving the rating
     */
    public UUID getReceiverId() {
        return this.RECEIVER_ID;
    }

    /**
     * Displays the rating
     * 
     * @return the rating as a string
     */
    public String toString() {
        /**
         * TODO - display rating method We are going to run into a problem displaying
         * the title/name of the writer and the reciever as we do not know what type of
         * user they are, and they do not share a common name from the parent User
         * class. Unless we want to display the username, we are probably going to have
         * to change something, or I could just make a complicated workaround.
         */
        return "Displays a rating";
    }

    /**
     * Converts the Rating to a JSON object
     * 
     * @return JSON representation of a rating
     */
    public String toJSON() {
        return "\"id\":\"" + ID.toString() + "\",\"receiverID\":\"" + RECEIVER_ID.toString() + "\",\"rating\":" + rating
                + ",\"comment\":\"" + comment + "\",\"writerID\":\"" + WRITER_ID.toString() + "\"}";
    }
}