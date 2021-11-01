package src;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.UUID;

/**
 * Database class stores all users
 */
public class Database {
    public static ArrayList<User> unverifiedUsers = new ArrayList<User>();
    public static ArrayList<Employer> employers = new ArrayList<Employer>();
    public static ArrayList<Student> students = new ArrayList<Student>();
    public static ArrayList<Admin> admins = new ArrayList<Admin>();

    /**
     * Private Constructor so it cannot be instantiated
     */
    private Database() {
    }

    public static void fromJSON(String json) {
        HashMap<String, String> userLists = DataLoader.dictFromBrace(json);

        for (String e : DataLoader.dictFromBracket(userLists.get("employers"))) {
            employers.add(Employer.fromJSON(e));
        }
        for (String e : DataLoader.dictFromBracket(userLists.get("students"))) {
            students.add(Student.fromJSON(e));
        }
        for (String e : DataLoader.dictFromBracket(userLists.get("admins"))) {
            admins.add(Admin.fromJSON(e));
        }
        /*
         * for (String e : DataLoader.dictFromBracket(userLists.get("unverifiedUsers")))
         * { switch (e.charAt(e.indexOf("\"userType\": \"") +
         * "\"userType\": \"".length())) { case 'E': case 'e':
         * unverifiedUsers.add(Employer.fromJSON(e)); break; case 'A': case 'a':
         * unverifiedUsers.add(Admin.fromJSON(e)); break; case 'S': case 's':
         * unverifiedUsers.add(Student.fromJSON(e)); break; } }
         */
    }

    // /**
    // * Filters through the users
    // *
    // * @param userType the type of users to be filtered through
    // * @param filter a string containing concatonated filters for the method to
    // * execute
    // * @return A string representation of the result of the filters
    // */
    // public String filterUsers(UserType userType, String filter) {
    // //create list of filters
    // String[] filters = filter.split(";");
    // for (String newFilter: filters) {
    // String[] filterDetails = newFilter.split(":");
    // String attribute = filterDetails[0];
    // switch (attribute) {
    // case ""
    // }
    // }
    // System.out.println(filters[0]);
    // return filters[1];
    // }

    /**
     * filters through the students who applied for a specific job
     * 
     * @param students the students who applied for the position
     * @param filter   a string containing concatonated filters for the method to
     *                 execute
     * @return A string representation of the result of the filters
     */
    public static ArrayList<Resume> filterApplicants(ArrayList<Resume> resumesToFilter, String filter) {
        ArrayList<Resume> resumes = new ArrayList<>();
        for (Resume oldResume : resumesToFilter)
            resumes.add(oldResume);

        String[] filters = filter.split(";");
        for (String newFilter : filters) {
            String[] filterDetails = newFilter.split(":");
            String attribute = filterDetails[0];
            switch (attribute) {
            case "gpa":
                filterResumesByGPA(filterDetails[1], resumes);
                break;
            case "skills":
                filterResumesBySkills(filterDetails[1], resumes);
                break;
            case "year":
                filterResumesByYear(filterDetails[1], resumes);
                break;
            }
        }
        return resumes;
    }

    /**
     * filters through job listings students can apply for
     * 
     * @param listings the job listings the student can apply for and that have
     *                 passed any previous filters
     * @param filter   a string containing concatenated filters for the method to
     *                 execute
     * @return An ArrayList of listings after the filters were applied
     */
    public static ArrayList<Listing> filterListings(ArrayList<Listing> listings, String filter) {
        ArrayList<Listing> filteredListings = new ArrayList<>();
        for (Listing oldListing : listings)
            filteredListings.add(oldListing);

        String[] filters = filter.split(";");
        for (String newFilter : filters) {
            String[] filterDetails = newFilter.split(":");
            String attribute = filterDetails[0];
            switch (attribute) {
            case "minpay":
                filteredListings = filterByPay(filterDetails[1], filteredListings);
                break;
            case "location":
                filteredListings = filterByLocation(filterDetails[1], filteredListings);
                break;
            case "startdate":
                filteredListings = filterByStartDate(filterDetails[1], filteredListings);
                break;
            case "enddate":
                filteredListings = filterByEndDate(filterDetails[1], filteredListings);
                break;
            case "skills":
                filteredListings = filterListingsBySkills(filterDetails[1], filteredListings);
                break;
            default:
            }
        }
        return listings;
    }

