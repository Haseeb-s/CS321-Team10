/**
 *  The job entity is used to create job objects which stores the information relevant to each job instance.
 *  The information stored will be provide applicantimport java.time.LocalDateTime;
 * with releveant information pertaining to the job.
 *
 * @author Haseeb Shuaib
 *
 */
package entities;


import java.time.LocalDate;
import coordinators.JobSystemCoordinator;
import java.time.format.DateTimeFormatter;

import static coordinators.JobSystemCoordinator.timer;

public class Job {
    public String jobName, contactEmail, jobType, jobID, jobDescrip, salary;
    public String currentStatus;
    private LocalDate creationDate = timer.getCurrentDate();
    private LocalDate expDate;
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
        currentStatus = "AVAILABLE";
        jobType = "";
        jobID = "";
        jobDescrip = "";
        salary = "$-1";
        expDate = timer.getCurrentDate().plusYears(1);
        numberofApplicants = 0;
    }

    /**
     *  Creates a new job using the provided information
     * @param contactEmail its the contact email
     * @param jobType the classification of this job listing
     * @param jobID the unique ID for this job
     * @param jobDescrip the unique description for this job
     * @param salary the salary set for the class
     * @param expDate the set expDate
     */
    public Job(String contactEmail, String jobType, String jobID, String jobDescrip, String salary, String jobName, String expDate){
        this.jobName = jobName;
        this.contactEmail = contactEmail;
        this.jobType = jobType;
        this.jobID = jobID;
        this.jobDescrip = jobDescrip;
        this.salary = salary;
        this.currentStatus = "AVAILABLE";
        DateTimeFormatter formatter;
            formatter = DateTimeFormatter.ofPattern("MM/dd/y");
        this.expDate = LocalDate.parse(expDate, formatter);
    }

    /**
     * increments numberofApplicants after someone succesfully applies
     */
    public void newApplicant() {
        //increment numberofApplicants
        numberofApplicants++;
    }

    /**
     * decrements numberofApplicants after someone succesfully withdraws
     */
    public void lostApplicant() {
        //decrements numberofApplicants
        numberofApplicants--;
    }

    /**
     * return the unique identification number associated to this job
     *
     * @return The unique ID assigned to this job
     */
    public String getJobID() {
        return jobID;
    }

    /**
     * extract the time at which this job expires
     *
     * @return The experation date of this job
     */
    public LocalDate getExpData() {
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
     * Returns the current status of this job
     *
     * @return The current status pertaining to this job
     */
    public String getStatus() {
        // return current status
        return currentStatus;
    }
    public void setStatus(String status){
        this.currentStatus = status;
    }

    /**
     * Set method used to edit/modify the job after having already been created. Useful to make adjustments or include
     * forgotten information.
     * @param jobName      set the new job name
     * @param contactEmail updated email used to contact job poster
     * @param jobType      update the type of job listing
     * @param jobDescrip   new job description that will overwrite previous
     * @param salary       set new salary
     * @param setDate      set new expiration date for the job
     */
    public void modJob(String jobName, String contactEmail, String jobType, String jobDescrip, String salary, String setDate) {
        this.jobName = jobName;
        this.contactEmail = contactEmail;
        this.jobType = jobType;
        this.jobDescrip = jobDescrip;
        this.salary = salary;
        this.expDate = LocalDate.parse(setDate);
    }

    /**
     * gets the date of which the job was created
     * @return the date the job was created
     */
    public String getCreationDate() {
        return creationDate.toString();
    }

    /**
     * returns a readable string with the job listing information
     *
     * @return String containing the data and description of the job
     */
    public String toString() {
        DateTimeFormatter formatter;
        formatter = DateTimeFormatter.ofPattern("MM/dd/y");
        //return readable formated string containing contactEmail, jobType, jobDescription, salary, expiration time
        return "=================DETAILS OF A JOB=================\n" +
                "Details of selected job are given below:\n" +
                "Job ID: " +jobID + "\n" +
                "Job Name: " +jobName + "\n" +
                "Job Type: " + jobType + "\n" +
                "Salary: " + salary + "\n" +
                "Job Description: " + jobDescrip + "\n" +
                "Expiration Date: " + expDate.format(formatter) + "\n" +
                "Contact email: " + contactEmail + "\n";
    }
}