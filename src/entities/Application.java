package entities;

import entities.Job;
import entities.Applicant;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

/**
 * Entitiy storing the information relating to a single job application.
 * @author Mathias Wiesbauer
 */

public class Application {
    private String resume;
    private String coverLetter;
    private String status;
    private Date dateApplied;
    private Date dateWithdrawn;
    private Job job;
    private Applicant applicant;
    private ArrayList<LocalDateTime> interviews;

    /**
     * Constructor requires the current date to create an application
     * @param job the job instance
     * @param applicant the applicant instance
     * @param currentDate the current date from the timer class
     */
    public Application(Job job, Applicant applicant, Date currentDate) {
        this.dateApplied = currentDate;
        this.job = job;
        this.applicant = applicant;
    }

    /**
     * Returns the job instance of the application
     * @return
     */
    public Job getJob() {
        return this.job;
    }

    /**
     * Returns the applicant instance of the application
     * @return
     */
    public Applicant getApplicant() {
        return this.applicant;
    }

    /**
     * Adds three time slots to the system
     * @param currentDate the current date in the system
     */
    public void scheduleInterviews(LocalDate currentDate) {
        // ADD 7 DAYS TO CURRENT DATE
        // GENERATE LOCALDATETIME OBJECTS FOR 9:00AM, 10:00AM, 11:00AM
        // ADD ALL THREE OBJECTS TO ARRAYLIST INTERVIEWS
    }

    /**
     * Sets the resume on the application instance
     * @param resume
     */
    public void setResume(String resume) {
        this.resume = resume;
    }

    /**
     * Returns the resume from the application instance
     * @return
     */
    public String getResume() {
        return resume;
    }

    /**
     * Sets the cover letter on the application instance
     * @param coverLetter
     */
    public void setCoverLetter(String coverLetter) {
        this.coverLetter = coverLetter;
    }

    /**
     * Returns the cover letter from the application instance
     * @return
     */
    public String getCoverLetter() {
        return coverLetter;
    }

    /**
     * Sets the status on the application instance
     * @param status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Returns the status from the application instance
     * @return
     */
    public String getStatus() {
        return status;
    }

    /**
     * Returns the application date from the instance
     * @return
     */
    public LocalDate getDateApplied() {
        return dateApplied;
    }

    /**
     * Withdrawing an application, changes the status
     * @param currentDate expects the current date in the system
     */
    public void withdrawApplication(LocalDate currentDate) {
        dateWithdrawn = LocalDateTime.now();
    }

    /**
     * Generates a formated output for the application instance
     * @return
     */
    public String toString() {
        return "Status: " + status + " Date Applied : " + dateApplied;
    }

}