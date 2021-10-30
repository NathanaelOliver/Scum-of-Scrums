package src;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Resume class stores a resume for a Student
 * 
 * @author Nathanael Oliver
 */
public class Resume implements JSONable {
    private String firstName;
    private String lastName;
    private double gpa;
    private ArrayList<Skills> skills;
    private ArrayList<Experience> workExperiences;
    private ArrayList<Experience> courseExperiences;
    private ArrayList<Experience> clubExperiences;

    /**
     * Constructor for the resume class, initializes arrays
     */
    public Resume(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.skills = new ArrayList<>();
        this.workExperiences = new ArrayList<>();
        this.courseExperiences = new ArrayList<>();
        this.clubExperiences = new ArrayList<>();
    }

    /**
     * Constructor for the resume class
     * 
     * @param gpa the gpa of the student
     */
    public Resume(String firstName, String lastName, double gpa) {
        this(firstName, lastName);
        this.gpa = gpa;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getName() {
        return this.firstName + " " + this.lastName;
    }

    public void setGPA(double gpa) {
        this.gpa = gpa;
    }

    public double getGPA() {
        return this.gpa;
    }

    public ArrayList<Skills> getSkills() {
        return this.skills;
    }

    public void setSkills(ArrayList<Skills> skills) {
        this.skills = skills;
    }

    public ArrayList<Experience> getExperiences() {
        ArrayList<Experience> experiences = workExperiences;
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

    public void addSkill(Skills skill) {
        this.skills.add(skill);
    }

    public void removeSkill(Skills skill) {
        this.skills.remove(skill);
    }

    public String toJSON() {
        return "{\"gpa\":" + gpa + "\",\"skills\":" + JSONhelper.skillsToJSON(skills) + ",\"workExperiences\":"
        + JSONhelper.toJson(workExperiences) + ",\"courseExperiences\":" + JSONhelper.toJson(courseExperiences)
        + ",\"clubExperiences\":" + JSONhelper.toJson(clubExperiences) + "}";
    }
}
