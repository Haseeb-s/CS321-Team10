package managers;

import managers.Timer;
import entities.Application;
import entities.Job;
import entities.Applicant;
import coordinators.JobSystemCoordinator;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * The application manager class interacts with the entities job and application
 * and allows the addition and withdrawal of job applications in the system.
 *
 * @author Mathias Wiesbauer
 */
public class ApplicationManager {

    ArrayList<Application> applications = new ArrayList<Application>();

    /**
     * Searches and returns a job application from the system
     * @param email the email of the applicant
     * @param jobID the job ID
     * @return returns a Application instance or NULL
     */
    public Application getApplication(String email, String jobID) {
        // FOR EACH APPLICATION IN APPLICATIONS
        // TRY TO FIND AN APPLICATION CONTAINING THE EMAIL AND JOB ID
        // IF FOUND RETURN THE APPLICATION
        // OTHERWISE RETURN NULL

        Application applicationNotFound = null;
        // CHECK IF APPLICATION ALREADY EXISTS IN THE SYSTEM IF IT EXISTS RETURN IT
        for (Application application : applications) {
            if (application.getApplicant().getEmail().equals(email) && application.getJob().getJobID().equals(jobID)) {
                return application;
            } // END IF
        } // END FOR

        // RETURN NULL
        return applicationNotFound;
    }


    /**
     * Searches and returns a list of job applications from the system
     * @param email the email of the applicant
     * @param email the job ID
     * @return returns an ArrayList of Application instances
     */
    public ArrayList<Application> getApplicationsByUser(String email) {
        // FOR EACH APPLICATION IN APPLICATIONS
        // CHECK IF APPLICATION CONTAININS THE EMAIL
        // IF FOUND ADD APPLICATION TO ARRAY LIST
        // RETURN ARRAY LIST

        ArrayList<Application> appList = new ArrayList<Application>();
        for (Application app : applications) {
            if (app.getApplicant().getEmail().equals(email)) {
                appList.add(app);
            } // END IF
        } // END FOR


        return appList;
    }

    /**
     * Searches and returns a list of pending job applications from the system
     * @return returns an ArrayList of Application instances
     */
    public ArrayList<Application> getPendingApplications() {
        // FOR EACH APPLICATION IN APPLICATIONS
        // CHECK IF APPLICATION IS PENDING
        // IF FOUND ADD APPLICATION TO ARRAY LIST
        // RETURN ARRAY LIST

        ArrayList<Application> appList = new ArrayList<Application>();
        return appList;
    }

    /**
     * Searches and returns a list of pending job applications for a particula job from the system
     * @param jobID the ID in the system
     * @return returns an ArrayList of Application instances
     */
    public ArrayList<Application> getPendingApplications(String jobID) {
        // FOR EACH APPLICATION IN APPLICATIONS
        // CHECK IF APPLICATION IS PENDING AND IF IT BELONGS TO JOBID
        // IF FOUND ADD APPLICATION TO ARRAY LIST
        // RETURN ARRAY LIST

        ArrayList<Application> appList = new ArrayList<Application>();

        // ITERATE OVER THE APPLICATIONS
        for (Application app : applications) {
            if (app.getJob().getJobID().equals(jobID) && !app.isWithdrawn()) {
                appList.add(app);
            } // END IF
        } // end for

        return appList;
    }

    /**
     * Sets three interview slots: +7 days from current date at 9:00am,
     * + 7 days from current day at 10:00am and +7 days from current day at 11:00am
     * @param currentDate the current date in the system (timer)
     */
    public void setupInterviews(LocalDate currentDate) {

        // FOR THE CURRENT APPLICATION
        // CALL THE SCHEDULEINTERVIEWS METHOD
    }

    /**
     * Adds an application to the system if the application does not yet exist
     * @param email the email address of the applicant
     * @param jobID the job ID the application will be associated with
     * @param coverLetter the applicants cover letter
     * @param resume the applicants resume
     */
    public void submitApplication(String email, String jobID, String coverLetter, String resume) {

        String success = String.format("==============JOB APPLICATION SUCCESS==============\n" +
                "Applicant email: %s\n" +
                "Job ID: %s\n", email, jobID);

        String failure = String.format("==============JOB APPLICATION FAILED==============\n" +
                "Applicant email: %s Job ID: %s\n", email, jobID);

        // CHECK IF THE APPLICATION ALREADY EXISTS IN THE SYSTEM
        Application application = getApplication(email, jobID);
        if (application != null ) {     // APPLICATION EXISTS ALREADY
            System.out.println(failure);
            return;
        }

        // CHECK IF THE JOB ID IS IN THE SYSTEM
        Job jobToApplyFor = null;
        ArrayList<Job> jobs = JobSystemCoordinator.jobManager.jobs;
        for (Job job : jobs) {
            if (job.getJobID().equals(jobID)) {
                jobToApplyFor = job;
            } // END IF
        } // END FOR

        // CHECK IF THE APPLICANT IS IN THE SYSTEM
        Applicant applicantApplying = null;
        ArrayList<Applicant> applicants = JobSystemCoordinator.signUpManager.applicants;
        for (Applicant applicant : applicants) {
            if (applicant.getEmail().equals(email)) {
                applicantApplying = applicant;
            } // END IF
        } // END FOR


        // IF JOB AND APPLICANT EXIST CREATE APPLICATION OBJECT
        if (jobToApplyFor != null && applicantApplying != null) {
            Application newApplication = new Application(jobToApplyFor, applicantApplying);
            newApplication.setResume(resume);
            newApplication.setCoverLetter(coverLetter);
            applications.add(newApplication);
            System.out.println(success);

            // OTHERWISE PRINT FAILURE MESSAGE
        } else {
            System.out.println(failure);
        } // END IF ELSE
    }

