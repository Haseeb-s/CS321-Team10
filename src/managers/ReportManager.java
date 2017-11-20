package managers;
/**
 *  ReportManager communicates with other classes to generate a readable report
 *  containing information pertaining to job postings.
 *
 *  (Get list of jobs from Job Manager and traverse to fill data OR have Job Manager return this data by traversing the
 *  list of jobs within the JobManger class)
 *
 * @author Haseeb Shuaib
 *
 */
import coordinators.JobSystemCoordinator;
import entities.Job;
import managers.JobManager;
import java.util.ArrayList;

public class ReportManager{
    private int numberofJobCreated = 0, currentNumberOfJobs = 0, jobPostingsFilled = 0, jobsNoLongerAvailable = 0,
        numJobListingsStudents = 0, numJobListingsStaff = 0, numJobListingsFaculty = 0;
    private double avgNumApps = 0, avgNumPostFilled = 0, avgNumAppsNotAvailJobs = 0;


    public ReportManager(){
     calculateAverages();
    }

    /**
     * Populates the fields relevant to the job report. Creates calculations based on the information gather by querying
     * other classes.
     *
     * It would be easiest and most efficent to populate all the data fields using the arrayList containing the jobs
     *
     */
    private void calculateAverages(){

        /*
          set avgNumApps to numberofJobCreated / number of total applicants
          set avgNumPostFilled to total number of applications for post filled jobs / number of applicants for post filled jobs
          set avgNumAppsAvailJobs to total number of applicants for avail jobs / number of available jobs
        */
        ArrayList<Job> newJob = JobSystemCoordinator.jobManager.getJobs();
        int filledApplicants = 0, notAvailApplicants = 0, numberOfApplicants = 0;
        for(Job temp: newJob){

            numberofJobCreated++;
            numberOfApplicants += temp.getNumApplicants();
            if(temp.currentStatus.equals("FILLED")) {
                jobPostingsFilled++;
                jobsNoLongerAvailable++;
                filledApplicants += temp.getNumApplicants();
                notAvailApplicants += temp.getNumApplicants();
            }
            if(temp.currentStatus.equals("EXPIRED")) {
                jobsNoLongerAvailable++;
                notAvailApplicants += temp.getNumApplicants();
            }
            if(temp.currentStatus.equals("AVAILABLE"))
                currentNumberOfJobs++;
            if(temp.jobType.equals("STUDENTS"))
                numJobListingsStudents++;
            if(temp.jobType.equals("STAFF"))
                numJobListingsStaff++;
            if(temp.jobType.equals("FACULTY"))
                numJobListingsFaculty++;


        }

        if (currentNumberOfJobs != 0) {
            avgNumApps = numberOfApplicants / numberofJobCreated;
        }

        if (jobPostingsFilled != 0) {
            avgNumPostFilled = filledApplicants / jobPostingsFilled;
        }

        if (jobsNoLongerAvailable != 0) {
            avgNumAppsNotAvailJobs = notAvailApplicants / jobsNoLongerAvailable;
        }

    }

    /**
     * Return a string representation of the Report object in a readable user friendly format.
     *
     * @return The string representations of this object
     */
    public String toString(){
        // build string displaying data in global variables in a readable format
        return "=================MONTHLY STATISTICS================\n" +
                "Month : " + JobSystemCoordinator.timer.getCurrentDate().getMonth() + "\n" +
                "Query type\t\t\t\t\t\t\t\t\tCount\n" +
                "---------------------------------------------------\n" +
                "Total job created: \t\t\t\t\t\t\t"+ numberofJobCreated +"\n" +
                "Post filled status:\t\t\t\t\t\t\t" + jobPostingsFilled + "\n" +
                "No longer available:\t\t\t\t\t\t" + jobsNoLongerAvailable + "\n" +
                "Avg. applicants(all jobs):\t\t\t\t\t" + avgNumApps + "\n" +
                "Avg. applicants(post filled):\t\t\t\t" + avgNumPostFilled + "\n" +
                "Avg. applicants(no longer available):\t\t" + avgNumAppsNotAvailJobs + "\n" +
                "Job listing (faculty):\t\t\t\t\t\t" +numJobListingsFaculty+ "\n" +
                "Job listing (student):\t\t\t\t\t\t" +numJobListingsStudents+ "\n" +
                "Job listing (staff):\t\t\t\t\t\t" +numJobListingsStaff+ "\n";
    }

}