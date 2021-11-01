package src;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

/**
 * CourseExperience Class Contains the information related to a course
 * experience
 * 
 * @author Noah MacBride
 */
public class CourseExperience extends Experience {
    private double grade;

    /**
     * Constructor for course experience
     * 
     * @param id        the uuid of the course experience
     * @param title     the title of the course experience
     * @param details   the array list of details
     * @param startDate the start date of the course experience
     * @param endDate   the end date of the course experience
     * @param grade     the grade in the course
     */
    public CourseExperience(UUID id, String title, ArrayList<String> details, Date startDate, Date endDate,
            double grade) {
        super(id, title, details, startDate, endDate);
        this.grade = grade;
    }

    /**
     * Constructor for Course Experience with only a title
     * 
     * @param title the title of the course experience
     */
    public CourseExperience(String title) {
        super(title);
    }

    /**
     * sets grade
     * 
     * @param grade is the grade in the course as a double
     */
    public void setGrade(Double grade) {
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
     * @return the string representation of the Course Experience
     */
    public String toString() {
        String ret = this.title + "\n" + this.startDate + " - " + this.endDate + "\n" + "Grade: " + this.grade;
        for (int i = 0; i < this.details.size(); i++) {
            ret += "\n * " + this.details.get(i);
        }
        return ret;
    }

    /**
     * Converts a Course Experience to a JSON object
     * 
     * @return Course Experience as a JSON object
     */
    public String toJSON() {
        return "{\"id\":\"" + ID.toString() + "\",\"title\":\"" + title + "\",\"details\":"
                + DataWriter.stringsToJSON(details) + ",\"startDate\":\"" + startDate.toString() + "\",\"grade\":"
                + grade + ",\"endDate\":\"" + endDate.toString() + "\"}";
    }

    /**
     * Creates a course experience from JSON
     * 
     * @param json is JSON representation of course experience
     * @return new course experience
     */
    public static CourseExperience fromJSON(String json) {
        HashMap<String, String> dict = DataLoader.dictFromBrace(json);
        return new CourseExperience(UUID.fromString(dict.get("id")), dict.get("title"),
                DataLoader.dictFromBracket(dict.get("details")), Date.fromString(dict.get("startDate")),
                Date.fromString(dict.get("endDate")), Double.parseDouble(dict.get("grade")));
    }

}
