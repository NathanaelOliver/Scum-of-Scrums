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
     * Converts a Course Experience to a JSON object
     * 
     * @return Course Experience as a JSON object
     */
    public String toJSON() {
        return "{\"id\":" + ID.toString() + "\",\"title\":\"" + title + "\",\"details\":"
                + DataWriter.stringsToJSON(details) + ",\"startDate\":\"" + startDate.toString() + "\",\"endDate\":\""
                + endDate.toString() + "\",\"grade\":" + grade + "}";
    }

    public static CourseExperience fromJSON(String json) {
        HashMap<String, String> dict = DataLoader.dictFromBrace(json);
        return new CourseExperience(UUID.fromString(dict.get("id")), dict.get("title"),
                DataLoader.dictFromBracket(dict.get("details")), Date.fromString(dict.get("startDate")),
                Date.fromString(dict.get("endDate")), Double.parseDouble(dict.get("grade")));
    }

}
