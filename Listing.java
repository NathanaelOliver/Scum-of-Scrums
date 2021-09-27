import java.util.Date;
import java.util.ArrayList;

public class Listing {
    private double payRate;
    private String location;
    private ArrayList<String> description;
    private Date startDate;
    private Date endDate;
    private String siteLink;
    private ArrayList<Skills> skills;
    private ArrayList<Student> applicants;
    private int id;




    public Listing() {

    }

    /**
     * Gets the ID for the listing
     * @return the listing ID
     */
    public int getID() {
        return id;
    }
}