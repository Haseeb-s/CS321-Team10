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

    private ReportManager(){
    /*
     initalize numJobListingsStudents, numJobListingsFaculty, numJobListingsStaff
     set numberofJobCreated, currentNumberOfJobs, jobPostingsFilled, jobsNoLongerAvailable

     */
    }

    /**
     * Gathers the number of job listings created for students and stores these values in the appropriate fields
     * to be used for calculations later.
     * @return The number of job listings available for students
     */
    private int getStudentListings(){
        /*
        return JobSystemCoordinator.getStudentListings
         */
        return 0;
    }
    /**
     * Gathers the number of job listings created for students and stores these values in the appropriate fields
     * to be used for calculations later.
     * @return The number of job listings available for Staff
     */
    private int getStaffListings(){
        /*
        return JobSystemCoordinator.getStaffListings
         */
        return 0;}
    /**
     * Gathers the number of job listings created for students and stores these values in the appropriate fields
     * to be used for calculations later.
     * @return The number of job listings available for Faculty
     */
    private int getFacultyListings(){
        /*
        return JobSystemCoordinator.getStaffListings
         */
        return 0;}

    /**
     * Populates the fields relevant to the job report. Creates calculations based on the information gather by querying
     * other classes.
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