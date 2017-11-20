package managers;

import java.time.LocalDate;
import java.util.ArrayList;

import static coordinators.JobSystemCoordinator.appManager;
import static coordinators.JobSystemCoordinator.jobManager;
import entities.Application;
import entities.Job;

/**
 * Timer will keep track of current date and provide time signals to other manager classes.
 * @author Paul Brown
 */
public class Timer {
    LocalDate currentDate;

    /**
     * The default constructor setting the date to 2017-01-01
     */
    public Timer() {
        currentDate = LocalDate.of(2017, 01, 01);
    }

    /**
     * Returns the current date in the system
     */
    public LocalDate getCurrentDate() {
        // return currentDate
        return currentDate;
    }

    /**
     * Will advance the date by 1 day increments
     */
    public void dateSignal() {
        // INCREMENT CURRENT DATE BY 1 DAY
        currentDate.plusDays(1);
    }

    public void expirationSignal(String month, String date, String year){
        ArrayList <Job> joblist = jobManager.getJobs();

        for(Job temp : joblist){
            String jobExp = temp.getExpData().toString();
            String yearTemp = jobExp.substring(2,4);
            String monthTemp = jobExp.substring(5,7);
            String dayTemp = jobExp.substring(8);
            //System.out.println(monthTemp + "/" + dayTemp + "/" + yearTemp + " VS " +month +"/" +date +"/" +year);

            if (Integer.parseInt(year) - (Integer.parseInt(yearTemp) -1) <= 1) // if the difference in year is >=1
                if ((Integer.parseInt(month) - (Integer.parseInt(monthTemp))) <= 0) // if job creation month is >= to the compared
                    if (Integer.parseInt(date) < Integer.parseInt(monthTemp)) // if the date is less than the compared
                        temp.setStatus("Expired");

        }
        System.out.println("=================EXPIRATION SIGNAL=================\n"+
                "Any job listing without application which is past expiration\n" +
                "the given date will be closed and marked as 'no longer available'");
    }
    /**
     * The month signal will advance the date to the first of the next month
     */
    public void monthSignal() {
        // INCREMENT CURRENT MONTH BY 1
        // SET THE DATE TO THE FIRST OF THE MONTH
        int month,day,year;
        currentDate.plusMonths(1);
        month = currentDate.getMonthValue();
        day = 1;
        year = currentDate.getYear();
        currentDate = LocalDate.of(year, month, day);
        // REMOVE WITHDRAWN APPLICATIONS
        for(Application application : appManager.applications){
            if(application.isWithdrawn() == true){
                appManager.applications.remove(application);
            }
        }
        
    }

    /**
     * The year signal advances to the first of the next year.
     * Calls the month signal
     * Removes all closed jobs and their associations.
     */
    public void yearSignal() {
        // INCREMENT CURRENT YEAR BY 1
        int month,day,year;
        month = 1;  
        day = 1;
        year = currentDate.getYear() + 1;
        // CALL THE MONTH SIGNAL
        monthSignal();
        // SET THE DATE TO THE FIRST OF THE YEAR
        currentDate = LocalDate.of(year, month, day);
        currentDate.toString();
        // REMOVE CLOSED JOBS AND ALL ASSOCIATIONS
        for(Job job : jobManager.jobs){
            if(job.getStatus().equals("CLOSED")){
                jobManager.jobs.remove(job);
            }
        }
        System.out.println("=================YEAR END SIGNAL=================\n" +
                           "Closed jobs will be cleared from the system\n" +
                           "at end of each year.");
    }

} // END CLASS