    /**
     * Prints the dashboard for a particular user showing the jobs and their status
     * @param email the email address of the user
     */
    public void printDashboard(String email) {

        String header = String.format("=========DASHBOARD - %s==========\n" +
                "Job ID\t\t\t Status\n" +
                "--------------------------------",email);
        System.out.println(header);

        String withdrawnIDS = "";

        // ITERATE OVER APPLICANT LIST
        ArrayList<Application> appList = getApplicationsByUser(email);
        for (Application app : appList) {
            if (!app.isWithdrawn()) {
                System.out.println(String.format("%s\t\t\t%s", app.getJob().getJobID(), app.getJob().getStatus()));
            } else {
                withdrawnIDS += app.getJob().getJobID() +"\n";
            } // END FOR
        } // END FOR

        System.out.println("\nWithdrawn application list:");
        System.out.println(withdrawnIDS+"\n");
    }

    /**
     * Will be used to print an application if it exists in the system or
     * otherwise print an error message
     * @param email is the email address of the applicant
     * @param jobID is the jobID of the job opening
     */
    public void printApplication(String email, String jobID) {
        Application foundApplication = getApplication(email, jobID);

        if (foundApplication != null) {


            String success = String.format("==============JOB APPLICATION DETAILS==============\n" +
                            "Applicant email: %s\n" +
                            "Job ID: %s\n" +
                            "Submitted Cover Letter: %s\n" +
                            "Submitted Resume: %s\n", email, jobID,
                    foundApplication.getCoverLetter(), foundApplication.getResume());

            System.out.println(success);

        } else {
            String failure = String.format("==========JOB APPLICATION DETAILS FAILURE==========\n" +
                    "Applicant email: %s\n" +
                    "Job ID: %s\n", email, jobID);

        }

    }

    /**
     * Prints all the jobs in the system and the applications associated with them
     */
    public void viewPendingJobApplications() {

        String header = String.format("==============PENDING JOB APPLICATIONS=============\n" +
                "Job ID\t\t\t Applicant list\n" +
                "----------------------------------------");

        String delimiter = "----------------------------------------";

        // GET THE JOBS FROM THE JOB MANAGER
        ArrayList<Job> jobs = JobSystemCoordinator.jobManager.getJobs();
        // PRINT THE HEADER
        System.out.println(header);
        // ITERATE OVER EACH JOB AND CREATE A NEW ROW
        for (Job job : jobs) {
            System.out.print(job.getJobID() + "\t\t");

            // ITERATE OVER EACH APPLICATION AND MATCH WITH CURRENT JOB
            int applicantCounter = 0;
            String applicantEmails = "";
            for (Application app : applications) {
                // IF APPLICATION MATCHES JOBID AND APPLICATION IS NOT WITHDRAWN ADD EMAIL ADDRESS
                if (app.getJob().getJobID().equals(job.getJobID()) && !app.isWithdrawn()) {
                    applicantEmails += app.getApplicant().getEmail() + ",\n\t\t";
                    applicantCounter += 1;
                } // END IF
            } // END FOR

            // IF THERE WAS AT LEAST ONE VALID APPLICANT PRINT THE MESSAGE
            if (applicantCounter != 0) {
                System.out.print(applicantEmails);
                System.out.println("\r" + delimiter);
            } else {
                System.out.println("\n" + delimiter);
            } // END IF
        } // END FOR
        System.out.println("\n");
    }

    /**
     * Print the pending job applications in the system to the console
     * @param jobID the ID of the job in the system
     */
    public void viewPendingJobApplications(String jobID) {

        int applicantCounter = 0;
        String applicantEmails = "";

        // ITERATE OVER THE APPLICATION LIST
        for (Application app : applications) {
            // IF APPLICATION MATCHES JOBID AND APPLICATION IS NOT WITHDRAWN ADD EMAIL ADDRESS
            if (app.getJob().getJobID().equals(jobID) && !app.isWithdrawn()) {
                applicantEmails += app.getApplicant().getEmail() + ",\n\t\t";
                applicantCounter += 1;
            }
        }

        // IF THERE WAS AT LEAST ONE VALID APPLICANT PRINT THE MESSAGE
        if (applicantCounter != 0) {
            String success = String.format("==========PENDING JOB APPLICATION for a JOB=======\n" +
                    "Job ID: %s\n" +
                    "Applicant list: %s", jobID, applicantEmails);
            System.out.println(success);
            System.out.println("\n");
        }

    } // END VIEW PENDING JOB APPLICATIONS


    /**
     * Withdrawing an application from the system
     * @param email the email address of the applicant
     * @param jobID the jobID
     */
    public void withdrawApplication(String email, String jobID) {

        String success = String.format("==========WITHDRAWING APPLICATION SUCCESS==========\n" +
                "Following job application successfully withdrawn:\n" +
                "Applicant email: %s\n" +
                "Job ID: %s\n",email, jobID);

        String failure = String.format("==========WITHDRAWING APPLICATION FAILURE==========\n" +
                "Job/User does not exist or application is not valid!\n");


        // FIND THE APPLICATION IN THE SYSTEM
        Application foundApplication = getApplication(email, jobID);
        if (foundApplication != null) { // APPLICATION EXISTS
            foundApplication.withdrawApplication();
            System.out.println(success);
        } else {
            System.out.println(failure);
        }
        // CHECK IF AN APPLICATION WITH THE EMAIL AND JOB ID EXISTS IN APPLICATIONS
        // IF IT DOES MARK AS WITHDRAWN
    }
} // END CLASS