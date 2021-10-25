package src;

/**
 * Application class, stores a job application
 */
public class Application {
    public final Listing LISTING;
    public final Student STUDENT;
    private int status;

    /**
     * Constructor for Application
     * @param listing the job being applied to
     * @param student the student applying to the job
     */
    public Application(Listing listing, Student student) {
        this.LISTING = listing;
        this.STUDENT = student;
        this.status = 2;  // status == 2: Application is pending
    }

    /**
     * status == 1: Application was accepted
     */
    public void accept() {
        this.status = 1;
    }

    /**
     * status == 0: Application was rejected
     */
    public void reject() {
        this.status = 0;
    }

    /**
     * Gets the status of the application
     * @return 0 if application was rejected, 1 if application was accepted,
     *         2 if application is pending
     */
    public int getStatus() {
        return status;
    }
}
