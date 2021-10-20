package src;

import java.util.ArrayList;
import java.util.Date;

/**
 * CourseExperience Class Contains the information related to a course
 * experience
 * 
 * @author Noah MacBride
 */
public class CourseExperience extends Experience {
    private double grade;

    /**
     * Constructor for Course Experience with only a title
     * 
     * @param title the title of the course experience
     */
    public CourseExperience(String title) {
        super(title);
    }

    /**
     * Constructor for Course Experience with all fields except grade
     * 
     * @param title     the title of the experience
     * @param details   details of the experience
     * @param startDate start date of the experience
     * @param endDate   end date of the experience
     */
    public CourseExperience(String title, ArrayList<String> details, Date startDate, Date endDate) {
        super(title, details, startDate, endDate);
    }

    /**
     * Constructor for Course Experience with all fields including grade
     * 
     * @param title     the title of the experience
     * @param details   details of the experience
     * @param startDate start date of the experience
     * @param endDate   end date of the experience
     * @param grade     grade attained by student in the course:uses floating point
     */
    public CourseExperience(String title, ArrayList<String> details, Date startDate, Date endDate, double grade) {
        super(title, details, startDate, endDate);
        this.grade = grade;
    }

    /**
     * Gets the student's grade in the course
     * 
     * @return the student's grade in the course
     */
    public double getGrade() {
        return grade;
    }

    /**
     * Converts a Course Experience to a JSON object
     * 
     * @return Course Experience as a JSON object
     */
    public String toJSON() {
        return "{\"id\": " + this.ID.toString() + ",\"title\": \"" + this.title + "\",\"details\":"
                + JSONhelper.stringsToJSON(details) + ",\"startDate\": \"" + startDate.toString()
                + "\",\"endDate\": \"" + endDate.toString() + "\",\"grade\": " + grade + "}";
    }

}
