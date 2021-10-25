/**
 * Student
 * User Type for Student Users with job app. features
 * @author Nathanael Oliver, William Hobbs
 */
package src;

import java.util.ArrayList;

public class Student extends User {
    private int phoneNumber;
    private String email;
    private int year;
    private Resume resume;

    /**
     * Constructor for a student
     * 
     * @param username the username of the student
     * @param password the password of the student
     * @param firstName the first name of the student
     * @param lastName  the last name of the student
     * @param email the email of the student
     */
    public Student(String username, String password, String firstName, String lastName, String email) {
        super(username, password);
        this.email = email;
        this.resume = new Resume(firstName, lastName);
    }

    /**
     * Constructor for a student
     * 
     * @param username the username of the student
     * @param password the password of the student
     * @param firstName the first name of the student
     * @param lastName  the last name of the student
     * @param phoneNumber the phone number of the student
     * @param email the email of the student
     * @param gpa the gpa of the student
     * @param year the graduation year of the student
     */
    public Student(String username, String password, String firstName, String lastName, int phoneNumber, String email, double gpa, int year) {
        this(username, password, firstName, lastName, email);
        this.phoneNumber = phoneNumber;
        this.year = year;
        this.resume.setGPA(gpa);
    }

    /**
     * Converts Student to JSON to be stored in database
     * TODO - run this through a JSON validator; not sure if the helper methods are used correctly
     * @return String, a JSON representation of Student
     */
    public String toJSON() {
        return "{\"id\":\"" + ID.toString() + "\",\"username\":\"" + getUsername() + "\",\"password\":\"" + password
        + "\",\"userType\":\"student\",\"isVerified\":" + isVerified + ",\"firstName\":\"" + resume.getFirstName()
        + "\",\"lastName\":\"" + resume.getLastName() + "\",\"phoneNumber\":" + phoneNumber + ",\"email\":\"" + email
        + "\",\"resume\":" + resume.toJSON() + "}";
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
     * Gets all the student's experiences
     * 
     * @return the student's experiences
     */
    public ArrayList<Experience> getExperiences() {
        return this.resume.getExperiences();
    }

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
