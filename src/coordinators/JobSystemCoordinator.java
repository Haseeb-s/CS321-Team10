package coordinators;

import managers.ApplicationManager;
import managers.JobManager;
import managers.ReportManager;
import managers.SignUpManager;
import managers.Timer;
import entities.Application;
import entities.Applicant;

/**
 * This is the coordinator handling all interactions with the client.
 *
 * @author Mathias Wiesbauer
 **/

public class JobSystemCoordinator {
    public static ApplicationManager appManager = new ApplicationManager();
    public static JobManager jobManager = new JobManager();
    public static ReportManager reportManager = new ReportManager();
    public static SignUpManager signUpManager = new SignUpManager();
    public static Timer timer = new Timer();

    /**
     * Calls the correct methods based on the instruction ID.
     * Also passes the parameters to the method.
     *
     * @param instructionID the ID of the instruction to be called
     * @param inst the array of parameters passed
     * @return a String will be returned indicating the instructions success or failure
     **/
    public static void callInstruction(int instructionID, String[] inst) {

        switch(instructionID) {
            case 1:     // SIGNING UP
                signUp(inst);
                break;
            case 2:     // VIEW AVAILABLE JOBS
                viewAvailableJobs();
                break;
            case 3:     // SUBMIT JOB APPLICATION
                submitJobApplication(inst);
                // DO...
                break;
            case 4:     // REVIEW JOB APPLICATION
                reviewJobApplication(inst);
                break;
            case 5:     // DASHBOARD
                viewDashboard(inst);
                break;
            case 6:     // WITHDRAW AN APPLICATION
                withdrawApplication(inst);
                break;
            case 7:     // POST A JOB
                postJob(inst);
                break;
            case 8:     // REMOVE A JOB
                removeJob(inst);
                break;
            case 9:     // MODIFY A JOB
                modifyJob(inst);
                break;
            case 10:     // VIEW PENDING JOB APPLICATIONS
                viewPendingJobApplications();
                break;
            case 11:     // SETUP INTERVIEWS
                setupInterviews(inst);
                break;
            case 12:     // MONTHLY REPORT
                monthlyReport(inst);
                break;
            case 13:     // EXPIRATION SIGNAL
                expirationSignal(inst);
                break;
            case 14:     // MONTH END SIGNAL
                monthEndSignal();
                break;
            case 15:     // YEAR END SIGNAL
                yearEndSignal();
                break;
            case 16:     // CLOSE A JOB WITH HIRING
                closeJobWithHiring(inst);
                break;
            case 17:     // VIEW PENDING JOB APPLICATIONS
                viewPendingJobApplications(inst);
                break;
            case 18:     // VIEW A SPECIFIC JOB
                viewJob(inst);
                break;
            } // END SWITCH
        } // END callInstruction


        /**
        * Coordinates the signup process in the system.
        * @param inst The string array containing the 6 elements required for signup.
        * @return success or failure message to be printed.
        */
        public static void signUp(String[] inst) {
            try {
                String name = inst[1];
                String email = inst[2];
                String phone = inst[3];
                String address = inst[4];
                String creditCard = inst[5];
                String expirationDate = inst[6];

                // - CREATE THE APPLICANT
                signUpManager.addApplicant(name, email, phone, address, creditCard, expirationDate);
            } catch (Exception e) {
                System.out.println("WRONG NUMBER OF INPUT PARAMETERS PROVIDED FOR @1 SIGN UP.");
            }
        }

        /**
        * Returns all available jobs stored in the system.
        * @return success or failure message to be printed.
        */
        public static void viewAvailableJobs() {
            // FROM THE HOB MANAGER SHOW GET THE JOB LIST
            // FILTER BY AVAILABLE JOBS
            // DISPLAY
            jobManager.printAvailableJobs();
        }

        /**
        * Submit a job application to the system
        * @param inst string array contains the 4 elements needed to create a new job.
        * @return success or failure message to be printed.
        */
        public static void submitJobApplication(String[] inst) {
            try {
                String email = inst[1];
                String jobID = inst[2];
                String coverLetter = inst[3];
                String resume = inst[4];

                appManager.submitApplication(email, jobID, coverLetter, resume);
            } catch (Exception e) {
                System.out.println("WRONG NUMBER OF INPUT PARAMETERS PROVIDED FOR @3 SUBMIT JOB APPLICATION.");
            }
        }

        /**
        * Review a particular job application.
        * @param inst string array contains the 2 elements needed to select an application.
        * @return success or failure message to be printed.
        */
        public static void reviewJobApplication(String[] inst) {
            try {
                String email = inst[1];
                String jobID = inst[2];

                appManager.printApplication(email, jobID);
                //return "@4 REVIEW APPLICATION";
            } catch (Exception e) {
                System.out.println("WRONG NUMBER OF INPUT PARAMETERS PROVIDED FOR @4 REVIEW JOB APPLICATION.");
            }
        }