    /**
     * Gets the students based on their GPA
     * 
     * @param GPA      minimum GPA of the student
     * @param students the list of students to be looking through
     * @return the students with the specified minimum GPA
     */
    private static ArrayList<Resume> filterResumesByGPA(String GPA, ArrayList<Resume> resumes) {
        ArrayList<Resume> filteredResumes = new ArrayList<>();
        for (Resume resume : resumes)
            filteredResumes.add(resume);
        filteredResumes.removeIf(filteredResume -> filteredResume.getGPA() < Double.parseDouble(GPA));
        return filteredResumes;
    }

    /**
     * Gets the students based on their graduation year
     * 
     * @param year     the year the student is graduating
     * @param students the list of students to be looking through
     * @return the students with the specified graduation year
     */
    private static ArrayList<Resume> filterResumesByYear(String year, ArrayList<Resume> resumes) {
        ArrayList<Resume> filteredResumes = new ArrayList<>();
        for (Resume resume : resumes)
            filteredResumes.add(resume);
        filteredResumes.removeIf(filteredResume -> filteredResume.getYear() < Integer.parseInt(year));
        return filteredResumes;
    }

    /**
     * Searches for resumes with a specific skill recommendation
     * 
     * @param skillsToFilter the recommended skills
     * @param resumes        the resumes to look through
     * @return the resumes with the specified skill
     */
    private static ArrayList<Resume> filterResumesBySkills(String skillsToFilter, ArrayList<Resume> resumes) {
        ArrayList<Resume> filteredResumes = new ArrayList<>();
        for (Resume resume : resumes)
            filteredResumes.add(resume);
        String[] skills = skillsToFilter.split(",");
        for (String skill : skills) {
            filteredResumes.removeIf(filteredResume -> !filteredResume.getSkills().contains(Skills.valueOf(skill)));
        }
        return filteredResumes;
    }

    /**
     * Searches for job listings with a minimum pay rate
     * 
     * @param payRate  the minimum pay rate
     * @param listings the listings to look through
     * @return the listings with the specified minimum pay rate
     */
    private static ArrayList<Listing> filterByPay(String payRate, ArrayList<Listing> listings) {
        ArrayList<Listing> filteredListings = new ArrayList<>();
        for (Listing listing : listings)
            filteredListings.add(listing);
        filteredListings.removeIf(filteredListing -> filteredListing.getPayRate() < Double.parseDouble(payRate));
        return filteredListings;
    }

    /**
     * Searches for job listings with a specific location
     * 
     * @param location the location
     * @param listings the listings to look through
     * @return the listings with the specified location
     */
    private static ArrayList<Listing> filterByLocation(String location, ArrayList<Listing> listings) {
        ArrayList<Listing> filteredListings = new ArrayList<>();
        for (Listing listing : listings)
            filteredListings.add(listing);
        filteredListings.removeIf(filteredListing -> !filteredListing.getLocation().equalsIgnoreCase(location));
        return filteredListings;
    }

    /**
     * Searches for job listings with a specific minimum start date
     * 
     * @param startDate the earliest start date
     * @param listings  the listings to look through
     * @return the listings with the specified earliest start date
     */
    private static ArrayList<Listing> filterByStartDate(String startDate, ArrayList<Listing> listings) {
        ArrayList<Listing> filteredListings = new ArrayList<>();
        for (Listing listing : listings)
            filteredListings.add(listing);
        filteredListings
                .removeIf(filteredListing -> filteredListing.getEndDate().compareTo(Date.fromString(startDate)) < 0);
        return filteredListings;
    }

