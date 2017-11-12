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
    int numberofJobCreated, currentNumberOfJobs, jobPostingsFilled, jobsNoLongerAvailable,
        numJobListingsStudents, numJobListingsStaff, numJobListingsFaculty;
    float avgNumApps, avgNumPostFilled, avgNumAppsAvailJobs;

    private ReportManager{
    this.numJobListingsStaff = getStaffListings();
    this.numJobListingsFaculty = getFacultyListings();
    this.numJobListingsStudents = getStudentListings();
    calculateAverages();
    }

    /**
     * Gathers the number of job listings created for students and stores these values in the appropriate fields
     * to be used for calculations later.
     * @return The number of job listings available for students
     */
    private int getStudentListings(){return 0;}
    /**
     * Gathers the number of job listings created for students and stores these values in the appropriate fields
     * to be used for calculations later.
     * @return The number of job listings available for Staff
     */
    private int getStaffListings(){return 0;}
    /**
     * Gathers the number of job listings created for students and stores these values in the appropriate fields
     * to be used for calculations later.
     * @return The number of job listings available for Faculty
     */
    private int getFacultyListings(){return 0;}

    /**
     * Populates the fields relevant to the job report. Creates calculations based on the information gather by querying
     * other classes.
     */
    private void calculateAverages(){
        // gather the list of jobs and formulate traverse to fill data
        // avgNumApps = TOTAL NUMBER OF APPLICANTS FOR ALL JOBS / numOfJobsCreated;
        // avgNumPostFilled = TOTAL NUMBER OF APPLICANTS FOR POSTFILLED / jobPostingsFilled;
        // avgNumAppAvailJobs = TOTAL NUMBER OF APPLICANTS FOR AVAIL JOBS / (currentNumberofJobs - (jobPostingsFilled +
        // jobsNoLongerAvailable)
    }

    /**
     * Return a string representation of the Report object in a readable user friendly format.
     *
     * @return The string representations of this object
     */
    public String toString(){return "";}

}