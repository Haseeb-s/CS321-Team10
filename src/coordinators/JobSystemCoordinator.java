package coordinators;

/**
 * This is the coordinator handling all interactions with the client.
 *
 * @author Mathias Wiesbauer
 **/

public class JobSystemCoordinator {
    /**
     * Calls the correct methods based on the instruction ID.
     * Also passes the parameters to the method.
     *
     * @param instructionID the ID of the instruction to be called
     * @param inst the array of parameters passed
     * @return a String will be returned indicating the instructions success or failure
     **/
    public static String callInstruction(int instructionID, String[] inst) {


        String message = "";
        switch(instructionID) {
            case 1:     // SIGNING UP
                message = signUp(inst);
                break;
            case 2:     // VIEW AVAILABLE JOBS
                message = viewAvailableJobs();
                break;
            case 3:     // SUBMIT JOB APPLICATION
                message = submitJobApplication(inst);
                // DO...
                break;
            case 4:     // REVIEW JOB APPLICATION
                message = reviewJobApplication(inst);
                break;
            case 5:     // DASHBOARD
                message = viewDashboard(inst);
                break;
            case 6:     // WITHDRAW AN APPLICATION
                message = withdrawApplication(inst);
                break;
            case 7:     // POST A JOB
                message = postJob(inst);
                break;
            case 8:     // REMOVE A JOB
                message = removeJob(inst);
                break;
            case 9:     // MODIFY A JOB
                message = modifyJob(inst);
                break;
            case 10:     // VIEW PENDING JOB APPLICATIONS
                message = viewPendingJobApplications();
                break;
            case 11:     // SETUP INTERVIEWS
                message = setupInterviews(inst);
                break;
            case 12:     // MONTHLY REPORT
                message = monthlyReport(inst);
                break;
            case 13:     // EXPIRATION SIGNAL
                message = expirationSignal(inst);
                break;
            case 14:     // MONTH END SIGNAL
                message = monthEndSignal();
                break;
            case 15:     // YEAR END SIGNAL
                message = yearEndSignal();
                break;
            case 16:     // CLOSE A JOB WITH HIRING
                message = closeJobWithHiring(inst);
                break;
            case 17:     // VIEW PENDING JOB APPLICATIONS
                message = viewPendingJobApplications(inst);
                break;
            case 18:     // VIEW A SPECIFIC JOB
                message = viewJob(inst);
                break;
            } // END SWITCH

        return message;
        } // END callInstruction


        /**
        * Coordinates the signup process in the system.
        * @param inst The string array containing the 6 elements required for signup.
        * @return success or failure message to be printed.
        */
        public static String signUp(String[] inst) {

            String name = inst[1];
            String email = inst[2];
            String phone = inst[3];
            String address = inst[4];
            String creditCard = inst[5];
            String expirationDate = inst[6];

            return "@1 SUCCESS SIGN UP";
        }

        /**
        * Returns all available jobs stored in the system.
        * @return success or failure message to be printed.
        */
        public static String viewAvailableJobs() {
            return "@2 100 AVAILABLE JOBS";
        }

        /**
        * Submit a job application to the system
        * @param inst string array contains the 4 elements needed to create a new job.
        * @return success or failure message to be printed.
        */
        public static String submitJobApplication(String[] inst) {
            String email = inst[1];
            String jobID = inst[2];
            String coverLetter = inst[3];
            String resume = inst[4];
            return "@3 SUBMITTED APPLICATION";
        }

        /**
        * Review a particular job application.
        * @param inst string array contains the 2 elements needed to select an application.
        * @return success or failure message to be printed.
        */
        public static String reviewJobApplication(String[] inst) {
            String email = inst[1];
            String jobID = inst[2];

            return "@4 REVIEW APPLICATION";
        }


        /**
        * Displays the dashboard information for a particular user.
        * @param inst string array containing the paramter needed to select the relevant information.
        * @return string containing the data to be displayed.
        */
        public static String viewDashboard(String[] inst) {
            String email = inst[1];

            return "@5 VIEW DASHBOARD";
        }

