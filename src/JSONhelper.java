package src;

import java.util.ArrayList;

public class JSONhelper {
    /**
     * Private constructor so no instances can be made
     */
    private JSONhelper() {
    }

    /**
     * Takes a list of JSON objects and outputs the concatenation of them as
     * JSON objects delimited by Strings
     * 
     * @param list the list of objects to be converted to JSON
     * @return the concatenated list as JSON objects
     */
    public static String toJson(ArrayList<? extends JSONable> list) {
        String str = " [";
        for (JSONable j : list)
            str += j.toJSON() + ",";
        return str.substring(0, str.length() - 1) + "]";
    }

    /**
     * Takes a list of skills and outputs the concatenation of them as JSON
     * objects delimited by Strings
     * 
     * @param skills the list of skills to be converted to JSON
     * @return the concatenated list as JSON objects
     */
    public static String skillsToJSON(ArrayList<Skills> skills) {
        String str = " [";
        for (Skills s : skills)
            str += "\"" + s.toString() + "\",";
        return str.substring(0, str.length() - 1) + "]";
    }

    /**
     * Takes a list of Strings and outputs the concatenation of them as
     * JSON objects delimited by Strings
     * 
     * @param strings the list of strings to be converted to JSON
     * @return the concatenated list as JSON objects
     */
    public static String stringsToJSON(ArrayList<String> strings) {
        return " [\"" + String.join("\",\"", strings) + "\"]";
    }
}
