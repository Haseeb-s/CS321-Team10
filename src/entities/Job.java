/**
 *  The job entity is used to create job objects which stores the information relevant to each job instance.
 *  The information stored will be provide applicantimport java.time.LocalDateTime;
 s with releveant information pertaining to the job.
 *
 * @author Haseeb Shuaib
 *
 */
package entities;


import java.time.LocalDate;
import coordinators.JobSystemCoordinator;

public class Job {
    private String contactEmail, currentStatus, jobType, jobID, jobDescrip;
    private double salary;
    private LocalDate expDate;

    private enum status {AVAILABLE, FILLED, WITHDRAWN, EXPIRED};
    private int numberofApplicants;

    /**
     * Creates a new job using the provided information
     */
    public Job() {
        /*
        sets contactEmail, jobType, jobID, jobDescrip
        set salary
        set current time + 1 year as expDate
        set status
         */
        contactEmail = "";
        currentStatus = status.AVAILABLE.toString();
        jobType = "";
        jobID = "";
        jobDescrip = "";
        salary = -1.0;
        expDate = JobSystemCoordinator.timer.getCurrentDate().plusYears(1);
    }

    /**
     * increments numberofApplicants after someone succesfully applies
     */
    public void newApplicant() {
        //increment numberofApplicants
    }

    /**
     * decrements numberofApplicants after someone succesfully withdraws
     */
    public void lostApplicant() {
        //decrements numberofApplicants
    }

    /**
     * return the unique identification number associated to this job
     *
     * @return The unique ID assigned to this job
     */
    private String getJobID() {
        /*
        return jobID
         */
        return jobID;
    }

    /**
     * extract the time at which this job expires
     *
     * @return The experation date of this job
     */
    private LocalDate getExpData() {
        // returns expDate
        return expDate;
    }

    /**
     * return the number of applicants who has succesfully applied to this job
     *
     * @return The unique ID assigned to this job
     */
    public int getNumApplicants() { // return numberOfApplicants
        return numberofApplicants;
    }

    /**
     * populates the fields required to succesfully build a job class
     *
     * @param contactEmail email used to contact job poster
     * @param jobType      type of job (faculty, student, staff)
     * @param jobID        unique ID for the job
     * @param jobDescrip   job description
     * @param salary       salary for this job ( XX.XX for hourly)
     */
    public Job createJob(String contactEmail, String jobType, String jobID, String jobDescrip, Float salary) {
        /*
            prompt user for email, job type, jobID, description, salary, job
            set appropriate fields for email, jobtype, jobID, description, salary, job
         */
        Job newJob = new Job();
        return newJob;
    }

    /**
     * Returns the current status of this job
     *
     * @return The current status pertaining to this job
     */
    public String getStatus() {
        // return current status
        return currentStatus;
    }

    /**
     * Set method used to edit/modify the job after having already been created. Useful to make adjustments or include
     * forgotten information.
     *
     * @param contactEmail updated email used to contact job poster
     * @param jobType      update the type of job listing
     * @param jobDescrip   new job description that will overwrite previous
     * @param salary       set new salary
     * @param setDate      set new expiration date for the job
     * @return The unique ID assigned to this job
     */
    public void modJob(String contactEmail, String jobType, String jobDescrip, float salary, LocalDate setDate) {
        /*
        prompt the user for new values to set for email, job type, job description, salary, and date
        set the new contactEmail, jobType, jobDescrp, salary, setDate
         */
    }

    /**
     * returns a readable string with the job listing information
     *
     * @return String containing the data and description of the job
     */
    public String toString() {
        //return readable formated string containing contactEmail, jobType, jobDescription, salary, expiration time
        return "";
    }
}