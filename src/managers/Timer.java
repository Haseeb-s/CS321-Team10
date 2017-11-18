package managers;

import java.time.LocalDate;

/**
 * Timer will keep track of current date and provide time signals to other manager classes.
 * @author
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
        return LocalDate.now(); // PLACEHOLDER RETURN
    }

    /**
     * Will advance the date by 1 day increments
     */
    public void dateSignal() {
        // INCREMENT CURRENT DATE BY 1 DAY
    }


    /**
     * The month signal will advance the date to the first of the next month
     */
    public void monthSignal() {
        // INCREMENT CURRENT MONTH BY 1
        // SET THE DATE TO THE FIRST OF THE MONTH
        //
        // REMOVE WITHDRAWN APPLICATION
    }

    /**
     * The year signal advances to the first of the next year.
     * Calls the month signal
     * Removes all closed jobs and their associations.
     */
    public void yearSignal() {
        // INCREMENT CURRENT YEAR BY 1
        // SET THE DATE TO THE FIRST OF THE YEAR
        //
        // CALL THE MONTH SIGNAL
        // REMOVE CLOSED JOBS AND ALL ASSOCIATIONS
    }

} // END CLASS