    /**
     * Searches for job listings with a specific minimum end date
     * 
     * @param endDate  the earliest end date
     * @param listings the listings to look through
     * @return the listings with the specified earliest end date
     */
    private static ArrayList<Listing> filterByEndDate(String endDate, ArrayList<Listing> listings) {
        ArrayList<Listing> filteredListings = new ArrayList<>();
        for (Listing listing : listings)
            filteredListings.add(listing);
        filteredListings
                .removeIf(filteredListing -> filteredListing.getEndDate().compareTo(Date.fromString(endDate)) > 0);
        return filteredListings;
    }

    /**
     * Searches for job listings with a specific skill recommendation
     * 
     * @param skillsToFilter the recommended skill
     * @param listings       the listings to look through
     * @return the listings with the specified skill
     */
    private static ArrayList<Listing> filterListingsBySkills(String skillsToFilter, ArrayList<Listing> listings) {
        ArrayList<Listing> filteredListings = new ArrayList<>();
        for (Listing listing : listings)
            filteredListings.add(listing);
        String[] skills = skillsToFilter.split(",");
        for (String skill : skills) {
            filteredListings.removeIf(filteredListing -> !filteredListing.getSkills().contains(Skills.valueOf(skill)));
        }
        return filteredListings;
    }

    /**
     * get employer by id
     * 
     * @param id is id of employer
     * @return employer
     */
    public static Employer getEmployerByID(UUID id) {
        for (Employer employer : employers) {
            if (employer.ID.equals(id))
                return employer;
        }
        return null;
    }

    /**
     * Gets all job listings
     * 
     * @return all job listings
     */
    public static ArrayList<Listing> getListings() {
        ArrayList<Listing> list = new ArrayList<>();
        if (employers == null || employers.isEmpty())
            return null;

        for (Employer e : employers) {
            ArrayList<Listing> listings = e.getListings();
            if (listings != null && !listings.isEmpty())
                list.addAll(listings);
        }
        return list;
    }

    /**
     * Gets a user by ID
     * 
     * @param id the id of the specified user
     * @return the user with the specified id
     */
    public static User getUserByID(UUID id) {
        for (User e : employers) {
            if (e.ID.equals(id)) {
                return e;
            }
        }
        for (User e : students) {
            if (e.ID.equals(id)) {
                return e;
            }
        }
        for (User e : admins) {
            if (e.ID.equals(id)) {
                return e;
            }
        }
        for (User e : unverifiedUsers) {
            if (e.ID.equals(id)) {
                return e;
            }
        }
        return null;
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
        for (User unverified : unverifiedUsers) {
            if (unverified.getUsername().equals(username)) {
                if (isCorrectPassword(unverified, password)) {
                    System.out.println("User verification is still pending.");
                }
                return null;
            }
        }
        for (Employer employer : employers) {
            if (employer.getUsername().equals(username)) {
                if (isCorrectPassword(employer, password)) {
                    return new EmployerUI(scanner, employer);
                }
                return null;
            }
        }
        for (Student student : students) {
            if (student.getUsername().equals(username)) {
                if (isCorrectPassword(student, password)) {
                    return new StudentUI(scanner, student);
                }
                return null;
            }
        }
        for (Admin admin : admins) {
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

    public static void removeUnverifiedUser(UUID id) {
        for (int i = 0; i < unverifiedUsers.size(); ++i) {
            if (unverifiedUsers.get(i).ID.equals(id)) {
                unverifiedUsers.remove(i);
                break;
            }
        }
    }

    public static void removeAdmin(UUID id) {
        for (int i = 0; i < admins.size(); ++i) {
            if (admins.get(i).ID.equals(id)) {
                admins.remove(i);
                break;
            }
        }
    }

    public static boolean isAvailable(String username) {
        for (User unverified : unverifiedUsers)
            if (unverified.getUsername().equals(username))
                return false;

        for (Employer employer : employers)
            if (employer.getUsername().equals(username))
                return false;

        for (Student student : students)
            if (student.getUsername().equals(username))
                return false;

        for (Admin admin : admins)
            if (admin.getUsername().equals(username))
                return false;

        return true;
    }

    public static Resume getResumeByID(UUID id) {
        for (Student student : students) {
            if (id.equals(student.getResume().ID))
                return student.getResume();
        }
        return null;
    }
}