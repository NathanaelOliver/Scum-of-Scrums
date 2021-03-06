package src;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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
     * 
     * @param firstName first name of resume owner
     * @param lastName  last name of resume owner
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
     * 
     * @param firstName         first name of resume owner
     * @param lastName          last name of resume owner
     * @param gpa               double gpa
     * @param phoneNumber       phoneNumber of resume owner
     * @param email             email of resume owner
     * @param skills            list of skills
     * @param workExperiences   list of work experiences
     * @param courseExperiences list of course experiences
     * @param clubExperiences   list of club experiences
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
     * 
     * @param firstName new first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Get first name
     * 
     * @return first name
     */
    public String getFirstName() {
        return this.firstName;
    }

    /**
     * set last name
     * 
     * @param lastName new last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * get last name
     * 
     * @return last name
     */
    public String getLastName() {
        return this.lastName;
    }

    /**
     * get name
     * 
     * @return string representation of full name
     */
    public String getName() {
        return this.firstName + " " + this.lastName;
    }

    /**
     * set gpa
     * 
     * @param gpa new double gpa
     */
    public void setGPA(double gpa) {
        this.gpa = gpa;
    }

    /**
     * get gpa
     * 
     * @return gpa as double
     */
    public double getGPA() {
        return this.gpa;
    }

    /**
     * get phone number
     * 
     * @return phone number as a string
     */
    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    /**
     * set phone number
     * 
     * @param phoneNumber new string phone number
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * get email
     * 
     * @return email as a string
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * set email
     * 
     * @param email new string email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * get year
     * 
     * @return year as an int
     */
    public int getYear() {
        return this.year;
    }

    /**
     * set year
     * 
     * @param year new int year
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * get list of skills
     * 
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
     * downloads a copy of the student's resume into their downloads folder
     */
    public void downloadResume() {
        String home = System.getProperty("user.home");
        try {
            File file = new File(home + "/Downloads/resume.txt");
            file.createNewFile();
            System.out.println("File created.");
            FileWriter writer = new FileWriter(home + "/Downloads/resume.txt");
            String resume = this.toString();
            writer.write(resume);
            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    /**
     * to String returns the resume in the form of a string
     * 
     * @return the String representation of a student's resume
     */
    public String toString() {
        String ret = this.getName() + "\n";
        ret += Database.phoneNumberToString(this.getPhoneNumber()) + "\n";
        ret += this.getEmail() + "\n";
        ret += "GPA: " + this.getGPA() + "\n";
        if (this.skills.size() > 0) {
            ret += "Skills: ";
            for (int i = 0; i < (this.skills.size()); i++) {
                ret += this.skills.get(i).toString() + ", ";
            }
            ret = ret.substring(0, ret.length()-2);
        }
        ret += "\nEducation:\n * University of South Carolina\n * Bachelors in Computer Information Systems\n * Expected Graduation: "
                + this.year;
        if (this.workExperiences.size() > 0) {
            ret += "\n\nWork Experiences\n";
            for (WorkExperience we : workExperiences) {
                ret += "----------------------------------------\n";
                ret += we + "\n";
            }
        }
        if (this.clubExperiences.size() > 0) {
            ret += "\nClub Experiences\n";
            for (ClubExperience ce : clubExperiences) {
                ret += "----------------------------------------\n";
                ret += ce + "\n";
            }
        }
        if (this.courseExperiences.size() > 0) {
            ret += "\nCourse Experiences\n";
            for (CourseExperience ce : courseExperiences) {
                ret += "----------------------------------------\n";
                ret += ce + "\n";
            }
        }
        return ret;
    }

    /**
     * Creates a JSON representation of the Resume
     * 
     * @return the JSON representation of the Resume
     */
    public String toJSON() {
        return "{\"id\":\"" + ID + "\",\"firstName\":\"" + firstName + "\",\"lastName\":\"" + lastName + "\",\"gpa\":"
                + gpa + ",\"phoneNumber\":\"" + phoneNumber + "\",\"email\":\"" + email + "\",\"skills\":"
                + DataWriter.skillsToJSON(skills) + ",\"workExperiences\":" + DataWriter.toJSON(workExperiences)
                + ",\"courseExperiences\":" + DataWriter.toJSON(courseExperiences) + ",\"clubExperiences\":"
                + DataWriter.toJSON(clubExperiences) + "}";
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
        for (String e : DataLoader.dictFromBracket(dict.get("workExperiences"))) {
            workExperiences.add(WorkExperience.fromJSON(e));
        }
        ArrayList<ClubExperience> clubExperiences = new ArrayList<ClubExperience>();
        for (String e : DataLoader.dictFromBracket(dict.get("clubExperiences"))) {
            clubExperiences.add(ClubExperience.fromJSON(e));
        }
        ArrayList<CourseExperience> courseExperiences = new ArrayList<CourseExperience>();
        for (String e : DataLoader.dictFromBracket(dict.get("courseExperiences"))) {
            courseExperiences.add(CourseExperience.fromJSON(e));
        }

        return new Resume(UUID.fromString(dict.get("id")), dict.get("firstName"), dict.get("lastName"),
                dict.get("gpa") == null ? 0 : Double.parseDouble(dict.get("gpa")),
                dict.get("year") == null ? 0 : Integer.parseInt(dict.get("year")), dict.get("phoneNumber"),
                dict.get("email"), skills, workExperiences, courseExperiences, clubExperiences);
    }
}
