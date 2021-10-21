package src;

import java.util.Scanner;

/**
 * Student User Interface Front-facing user commands for Student users.
 * 
 * @author William Hobbs
 */
public class StudentUI extends InternshipUI {
    public Student student;

    public StudentUI(Scanner scanner) {
        super(scanner);
    }

    public StudentUI(Scanner scanner, Student student) {
        super(scanner);
        this.student = student;
    }

    public void run() {

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

    public void createUser() {

        //student = new Student(username,password,UserType.student);
        //Database.addStudent(student);
    }
}
