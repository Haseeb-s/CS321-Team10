package managers;

import java.util.ArrayList;
import entities.Job;
import coordinators.JobSystemCoordinator;
import entities.Application;
import java.time.LocalDateTime;

/**
 * The job manager will deal with holding all the jobs in the system and
 * adding and removing any jobs that are needed
 * @author Kevin Silvera
 */
public class JobManager{
    ArrayList<Job> jobs = new ArrayList<Job>();
    Job currentJob;
    Timer time;
    ArrayList<Application> appList;

    /**
     * Will initialize the Job Manager
     */
    public JobManager(){
        //Initialize the job manager for use of the system
    }

    /**
     * Will add a job into the arrayList of the job
     * @param jobID will hold the job's identification
     * @param jobTitle will hold job's name
     * @param jobType will hold the classification
     * @param salary will hold the salary for the job
     * @param jobDescription the unique description for this job
     * @param expirationDate the date that will expire the job
     * @param contactEmail will hold the employer email
     * @return true if added correctly
     */
    public void addJob(String jobID, String jobTitle, String jobType,
                          String salary, String jobDescription, String expirationDate,
                          String contactEmail) {
        //Will check if the amount is less than 100 jobs added
        //then Will add the job to the end of the arrayList
        //will return true if added else return false
        currentJob = new Job(contactEmail, jobType, jobID, jobDescription, salary, jobTitle, expirationDate);
        if(jobs.size() <= 100)
        {
            jobs.add(currentJob);
            String success = String.format("================JOB POSTING SUCCESS================\n" +
                            "A new job has been posted with following details:\n" +
                            "Job ID: %s\n" +
                            "Job Name: %s\n" +
                            "Job Type: %s\n" +
                            "Salary: %s\n" +
                            "Job Description: %s\n" +
                            "Expiration Date: %s\n" +
                            "Contact email: %s\n", jobID, jobTitle, jobType, salary, jobDescription, expirationDate, contactEmail);

            System.out.println(success);
        } else {
            String success = String.format("================JOB POSTING FAILURE ================\n" +
                    "THERE ARE MORE THAN 100 JOBS IN THE SYSTEM:\n");
            System.out.println(success);
        }
    }

    /**
     * Will remove a job from the arrayList
     * @param jobID will be used to check for the jobID in the ArrayList
     * @return the JobID that was removed
     */
    public String removeJob(String jobID){
        //Will look for the job ID in the jobs arrayList
        //then will remove that job from the arrayList
        //Will return the String jobID that has been removed
        for(int i = 0; i < jobs.size(); i++){
            this.currentJob = jobs.get(i);
            if(jobID.equals(currentJob.getJobID())){
                jobs.remove(i);
                String success = String.format("============REMOVING A JOB SUCCESS==============\n" +
                        "The job with ID %s has been removed successfully.\n",jobID);
                System.out.println(success);
                return currentJob.getJobID();
            }
        }
        return "JOB NOT FOUND";
    }


    public void printAvailableJobs() {


        String output = "===============LIST OF AVAILABLE JOBS==============";
        System.out.println(output);
        for (Job job : jobs) {
            if (job.currentStatus.equals("AVAILABLE")) {
                System.out.println(String.format("Job ID: %s", job.getJobID()));
            }
        }
        System.out.println("\n");
    }


