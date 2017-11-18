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
public class ReportManager{
    private int numberofJobCreated, currentNumberOfJobs, jobPostingsFilled, jobsNoLongerAvailable,
        numJobListingsStudents, numJobListingsStaff, numJobListingsFaculty;
    private float avgNumApps, avgNumPostFilled, avgNumAppsAvailJobs;


    public ReportManager(){
    /*
     initalize numJobListingsStudents, numJobListingsFaculty, numJobListingsStaff
     set numberofJobCreated, currentNumberOfJobs, jobPostingsFilled, jobsNoLongerAvailable

     */
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


    }

    /**
     * Return a string representation of the Report object in a readable user friendly format.
     *
     * @return The string representations of this object
     */
    public String toString(){
        // build string displaying data in global variables in a readable format
        return "";}

}