        /**
        * Displays the dashboard information for a particular user.
        * @param inst string array containing the paramter needed to select the relevant information.
        * @return string containing the data to be displayed.
        */
        public static void viewDashboard(String[] inst) {
            try {
                String email = inst[1];
                // SHOW THE DASHBOARD FOR THE USER
                // LIST ALL JOBS THE USER HAS APPLIED TO
                // GET THE APPLICATION MANAGER INSTANCE
                // FIND ALL APPLICATIONS FOR A PARTICULAR USER
                // PRINT THE APPLICATIONS

                appManager.printDashboard(email);
            } catch (Exception e) {
                System.out.println("WRONG NUMBER OF INPUT PARAMETERS PROVIDED FOR @5 VIEW DASHBOARD.");
            }
            //return "@5 VIEW DASHBOARD";
        }

        /**
        * Allows an applicant to withdraw an application.
        * @param inst string array containing the 2 parameters needed to select an application.
        * @return success or failure message to be printed.
        */
        public static void withdrawApplication(String[] inst) {
            try {
                String email = inst[1];
                String jobID = inst[2];

                appManager.withdrawApplication(email, jobID);
            } catch (Exception e) {
                System.out.println("WRONG NUMBER OF INPUT PARAMETERS PROVIDED FOR @6 WITHDRAW APPLICATION.");
            }
            //return "@6 WITHDRAWING APPLICATION";
        }

        /**
        * Add a new Job opening to the system.
        * @param inst string array containing the 7 parameters needed to create a new job posting.
        * @return success or failure message to be printed.
        */
        public static void postJob(String inst[]) {
            try {
                String jobID = inst[1];
                String jobTitle = inst[2];
                String jobType = inst[3];
                String salary = inst[4];
                String jobDescription = inst[5];
                String expirationDate = inst[6];
                String contactEmail = inst[7];

                // GET JOB MANAGER INSTANCE
                // - IF JOB IS NOT YET IN THE SYSTEM
                //  - ADD JOB
                // - ELSE PRINT ERROR
                jobManager.addJob(jobID, jobTitle, jobType, salary,
                        jobDescription, expirationDate, contactEmail);
            } catch (Exception e) {
                System.out.println("WRONG NUMBER OF INPUT PARAMETERS PROVIDED FOR @7 POST JOB.");
            }

        }

        /**
        * Removing a job from the system.
        * @param inst contains the parameter needed to select a job in the system.
        * @return success or failure message to be printed.
        */
        public static void removeJob(String inst[]) {
            try {
                String jobID = inst[1];

                // GET JOB MANAGER INSTANCE
                // - IF JOB IS IN THE SYSTEM
                //  - REMOVE JOB
                // - ELSE PRINT ERROR
                jobManager.removeJob(jobID);
            } catch (Exception e) {
                System.out.println("WRONG NUMBER OF INPUT PARAMETERS PROVIDED FOR @8 REMOVE JOB.");
            }
        }

        /**
        * Allows the modification of an existin job application.
        * @param inst string array containing the parameters needed to modify a job application.
        * @return success or failure message to be printed.
        */
        public static void modifyJob(String inst[]) {
            try {

                String jobID = inst[1];
                String jobTitle = inst[2];
                String jobType = inst[3];
                String salary = inst[4];
                String jobDescription = inst[5];
                String expirationDate = inst[6];
                String contactEmail = inst[7];

                // GET JOB MANAGER INSTANCE
                // - IF JOB IS IN SYSTEM
                //  - MODIFY
                // - ELSE PRINT ERROR
                jobManager.modifyJob(jobID, jobTitle, jobType, salary,
                        jobDescription, expirationDate, contactEmail);
            } catch (Exception e) {
                System.out.println("WRONG NUMBER OF INPUT PARAMETERS PROVIDED FOR @9 MODIFY JOB.");
            }
        }

        /**
        * Prints a list of all pending job applications.
        * @return all pending job applications.
        */
        public static void viewPendingJobApplications()
        {

            // GET APPLICATION MANAGER INSTANCE
            // GET ALL PENDING JOB APPLICATIONS
            // PRINT
            appManager.viewPendingJobApplications();
        }

        /**
        * Sets up interviews for a candidate for a particular job application
        * @param inst string array contains the parameters needed to setup the interviews.
        * @return success or failure message to be printed.
        */
        public static void setupInterviews(String[] inst) {
            try {
                String jobID = inst[1];
                String email = inst[2];

                // GET APPLICATION MANAGER INSTANCE
                // - IF THE APPLICATION EXISTS IN THE SYSTEM
                //  - CALL THE SETUP INTERVIEWS METHOD
                // - ELSE RETURN ERROR

                jobManager.setUpInterview(jobID, email);
            } catch (Exception e) {
                System.out.println("WRONG NUMBER OF INPUT PARAMETERS PROVIDED FOR @11 SETUP INTERVIEWS.");
            }
        }

