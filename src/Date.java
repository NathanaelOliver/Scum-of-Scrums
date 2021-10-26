package src;

/**
 * Date class
 * 
 * @author Nathanael Oliver
 */
public class Date {
    private int month;
    private int day;
    private int year;

    /**
     * Constructor for the date class
     * 
     * @param day   the day
     * @param month the month
     * @param year  the year
     */
    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    /**
     * Creates a Date from a String
     * 
     * @param string the string
     * @return a date created from the string
     */
    public static Date fromString(String string) {
        return new Date(Integer.parseInt(string.substring(0, 2)), Integer.parseInt(string.substring(3, 5)),
                Integer.parseInt(string.substring(6, 8)));
    }

    /**
     * Converts Date to a string
     * 
     * @return the date as a string
     */
    public String toString() {
        return (day < 10 ? "0" : "") + day + "/" + (month < 10 ? "0" : "") + month + "/" + year;
    }
}
