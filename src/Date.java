package src;

public class Date {
    private final int MONTH, DAY, YEAR;

    public Date(int month, int day, int year) {
        this.MONTH = month;
        this.DAY = day;
        this.YEAR = year;
    }

    public String toString() {
        return MONTH + "/" + DAY + "/" + YEAR;
    }
}
