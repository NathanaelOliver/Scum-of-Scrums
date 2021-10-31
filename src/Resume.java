package src;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

/**
 * Resume class stores a resume for a Student
 * 
 * @author Nathanael Oliver
 */
public class Resume implements JSONable {
    public final UUID ID;
    private String firstName, lastName, phoneNumber, email;
    private double gpa;
    private int year;
    private ArrayList<Skills> skills;
    private ArrayList<WorkExperience> workExperiences;
    private ArrayList<CourseExperience> courseExperiences;
    private ArrayList<ClubExperience> clubExperiences;

    /**
     * Resume Constructor
     * @param firstName first name of resume owner
     * @param lastName last name of resume owner
     */
    public Resume(String firstName, String lastName, String email) {
        this.ID = UUID.randomUUID();
        this.firstName = firstName;
        this.lastName = lastName;
        this.skills = new ArrayList<>();
        this.workExperiences = new ArrayList<>();
        this.courseExperiences = new ArrayList<>();
        this.clubExperiences = new ArrayList<>();
    }

    /**
     * Full Constructor for Resume
     * @param firstName first name of resume owner
     * @param lastName last name of resume owner
     * @param gpa double gpa
     * @param phoneNumber phoneNumber of resume owner
     * @param email email of resume owner
     * @param skills list of skills
     * @param workExperiences list of work experiences
     * @param courseExperiences list of course experiences
     * @param clubExperiences list of club experiences
     */
    public Resume(UUID id, String firstName, String lastName, double gpa, int year, String phoneNumber, String email,
            ArrayList<Skills> skills, ArrayList<WorkExperience> workExperiences,
            ArrayList<CourseExperience> courseExperiences, ArrayList<ClubExperience> clubExperiences) {
        this.ID = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gpa = gpa;
        this.year = year;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.skills = skills;
        this.workExperiences = workExperiences;
        this.courseExperiences = courseExperiences;
        this.clubExperiences = clubExperiences;
    }

    /**
     * Set first name
     * @param firstName new first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Get first name
     * @return first name
     */
    public String getFirstName() {
        return this.firstName;
    }

    /**
     * set last name
     * @param lastName new last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * get last name
     * @return last name
     */
    public String getLastName() {
        return this.lastName;
    }

    /**
     * get name
     * @return string representation of full name
     */
    public String getName() {
        return this.firstName + " " + this.lastName;
    }

    /**
     * set gpa
     * @param gpa new double gpa
     */
    public void setGPA(double gpa) {
        this.gpa = gpa;
    }

    /**
     * get gpa
     * @return gpa as double
     */
    public double getGPA() {
        return this.gpa;
    }

    /**
     * get phone number
     * @return phone number as a string
     */
    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    /**
     * set phone number
     * @param phoneNumber new string phone number
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * get email
     * @return email as a string
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * set email
     * @param email new string email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * get year
     * @return year as an int
     */
    public int getYear() {
        return this.year;
    }

    /**
     * set year
     * @param year new int year
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * get list of skills
     * @return list of skills
     */
    public ArrayList<Skills> getSkills() {
        return this.skills;
    }

    public void setSkills(ArrayList<Skills> skills) {
        this.skills = skills;
    }

    public ArrayList<Experience> getExperiences() {
        ArrayList<Experience> experiences = new ArrayList<Experience>();
        experiences.addAll(workExperiences);
        experiences.addAll(courseExperiences);
        experiences.addAll(clubExperiences);
        return experiences;
    }

    /**
     * Adds a work experience to the work experience list
     * 
     * @param experience the experience to be added
     */
    public void addExperience(WorkExperience experience) {
        workExperiences.add(experience);
    }

    /**
     * Adds a club experience to the work experience list
     * 
     * @param experience the experience to be added
     */
    public void addExperience(ClubExperience experience) {
        clubExperiences.add(experience);
    }

