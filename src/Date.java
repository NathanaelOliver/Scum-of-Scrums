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
        if (string.equals("")) {
            return null;
        }
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

    /**
     * compare two dates
     * 
     * @param date is the date to compare with
     * @return -1 if this date is less than the date being compared with 1 if this
     *         date is greater than the date being compared with 0 if the dates are
     *         equal
     */
    public int compareTo(Date date) {
        if (year < date.year)
            return -1;
        else if (year > date.year)
            return 1;

        if (month < date.month)
            return -1;
        else if (month > date.month)
            return 1;

        if (day < date.day)
            return -1;
        else if (day > date.day)
            return 1;

        return 0;
    }

    /**
     * Checks if two Experiences are equal to each other
     * 
     * @param o the object that is being checked to make sure they are equal
     */
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof Date)) {
            return false;
        }
        return this.compareTo((Date) o) == 0;
    }
}
