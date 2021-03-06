package entities;

import entities.Job;
import entities.Applicant;
import coordinators.JobSystemCoordinator;
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
    private String status = "Submitted";
    private LocalDate dateApplied;
    private LocalDate dateWithdrawn;
    private Boolean withdrawn = false;
    private Job job;
    private Applicant applicant;

    /**
     * Constructor requires the current date to create an application
     * @param job the job instance
     * @param applicant the applicant instance*
     */
    public Application(Job job, Applicant applicant) {
        this.job = job;
        this.applicant = applicant;
        this.dateApplied = JobSystemCoordinator.timer.getCurrentDate();
    }

    /**
     * Default constructor
     */
    public Application() {

    }

    /**
     * Returns the job instance of the application
     * @return returns a job instance
     */
    public Job getJob() {
        return this.job;
    }

    /**
     * Returns the applicant instance of the application
     * @return returns an applicant instance
     */
    public Applicant getApplicant() {
        return this.applicant;
    }

    /**
     * Sets the resume on the application instance
     * @param resume returns the resume as a string
     */
    public void setResume(String resume) {
        this.resume = resume;
    }

    /**
     * Returns the resume from the application instance
     * @return returns the resume as a string
     */
    public String getResume() {
        return resume;
    }

    /**
     * Sets the cover letter on the application instance
     * @param coverLetter the cover letter as a string
     */
    public void setCoverLetter(String coverLetter) {
        this.coverLetter = coverLetter;
    }

    /**
     * Returns the cover letter from the application instance
     * @return returns the cover letter as a string
     */
    public String getCoverLetter() {
        return coverLetter;
    }

    /**
     * Sets the status on the application instance
     * @param status the status string to be set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Returns the status from the application instance
     * @return returns the status string
     */
    public String getStatus() {
        return status;
    }

    /**
     * Returns the application date from the instance
     * @return returns the date the applicant applied
     */
    public LocalDate getDateApplied() {
        return dateApplied;
    }

    /**
     * Withdrawing an application, changes the status
     */
    public void withdrawApplication() {
        this.dateWithdrawn = JobSystemCoordinator.timer.getCurrentDate();
        this.withdrawn = true;

    }

    /**
     * Gets the withdrawn status of an application
     *
     * @return returns a boolean
     */
    public boolean isWithdrawn() {
        return this.withdrawn;
    }

    /**
     * Generates a formated output for the application instance
     * @return returns a formated string
     */
    public String toString() {
        return "Status: " + status + " Date Applied : " + dateApplied;
    }

}