    /**
     * Adds a course experience to the work experience list
     * 
     * @param experience the experience to be added
     */
    public void addExperience(CourseExperience experience) {
        courseExperiences.add(experience);
    }

    /**
     * removes an experience from the resume by id
     * 
     * @param id the id of the experience
     */
    public void deleteExperience(UUID id) {
        for (Experience e : workExperiences) {
            if (e.ID.equals(id)) {
                workExperiences.remove(e);
                return;
            }
        }
        for (Experience e : courseExperiences) {
            if (e.ID.equals(id)) {
                workExperiences.remove(e);
                return;
            }
        }
        for (Experience e : clubExperiences) {
            if (e.ID.equals(id)) {
                workExperiences.remove(e);
                return;
            }
        }
    }

    /**
     * Gets an experince from the resume by ID
     * 
     * @param id the id of the experience that is being looked for
     * @return the experience
     */
    public Experience getExperience(UUID id) {
        for (Experience e : workExperiences) {
            if (e.ID.equals(id)) {
                return e;
            }
        }
        for (Experience e : courseExperiences) {
            if (e.ID.equals(id)) {
                return e;
            }
        }
        for (Experience e : clubExperiences) {
            if (e.ID.equals(id)) {
                return e;
            }
        }
        return null;
    }

    /**
     * Adds a skill to the resume
     * 
     * @param skill the skill to add to the resume
     */
    public void addSkill(Skills skill) {
        this.skills.add(skill);
    }

    /**
     * Removes a skill from the resume
     * 
     * @param skill the skill to remove from the resume
     */
    public void removeSkill(Skills skill) {
        this.skills.remove(skill);
    }

    /**
     * Creates a JSON representation of the Resume
     * 
     * @return the JSON representation of the Resume
     */
    public String toJSON() {
        return "{\"firstName\":" + firstName + "\",\"lastName\":" + lastName + "\",\"gpa\":" + gpa + ",\"phoneNumber\":\""
                + phoneNumber + "\",\"email\":\"" + email + "\",\"skills\":" + DataWriter.skillsToJSON(skills)
                + ",\"workExperiences\":" + DataWriter.toJSON(workExperiences) + ",\"courseExperiences\":"
                + DataWriter.toJSON(courseExperiences) + ",\"clubExperiences\":" + DataWriter.toJSON(clubExperiences)
                + "}";
    }

    /**
     * Creates a Resume from a JSON object
     * 
     * @param json the JSON object
     * @return the resume created from the JSON object
     */
    public static Resume fromJSON(String json) {
        HashMap<String, String> dict = DataLoader.dictFromBrace(json);
        ArrayList<Skills> skills = new ArrayList<Skills>();
        for (String e : DataLoader.dictFromBracket(dict.get("skills"))) {
            skills.add(Skills.valueOf(e));
        }
        ArrayList<WorkExperience> workExperiences = new ArrayList<WorkExperience>();
        for (String e : DataLoader.dictFromBracket(dict.get("workExperience"))) {
            workExperiences.add(WorkExperience.fromJSON(e));
        }
        ArrayList<ClubExperience> clubExperiences = new ArrayList<ClubExperience>();
        for (String e : DataLoader.dictFromBracket(dict.get("clubExperience"))) {
            clubExperiences.add(ClubExperience.fromJSON(e));
        }
        ArrayList<CourseExperience> courseExperiences = new ArrayList<CourseExperience>();
        for (String e : DataLoader.dictFromBracket(dict.get("courseExperience"))) {
            courseExperiences.add(CourseExperience.fromJSON(e));
        }
        return new Resume(UUID.fromString(dict.get("id")), dict.get("firstName"), dict.get("lastName"),
                dict.get("gpa") == null ? 0 : Double.parseDouble(dict.get("gpa")), dict.get("year") == null ? 0 : Integer.parseInt(dict.get("year")), dict.get("phoneNumber"), dict.get("email"), skills,
                workExperiences, courseExperiences, clubExperiences);
    }
}
