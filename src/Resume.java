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
    private double gpa;
    private String name;
    private String education;
    private ArrayList<Skills> skills;
    private ArrayList<WorkExperience> workExperiences;
    private ArrayList<CourseExperience> courseExperiences;
    private ArrayList<ClubExperience> clubExperiences;

    /**
     * Constructor for the resume class
     * 
     * @param firstName first name of the student creating the resume
     * @param lastName  last name of the student creating the resume
     */
    public Resume(String firstName, String lastName) {
        this.name = firstName + " " + lastName;
    }

    public Resume(String name, double gpa, String education, ArrayList<Skills> skills,
            ArrayList<WorkExperience> workExperiences, ArrayList<CourseExperience> courseExperiences,
            ArrayList<ClubExperience> clubExperiences) {
        this.name = name;
        this.gpa = gpa;
        this.education = education;
        this.skills = skills;
        this.workExperiences = workExperiences;
        this.courseExperiences = courseExperiences;
        this.clubExperiences = clubExperiences;
    }

    /**
     * Gets the name of the student whose resume this belongs to
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
     * Gets the education on the resume
     * 
     * @return the education on the resume
     */
    public String getEducation() {
        return this.education;
    }

    /**
     * Sets the education to display on the Resume
     * 
     * @param education the education
     */
    public void setEducation(String education) {
        this.education = education;
    }

    /**
     * Creates a JSON representation of the Resume
     * 
     * @return the JSON representation of the Resume
     */
    public String toJSON() {
        return "{\"gpa\":" + gpa + ",\"education\":\"" + education + "\",\"skills\":" + DataWriter.skillsToJSON(skills)
                + ",\"workExperiences\":" + DataWriter.toJson(workExperiences) + ",\"courseExperiences\":"
                + DataWriter.toJson(courseExperiences) + ",\"clubExperiences\":" + DataWriter.toJson(clubExperiences)
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
        return new Resume(dict.get("name"), Double.parseDouble(dict.get("gpa")), dict.get("education"), skills,
                workExperiences, courseExperiences, clubExperiences);
    }
}
