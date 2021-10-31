package src;

import java.util.Scanner;
import java.util.ArrayList;

/**
 * Employer User Interface Runs the front-end of the employer's experience with
 * the Internship program.
 * 
 * @author William Hobbs
 */
public class EmployerUI extends InternshipUI {
    public Employer employer;
    private boolean loggedIn;
    // QUESTION - reference employer or this.employer?

    public EmployerUI(Scanner scanner) {
        super(scanner);
        this.mainMenuOptions = new String[]{"Edit your Company Profile", "Add a Job Listing", "Update a Job Listing","Delete a Job Listing","Log Out"};
    }

    public EmployerUI(Scanner scanner, Employer employer) {
        this(scanner);
        this.employer = employer;
    }
    /**
     * run runs the central framework of the UI for employers
     */
    public void run() {
        // initialize?
        loggedIn = true;
        while (loggedIn) {
            // try {
                int mainMenuOption = readMenu(this.mainMenuOptions);
                switch (mainMenuOption) {
                    case 1: addDescription();
                            break;
                    case 2: addListing();
                            break;
                    case 3: editListing();
                            break;
                    case 4: deleteListing();
                            break;
                    case 5: loggedIn = false;
                            break;
                }
            //} catch(Exception e) {
            //    System.out.println("Invalid entry! Try again.");
            //}
        }
    } // done

    public void createUser() {
        flush();
        String username = readUsername();
        String password = readPassword();
        String title = readString("Please enter the name of your company.");
        this.employer = new Employer(username, password, title);
        if (readBoolean("Would you like to add a company profile?")) {
            addDescription();
        }
    }

    /**
     * addProfile Helps an employer set up their Employer Profile for students to
     * search.
     * - i like the idea of prompting a vim editor here so that they can edit it more easily
     * - find a way to take a longer input and allow for formatting (?)
     * - this is called profile in the UI but description in the Employer class, do we change?
     */
    private void addDescription() {
        ArrayList<String> description = this.employer.getDescription();
        
    }

    /**
     * addListing Employer adds a new job listing for students to apply.
     */
    private void addListing() {
        // loops through all the stuff it needs and adds it
        // to their arraylist
        boolean creatingListing;
        do {
            creatingListing = false;
            double payRate = readDouble("Please give the pay rate of the listing as an hourly wage");
            Date startDate = readDate("Add a start date for the job."); // does not print out
            Date endDate = readDate("Add an end date for the job.");
            String siteLink = readWord("Link a site for the job description.");
            String title = readString("Provide a title for the job.");
            String location = readString("Provide the location for work.");
            ArrayList<Skills> skills = new ArrayList<Skills>();
            if (readBoolean("Do you want to enter skills for this job?")) {
                skills = readSkills(skills);
            }
            ArrayList<String> description = readStringArrayList("Add a description of the job listing.","Add an additional line of the job description.");
            Listing listing = new Listing(title, payRate, location, description, startDate, 
                endDate, siteLink, skills, this.employer.ID);
        } while (creatingListing);
    }

    /**
     * deleteListing Employer can delete their job listings
     */
    private void deleteListing() {
        // for loop, prints title of all listings
        // asks them for the index of which one they want to delete
        // deletes that listing from the arraylist, moves all the others up
        for (int i = 0; i < this.employer.getListings().size(); i++) {
            System.out.println((i) + ". " + this.employer.getListings().get(i).getTitle());
        } // TODO - move to internshipUI 
        try {
            int input = readInt("Which listing would you like to delete?");
            ArrayList<Listing> tempListings = this.employer.getListings();
            tempListings.remove(input);
            this.employer.setListings(tempListings);
        } catch (Exception e) {
            System.out.println("Invalid entry");
        }
        // BUG - if they delete the listing, that deletes all the applications associated with it in
        // our current UML
        // when they delete does it remove from JSON?
    } // done

    /**
     * editListing Employer can edit their job listings
     */
    private void editListing() {
        flush();
        for (int i = 0; i < this.employer.getListings().size(); i++) {
            System.out.println((i+1) + ". " + this.employer.getListings().get(i).getTitle());
        }
        boolean choosing = true;
        int input = readInt("Which listing would you like to edit?", 1, (this.employer.getListings().size()));
        Listing listing = this.employer.getListings().get(input - 1);
        System.out.println("What would you like to edit?");
        String[] editOptions = new String[]{"Pay Rate", "Description", "Start Date", "End Date", "Site Link", "Title", "Location", "Skills"};
        int editing = readMenu(editOptions);
        switch (editing) { 
            case 1: listing.setPayRate(readDouble("Please give the pay rate of the listing as an hourly wage"));
                    break;
            case 2: listing.setSkills(readSkills(listing.getSkills()));
                    break;
            case 3: listing.setStartDate(readDate("Enter the new start date."));
                    break;
            case 4: listing.setStartDate(readDate("Enter the new end date."));
                    break;
            case 5: listing.setSiteLink(readWord("Enter the new site link."));
                    break;
            case 6: listing.setTitle(readString("Enter the new title."));
                    break;
            case 7: listing.setLocation(readString("Enter the new location."));
                    break;
            case 8: listing.setDescription(readStringArrayList(listing.getDescription(), "Would you like to add another line of the job description?"));
                    break;
        }
    }
} // done