    /**
     * Will search for the job then will add the modified job
     * in the ArrayList
     * @param jobID will hold the job's identification
     * @param jobTitle will hold job's name
     * @param jobType will hold the classification
     * @param salary will hold the salary for the job
     * @param jobDescription the unique description for this job
     * @param expirationDate the date that will expire the job
     * @param contactEmail will hold the employer email
     * @return true if successfully edited
     */
    public boolean modifyJob(String jobID, String jobTitle, String jobType,
                             String salary, String jobDescription, String expirationDate,
                             String contactEmail){
        //Will locate the job with the jobID
        //Then will move the user input for each input
        //to its respected fields
        //Will then return true if successful
        Job newJob = new Job(contactEmail, jobType, jobID, jobDescription, salary, jobTitle, expirationDate);
        for(int i = 0; i< jobs.size(); i++){
            this.currentJob = jobs.get(i);
            if(this.currentJob.getJobID().compareTo(newJob.getJobID())==0){
                jobs.set(i,newJob);
                String success = String.format("=========JOB POSTING MODIFICATION SUCCESS=========\n"+
                        "A new job has been posted with following details:\n"+
                        "Job ID: %s\n"+
                        "Job Name: %s\n"+
                        "Job Type: %s\n"+
                        "Salary: %s\n"+
                        "Job Description: %s\n"+
                        "Expiration Date: %s\n"+
                        "Contact email: %s\n", jobID,jobTitle,jobType,salary,jobDescription,expirationDate,contactEmail);
                System.out.println(success);
                return true;
            }
        }
        return false;
    }

    /**
     * Will check the expiration for the whole job arrayLIst
     * then Remove all the jobs passed that time
     * @return if found and removed
     */
    public void checkExpiration(){
        //Will grab the time from the timer and compare it to the job expiration
        //Then will grab each jobID that is expired
        //Will then add it to a String array
        //then remove all those jobs in the String array
        //return true if found

        for(int i=0; i < jobs.size(); i++){
            currentJob = jobs.get(i);
            if(currentJob.getExpData().compareTo(JobSystemCoordinator.timer.getCurrentDate())==0){
                currentJob.setStatus("EXPIRED");
            }
        }
    }

    /**
     * Will close a job and send to all other applicants that
     * job has been filled
     * @param jobID will grab the id of the job that will be closed
     * @param email will be the email of who was hired
     */
    public void closeJobHiring(String jobID, String email)
    {
        appList= JobSystemCoordinator.appManager.getPendingApplications(jobID);
        currentJob = getJobAtIndex(jobID);
        for(Application app : appList) {
            app.setStatus("Post no longer available!");
        }
        currentJob.setStatus("FILLED");
                String success = String.format("============CLOSING A JOB SUCCESS==============\n" +
                        "Job ID: %s\n" +
                        "Hired Candidates: %s\n", currentJob.getJobID(), email);
                System.out.println(success);
    }

    /**
     * Will grab a job at the jobID and send it back
     * otherwise null
     * @param jobID the job that is being searched
     * @return the job entity will relevant information
     */
    public Job getJobAtIndex(String jobID){
        for(Job job: jobs){
            if(job.getJobID().equals(jobID))
                return job;
        }
        return null;
    }

    /**
     * Will grab a specific job and print it out to the user
     * @param jobID the specific job they want
     */
    public void viewSpecificJob(String jobID) {
        System.out.println(getJobAtIndex(jobID).toString());
    }

    /**
     * will send the arraylist back if needed by other classes
     * @return the arrayList of jobs
     */
    public ArrayList<Job> getJobs(){
        return jobs;
    }

    /**
     * Will set up the interview of the user and set
     * their status for awaiting interview and send a confirmation
     * of successful interview
     * @param jobID the job that is wanted
     * @param email the email of the applicant that will be interviewed
     */
    public void setUpInterview(String jobID, String email){
        appList= JobSystemCoordinator.appManager.getPendingApplications(jobID);
        currentJob = getJobAtIndex(jobID);
        for(Application app : appList){
            if(app.getApplicant().getEmail().equals(email)){
                app.setStatus("Awaiting Interview");
                String success = String.format("===========SETTING UP INTERVIEWS FOR A JOB========\n" +
                        "Details of setting up interviews:\n" +
                        "Job ID: %s\n" +
                        "Candidate list: %s\n",currentJob.getJobID(),app.getApplicant().getEmail());
                System.out.println(success);
            }
        }
    }
}