package src;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Student User Interface Front-facing user commands for Student users.
 * 
 * @author Noah MacBride, William Hobbs
 */
public class StudentUI extends InternshipUI {
    public Student student;
    private final String[] FILTER_MENU;
    private String filter;
    private boolean running;

    /**
     * Constructor for a student's user interface
     * 
     * @param scanner is the scanner from the Driver
     */
    public StudentUI(Scanner scanner) {
        super(scanner);
        this.mainMenuOptions = new String[] { "View Job Listings", "Edit Account Information",
                "Edit Resume", "Download Resume", "Log Out" };
        this.FILTER_MENU = new String[] { "Pay Rate", "Location", "Start Date", "End Date", "Skills", "Complete Filter",
                "Clear Filter" };
        this.filter = "";
    }

    /**
     * Constructor for a student's user interface
     * 
     * @param scanner is the scanner from the Driver
     * @param student the particular student using the program
     */
    public StudentUI(Scanner scanner, Student student) {
        this(scanner);
        this.student = student;
    }

    /**
     * Runs the main logic of the student's user interface
     */
    public void run() {
        do {
            running = true;
            int selection = readMenu(this.mainMenuOptions);
            switch(selection) {
                case 1:  searchJobs(); break;  // "View Job Listings"
                case 2:  editAccount(); break;  // "Edit Account Information"
                case 3:  editResume(); break;  // "Edit Resume"
                case 4:  this.student.getResume().downloadResume(); break; // "Download Resume"
                case 5:  running = false;
                         logout(); break;   // "Log Out"
            }
        } while (running);
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
            String phoneNumber = readWord("Please enter your phone number:");
            double gpa = readDouble("Please enter your GPA:");
            int year = readInt("Please enter your graduation year:");

            student = new Student(username, password, firstName, lastName, phoneNumber, email, gpa, year);

            if (readBoolean("Would you like to enter a list of skills?"))
                readStudentSkills();
            if (readBoolean("Would you like to add a relevant experience to your profile"))
                readExperiences();
        } else
            student = new Student(username, password, firstName, lastName, email);
    }

    /**
     * apply Student submits their application (including resume) to a job posting
     */
    private void apply(Listing listing) {
        listing.apply(this.student.getResume());
        this.student.addApplication(listing.ID);
    }

    /**
     * searchJobs Student searches for jobs of interest
     */
    private void searchJobs() {
        this.filter = "";
        ArrayList<Listing> listings = Database.getListings();
        searchJobs(listings);
    }

    /**
     * Student searches for jobs of interest
     * 
     * @param listings pre-determined arraylist of listings - useful for filtered
     *                 listings lists
     */
    private void searchJobs(ArrayList<Listing> listings) {
        if (listings == null || listings.isEmpty()) {
            System.out.println("There are no available job listings at this time.");
            return;
        }

        int input = readListingMenu(listings, new String[] { "Edit Filters", "Clear Filters", "Exit to Main Menu" });

        if (input - 1 < listings.size())
            viewListing(listings.get(input - 1), listings);
        else if (input - 1 == listings.size())
            searchJobs(filterListings(listings));
        else if (input - 1 == listings.size() + 1)
            searchJobs();
    }

    /**
     * Processes the user looking at a menu of listings and selecting one to look
     * at, or choose a different option
     * 
     * @param listings          list of jobs the student can apply to, possibly
     *                          filtered
     * @param additionalOptions extra options at the end of the listing, could be
     *                          "Exit to Main Menu" or "Edit Filter", etc
     * @return the int value corresponding to the option chosen by the user
     */
    private int readListingMenu(ArrayList<Listing> listings, String[] additionalOptions) {
        flush();

        String[] listingStrings = new String[listings.size() + additionalOptions.length];
        for (int i = 0; i < listingStrings.length; i++)
            listingStrings[i] = Database.getEmployerByID(listings.get(i).EMPLOYER_ID).getTitle() + " - "
                    + listings.get(i).getTitle();

        for (int i = 0; i < additionalOptions.length; i++)
            listingStrings[listings.size() + i] = additionalOptions[i];

        System.out.println("Select job listing to view by number:");
        return readMenu(listingStrings);
    }

    /**
     * Recursive method to process the user filtering a list of job listings
     * 
     * @param filter   the concatenated string of filters to go through
     * @param listings the list of job listings to filter
     * @return a filtered list of job listings
     */
    private ArrayList<Listing> filterListings(ArrayList<Listing> listings) {
        int input = readMenu(FILTER_MENU);

        switch (input) {
        case 1: // "Pay Rate"
            this.filter += "minpay:" + readInt("Enter a minimum hourly pay rate:") + ";";
            break;
        case 2: // "Location"
            this.filter += "location:" + readLocation() + ";";
            break;
        case 3: // "Start Date"
            this.filter += "startdate:" + readDate("Enter the first day you are able to work:").toString() + ";";
            break;
        case 4: // "End Date"
            this.filter += "enddate:" + readDate("Enter the final day you are able to work:").toString() + ";";
            break;
        case 5: // "Skills"
            this.filter += "skills:" + readSkillsFilter() + ";";
            break;
        case 6: // "Complete Filter"
            return Database.filterListings(listings, this.filter);
        case 7: // "Clear Filter"
            this.filter = "";
            return filterListings(listings);
        }

        return filterListings(listings);
    }

    /**
     * Processes the user entering his desired location for a filter
     * 
     * @return filter representation of location
     */
    private String readLocation() {
        return readString("Enter the city you want to work in:") + ", "
                + readString("Enter the state you want to work in");
    }

    /**
     * Shows the student a listing and asks if they would like to apply for the job
     * 
     * @param listing  the job listing to be displayed
     * @param listings a potentially filtered list of job listings
     */
    private void viewListing(Listing listing, ArrayList<Listing> listings) {
        System.out.println(listing.toString(false));
        if (readBoolean("Would you like to apply for this job?")) {
            apply(listing);
            flush();
            System.out.println("Success!");
        }
        System.out.println("Returning to listings...");
        searchJobs(listings);
    }

    /**
     * editAccount Student can edit their account information
     */
    private void editAccount() {
        if (readBoolean("Would you like to change your username?"))
            student.setUsername(readUsername());
        if (readBoolean("Would you like to change your password?"))
            student.setPassword(readPassword());
        if (readBoolean("Would you like to change your phone number?"))
            student.setPhoneNumber(readWord("Please enter your phone number:"));
        if (readBoolean("Would you like to change your email?"))
            student.setEmail(readWord("Please enter your email:"));
        if (readBoolean("Would you like to change your graduation year?"))
            student.setYear(readInt("Please enter your graduation year:"));
    }

    /**
     * editResume Student can edit their main resume
     */
    private void editResume() {
        if (readBoolean("Would you like to change your GPA?"))
            student.setGPA(readDouble("Please enter your GPA:"));
        if (readBoolean("Would you like to add skills?"))
            readStudentSkills();
        if (readBoolean("Would you like to add experiences?"))
            readExperiences();
    }

    private void readStudentSkills() {
        ArrayList<Skills> skills = this.student.getResume().getSkills();
        this.student.getResume().setSkills(readSkills(skills));
    }

    /**
     * prompts the user for new experiences until the user is done
     */
    private void readExperiences() {
        boolean reading;
        String[] experienceMenu = new String[] { "Work Experience", "Course Experience", "Club Experience", "Cancel" };
        do {
            System.out.println("Which type of experience would you like to add?");

            reading = false;
            int input = readMenu(experienceMenu);

            switch (input) {
            case 1:
                readWorkExperience();
                break; // "Work Experience"
            case 2:
                readCourseExperience();
                break; // "Course Experience"
            case 3:
                readClubExperience();
                break; // "Club Experience"
            case 4:
                return; // "Cancel"
            }

            reading = readBoolean("Would you like to enter another experience?");

        } while (reading);
    }

    /**
     * Processes the user inputting a new work experience
     */
    private void readWorkExperience() {
        String title = readString("Please enter the name of your employer:");
        WorkExperience exp = new WorkExperience(title);
        readExperienceDates(exp);
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
        readExperienceDates(exp);
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
        readExperienceDates(exp);
        if (readBoolean("Would you like to add your role in the club?")) {
            flush();
            exp.setRole(readString("Please enter your role in this club"));
        }
        this.student.addExperience(exp);
    }

    /**
     * Reads a single experience, then kicks it back to the main experience loop
     * method
     * 
     * @param exp experience to be added to
     */
    private void readExperienceDates(Experience exp) {
        if (readBoolean("Would you like to enter when this experience occurred?")) {
            Date startDate = readDate("Please enter the date you started this experience");
            Date endDate = readDate("Please enter the date you ended this job");
            exp.setStartDate(startDate);
            exp.setEndDate(endDate);
        }
        if (readBoolean("Would you like to add details about your experience?"))
            exp.setDetails(readStringArrayList("Enter a detail about your experience",
                    "Would you like to add another detail abuot your experience?"));
    }

    /**
     * Prompts the user to add references, loops until the user is done
     * 
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
     * Processes a single reference then kicks it back out too the main reference
     * looping method
     * 
     * @param exp experience for reference to be added to
     */
    private void readReference(WorkExperience exp) {
        String firstName = readWord("Enter your reference's first name:");
        String lastName = readWord("Enter your reference's last name:");
        String phoneNumber = readWord("Enter your reference's phone number:");
        String email = readWord("Enter your reference's email:");
        exp.addReference(new Reference(firstName, lastName, phoneNumber, email));
    }

    /**
     * Processes new skills to be added to a filter to filter through job listings
     * 
     * @return a string representation of a list of skills to filter by
     */
    private String readSkillsFilter() {
        boolean reading;
        String str = "";
        do {
            reading = false;

            Skills newSkill = readSkillMenu();
            str += newSkill.toString() + ",";

            reading = readBoolean("Would you like to enter another skill?");
        } while (reading);

        return str.substring(0, str.length() - 1);
    }
}