        /**
        * Generate a monthly report.
        * @param inst string array containing the month formatted as 11/17
        * @return the monthly report to be printed.
        */
        public static void monthlyReport(String[] inst) {
            try {
                String month = inst[1];      // FORMATTED AS 11/17
                System.out.println(reportManager.toString(month));
            } catch (Exception e) {
                System.out.println("WRONG NUMBER OF INPUT PARAMETERS PROVIDED FOR @12 MONTHLY REPORT.");
            }
            // GET REPORT MANAGER INSTANCE
            // - GET TOTAL JOBS CREATED
            // - GET POST FILLED JOBS
            // - GET NO LONGER AVAILABLE JOBS
            // - GET AVG APPLICANTS
            // ....

        }

        /**
        * Sends the expiration signal to the system to expire jobs older than the passed in date.
        * @param inst string array containg the expiration date formatted as 11/20/2017
        * @return success or failure message to be printed.
        */
        public static void expirationSignal(String[] inst) {
            try {

                String expDate = inst[1];  // FORMATTED AS 11/20/2017
                String month, date, year;
                month = expDate.toString().substring(0, 2);
                date = expDate.toString().substring(3, 5);
                year = expDate.toString().substring(8);
                // GET JOB MANAGER INSTANCE AND APPLICATION MANAGER INSTANCE
                // ITERATE OVER JOB LIST
                // - IF A JOB IS OLDER THAN THE DATE
                //  - CHECK IF JOB HAS AN APPLICATION
                //    - IF JOB HAS NO APPLICATION CLOSE AND MARK AS NO LONGER AVAIL.
                timer.expirationSignal(month, date, year);
            } catch (Exception e) {
                System.out.println("WRONG NUMBER/FORMAT OF INPUT PARAMETERS PROVIDED FOR @13 EXPIRATIN SIGNAL.");
            }
        }

        /**
        * Triggers reporting activity at the end of every month.
        */
        public static void monthEndSignal()
        {
            timer.monthSignal();
            System.out.println("=================MONTH END SIGNAL=================\n" +
                    "Withdrawn applications will be cleared from the system\n" +
                    "at end of each month.");
        }

            // GET TIMER INSTANCE
            // CALL THE MONTH SIGNAL


        /**
        * Triggers reporting activity at the end of every year.
        * @return success or failure message to be printed.
        */
        public static void yearEndSignal() {

            // GET TIMER INSTANCE
            // CALL YEAR END SIGNAL

            timer.yearSignal();
        }


        /**
        * When hiring an applicant for a job posting close the job.
        * @param inst string array containing the jobID  and email
        * @return success or failure message to be printed.
        */
        public static void closeJobWithHiring(String[] inst) {
            try {
                String jobID = inst[1];
                String email = inst[2];

                // GET JOB MANAGER AND APPLICATION MANAGER INSTANCE
                // GET REPORT MANAGER INSTANCE

                // CLOSE JOB
                // UPDATE REPORT MANAGER STATS
                // REMOVE APPLICATIONS ASSOCIATED WITH JOB
                jobManager.closeJobHiring(jobID, email);
            } catch (Exception e) {
                    System.out.println("WRONG NUMBER OF INPUT PARAMETERS PROVIDED FOR @16 CLOSE JOB WITH HIRING.");
            }
        }

        /**
        * Displays all pending job applications
        * @param inst string array containing the jobID
        * @return all pending job applications or error message.
        */
        public static void viewPendingJobApplications(String[] inst) {
            try {
                String jobID = inst[1];

                // GET APPLICATION MANAGER
                // CALL PENDING JOB APPLICATION METHOD
                // PRINT LIST
                appManager.viewPendingJobApplications(jobID);
            } catch (Exception e) {
                System.out.println("WRONG NUMBER OF INPUT PARAMETERS PROVIDED FOR @17 VIEW PENDING JOB APPLICATIONS.");
            }
        }

        /**
        * View a particulatr job in the system
        * @param inst string array containing the jobID
        * @return a job listing or an error message.
        */
        public static void viewJob(String[] inst) {
            try {
                String jobID = inst[1];

                // GET THE JOB MANAGER INSTANCE
                // FIND A JOB WITH THE JOB ID IN THE JOB LIST
                // - IF JOB WAS FOUND PRINT
                // - ELSE PRINT ERROR
                jobManager.viewSpecificJob(jobID);
            } catch (Exception e) {
                System.out.println("WRONG NUMBER OF INPUT PARAMETERS PROVIDED FOR @18 VIEW JOB.");
            }
        }

} // END CLASS
