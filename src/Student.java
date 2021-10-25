/**
 * Student
 * User Type for Student Users with job app. features
 * @author William Hobbs
 */
package src;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class Student extends User {
    private String firstName;
    private String lastName;
    private int phoneNumber;
    private String email;
    private double gpa;
    private int year;
    private ArrayList<Skills> skills;
    private ArrayList<Experience> experiences;
    private Resume resume;

    /**
     * Constructor for a student
     * 
     * @param firstName the first name of the student
     * @param lastName  the last name of the student
     */
    public Student(String firstName, String lastName) {
        super(UserType.student);
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Student(UUID id, boolean isVerified, String username, String password, String firstName, String lastName,
            int phoneNumber, String email, double gpa, int year, ArrayList<Skills> skills,
            ArrayList<Experience> experiences, Resume resume) {
        super(id, UserType.student, isVerified, username, password);
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.gpa = gpa;
        this.year = year;
        this.skills = skills;
        this.experiences = experiences;
        this.resume = resume;
    }

    /**
     * Converts Student to JSON to be stored in database
     * 
     * @return String, a JSON representation of Student
     */
    public String toJSON() {
        // TODO - run this through a JSON validator; not sure if the helper methods are
        // used correctly
        return "{\"id\":\"" + ID.toString() + "\",\"username\":\"" + username + "\",\"password\":\"" + password
                + "\",\"userType\":\"" + userType.toString() + "\",\"isVerified\":" + isVerified + ",\"firstName\":\""
                + firstName + "\",\"lastName\":\"" + lastName + "\",\"phoneNumber\":" + phoneNumber + ",\"email\":\""
                + email + "\",\"resume\":" + resume.toJSON() + "}";
    }

    /**
     * Creates a student from a JSON object
     * 
     * @param json the json object
     * @return the Student created from the JSON object
     */
    public static Student fromJSON(String json) {
        HashMap<String, String> dict = DataLoader.dictFromBrace(json);
        ArrayList<Skills> skills = new ArrayList<Skills>();
        for (String e : DataLoader.dictFromBracket(dict.get("skills"))) {
            skills.add(Skills.valueOf(e));
        }
        ArrayList<Experience> experiences = new ArrayList<Experience>();
        for (String e : DataLoader.dictFromBracket(dict.get("experience"))) {
            if (e.contains("\"references\"")) {
                experiences.add(WorkExperience.fromJSON(e));
            } else if (e.contains("\"grade\"")) {
                experiences.add(CourseExperience.fromJSON(e));
            } else {
                experiences.add(ClubExperience.fromJSON(e));
            }
        }
        return new Student(UUID.fromString(dict.get("id")), dict.get("isVerified").equals("true"), dict.get("username"),
                dict.get("password"), dict.get("firstName"), dict.get("lastName"),
                Integer.parseInt(dict.get("phoneNumber")), dict.get("email"), Double.parseDouble(dict.get("gpa")),
                Integer.parseInt(dict.get("year")), skills, experiences, Resume.fromJSON(dict.get("resume")));
    }

    /**
     * Gets the student's first name
     * 
     * @return the student's first name
     */
    public String getFirstName() {
        return this.firstName;
    }

    /**
     * sets the students first name
     * 
     * @param firstName the new first name of the student
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the last name of the student
     * 
     * @return the last name of the student
     */
    public String getLastName() {
        return this.lastName;
    }

    /**
     * Sets the last name of the student
     * 
     * @param lastName the student's new last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets the student's phone number
     * 
     * @return the phone number of the student
     */
    public int getPhoneNumber() {
        return this.phoneNumber;
    }

    /**
     * Sets the phone number of the student
     * 
     * @param phoneNumber the new phone number of the student
     */
    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Gets the student's email address
     * 
     * @return the student's email address
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * Sets the student's email address
     * 
     * @param email the student's email address
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the student's GPA
     * 
     * @return the student's GPA
     */
    public double getGpa() {
        return this.gpa;
    }

    /**
     * Sets the student's GPA
     * 
     * @param gpa the new GPA of the student
     */
    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    /**
     * Gets the year that the student is graduating from school
     * 
     * @return the student's graduation year
     */
    public int getYear() {
        return this.year;
    }

    /**
     * Sets the year that the student graduates
     * 
     * @param year the year that the student graduates
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * Gets the Student's Skills
     * 
     * @return the student's skills
     */
    public ArrayList<Skills> getSkills() {
        return this.skills;
    }

    /**
     * sets the students skills
     * 
     * @param skills the students new skills
     */
    public void setSkills(ArrayList<Skills> skills) {
        this.skills = skills;
    }

    /**
     * Gets the student's Experiences
     * 
     * @return the student's experiences
     */
    public ArrayList<Experience> getExperiences() {
        return this.experiences;
    }

    /**
     * Sets the students experiences
     * 
     * @param experiences the student's new experiences.
     */
    public void setExperiences(ArrayList<Experience> experiences) {
        this.experiences = experiences;
    }

    /**
     * Get the student's resume
     * 
     * @return Resume, a copy of the student's resume
     */
    public Resume getResume() {
        return this.resume;
    }

    /**
     * Sets up the student's resume. Student only has one.
     * 
     * @param resume is the student's resume
     */
    public void setResume(Resume resume) {
        this.resume = resume;
    }
}
