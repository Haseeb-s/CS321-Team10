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

import java.time.LocalDate;
import java.util.ArrayList;
/**
 *  ReportManager communicates with other classes to generate a readable report
 *  containing information pertaining to job postings.
 *
 */
public class ReportManager{
    private int numberofJobCreated = 0, currentNumberOfJobs = 0, jobPostingsFilled = 0, jobsNoLongerAvailable = 0,
        numJobListingsStudents = 0, numJobListingsStaff = 0, numJobListingsFaculty = 0;
    private double avgNumApps = 0, avgNumPostFilled = 0, avgNumAppsNotAvailJobs = 0;
    private String error = "";

    public ReportManager(){
    }

    /**
     * Populates the fields relevant to the job report. Creates calculations based on the information gather by querying
     * other classes.
     *
     * It would be easiest and most efficent to populate all the data fields using the arrayList containing the jobs
     * @param monthYear is the inputted string date that the report should print
     */
    private void calculateAverages(String monthYear) {

        /*
          set avgNumApps to numberofJobCreated / number of total applicants
          set avgNumPostFilled to total number of applications for post filled jobs / number of applicants for post filled jobs
          set avgNumAppsAvailJobs to total number of applicants for avail jobs / number of available jobs
        */
        ArrayList<Job> newJob = JobSystemCoordinator.jobManager.getJobs();
        int filledApplicants = 0, notAvailApplicants = 0, numberOfApplicants = 0;
        for (Job temp : newJob) {

            if (checkDates(monthYear, temp.getCreationDate())) {

                numberofJobCreated++;
                numberOfApplicants += temp.getNumApplicants();
                if (temp.currentStatus.toUpperCase().equals("FILLED")) {
                    jobPostingsFilled++;
                    jobsNoLongerAvailable++;
                    filledApplicants += temp.getNumApplicants();
                    notAvailApplicants += temp.getNumApplicants();
                }
                if (temp.currentStatus.toUpperCase().equals("EXPIRED")) {
                    jobsNoLongerAvailable++;
                    notAvailApplicants += temp.getNumApplicants();
                }
                if (temp.currentStatus.toUpperCase().equals("AVAILABLE"))
                    currentNumberOfJobs++;
                if (temp.jobType.toUpperCase().equals("STUDENT"))
                    numJobListingsStudents++;
                if (temp.jobType.toUpperCase().equals("STAFF"))
                    numJobListingsStaff++;
                if (temp.jobType.toUpperCase().equals("FACULTY"))
                    numJobListingsFaculty++;


            }

            if (numberofJobCreated != 0) {
                avgNumApps = (double)numberOfApplicants /(double) numberofJobCreated;
            }

            if (jobPostingsFilled != 0) {
                avgNumPostFilled = (double)filledApplicants / jobPostingsFilled;
            }

            if (jobsNoLongerAvailable != 0) {
                avgNumAppsNotAvailJobs = (double) notAvailApplicants / jobsNoLongerAvailable;
            }

        }

        if (numberofJobCreated == 0){
            error = "No jobs were found for the desired month and year.\nThe System date is: "
                    + JobSystemCoordinator.timer.getCurrentDate() + ".\n";
            if (JobSystemCoordinator.timer.getCurrentDate().toString().equals("2017-01-01") )
                error = "No jobs were found for the desired month and year.\nThe System date is "
                        + JobSystemCoordinator.timer.getCurrentDate() + ". (Adjust System date using appropriate signals)\n";
        }
    }

    /**
     * This method is used to make sure the reports being checked is within the proper date/month
     * @param monthYear Holds the string containing the required month and year for the report (XX/XX)
     * @param date the date of which the current job was created
     * @return
     */
    public boolean checkDates (String monthYear, String date){
        if (monthYear.length() == 0)
            return false;
       // System.out.println("The job was created on : " + date);
        String month = monthYear.substring(0, monthYear.indexOf("/"));
        String year = monthYear.substring(monthYear.indexOf("/") + 1, monthYear.length());
        String checkYear = date.toString().substring(2,4);
        String checkMonth = date.toString().substring(5,7);


        if ( !(month.matches("^[0-9]+$")) || !(year.matches("^[0-9]+$"))) {
            return false;
        }
        if (Integer.parseInt(year) > JobSystemCoordinator.timer.getCurrentDate().getYear())
            return false;
      //  System.out.println(month + year + " VS "+ checkMonth +"  " + checkYear);
        if (month.equals(checkMonth) && year.equals(checkYear))
            return true;
        else
            return false;


    }

    /**
     * Return a string representation of the Report object in a readable user friendly format.
     *
     * @return The string representations of this object
     */
    public String toString(String monthyear){
        calculateAverages(monthyear);
        // build string displaying data in global variables in a readable format;
        return String.format("=================MONTHLY STATISTICS================\n" +
                "Month/Year: " + monthyear + "\n" +
                "Query type                                  Count\n" +
                "---------------------------------------------------\n" +
                "Total job created: %28s\n" +
                "Post filled status: %27s\n" +
                "No longer available: %26s\n" +
                "Avg. applicants(all jobs): %22.3f\n" +
                "Avg. applicants(post filled): %19.3f\n" +
                "Avg. applicants(no longer available): %11.3f\n" +
                "Job listing (faculty): %24s\n" +
                "Job listing (student): %24s\n" +
                "Job listing (staff): %26s\n%s",numberofJobCreated,jobPostingsFilled,
                jobsNoLongerAvailable,avgNumApps,avgNumPostFilled,avgNumAppsNotAvailJobs, numJobListingsFaculty,numJobListingsStudents,
                numJobListingsStaff, error);
    }

}