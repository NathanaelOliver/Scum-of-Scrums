package src;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

public class DataWriter {
    /**
     * Private constructor so no instances can be made
     */
    private DataWriter() {
    }

    /**
     * Takes a list of JSON objects and outputs the concatenation of them as JSON
     * objects delimited by Strings
     * 
     * @param list the list of objects to be converted to JSON
     * @return the concatenated list as JSON objects
     */
    public static String toJSON(ArrayList<? extends JSONable> list) {
        String str = "[ ";
        for (JSONable j : list)
            str += j.toJSON() + ",";
        return str.substring(0, str.length() - 1) + "]";
    }

    /**
     * Takes a list of skills and outputs the concatenation of them as JSON objects
     * delimited by Strings
     * 
     * @param skills the list of skills to be converted to JSON
     * @return the concatenated list as JSON objects
     */
    public static String skillsToJSON(ArrayList<Skills> skills) {
        String str = "[ ";
        for (Skills s : skills)
            str += "\"" + s.toString() + "\",";
        return str.substring(0, str.length() - 1) + "]";
    }

    public static String idsToJSON(ArrayList<UUID> ids) {
        ArrayList<String> idStrings = new ArrayList<>();
        for (UUID id : ids)
            idStrings.add(id.toString());
        return DataWriter.stringsToJSON(idStrings);
    }

    /**
     * Takes a list of Strings and outputs the concatenation of them as JSON objects
     * delimited by Strings
     * 
     * @param strings the list of strings to be converted to JSON
     * @return the concatenated list as JSON objects
     */
    public static String stringsToJSON(ArrayList<String> strings) {
        return "[\"" + String.join("\",\"", strings) + "\"]";
    }

    /**
     * Saves all things in database to JSON files
     */
    public static void save() throws IOException {
        String users = "{\"unverifiedUsers\":" + toJSON(Database.unverifiedUsers) + ",\"students\":"
                + toJSON(Database.students) + ",\"employers\":" + toJSON(Database.employers) + ",\"admins\":"
                + toJSON(Database.admins) + "}";

        BufferedWriter writer = new BufferedWriter(new FileWriter("data/Users2.json"));
        writer.write(users);
        writer.close();
    }
}
