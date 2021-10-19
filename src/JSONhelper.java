package src;

import java.util.ArrayList;

public class JSONhelper {
    /**
     * Private constructor so no instances can be made
     */
    private JSONhelper() {
    }

    /**
     * Takes a list of JSON objects and outputs the concatonation of all of them as
     * JSON objects delimited by Strings
     * 
     * @param list the list of objects to be converted to JSON
     * @return the concatonated list as JSON objects
     */
    public static String toJson(ArrayList<? extends JSONable> list) {
        String str = "";
        for (int i = 0; i < list.size(); i++) {
            str += ((JSONable) list.get(i)).toJSON() + ",";
        }
        return str.substring(0, str.length() - 1);
    }

    public static String skillsToJSON(ArrayList<Skills> skills) {
        return "";
    }
}
