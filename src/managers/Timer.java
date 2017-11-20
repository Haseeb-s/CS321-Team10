package managers;

import java.time.LocalDate;
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
        System.out.println("=================MONTH END SIGNAL=================/n" +
                           "Withdrawn applications will be cleared from the system/n" +
                           "at end of each month.");
        
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
        System.out.println("=================YEAR END SIGNAL=================/n" +
                           "Closed jobs will be cleared from the system/n" +
                           "at end of each year.");
    }

} // END CLASS

