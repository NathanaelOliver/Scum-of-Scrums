package src;

/**
 * Ensures that object can be converted into JSON
 * 
 * @author Nathanael Oliver
 */
public interface JSONable {
    /**
     * Converts an Object to a JSON object
     * 
     * @return the JSON representation of an Object
     */
    String toJSON();
}