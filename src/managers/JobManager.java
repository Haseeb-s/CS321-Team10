package managers;

import java.util.ArrayList;
import entities.Job;
import coordinators.JobSystemCoordinator;
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

    /**
     * Will initialize the Job Manager
     */
    public JobManager(){
        //Initialize the job manager for use of the system
    }

    /**
     * Will add a job into the arrayList of the job
     * @param job will contain a job information and add it to the job arrayList
     * @return true if added correctly
     */
    public boolean addJob(String jobID, String jobTitle, String jobType,
                          String salary, String jobDescription, String expirationDate,
                          String contactEmail) {
        //Will check if the amount is less than 100 jobs added
        //then Will add the job to the end of the arrayList
        //will return true if added else return false
        currentJob = new Job(contactEmail, jobType, jobID, jobDescription, salary, jobTitle, expirationDate);
        if(jobs.size() <= 100)
        {
            jobs.add(currentJob);
            return true;
        }
        return false;
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
            if(jobID.compareTo(currentJob.getJobID()) == 0){
                jobs.remove(i);
                return this.currentJob.getJobID();
            }
        }
        return "";
    }

    /**
     * Will search for the job then will add the modified job
     * in the ArrayList
     * @param job Will contain all the new job information
     * @return true if successfully edited
     */
    public boolean modifyJob(String jobID, String jobTitle, String jobType,
                             String salary, String jobDescription, String expirationDate,
                             String contactEmail){
        //Will locate the job with the jobID
        //Then will move the user input for each input
        //to its respected fields
        //Will then return true if successful
        Job newJob = new Job(contactEmail, jobType, jobID, jobDescription, salary);
        for(int i = 0; i< jobs.size(); i++){
            this.currentJob = jobs.get(i);
            if(this.currentJob.getJobID().compareTo(newJob.getJobID())==0){
                jobs.set(i,newJob);
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
    public boolean checkExpiration(){
        //Will grab the time from the timer and compare it to the job expiration
        //Then will grab each jobID that is expired
        //Will then add it to a String array
        //then remove all those jobs in the String array
        //return true if found
        ArrayList<String> expiredJobs = new ArrayList<>();
        for(int i=0; i < jobs.size(); i++){
            currentJob = jobs.get(i);
            if(currentJob.getExpData().compareTo(JobSystemCoordinator.timer.getCurrentDate())==0){
                expiredJobs.add(currentJob.getJobID());
            }
        }
        for(int i = 0; i <expiredJobs.size(); i++){
            removeJob(expiredJobs.get(i));
        }
        if(expiredJobs.size()!=0)
            return true;
        return false;
    }

    public ArrayList<Job> getJobs(){
        return jobs;
    }
}