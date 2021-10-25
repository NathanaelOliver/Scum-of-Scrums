package src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * DataLoader Class
 * 
 * @author Nathanael Oliver
 */
public class DataLoader {

    /**
     * Private Default Constructor so an instance cannot be made.
     */
    private DataLoader() {

    }

    /**
     * Gets the JSON text from the file and returns it as a string
     * 
     * @return the JSON file as a string
     */
    public static String getJSON() {
        String jsonText = "";
        Scanner scan = new Scanner("data/Users.json");
        while (scan.hasNextLine()) {
            jsonText += scan.nextLine();
        }
        scan.close();
        jsonText.replaceAll("\\s", "");
        return jsonText;
    }

    /**
     * Creates a dictionary containing all the key value pairs within the json
     * 
     * @param json the json
     * @return a hashmap of the JSON object
     */
    public static HashMap<String, String> dictFromBrace(String json) {
        // TODO - This method is also probably broken
        HashMap<String, String> dict = new HashMap<String, String>();
        for (int i = 0; i < json.length() - 1;) {
            while (json.charAt(i) != '"') {
                i++;
            }
            i++;
            int kStart = i;
            while (json.charAt(i) != '"') {
                i++;
            }
            int kEnd = i;
            i += 2;
            if (json.charAt(i) == '"') {
                i++;
                int vStart = i;
                i++;
                while (json.charAt(i) != '"') {
                    i++;
                }
                int vEnd = i;
                dict.put(json.substring(kStart, kEnd), json.substring(vStart, vEnd));
            } else if (json.charAt(i) == 't') {
                dict.put(json.substring(kStart, kEnd), "true");
            } else if (json.charAt(i) == 'f') {
                dict.put(json.substring(kStart, kEnd), "false");
            } else if (json.charAt(i) == '{') {
                int count = 1;
                int vStart = i;
                i++;
                while (count != 0) {
                    i++;
                    if (json.charAt(i) == '{') {
                        count++;
                    } else if (json.charAt(i) == '}') {
                        count--;
                    }
                }
                i++;
                int vEnd = i;
                dict.put(json.substring(kStart, kEnd), json.substring(vStart, vEnd));
            } else if (json.charAt(i) == '[') {
                int count = 1;
                int vStart = i;
                i++;
                while (count != 0) {
                    i++;
                    if (json.charAt(i) == '[') {
                        count++;
                    } else if (json.charAt(i) == ']') {
                        count--;
                    }
                }
                i++;
                dict.put(json.substring(kStart, kEnd), json.substring(vStart, i));
            } else {
                int vStart = i;
                while (json.charAt(i) != ',') {
                    i++;
                }
                dict.put(json.substring(kStart, kEnd), json.substring(vStart, i));
            }
        }
        return dict;
    }

    /**
     * Creates an ArrayList of elements within the brackets in the json
     * 
     * @param json the json
     * @return an ArrayList of elements within the brackets
     */
    public static ArrayList<String> dictFromBracket(String json) {
        switch (json.charAt(1)) {
        case '"':
            return (ArrayList<String>) Arrays.asList(json.split(","));
        case '{':
            ArrayList<String> dict = new ArrayList<String>();
            int start = 1;
            int count = 0;
            boolean flag = true;
            for (int i = 0; i < json.length(); i++) {
                if (flag) {
                    switch (json.charAt(i)) {
                    case '{':
                        if (count == 0)
                            start = i;
                        count += flag ? 1 : 0;
                        break;
                    case '}':
                        count -= flag ? 1 : 0;
                        if (count == 0)
                            dict.add(json.substring(start, i + 1));
                        break;
                    case '"':
                        flag = !flag;
                    }
                }
            }
            return dict;
        }
        return null;
    }

    /**
     * Gets the specified value from the JSON
     * 
     * @param json the JSON to get the value from
     * @param key  the key that is being searched for
     * @return the value corresponding to the key in the JSON
     *
     *         public static String getValue(String json, String key) { key = "\"" +
     *         key + "\":"; return json.substring(json.indexOf(key) + key.length(),
     *         json.substring(json.indexOf(key) + key.length()).indexOf("\",") +
     *         json.indexOf(key) + key.length()); }
     * 
     *         public static String[] arrayFromJSON(String json, String key) { key =
     *         "\"" + key + "\":["; return json.substring(json.indexOf(key) +
     *         key.length(), json.substring(json.indexOf(key) +
     *         key.length()).indexOf("]") + json.indexOf(key) + key.length())
     *         .split("},{"); }
     * 
     *         public static ArrayList<String> stringArrayFromJSON(String json,
     *         String key) { key = "\"" + key + "\":["; return (ArrayList<String>)
     *         Arrays.asList(json.substring(json.indexOf(key) + key.length(),
     *         json.substring(json.indexOf(key) + key.length()).indexOf("]") +
     *         json.indexOf(key) + key.length()) .split("\",\"")); }
     * 
     *         public static int getIntValue(String json, String key) { key = "\"" +
     *         key + "\":"; return Integer.parseInt(json.substring(json.indexOf(key)
     *         + key.length(), json.substring(json.indexOf(key) +
     *         key.length()).indexOf(",") + json.indexOf(key) + key.length())); }
     */
}
