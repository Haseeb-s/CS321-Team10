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
        Application application = new Application();
        return application;
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


        // CHECK IF APPLICATION ALREADY EXISTS IN THE SYSTEM IF IT EXISTS PRINT ERROR AND RETURN
        for (Application application : applications) {
            if (application.getApplicant().getEmail().equals(email) && application.getJob().getJobID().equals(jobID)) {
                System.out.println(failure);
                return;
            } // END IF
        } // END FOR



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
     * Withdrawing an application from the system
     * @param email the email address of the applicant
     * @param jobID the jobID
     */
    public void withdrawApplication(String email, String jobID) {
        // CHECK IF AN APPLICATION WITH THE EMAIL AND JOB ID EXISTS IN APPLICATIONS
        // IF IT DOES MARK AS WITHDRAWN
    }
} // END CLASS