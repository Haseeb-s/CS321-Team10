package managers;

import entities.Application;
import entities.Job;
import java.util.ArrayList;

/**
 * The application manager class interacts with the entities job and application
 * and allows the addition and withdrawal of job applications in the system.
 */
public class ApplicationManager {

    ArrayList<Application> applications = new ArrayList<Application>();

    /**
     * Searches and returns a job application from the system
     * @param email the email of the applicant
     * @param jobID the job ID
     * @return returns a Application instance or NULL
     */
    public Application getApplication(String email, String jobID) {
        // FOR EACH APPLICATION IN APPLICATIONS
        // TRY TO FIND AN APPLICATION CONTAINING THE EMAIL AND JOB ID
        // IF FOUND RETURN THE APPLICATION
        // OTHERWISE RETURN NULL
    }


    /**
     * Searches and returns a list of job applications from the system
     * @param email the email of the applicant
     * @param jobID the job ID
     * @return returns an ArrayList of Application instances
     */
    public ArrayList<Application> getApplicationsByUser(String email) {
        // FOR EACH APPLICATION IN APPLICATIONS
        // CHECK IF APPLICATION CONTAININS THE EMAIL
        // IF FOUND ADD APPLICATION TO ARRAY LIST
        // RETURN ARRAY LIST
    }

    /**
     * Searches and returns a list of pending job applications from the system
     * @return returns an ArrayList of Application instances
     */
    public ArrayList<Application> getPendingApplications() {
        // FOR EACH APPLICATION IN APPLICATIONS
        // CHECK IF APPLICATION IS PENDING
        // IF FOUND ADD APPLICATION TO ARRAY LIST
        // RETURN ARRAY LIST
    }

    /**
     * Searches and returns a list of pending job applications for a particula job from the system
     * @param jobID
     * @return returns an ArrayList of Application instances
     */
    public ArrayList<Application> getPendingApplications(String jobID) {
        // FOR EACH APPLICATION IN APPLICATIONS
        // CHECK IF APPLICATION IS PENDING AND IF IT BELONGS TO JOBID
        // IF FOUND ADD APPLICATION TO ARRAY LIST
        // RETURN ARRAY LIST
    }

    /**
     * Sets three interview slots: +7 days from current date at 9:00am,
     * + 7 days from current day at 10:00am and +7 days from current day at 11:00am
     * @param currentDate the current date in the system (timer)
     */
    public void setupInterviews(LocalDate currentDate) {

        // FOR THE CURRENT APPLICATION
        // CALL THE SCHEDULEINTERVIEWS METHOD
    }

    /**
     * Adds an application to the system
     * @param email the email address of the applicant
     * @param jobID the job ID the application will be associated with
     * @param coverLetter the applicants cover letter
     * @param resume the applicants resume
     */
    public void submitApplication(String email, String jobID, String coverLetter, String resume) {
        // CHECK IF AN APPLICATION WITH THE SAME EMAIL AND JOB ID EXISTS ALREADY
        // IF NOT CREATE A NEW APPLICATION
        // ADD NEW APPLICATION TO APPLICATIONS
    }

    /**
     * Withdrawing an application from the system
     * @param email the email address of the applicant
     * @param jobID the jobID
     */
    public void withdrawApplication(String email, String jobID) {
        // CHECK IF AN APPLICATION WITH THE EMAIL AND JOB ID EXISTS IN APPLICATIONS
        // IF IT DOES MARK AS WITHDRAWN
    }
} // END CLASS