package src;

import java.util.Scanner;

/**
 * Employer User Interface Runs the front-end of the employer's experience with
 * the Internship program.
 * 
 * @author William Hobbs
 */
public class EmployerUI extends InternshipUI {
    public Employer employer;
    // QUESTION - reference employer or this.employer?

    public EmployerUI(Scanner scanner) {
        super(scanner);
    }

    public EmployerUI(Scanner scanner, Employer employer) {
        super(scanner);
        this.employer = employer;
    }
    /**
     * run runs the central framework of the UI for employers
     */
    public void run() {
        boolean running = true;
        while (running) {
            System.out.println("1. Add a Company Profile\n2. Add a Job Listing\n3. Update a Job Listing\n4. Delete a Job Listing\n5. Quit");
            int input = scanner.nextLine();
            switch (input) {
                case 1: addProfile();
                        break;
                case 2: addListing();
                        break;
                case 3: editListing();
                        break;
                case 4: deleteListing();
                        break;
                case 5: running = false;
                        break;
            }
        }
    }

    public void createUser() {
        boolean creatingUser = true;
        while (creatingUser) {

        }
    }

    /**
     * addProfile Helps an employer set up their Employer Profile for students to
     * search.
     * - i like the idea of prompting a vim editor here so that they can edit it more easily
     * - find a way to take a longer input and allow for formatting (?)
     * - this is called profile in the UI but description in the Employer class, do we change?
     */
    private void addProfile() {
        System.out.println("Write your company's profile, type DONE when finished.");
        describing = true;
        while (describing) {
            String desc = scanner.nextLine();
            if (desc.equalsIgnoreCase("done")) {
                describing = false;
                break;
            } else {
                this.employer.addDescription(desc);
            }
        }
    } // done

    /**
     * addListing Employer adds a new job listing for students to apply.
     */
    private void addListing() {
        // loops through all the stuff it needs and adds it
        // to their arraylist
        boolean creatingListing;
        do {
            creatingListing = false;
            System.out.println("Please give the pay rate of the listing as an hourly wage");
            double payRate = scanner.nextLine();
            System.out.println("Add a start date for the job. MM/DD/YYYY");
            Date startDate = scanner.nextLine();
            System.out.println("Add an end date for the job. MM/DD/YYYY");
            Date endDate = scanner.nextLine();
            System.out.println("Link a site for the job description.");
            String siteLink = scanner.nextLine();
            System.out.println("Provide a title for the job.");
            String title = scanner.nextLine();
            System.out.println("Provide the location for work.");
            String location = scanner.nextLine();
            // prompt for strings, "quit" = quit
            Listing listing = new Listing(payRate, location, description, startDate, 
                endDate, siteLink, skills, employer.getTitle());

            System.out.println("What skills will the job require? (type \'done\' when done)");
            ArrayList<Skills> skills = new ArrayList<Skills>();
            boolean describing = true;
            while (describing) {
                String skill = scanner.nextLine();
                if (skill.equalsIgnoreCase("done")) {
                    describing = false;
                    break;
                } else {
                    try {
                        skills.add(scanner.nextLine()); 
                    } catch(Exception e) {
                        System.out.println("Invalid skill, try again");
                    }
                }
            }
            System.out.println("Add a description of the job.");
            describing = true;
            while (describing) {
                String desc = scanner.nextLine();
                if (desc.equalsIgnoreCase("done")) {
                    describing = false;
                    break;
                } else {

                }
            }

        } while (creatingListing);
        // creating listing could hypothetically fail infinitely
        // until a user gets their act together and puts in acceptable values
    }

    /**
     * deleteListing Employer can delete their job listings
     */
    private void deleteListing() {
        // for loop, prints title of all listings
        // asks them for the index of which one they want to delete
        // deletes that listing from the arraylist, moves all the others up
        for (int i = 0; i < this.employer.getListings().size(); i++) {
            System.out.println((i+1) + ". " + this.employer.getListings().get(i).getTitle());
        }
        System.out.println("Which listing would you like to delete?"); 
        // go back and make this a while in case someone doesn't put a number
        try {
            int input = (Scanner.nextline() - 1);
            this.employer.setListings(employer.getListings().remove(i));
        } catch (Exception e) {
            System.out.println("Invalid entry");
        }
        // BUG - if they delete the listing, that deletes all the applications associated with it in
        // our current UML
    }

    /**
     * editListing Employer can edit their job listings
     */
    private void editListing() {
        // WHICH TO EDIT
        for (int i = 0; i < employer.getListings().size(); i++) {
            System.out.println((i+1) + ". " + employer.getListings().get(i).getTitle());
        }
        System.out.println("Which listing would you like to edit?");
        boolean choosing = true;
        while (choosing) {
            try {
                int input = Scanner.nextline();
                Listing listing = listings.get(input);
                choosing = false;
                break; // necessary?
            } catch(Exception e) {
                System.out.println("Invalid entry! Try again.");
            }
        }
        // WHAT TO EDIT
        System.out.println("What would you like to edit?");
        System.out.println("1. Pay Rate \n2. Description \n3. Start Date \n4. End Date \n5. Site Link \n6. Title \n7. Location \n8. Skills");
        String editing = scanner.nextLine();
        switch (editing) { 
            // PROBLEM: no exception handling here
            case 1: System.out.println("Enter the new pay rate.");
                    listing.setPayRate(scanner.nextLine());
                    break;
            case 2: System.out.println("Enter the new description.");
                    // TODO
                    break;
            case 3: System.out.println("Enter the new start date.");
                    listing.setStartDate(scanner.nextLine());
                    break;
            case 4: System.out.println("Enter the new end date.");
                    listing.setEndDate(scanner.nextLine());
                    break;
            case 5: System.out.println("Enter the new site link.");
                    listing.setSiteLink(scanner.nextLine());
                    break;
            case 6: System.out.println("Enter the new title.");
                    listing.setTitle(scanner.nextLine());
                    break;
            case 7: System.out.println("Enter the new location.");
                    listing.setLocation(scanner.nextLine());
                    break;
            case 8: System.out.println("Enter the new skils.");
                    // TODO
                    break;
        }
    }
}
