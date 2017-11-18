/**
 *  The job entity is used to create job objects which stores the information relevant to each job instance.
 *  The information stored will be provide applicantimport java.time.LocalDateTime;
 s with releveant information pertaining to the job.
 *
 * @author (INSERT NAME HERE) <-------------------------------------------- That means you Paul!
 *
 */
package entities;


import java.time.LocalDateTime;

public class Job {
    private String contactEmail, status, jobType, jobID, jobDescrip;
    private float salary;
    private LocalDateTime expDate;

    private enum status {AVAILABLE, FILLED, WITHDRAWN, EXPIRED}

    ;
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
    private LocalDateTime getExpData() {
        // returns expDate
        return expDate;
    }

    /**
     * return the number of applicants who has succesfully applied to this job
     *
     * @return The unique ID assigned to this job
     */
    private int getNumApplicants() { // return numberOfApplicants
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
     * @param job          the date the job starts
     */
    public void createJob(String contactEmail, String jobType, String jobID, String jobDescrip, Float salary, LocalDateTime job) {
        /*
            prompt user for email, job type, jobID, description, salary, job
            set appropriate fields for email, jobtype, jobID, description, salary, job
         */
    }

    /**
     * Returns the current status of this job
     *
     * @return The current status pertaining to this job
     */
    private String getStatus() {
        // return current status
        return status;
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
    private void modJob(String contactEmail, String jobType, String jobDescrip, float salary, LocalDateTime setDate) {
        /*
        prompt the user for new values to set for email, job type, job description, salary, and date
        set the new contactEmail, jobType, jobDescrp, salary, setDate
         */
    }

    ;

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