package managers;

import java.io.*;
import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;
import junit.framework.TestCase;
import coordinators.JobSystemCoordinator;
import entities.Applicant;
import entities.Application;
import entities.Job;
import managers.SignUpManager;
import managers.JobManager;
import managers.ApplicationManager;

public class ApplicationManagerTests {

    private Applicant applicant;
    private Application application;
    private Application applicationWithdrawn;
    private Job job;

    @Before
    public void setUp() throws Exception {
        // SETTING UP THE SYSTEM FOR TESTING
        System.out.println("Setting up tests for Application manager.\n");
        JobSystemCoordinator.signUpManager = new SignUpManager();
        JobSystemCoordinator.jobManager = new JobManager();
        JobSystemCoordinator.appManager = new ApplicationManager();

        JobSystemCoordinator.signUpManager.addApplicant(
            "John Snow", "jsnow@nightwatch.com", "571 571 5577",
            "22441, snow leaf ct. Winterfell", "3423 1232 4345 4343",
            "11/20"
        );

        JobSystemCoordinator.jobManager.addJob(
            "J020913", "Asst. Professor", "Faculty", "$90000",
            "Assistant Professor in CS department", "10/31/17",
            "universitycontact@hr.com"
        );

        JobSystemCoordinator.jobManager.addJob(
                "J020100", "Janitor", "Faculty", "$200",
                "Assistant Professor in CS department", "11/20/17",
                "universitycontact@hr.com"
        );

        JobSystemCoordinator.appManager.submitApplication(
            "jsnow@nightwatch.com", "J020913", "cover letter text",
            "resume text"
        );

        JobSystemCoordinator.appManager.submitApplication(
                "jsnow@nightwatch.com", "J020100", "will be withdrawn",
                "resume will be withdrawn"
        );

        JobSystemCoordinator.appManager.submitApplication(
                "jsnow@nightwatch.com", "J020100", "will be withdrawn",
                "resume will be withdrawn"
        );


        applicant = JobSystemCoordinator.signUpManager.getApplicantData("jsnow@nightwatch.com");
        job = JobSystemCoordinator.jobManager.getJobAtIndex("J020913");
        application = JobSystemCoordinator.appManager.getApplication("jsnow@nightwatch.com", "J020913");
        applicationWithdrawn = JobSystemCoordinator.appManager.getApplication("jsnow@nightwatch.com", "J020100");
    }

    @Ignore
    @Test
    public void getApplication01() {
        // TESTS IF THE APPLICATION IS ADDED CORRECTLY
        Application applicationGet = JobSystemCoordinator.appManager.getApplication("jsnow@nightwatch.com",
                "J020913");
        assertEquals(application, applicationGet);

        applicationGet = JobSystemCoordinator.appManager.getApplication("", "");
        assertEquals(null, applicationGet);
    } // END TEST


    @Ignore
    @Test
    public void getApplicationByUser01() {
        // TESTS IF THE APPLICATION IS BEING ADDED CORRECTLY TO THE SYSTEM
        ArrayList<Application> applications = JobSystemCoordinator.appManager.getApplicationsByUser("jsnow@nightwatch.com");
        Application applicationGet = applications.get(0);
        assertEquals(application, applicationGet);

        // TESTS IF THE APPLICATION IS BEING ADDED CORRECTLY TO THE SYSTEM
        applications = JobSystemCoordinator.appManager.getApplicationsByUser("none");
        int length = applications.size();
        assertEquals(0, length);
    } //end test


    @Ignore
    @Test
    public void getPendingApplications01() {
        // TESTS IF THE APPLICATION IS BEING ADDED CORRECTLY TO THE SYSTEM
        ArrayList<Application> applications = JobSystemCoordinator.appManager.getPendingApplications("J020100");
        Application applicationGet = applications.get(0);
        assertEquals(applicationWithdrawn, applicationGet);

        // WITHDRAW APPLICATION AND CHECK
        applicationWithdrawn.withdrawApplication();
        applications = JobSystemCoordinator.appManager.getPendingApplications("J020100");
        assertEquals(0, applications.size());

        // CHECK INVALID JOB ID
        applications = JobSystemCoordinator.appManager.getPendingApplications("");
        assertEquals(0, applications.size());
    } //end test

    @Ignore
    @Test
    public void submitApplication01() {

        int success;

        // SUBMIT NEW APPLICATION THAT IS NOT YET IN THE SYSTEM
        JobSystemCoordinator.signUpManager.addApplicant(
                "Joe Doe", "joe@google.com", "481 251 0000",
                "11, snow leaf ct. london", "123 4567 8901 2345",
                "01/22"
        );

        JobSystemCoordinator.jobManager.addJob(
                "J010000", "Programmer", "Faculty", "$10000",
                "Programming Chiev of Awesomness", "11/11/17",
                "universitycontact@hr.com"
        );

        success = JobSystemCoordinator.appManager.submitApplication(
                "joe@google.com", "J010000", "really want to get the job",
                "i am super awesome"
        );
        assertEquals(1, success);


        // APPLICANT DOES NOT EXIST
        success = JobSystemCoordinator.appManager.submitApplication(
                "jsnow@nightwatch.com11", "J020100", "will be withdrawn",
                "resume will be withdrawn"
        );

        assertEquals(0, success);

        // JOB DOES NOT EXIST
        success = JobSystemCoordinator.appManager.submitApplication(
                "jsnow@nightwatch.com", "J020099", "will be withdrawn",
                "resume will be withdrawn"
        );

        assertEquals(0, success);


        // SUBMIT APPLICATION THAT IS ALREADY IN THE SYSTEM
        success = JobSystemCoordinator.appManager.submitApplication(
                "jsnow@nightwatch.com", "J020100", "will be withdrawn",
                "resume will be withdrawn"
        );

        assertEquals(0, success);
    }

