package src;

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
                + JSONhelper.stringsToJSON(details) + ",\"startDate\":\"" + startDate.toString()
                + "\",\"endDate\":\"" + endDate.toString() + "\",\"grade\":" + grade + "}";
    }

}
