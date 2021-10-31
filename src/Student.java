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
    private Resume resume;
    private ArrayList<Application> applications;

    /**
     * Constructor for a student
     * 
     * @param username  the username of the student
     * @param password  the password of the student
     * @param firstName the first name of the student
     * @param lastName  the last name of the student
     * @param email     the email of the student
     */
    public Student(String username, String password, String firstName, String lastName, String email) {
        super(username, password, UserType.student);
        this.resume = new Resume(firstName, lastName, email);
        this.applications = new ArrayList<>();
    }

    /**
     * Constructor for a student
     * 
     * @param username    the username of the student
     * @param password    the password of the student
     * @param firstName   the first name of the student
     * @param lastName    the last name of the student
     * @param phoneNumber the phone number of the student
     * @param email       the email of the student
     * @param gpa         the gpa of the student
     * @param year        the graduation year of the student
     */
    public Student(String username, String password, String firstName, String lastName, String phoneNumber,
            String email, double gpa, int year) {
        this(username, password, firstName, lastName, email);
        this.setPhoneNumber(phoneNumber);
        this.setYear(year);
        this.setGPA(gpa);
    }

    /**
     * Student Constructor
     * @param id student user id
     * @param isVerified boolean if user if verified
     * @param username student's username
     * @param password student's password
     * @param year student's grade level
     * @param resume student's resume
     */
    public Student(UUID id, boolean isVerified, String username, String password,
                   int year, Resume resume) {
        super(id, UserType.student, isVerified, username, password);
        this.applications = new ArrayList<>();
        this.resume = resume;
        this.setYear(year);
    }

    /**
     * Converts Student to JSON to be stored in database
     * 
     * @return String, a JSON representation of Student
     */
    public String toJSON() {
        return "{\"id\":\"" + ID.toString() + "\",\"username\":\"" + username + "\",\"password\":\"" + password
                + "\",\"userType\":\"" + userType.toString() + "\",\"isVerified\":" + isVerified
                + ",\"resume\":" + resume.toJSON() + "}";
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
                dict.get("password"), dict.get("year") == null ? 0 : Integer.parseInt(dict.get("year")), Resume.fromJSON(dict.get("resume")));
    }

    /**
     * Gets the student's first name
     * 
     * @return the student's first name
     */
    public String getFirstName() {
        return this.resume.getFirstName();
    }

    /**
     * sets the students first name
     * 
     * @param firstName the new first name of the student
     */
    public void setFirstName(String firstName) {
        this.resume.setFirstName(firstName);
    }

    /**
     * Gets the last name of the student
     * 
     * @return the last name of the student
     */
    public String getLastName() {
        return this.resume.getLastName();
    }

    /**
     * Sets the last name of the student
     * 
     * @param lastName the student's new last name
     */
    public void setLastName(String lastName) {
        this.resume.setLastName(lastName);
    }

    /**
     * Gets the student's phone number
     * 
     * @return the phone number of the student
     */
    public String getPhoneNumber() {
        return this.resume.getPhoneNumber();
    }

    /**
     * Sets the phone number of the student
     * 
     * @param phoneNumber the new phone number of the student
     */
    public void setPhoneNumber(String phoneNumber) {
        this.resume.setPhoneNumber(phoneNumber);
    }

    /**
     * Gets the student's email address
     * 
     * @return the student's email address
     */
    public String getEmail() {
        return this.resume.getEmail();
    }

    /**
     * Sets the student's email address
     * 
     * @param email the student's email address
     */
    public void setEmail(String email) {
        this.resume.setEmail(email);
    }

    /**
     * Gets the year that the student is graduating from school
     * 
     * @return the student's graduation year
     */
    public int getYear() {
        return this.resume.getYear();
    }

    /**
     * Sets the year that the student graduates
     * 
     * @param year the year that the student graduates
     */
    public void setYear(int year) {
        this.resume.setYear(year);
    }

    /**
     * Gets the student's Grade Point Average (GPA)
     * 
     * @return the student's GPA
     */
    public double getGPA() {
        return this.resume.getGPA();
    }

    /**
     * Sets the student's Grade Point Average (GPA)
     * 
     * @param gpa the student's new GPA
     */
    public void setGPA(double gpa) {
        this.resume.setGPA(gpa);
    }

    /**
     * Gets all of a student's skills
     * 
     * @return the student's skills
     */
    public ArrayList<Skills> getSkills() {
        return this.resume.getSkills();
    }

    /**
     * Adds a skill to a student's list
     * 
     * @param skill new skill to be added to resume
     */
    public void addSkill(Skills skill) {
        this.resume.addSkill(skill);
    }

    /**
     * Adds a job application to the student's records
     * 
     * @param app the new application to be added
     */
    public void addApplication(Application app) {
        this.applications.add(app);
    }

    /**
     * Gets all of a student's past applications
     * 
     * @return the student's applications
     */
    public ArrayList<Application> getApplications() {
        return this.applications;
    }

    /**
     * Gets all the student's experiences
     * 
     * @return the student's experiences
     */
    public ArrayList<Experience> getExperiences() {
        return this.resume.getExperiences();
    }

    /**
     * Adds a work experience to a student's resume
     * 
     * @param e work experience to be added to resume
     */
    public void addExperience(WorkExperience e) {
        this.resume.addExperience(e);
    }

    public void addExperience(CourseExperience e) {
        this.resume.addExperience(e);
    }

    public void addExperience(ClubExperience e) {
        this.resume.addExperience(e);
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

    public String toString() {
        return "Student toString result";
    }
}