        /**
        * Allows an applicant to withdraw an application.
        * @param inst string array containign the 2 paramters needed to select an application.
        * @return success or failure message to be printed.
        */
        public static String withdrawApplication(String[] inst) {
            String email = inst[1];
            String jobID = inst[2];

            return "@6 WITHDRAWING APPLICATION";
        }

        /**
        * Add a new Job opening to the system.
        * @param inst string array containing the 7 parameters needed to create a new job posting.
        * @return success or failure message to be printed.
        */
        public static String postJob(String inst[]) {
            String jobID = inst[1];
            String jobTitle = inst[2];
            String jobType = inst[3];
            String salary = inst[4];
            String jobDescription = inst[5];
            String expirationDate = inst[6];
            String contactEmail = inst[7];

            return "@7 POSTING JOB";
        }

        /**
        * Removing a job from the system.
        * @param inst contains the parameter needed to select a job in the system.
        * @return success or failure message to be printed.
        */
        public static String removeJob(String inst[]) {
            String jobID = inst[1];

            return "@8 REMOVE A JOB";
        }

        /**
        * Allows the modification of an existin job application.
        * @param inst string array containing the parameters needed to modify a job application.
        * @return success or failure message to be printed.
        */
        public static String modifyJob(String inst[]) {
            String jobID = inst[1];
            String jobTitle = inst[2];
            String jobType = inst[3];
            String salary = inst[4];
            String jobDescription = inst[5];
            String expirationDate = inst[6];
            String contactEmail = inst[7];

            return "@9 MODIFYING JOB";
        }

        /**
        * Prints a list of all pending job applications.
        * @return all pending job applications.
        */
        public static String viewPendingJobApplications() {
            return "@10 VIEW PENDING JOB APPLICATIONS";
        }

        /**
        * Sets up interviews for a candidate for a particular job application
        * @param inst string array contains the parameters needed to setup the interviews.
        * @return success or failure message to be printed.
        */
        public static String setupInterviews(String[] inst) {
            String jobID = inst[1];
            String email = inst[2];

            return "@11 SETUP INTERVIEWS";
        }

        /**
        * Generate a monthly report.
        * @param inst string array containing the month formatted as 11/17
        * @return the monthly report to be printed.
        */
        public static String monthlyReport(String[] inst) {
            String month = inst[1];      // FORMATTED AS 11/17

            return "@12 MONTHLY REPORT";
        }

        /**
        * Sends the expiration signal to the system to expire reports older than the passed in date.
        * @param inst string array containg the expiration date formatted as 11/20/2017
        * @return success or failure message to be printed.
        */
        public static String expirationSignal(String[] inst) {
            String expirationDate = inst[1];  // FORMATTED AS 11/20/2017

            return "@13 EXPIRATION SIGNAL";
        }

        /**
        * Triggers reporting activity at the end of every month.
        * @return success or failure message to be printed.
        */
        public static String monthEndSignal() {
            return "@14 MONTH END SIGNAL";
        }

        /**
        * Triggers reporting activity at the end of every year.
        * @return success or failure message to be printed.
        */
        public static String yearEndSignal() {
            return "@15 YEAR END SIGNAL";
        }


        /**
        * When hiring an applicant for a job posting close the job.
        * @param inst string array containing the jobID  and email
        * @return success or failure message to be printed.
        */
        public static String closeJobWithHiring(String[] inst) {
            String jobID = inst[1];
            String email = inst[2];

            return "@16 CLOSE JOB WITH HIRING";
        }

        /**
        * Displays all pending job applications
        * @param inst string array containing the jobID
        * @return all pending job applications or error message.
        */
        public static String viewPendingJobApplications(String[] inst) {
            String jobID = inst[1];

            return "@17 VIEW PENDING JOB APPLICATIONS";
        }

        /**
        * View a particulatr job in the system
        * @param inst string array containing the jobID
        * @return a job listing or an error message.
        */
        public static String viewJob(String[] inst) {
            String jobID = inst[1];

            return "@18 VIEW A SPECIFIC JOB";
        }

} // END CLASS