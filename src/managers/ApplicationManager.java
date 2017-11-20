package managers;

import static coordinators.JobSystemCoordinator.jobManager;
import static coordinators.JobSystemCoordinator.signUpManager;
import static coordinators.JobSystemCoordinator.timer;
import managers.Timer;
import entities.Applicant;
import entities.Application;
import entities.Job;
import entities.Applicant;
import coordinators.JobSystemCoordinator;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * The application manager class interacts with the entities job and application
 * and allows the addition and withdrawal of job applications in the system.
 * @author Paul Brown
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
        
        Job tempJob = new Job();
        Applicant tempApp = new Applicant();
        Application application = new Application();
        for(int i = 0; i < applications.size()-1; i++)
        {
            application = applications.get(i);
            tempApp = application.getApplicant();
            tempJob = application.getJob();
            if(tempApp.getEmail().equals(email) && tempJob.getJobID().equals(jobID)) return application;
        }
        return null;
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
        Applicant tempApp = new Applicant();
        Application application = new Application();
        for(int i = 0; i < applications.size()-1; i++)
        {
            application = applications.get(i);
            tempApp = application.getApplicant();
            if(tempApp.getEmail().equals(email)) appList.add(application);
        }
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
        Application application = new Application();
        for(int i = 0; i < applications.size()-1; i++)
        {
            application = applications.get(i);
            if(application.getStatus().equals("Pending")) appList.add(application);
        }
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
        Job tempJob = new Job();
        Application application = new Application();
        for(int i = 0; i < applications.size()-1; i++)
        {
            application = applications.get(i);
            if(application.getStatus().equals("Pending") && application.getJob().getJobID().equals(jobID)) appList.add(application);
        }
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
        // CHECK IF AN APPLICATION WITH THE SAME EMAIL AND JOB ID EXISTS ALREADY
        // IF NOT CREATE A NEW APPLICATION
        // ADD NEW APPLICATION TO APPLICATIONS
        
        Job tempJob = jobManager.getJob(jobID);
        Applicant tempApp = signUpManager.getApplicantData(email);
        LocalDate currentDate = timer.getCurrentDate();
        Application application = new Application();
        if(applications != null){
            for(int i = 0; i < applications.size()-1; i++){
                application = applications.get(i);
                tempApp = application.getApplicant();
                tempJob = application.getJob();
                if(tempApp.getEmail().equals(email) && tempJob.getJobID().equals(jobID)){
                    System.out.println("==============JOB APPLICATION FAILED==============\n" + 
                                        "Job Application already exists.");
                    return;
                }
            }
        }
          Application newApplication = new Application(tempJob,tempApp);
          applications.add(newApplication);
          System.out.println("==============JOB APPLICATION SUCCESS==============\n" + 
                                "Applicant email: " + email + "\n" + 
                                "Job ID: " + jobID + "\n");
    }

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
        Application application = getApplication(email, jobID);
        if(application != null){
            application.setStatus("Withdrawn");
        }
    }
} // END CLASS
