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

    public EmployerUI(Scanner scanner) {
        super(scanner);
    }

    public EmployerUI(Scanner scanner, Employer employer) {
        super(scanner);
        this.employer = employer;
    }

    public void run() {
        boolean running = true;
        while (running) {
            int input = scanner.nextLine();
            switch (input) {
                case 1:
                case 2: 
                case 3:
                case 4:
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
        System.out.println("Write your company's profile, followed by the enter key.");
        employer.addDescription(scanner.nextLine());
    }

    /**
     * addListing Employer adds a new job listing for students to apply.
     */
    private void addListing() {
        // loops through all the stuff it needs and adds it
        // to their arraylist
        boolean creatingListing;
        // String[] prompts = new String["payRate", "description", "startDate", "endDate", "description", "title", "location", "skills"];
        do {
            creatingListing = false;
            System.out.println("Please give the pay rate of the listing as an hourly wage");
            double payRate = scanner.nextLine();
            // bulletpoints description, "quit" = quit


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
            
            System.out.println("What skills will the job require? (type \'done\' when done)");
            System.out.println("Add a description of the job.");
            describing = false;
            ArrayList<String> 
            while (describing) {

            }

        } while (creatingListing);
    }

    /**
     * deleteListing Employer can delete their job listings
     */
    private void deleteListing() {
        // for loop, prints title of all listings
        // asks them for the index of which one they want to delete
        // deletes that listing from the arraylist, moves all the others up
        for (int i = 0; i < employer.getListings().size(); i++) {
            System.out.println((i+1) + ". " + employer.getListings().get(i).getTitle());
        }
        System.out.println("Which listing would you like to delete?"); 
        // go back and make this a while in case someone doesn't put a number
        try {
            int input = Scanner.nextline();
            employer.setListings(employer.getListings().remove(i));
        } catch (Exception e) {
            System.out.println("invalid entry");
        }
        // BUG - if they delete the listing, that deletes all the applications associated with it in
        // our current UML. are we sure we want this?
    }

    /**
     * editListing Employer can edit their job listings
     */
    private void editListing() {
        // for loop, prints title of all listings
        // asks them which listing they want
        // loop, prints the different things in the listing, which one do you want to edit
        // edit that listing
        // done
        // ArrayList<Listing> listings = employer.getListings();
        for (int i = 0; i < employer.getListings().size(); i++) {
            System.out.println((i+1) + ". " + employer.getListings().get(i).getTitle());
        }
        System.out.println("Which listing would you like to edit?"); // go back and make this a while in case someone gets smart and doesn't put a number
        /*try {
            int input = Scanner.nextline();
        } catch(Exception e) {

        }*/
        int input = Scanner.nextline();
        Listing listing = listings.get(input);
        System.out.println("What would you like to edit?");
        System.out.println("1. Pay Rate \n2. Description \n3. Start Date \n4. End Date \n5. Site Link \n6. Title \n7. Location \n8. Skills");
        String editing = scanner.nextLine();
        switch (editing) { 
            // PROBLEM: no exception handling here
            case 1: System.out.println("Enter the new pay rate.");
                    listing.setPayRate(scanner.nextLine());
                    break;
            case 2: System.out.println("Enter the new description.");
                    break;
            case 3: System.out.println("Enter the new start date.");
                    listing.setStartDate(scanner.nextLine());
                    break;
            case 4: System.out.println("Enter the new end date.");
                    listing.setEndDate(scanner.nextLine());
                    break;
            case 5: 
            case 6: 
            case 7:
            case 8:
        }
        /** f
            private double payRate;
            private ArrayList<String> description;
            private Date startDate, endDate;
            private String siteLink, title, location;
            private ArrayList<Skills> skills;
        */
        


    }

}
