package src;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Resume class stores a resume for a Student
 * 
 * @author Nathanael Oliver
 */
public class Resume implements JSONable {
    private double gpa;
    private String name;
    private String education;
    private ArrayList<Skills> skills;
    private ArrayList<Experience> workExperiences;
    private ArrayList<Experience> courseExperiences;
    private ArrayList<Experience> clubExperiences;

    /**
     * Constructor for the resume class
     * 
     * @param firstName first name of the student creating the resume
     * @param lastName  last name of the student creating the resume
     */
    public Resume(String firstName, String lastName) {
        this.name = firstName + " " + lastName;
    }

    /**
     * Gets the name of the student who's resume this belongs to
     * 
     * @return the name of the student
     */
    public String getName() {
        return this.name;
    }

    /**
     * Adds a work experience to the work experience list
     * 
     * @param experience the experience to be added
     */
    public void addWorkExperience(WorkExperience experience) {
        workExperiences.add(experience);
    }

    /**
     * Adds a club experience to the work experience list
     * 
     * @param experience the experience to be added
     */
    public void addClubExperience(ClubExperience experience) {
        clubExperiences.add(experience);
    }

    /**
     * Adds a course experience to the work experience list
     * 
     * @param experience the experience to be added
     */
    public void addCourseExperience(CourseExperience experience) {
        courseExperiences.add(experience);
    }

    public void deleteExperience(UUID id) {
        for (Experience e : workExperiences) {
            if (e.id.equals(id)) {
                workExperiences.remove(e);
                return;
            }
        }
        for (Experience e : courseExperiences) {
            if (e.id.equals(id)) {
                workExperiences.remove(e);
                return;
            }
        }
        for (Experience e : clubExperiences) {
            if (e.id.equals(id)) {
                workExperiences.remove(e);
                return;
            }
        }
    }

    public Experience getExperience(UUID id) {
        for (Experience e : workExperiences) {
            if (e.id.equals(id)) {
                return e;
            }
        }
        for (Experience e : courseExperiences) {
            if (e.id.equals(id)) {
                return e;
            }
        }
        for (Experience e : clubExperiences) {
            if (e.id.equals(id)) {
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

    public String getEducation() {
        return this.education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String toJSON() {
        return "{\"name\":" + name + "\",gpa\": " + gpa + ",\"education\": \"" + education + "\",\"skills\": ["
                + JSONhelper.skillsToJSON(skills) + "],\"workExperiences\": [" + JSONhelper.toJson(workExperiences)
                + "],\"courseExperiences\": [" + JSONhelper.toJson(courseExperiences) + "],\"clubExperiences\": ["
                + JSONhelper.toJson(clubExperiences) + "]}";
    }
}