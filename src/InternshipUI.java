package src;

import java.util.Scanner;

/**
 * Intership User Interface
 * This user interface runs the front-end of the Internship system.
 * @author William Hobbs, Noah MacBride, and Jack Oberman
 */
public abstract class InternshipUI {
    private final Skills[] SKILLS_LIST;
    protected Scanner scanner;
    protected String[] mainMenuOptions;

    /**
     * Constructor for an internship user interface
     * @param scanner is the scanner from Driver
     */
    public InternshipUI(Scanner scanner) {
        this.scanner = scanner;
        this.SKILLS_LIST = new Skills[]{Skills.Linux, Skills.CPlusPlus, Skills.Java, Skills.JavaScript,
            Skills.CSharp, Skills.Python, Skills.Git, Skills.GitHub, Skills.HTML,
            Skills.CSS, Skills.React, Skills.Vue, Skills.Angular, Skills.Swift,
            Skills.Flutter, Skills.Django, Skills.PHP, Skills.C, Skills.RobotC,
            Skills.Ruby, Skills.Cobalt, Skills.SQL, Skills.GO, Skills.Rust};
    }

    /**
     * Runs the internship user interface
     */
    public abstract void run();

    /**
     * Logs a user out of the system and clears data
     */
    protected void logout() {
        //TO-DO: DataWriter.save();
    }

    /**
     * Displays menu options
     * @param menuOptions is a String[] for menu options with a corresponding int
     * @return string representation of menu options with corresponding int 
     */
    protected String displayMenu(String[] menuOptions) {
        String display = "";
        for (int i = 0; i < menuOptions.length; ++i) {
            display += (i+1) + ") " + menuOptions[i] + "\n";
        }
        return display + "Pick 1 through " + menuOptions.length;
    }

    /**
     * displays a menu and reads integer response, repeating until it receives a valid response
     * @param menuOptions is a String[] for menu options with a corresponding int
     * @return integer response for menu option
     */
    protected int readMenu(String[] menuOptions) {
        boolean reading;
        int option;
        do {
            reading = false;
            System.out.println(displayMenu(menuOptions));
            option = Integer.parseInt(scanner.nextLine());
            if (option < 1 || option > menuOptions.length)
                reading = !error("Please enter a valid number from 1 through " + menuOptions.length);
        } while (reading);

        return option;
    }

    /**
     * displays a menu of possible skills and reads an integer response, repeating until it received a valid value
     * @return integer response for skill chosen
     */
    protected Skills readSkillMenu() {
        String[] skills = new String[SKILLS_LIST.length];

        for (int i = 0; i < skills.length; i++)
            skills[i] = SKILLS_LIST[i].toString();

        return SKILLS_LIST[readMenu(skills) + 1];
    }

    /**
     * reads a string response to a prompt
     * @param message is the prompt 
     * @return String response
     */
    protected String readString(String message) {
        System.out.println(message);
        return scanner.nextLine();
    }

    /**
     * reads an int response to a prompt
     * @param message is the prompt
     * @return int response
     */
    protected int readInt(String message) {
        System.out.println(message);
        return Integer.parseInt(scanner.nextLine());
    }

    /**
     * reads an int response to a prompt, int must be in range
     * @param message is the prompt
     * @param lower the lower boundary of the acceptable range (inclusive)
     * @param upper the upper boundary of the acceptable range (non-inclusive)
     * @return int response in range
     */
    protected int readInt(String message, int lower, int upper) {
        boolean reading;
        int result;
        do {
            reading = false;
            System.out.println(message + " (" + lower + "-" + upper + ")");
            result = Integer.parseInt(scanner.nextLine());
            reading = !(result >= lower && result < upper);
            if (reading) error("Please enter a number in the range");
        } while (reading);

        return result;
    }

    /**
     * reads a double response to a prompt
     * @param message is the prompt
     * @return double response
     */
    protected double readDouble(String message) {
        System.out.println(message);
        return Double.parseDouble(scanner.nextLine());
    }

    /**
     * reads a boolean response to a prompt
     * @param message is the prompt
     * @return boolean response
     */
    protected boolean readBoolean(String message) {
        boolean reading;
        do {
            reading = false;
            System.out.println(message + " (y/n)");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("y"))
                return true;
            else if (input.equalsIgnoreCase("n"))
                return false;
            else reading = true;
            if (reading) error("Please enter a \"y\" or an \"n\"");
        } while (reading);

        return false;
    }

    /**
     * reads a date response to a prompt
     * @param message is the prompt
     * @return a Date object in the form of mm/dd/yy
     */
    protected Date readDate(String message) {
        System.out.println(message);
        int month, day, year;
        month = readInt("Please enter the month", 1, 12);
        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12)
            day = readInt("Please enter the day", 1, 31);
        else if (month == 4 || month == 6 || month == 9 || month == 11)
            day = readInt("Please enter the day", 1, 30);
        else day = readInt("Please enter the day", 1, 28);
        year = readInt("Please enter the year");
        
        return new Date(month, day, year);
    }

    /**
     * reads a singular word response to a prompt
     * @param message is the prompt
     * @return is the string with no spaces
     */
    protected String readWord(String message) {
        boolean reading;
        String word;
        
        do {
            reading = false;
            System.out.println(message);
            word = scanner.nextLine();

            if (word.contains(" "))
                reading = !error("Please enter only a single word");
            else if (word.length() > 40)
                reading = !error("Please enter 40 characters or less");
        } while (reading);

        return word;
    }

    /**
     * reads a username, repeats until an available username is chosen
     * @return a valid username
     */
    protected String readUsername() {
        flush();
        boolean reading;
        String username;
        
        do {
            reading = false;
            System.out.println("Please enter a username:");
            username = scanner.nextLine();
            reading = !Database.isAvailable(username);
            if (reading) error("Your username is taken, please enter another username:");
        } while (reading);

        return username;
    }

    /**
     * reads a password, repeats until a valid password is chosen
     * @return a valid password
     */
    protected String readPassword() {
        flush();
        boolean reading;
        String password;
        
        do {
            reading = false;
            System.out.println("Please enter a password:");
            password = scanner.nextLine();
            reading = !isValidPassword(password);
        } while (reading);

        return password;
    }

    /**
     * Creates a user when they are signing up, called by Driver
     */
    public abstract void createUser();

    /**
     * Ensure password has a length between 8 and 16, has a number, a lowercase letter, a capital letter, and a symbol with no spaces
     * 
     * @param password password to be verified
     * @return true if password is valid, false otherwise
     */
    private boolean isValidPassword(String password) {
        if (password.length() < 8)
            return error("Password must be at least 8 characters");
        if (password.length() > 16)
            return error("Password must be less than 17 characters");
        if (!password.matches(".*[a-z].*"))
            return error("Password must contain a lowercase letter");
        if (!password.matches(".*[A-Z].*"))
            return error("Password must contain a uppercase letter");
        if (!password.matches(".*[0-9].*"))
            return error("Password must contain a number");
        if (!password.matches(".*[!-&].*"))
            return error("Password must contain a special character");
        if (password.matches(".*/\\s/g.*"))
            return error("Password may not have any spaces");
    
        return true;
    }

    /**
     * prints error response
     * @param message is the error response
     * @return false
     */
    protected boolean error(String message) {
        System.err.println(message);
        return false;
    }

    /**
     * Clears dialogue from terminal
     */
    protected void flush() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}
