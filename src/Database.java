package src;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

/**
 * Database class stores all users
 */
public class Database {
    public static ArrayList<User> unverifiedUsers = new ArrayList<>();
    public static ArrayList<Employer> verifiedEmployers = new ArrayList<>();
    public static ArrayList<Student> verifiedStudents = new ArrayList<>();
    public static ArrayList<Admin> verifiedAdmins = new ArrayList<>();

    /**
     * Filters through the users
     * 
     * @param userType the type of users to be filtered through
     * @param filter   a string containing concatonated filters for the method to
     *                 execute
     * @return A string representation of the result of the filters
     */
    public String filter(UserType userType, String filter) {
        return "";
    }

    /**
     * filters through the students who applied for a specific job
     * 
     * @param students the students who applied for the position
     * @param filter   a string containing concatonated filters for the method to
     *                 execute
     * @return A string representation of the result of the filters
     */
    public String filterApplications(ArrayList<Student> students, String filter) {
        return "";
    }

    /**
     * Gets the unverified employers
     * 
     * @return the unverified employers
     */
    public ArrayList<Employer> getUnverifiedEmployers() {
        return new ArrayList<Employer>();
    }

    /**
     * Gets the students based on their first name
     * 
     * @param firstName first name of the student
     * @param students  the list of students to be looking through
     * @return the students with the specified first name
     */
    private ArrayList<Student> searchFirstName(String firstName, ArrayList<Student> students) {
        return new ArrayList<Student>();
    }

    /**
     * Gets the students based on their last name
     * 
     * @param lastName last name of the student
     * @param students the list of students to be looking through
     * @return the students with the specified last name
     */
    private ArrayList<Student> searchLastName(String lastName, ArrayList<Student> students) {
        return new ArrayList<Student>();
    }

    /**
     * Gets the students based on their GPA
     * 
     * @param GPA      minimum GPA of the student
     * @param students the list of students to be looking through
     * @return the students with the specified minimum GPA
     */
    private ArrayList<Student> searchGPA(String GPA, ArrayList<Student> students) {
        return new ArrayList<Student>();
    }

    /**
     * Gets the students based on their graduation year
     * 
     * @param year     the year the student is graduating
     * @param students the list of students to be looking through
     * @return the students with the specified graduation year
     */
    private ArrayList<Student> searchYear(String year, ArrayList<Student> students) {
        return new ArrayList<Student>();
    }

    /**
     * Gets the students based on their skills
     * 
     * @param skill    skill of the student
     * @param students the list of students to be looking through
     * @return the students with the specified skill
     */
    private ArrayList<Student> searchSkills(String skill, ArrayList<Student> students) {
        return new ArrayList<Student>();
    }

    /**
     * Searches for job listings with a minimum pay rate
     * 
     * @param payRate  the minimum pay rate
     * @param listings the listings to look through
     * @return the listings with the specified minimum pay rate
     */
    private ArrayList<Listing> searchPayRate(String payRate, ArrayList<Listing> listings) {
        return new ArrayList<Listing>();
    }

    /**
     * Searches for job listings with a specific location
     * 
     * @param location the location
     * @param listings the listings to look through
     * @return the listings with the specified location
     */
    private ArrayList<Listing> searchLocation(String location, ArrayList<Listing> listings) {
        return new ArrayList<Listing>();
    }

    /**
     * Searches for job listings with a specific minimum start date
     * 
     * @param startDate the earliest start date
     * @param listings  the listings to look through
     * @return the listings with the specified earliest start date
     */
    private ArrayList<Listing> searchStartDate(String startDate, ArrayList<Listing> listings) {
        return new ArrayList<Listing>();
    }

    /**
     * Searches for job listings with a specific minimum end date
     * 
     * @param endDate  the earliest end date
     * @param listings the listings to look through
     * @return the listings with the specified earliest end date
     */
    private ArrayList<Listing> searchEndDate(String endDate, ArrayList<Listing> listings) {
        return new ArrayList<Listing>();
    }

    /**
     * Searches for job listings with a specific skill recommendation
     * 
     * @param skill    the recommended skill
     * @param listings the listings to look through
     * @return the listings with the specified skill
     */
    private ArrayList<Listing> searchListingSkills(String skill, ArrayList<Listing> listings) {
        return new ArrayList<Listing>();
    }

    /**
     * Searches for job listings with a specific id
     * 
     * @param id       the id of the listing
     * @param listings the listings to look through
     * @return the listing with the specified id
     */
    public Listing getListingByID(UUID id) {
        return null;
    }

    /**
     * Gets all job listings
     * 
     * @return all job listings
     */
    private ArrayList<Listing> getListings() {
        return new ArrayList<Listing>();
    }

    /**
     * Gets a user by ID
     * 
     * @param id the id of the specified user
     * @return the user with the specified id
     */
    public static User getUserByID(String id) {
        return new Admin("","","", "");
    }

    private static boolean isCorrectPassword(User user, String password) {
        if (!user.checkPassword(password)) {
            System.out.println("Incorrect password");
            return false;
        }
        return true;
    }

    public static InternshipUI verifyLoginCredentials(Scanner scanner, String username, String password) {
        // erase dialog up to this point
        System.out.print("\033[H\033[2J");
        System.out.flush();

        // find user in system
        for (User unverified: unverifiedUsers) {
            if (unverified.getUsername().equals(username)) {
                if (isCorrectPassword(unverified, password)) {
                    System.out.println("User verification is still pending.");
                }
                return null;
            }
        }
        for (Employer employer: verifiedEmployers) {
            if (employer.getUsername().equals(username)) {
                if (isCorrectPassword(employer, password)) {
                    return new EmployerUI(scanner, employer);
                }
                return null;
            }
        }
        for (Student student: verifiedStudents) {
            if (student.getUsername().equals(username)) {
                if (isCorrectPassword(student, password)) {
                    return new StudentUI(scanner, student);
                }
                return null;
            }
        }
        for (Admin admin: verifiedAdmins) {
            if (admin.getUsername().equals(username)) {
                if (isCorrectPassword(admin, password)) {
                    return new AdminUI(scanner, admin);
                }
                return null;
            }
        }

        // username does not correspond with a user
        System.out.println("The username \"" + username + "\" does not exist.");
        return null;
    }

    public static boolean isAvailable(String username) {
        for (User unverified: unverifiedUsers)
            if (unverified.getUsername().equals(username))
                return false;

        for (Employer employer: verifiedEmployers)
            if (employer.getUsername().equals(username))
                return false;

        for (Student student: verifiedStudents)
            if (student.getUsername().equals(username))
                return false;

        for (Admin admin: verifiedAdmins)
            if (admin.getUsername().equals(username))
                return false;

        return true;
    }

    public static void removeUnverifiedUser(UUID id) {
        for (int i = 0; i < unverifiedUsers.size(); ++i) {
            if (unverifiedUsers.get(i).ID.equals(id)) {
                unverifiedUsers.remove(i);
                break;
            }
        }
    }

    public static void removeAdmin(UUID id) {
        for (int i = 0; i < verifiedAdmins.size(); ++i) {
            if (verifiedAdmins.get(i).ID.equals(id)) {
                verifiedAdmins.remove(i);
                break;
            }
        }
    }
}