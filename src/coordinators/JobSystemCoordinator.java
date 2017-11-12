package coordinators;


public class JobSystemCoordinator {
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

        // @1 SIGN UP
        public static String signUp(String[] inst) {
            String name = inst[1];
            String email = inst[2];
            String phone = inst[3];
            String address = inst[4];
            String creditCard = inst[5];
            String expirationDate = inst[6];

            return "@1 SUCCESS SIGN UP";
        }

        // @2 VIEW AVAILABLE JOBS
        public static String viewAvailableJobs() {
            return "@2 100 AVAILABLE JOBS";
        }

        // @3 SUBMIT JOB APPLICATION
        public static String submitJobApplication(String[] inst) {
            String email = inst[1];
            String jobID = inst[2];
            String coverLetter = inst[3];
            String resume = inst[4];
            return "@3 SUBMITTED APPLICATION";
        }

        // @4 REVIEW JOB APPLICATION
        public static String reviewJobApplication(String[] inst) {
            String email = inst[1];
            String jobID = inst[2];

            return "@4 REVIEW APPLICATION";
        }


        // @5 DASHBOARD
        public static String viewDashboard(String[] inst) {
            String email = inst[1];

            return "@5 VIEW DASHBOARD";
        }

        // @6 WITHDRAW AN APPLICATION
        public static String withdrawApplication(String[] inst) {
            String email = inst[1];
            String jobID = inst[2];

            return "@6 WITHDRAWING APPLICATION";
        }


        // @7 POST A JOB
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

        //@8 REMOVE A JOB
        public static String removeJob(String inst[]) {
            String jobID = inst[1];

            return "@8 REMOVE A JOB";
        }

        // @9 MODIFY A JOB
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

        // @10 VIEW PENDING JOB APPLICATIONS
        public static String viewPendingJobApplications() {
            return "@10 VIEW PENDING JOB APPLICATIONS";
        }

        // @11 SETUP INTERVIEWS
        public static String setupInterviews(String[] inst) {
            String jobID = inst[1];
            String email = inst[2];

            return "@11 SETUP INTERVIEWS";
        }

        // @12 MONTHLY REPORT
        public static String monthlyReport(String[] inst) {
            String month = inst[1];      // FORMATTED AS 11/17

            return "@12 MONTHLY REPORT";
        }

        // @13 EXPIRATION SIGNAL
        public static String expirationSignal(String[] inst) {
            String expirationDate = inst[1];  // FORMATTED AS 11/20/2017

            return "@13 EXPIRATION SIGNAL";
        }

        // @14 MONTH END SIGNAL
        public static String monthEndSignal() {
            return "@14 MONTH END SIGNAL";
        }

        // @15 MONTH END SIGNAL
        public static String yearEndSignal() {
            return "@15 YEAR END SIGNAL";
        }


        // @16 CLOSE JOB WITH HIRING
        public static String closeJobWithHiring(String[] inst) {
            String jobID = inst[1];
            String email = inst[2];

            return "@16 CLOSE JOB WITH HIRING";
        }

        // @17 VIEW PENDING JOB APPLICATIONS
        public static String viewPendingJobApplications(String[] inst) {
            String jobID = inst[1];

            return "@17 VIEW PENDING JOB APPLICATIONS";
        }

        // @18 VIEW A SPECIFIC JOB
        public static String viewJob(String[] inst) {
            String jobID = inst[1];

            return "@18 VIEW A SPECIFIC JOB";
        }

} // END CLASS