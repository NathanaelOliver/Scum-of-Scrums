package src;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

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
    public static String getJSON(String filePath) {
        String jsonText = "";
        try {
            Scanner scan = new Scanner(new File(filePath));
            while (scan.hasNextLine()) {
                jsonText += scan.nextLine().trim();
            }
            scan.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getStackTrace());
            return null;
        }
        return jsonText;
    }

    /**
     * Creates a dictionary containing all the key value pairs within the json
     * 
     * @param json the json
     * @return a hashmap of the JSON object
     */
    public static HashMap<String, String> dictFromBrace(String json) {
        HashMap<String, String> dict = new HashMap<String, String>();
        int i = 0;
        while (i < json.length()) {

            while (json.charAt(i) != '"') {
                i++;
                if (i == json.length()) {
                    return dict;
                }
            }
            int kStart = i + 1;
            do {
                i++;
            } while (json.charAt(i) != '"');
            int kEnd = i;
            do {
                i++;
            } while (json.charAt(i) == ' ' || json.charAt(i) == '\t' || json.charAt(i) == '\n'
                    || json.charAt(i) == ':');
            int vStart = i;
            int count = 0;
            switch (json.charAt(i)) {
            case '"':
                vStart++;
                do {
                    i++;
                } while (json.charAt(i) != '"');
                break;
            case 'f':
                i += 5;
                break;
            case 't':
                i += 4;
                break;
            case '{':
                count = 0;
                do {
                    if (json.charAt(i) == '{') {
                        count++;
                    } else if (json.charAt(i) == '}') {
                        count--;
                    }
                    i++;
                } while (count != 0);
                break;
            case '[':
                count = 0;
                do {
                    if (json.charAt(i) == '[') {
                        count++;
                    } else if (json.charAt(i) == ']') {
                        count--;
                    }
                    i++;
                } while (count != 0);
                break;
            default:
                do {
                    i++;
                } while (json.charAt(i) != ',');
            }
            dict.put(json.substring(kStart, kEnd).trim(), json.substring(vStart, i).trim());
            i++;
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
        if (json == null || json.length() <= 2) {
            return new ArrayList<String>();
        }

        json = json.trim().substring(1, json.trim().length() - 1).trim();
        switch (json.charAt(0)) {
        case '"':
            return stringDictFromBracket(json);
        case '{':
            return objectDictFromBracket(json);
        }
        return new ArrayList<String>();
    }

    /**
     * Creates an ArrayList of json objects from comma delimited json objects
     * 
     * @param json comma delimited json object
     * @return an arraylist of JSON objects
     */
    public static ArrayList<String> stringDictFromBracket(String json) {
        ArrayList<String> dict = new ArrayList<String>();
        for (String e : json.split(",")) {
            if (e.trim().length() > 0)
                dict.add(e.trim().substring(1, e.trim().length() - 1));
        }
        return dict;
    }

    /**
     * Creates an ArrayList of Strings from comma delimited JSON strings
     * 
     * @param json comma delimited JSON Strings
     * @return ArrayList of Strings
     */
    public static ArrayList<String> objectDictFromBracket(String json) {
        ArrayList<String> dict = new ArrayList<String>();
        int start = 0, count = 0, i = 0;
        boolean flag = true;
        do {
            while (!(json.charAt(i) == '"' || json.charAt(i) == '{')) {
                i++;
                if (i == json.length()) {
                    return dict;
                }
            }
            start = i;
            do {
                switch (json.charAt(i)) {
                case '"':
                    flag = !flag;
                    break;
                case '{':
                    count += flag ? 1 : 0;
                    break;
                case '}':
                    count -= flag ? 1 : 0;
                    break;
                }
                i++;
            } while (count != 0);
            dict.add(json.substring(start, i).trim());
        } while (i != json.length());
        return dict;
    }
}
