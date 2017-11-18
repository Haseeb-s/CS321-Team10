package managers;

import java.util.ArrayList;
import entities.Job;
import java.time.LocalDateTime;

/**
 * The job manager will deal with holding all the jobs in the system and
 * adding and removing any jobs that are needed
 * @author Kevin Silvera
 */
public class JobManager{
    ArrayList<Job> jobs = new ArrayList<Job>();
    Job job;
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
    public boolean addJob(Job job) {
        //Will check if the amount is less than 100 jobs added
        //then Will add the job to the end of the arrayList
        //will return true if added else return false
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
        return "";
    }

    /**
     * Will search for the job then will add the modified job
     * in the ArrayList
     * @param job Will contain all the new job information
     * @return true if successfully edited
     */
    public boolean modifyJob(Job job){
        //Will locate the job with the jobID
        //Then will move the user input for each input
        //to its respected fields
        //Will then return true if successful
        return false;
    }

    /**
     * Will check the expiration for the whole job arrayLIst
     * then Remove all the jobs passed that time
     * @param time will get the expiration signal from the Timer class
     * @return if found and removed
     */
    public boolean checkExp(Timer time){
        //Will grab the time from the timer and compare it to the job expiration
        //Then will grab each jobID that is expired
        //Will then add it to a String array
        //then remove all those jobs in the String array
        //return true if found
        return false;
    }
}