    @Ignore
    @Test
    public void printDashboard01() {
        int success;

        // TEST EXISTING APPLICANT WITH APPLICATIONS
        success = JobSystemCoordinator.appManager.printDashboard("jsnow@nightwatch.com");
        assertEquals(1, success);

        // TEST EXISTING APPLICANT WITH NO APPLICATIONS
        JobSystemCoordinator.signUpManager.addApplicant(
                "Joe Doe", "joe@google.com", "481 251 0000",
                "11, snow leaf ct. london", "123 4567 8901 2345",
                "01/22"
        );
        success = JobSystemCoordinator.appManager.printDashboard("joe@google.com");
        assertEquals(1, success);


        // TEST NON EXISTING APPLICANT
        success = JobSystemCoordinator.appManager.printDashboard("does@exist.not");
        assertEquals(0, success);
    }

    @Ignore
    @Test
    public void printApplication01() {
        int success;

        // TEST EXISTING APPLICANT WITH APPLICATIONS
        success = JobSystemCoordinator.appManager.printApplication("jsnow@nightwatch.com", "J020913");
        assertEquals(1, success);

        // TEST EXISTING APPLICANT WITH NO APPLICATIONS TO PARTICULAR JOB
        JobSystemCoordinator.signUpManager.addApplicant(
                "Joe Doe", "joe@google.com", "481 251 0000",
                "11, snow leaf ct. london", "123 4567 8901 2345",
                "01/22"
        );
        success = JobSystemCoordinator.appManager.printApplication("joe@google.com", "J020913");
        assertEquals(0, success);
    }

    @Ignore
    @Test
    public void viewPendingJobApplications01() {
        int success;

        // TEST WITH EXISTING JOB INT THE SYSTEM
        success = JobSystemCoordinator.appManager.viewPendingJobApplications();
        assertEquals(1, success);

        // TEST WITH NO JOBS IN THE SYSTEM
        JobSystemCoordinator.jobManager.removeJob("J020913");
        JobSystemCoordinator.jobManager.removeJob("J020100");

        success = JobSystemCoordinator.appManager.viewPendingJobApplications();
        assertEquals(0, success);
    }

    @Ignore
    @Test
    public void viewPendingJobApplications02() {
        int success;

        // TEST PENDING APPLICATIONS FOR JOB ID
        success = JobSystemCoordinator.appManager.viewPendingJobApplications("J020913");
        assertEquals(1, success);

        // TEST JOB ID WITH NO APPLICATIONS
        JobSystemCoordinator.jobManager.addJob(
                "J000913", "Asst. Professor", "Faculty", "$90000",
                "Assistant Professor in CS department", "10/31/17",
                "universitycontact@hr.com"
        );

        success = JobSystemCoordinator.appManager.viewPendingJobApplications("J000913");
        assertEquals(0, success);

        // TEST JOB ID THAT DOES NOT EXIST
        success = JobSystemCoordinator.appManager.viewPendingJobApplications("J000000");
        assertEquals(0, success);
    }

    @Test
    public void withdrawApplication01() {
        int success;

        // TEST EXISTING APPLICANT WITH APPLICATIONS
        success = JobSystemCoordinator.appManager.withdrawApplication("jsnow@nightwatch.com", "J020913");
        assertEquals(1, success);

        // GET APPLICATION AND MAKE SURE THE STATUS IS SET TO WITHDRAWN
        Application application = JobSystemCoordinator.appManager.getApplication("jsnow@nightwatch.com", "J020913");
        assertEquals(true, application.isWithdrawn());


        // TEST EXISTING APPLICANT WITH NO APPLICATIONS TO PARTICULAR JOB
        JobSystemCoordinator.signUpManager.addApplicant(
                "Joe Doe", "joe@google.com", "481 251 0000",
                "11, snow leaf ct. london", "123 4567 8901 2345",
                "01/22"
        );
        success = JobSystemCoordinator.appManager.withdrawApplication("joe@google.com", "J020913");
        assertEquals(0, success);

    }

    @After
    public void tearDown() {
        // PROPERLY CLEANING UP THE SYSTEM AFTER EACH TEST
        System.out.println("Cleaning up... \n");
        applicant = null;
        application = null;
        job = null;
        JobSystemCoordinator.appManager = null;
        JobSystemCoordinator.signUpManager = null;
        JobSystemCoordinator.jobManager = null;
    }

} // END CLASS