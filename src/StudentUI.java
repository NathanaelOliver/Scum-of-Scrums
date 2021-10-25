package src;

import java.util.Scanner;


/**
 * Student User Interface Front-facing user commands for Student users.
 * @author Noah MacBride, William Hobbs
 */
public class StudentUI extends InternshipUI {
    public Student student;

    /**
     * Constructor for a student's user interface
     * @param scanner is the scanner from the Driver
     */
    public StudentUI(Scanner scanner) {
        super(scanner);
    }

    /**
     * Constructor for a student's user interface
     * @param scanner is the scanner from the Driver
     * @param student the particular student using the program
     */
    public StudentUI(Scanner scanner, Student student) {
        super(scanner);
        this.student = student;
    }

    /**
     * Runs the main logic of the student's user interface
     */
    public void run() {

    }

    /**
     * Creates a new student user when someone new logs in
     */
    public void createUser() {
        String username = readUsername();
        String password = readPassword();
        String firstName = readWord("Please enter your first name:");
        String lastName = readWord("Please enter your last name:");
        String email = readWord("Please enter your e-mail:");
        if (readBoolean("Would you like to add more information?")) {
            int phoneNumber = readInt("Please enter your phone number:");
            double gpa = readDouble("Please enter your GPA:");
            int year = readInt("Please enter your graduation year:");
            
            student = new Student(username, password, firstName, lastName, phoneNumber, email, gpa, year);
        } else student = new Student(username, password, firstName, lastName, email);
        
        if (readBoolean("Would you like to enter a list of skills?"))
            readSkills();
        
        if (readBoolean("Would you like to add a relevant experience to your profile?"))
            readExperiences();
    }

    /**
     * apply Student submits their application (including resume) to a job posting
     */
    private void apply() {

    }

    /**
     * searchJobs Student searches for jobs of interest
     */
    private void searchJobs() {

    }

    /**
     * rateEmployer Student can rate employers based on their experiences
     */
    private void rateEmployer() {

    }

    /**
     * editResume Student can edit their main resume
     */
    private void editResume() {

    }

    /**
     * prompts the user for new experiences until the user is done
     */
    private void readExperiences() {
        boolean reading;
        do {
            reading = false;
            mainMenuOptions = new String[]{"Work Experience", "Course Experience", "Club Experience"};
            int input = readMenu(mainMenuOptions);
            
            switch(input) {
                case 1: readWorkExperience();
                case 2: readCourseExperience();
                case 3: readClubExperience();
            }

        } while (reading);
    }

    /**
     * Processes the user inputting a new work experience
     */
    private void readWorkExperience() {
        String title = readString("Please enter the name of your employer:");
        WorkExperience exp = new WorkExperience(title);
        readExperience(exp);
        if (readBoolean("Would you like to add references?")) {
            flush();
            readReferences(exp);
        }
        this.student.addExperience(exp);
    }

    /**
     * Processes the user inputting a new course experience
     */
    private void readCourseExperience() {
        String title = readString("Please enter the title of the course taken:");
        CourseExperience exp = new CourseExperience(title);
        readExperience(exp);
        if (readBoolean("Would you like to add your grade in the class?")) {
            flush();
            exp.setGrade(readDouble("Please enter the grade you received in this class in decimal form:"));
        }
        this.student.addExperience(exp);
    }

    /**
     * Processes the user inputting a new club experience
     */
    private void readClubExperience() {
        String title = readString("Please enter the title of the club:");
        ClubExperience exp = new ClubExperience(title);
        readExperience(exp);
        if (readBoolean("Would you like to add your role in the club?")) {
            flush();
            exp.setRole(readString("Please enter your role in this club"));
        }
        this.student.addExperience(exp);
    }

    /**
     * Reads a single experience, then kicks it back to the main experience loop method
     * @param exp experience to be added to
     */
    private void readExperience(Experience exp) {
        if (readBoolean("Would you like to enter timing information related to your experience?")) {
            Date startDate = readDate("Please enter the date you started this experience");
            Date endDate = readDate("Please enter the date you ended this job");
            exp.setStartDate(startDate); exp.setEndDate(endDate);
        } 
        if (readBoolean("Would you like to add details about your experience?"))
            readDetails(exp);
    }

    /**
     * Processes the user inputting the details of his experience
     * @param exp experience to be modified
     */
    private void readDetails(Experience exp) {
        boolean reading;
        do {
            reading = false;

            String detail = scanner.nextLine();
            exp.addDetail(detail);

            reading = readBoolean("Would you like to add another detail?");
        } while (reading);
    }

    /**
     * Prompts the user to add references, loops until the user is done
     * @param exp experience for references to be added to
     */
    private void readReferences(WorkExperience exp) {
        boolean reading;
        do {
            reading = false;
            readReference(exp);

            reading = readBoolean("Would you like to add another reference?");
        } while (reading);
    }

    /**
     * Processes a single reference then kicks it back out too the main reference looping method
     * @param exp experience for reference to be added to
     */
    private void readReference(WorkExperience exp) {
        String firstName = readWord("Enter your reference's first name:");
        String lastName = readWord("Enter your reference's last name:");
        int phoneNumber = readInt("Enter your reference's phone number:");
        String email = readWord("Enter your reference's email:");
        exp.addReference(new Reference(firstName, lastName, phoneNumber, email));
    }

    /**
     * Processes new skills being added by the user until the user is done
     */
    private void readSkills() {
        boolean reading;
        do {
            reading = false;

            Skills newSkill = readSkillMenu();
            this.student.addSkill(newSkill);

            reading = readBoolean("Would you like to enter another skill?");
        } while (reading);
    }
}
