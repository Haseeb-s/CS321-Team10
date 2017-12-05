
package managers;

import coordinators.JobSystemCoordinator;
import entities.Applicant;
import entities.Job;
import entities.Application;
import managers.ApplicationManager;
import managers.JobManager;
import managers.SignUpManager;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author Paul B
 */
public class JobManagerTest {
    
    private Applicant applicant;
    private Application application;
    private Application applicationWithdrawn;
    private Job job;
    
    public JobManagerTest() {
    }
    
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

    /**
     * Test of addJob method, of class JobManager.
     * Test 1 is a Happy Path that succeeds.
     * Test 2 invalid JobID
     * Test 3 invalid jobType
     * Test 4 invalid salary format
     * Test 5 invalid experationDate
     * Test 6 invalid contactEmail
     */
    @Test
    public void testAddJob() {
        JobManager instance = new JobManager();
        System.out.println("addJob");
        
        //JOB INFORMATION (VALID INFO)
        String jobID = "J030913";
        String jobTitle = "Teaching Assistant";
        String jobType = "Student";
        String salary = "$5000";
        String jobDescription = "To grade stuff.";
        String expirationDate = "08/08/2017";
        String contactEmail = "getajob@hotmail.com";
        //JOB INFORMATION (INVALID (JobID) INFO) IllegalArgumentException is expected.
        String jobID2 = "123ABC";
        String jobTitle2 = "Teaching Assistant";
        String jobType2 = "Faculty";
        String salary2 = "$5000";
        String jobDescription2 = "To grade stuff.";
        String expirationDate2 = "08/08/2017";
        String contactEmail2 = "getajob@hotmail.com";
        //JOB INFORMATION (INVALID (jobType) INFO)  IllegalArgumentException is expected.
        String jobID3 = "J070913";
        String jobTitle3 = "Teaching Assistant";
        String jobType3 = "Guy";
        String salary3 = "$5000";
        String jobDescription3 = "To grade stuff.";
        String expirationDate3 = "08/08/2017";
        String contactEmail3 = "getajob@hotmail.com";
        //JOB INFORMATION (INVALID (salary) INFO)  IllegalArgumentException is expected.
        String jobID4 = "J060913";
        String jobTitle4 = "Teaching Assistant";
        String jobType4 = "Faculty";
        String salary4 = "50a0";
        String jobDescription4 = "To grade stuff.";
        String expirationDate4 = "08/08/2017";
        String contactEmail4 = "getajob@hotmail.com";
        //JOB INFORMATION (INVALID (expirationDate) INFO)  IllegalArgumentException is expected.
        String jobID5 = "J000913";
        String jobTitle5 = "Teaching Assistant";
        String jobType5 = "Faculty";
        String salary5 = "$5000";
        String jobDescription5 = "To grade stuff.";
        String expirationDate5 = "00/00/1992";
        String contactEmail5 = "getajob@hotmail.com";
        //JOB INFORMATION (INVALID (contactEmail) INFO)  IllegalArgumentException is expected.
        String jobID6 = "J010913";
        String jobTitle6 = "Teaching Assistant";
        String jobType6 = "Faculty";
        String salary6 = "$5000";
        String jobDescription6 = "To grade stuff.";
        String expirationDate6 = "08/08/2017";
        String contactEmail6 = "get.ajob@hotmail.";
         //JOB INFORMATION (INVALID DUPLICATE INFO)
        String jobID7 = "J020913";
        String jobTitle7 = "Teaching Assistant";
        String jobType7 = "Faculty";
        String salary7 = "$5000";
        String jobDescription7 = "To grade stuff.";
        String expirationDate7 = "08/08/2017";
        String contactEmail7 = "getajob@hotmail.com";
        //Test 1 Happy Path--------------------------------------
        instance.addJob(jobID, jobTitle, jobType, salary, jobDescription, expirationDate, contactEmail);
        Job job = instance.getJobAtIndex(jobID);
        assertTrue(job.getJobID().equals(jobID));
        //------------------------------------------------------
        try{ //Test 2
            instance.addJob(jobID2, jobTitle2, jobType2, salary2, jobDescription2, expirationDate2, contactEmail2);
        }
        catch(IllegalArgumentException jobIDEx){
            System.out.println("Error, invalid jobID");
        }
        //-------------------------------------------------------
        try{ //Test 3
            instance.addJob(jobID3, jobTitle3, jobType3, salary3, jobDescription3, expirationDate3, contactEmail3);
        }
        catch(IllegalArgumentException jobTypeEx){
            System.out.println("Error, invalid jobType must be: Faculty, Staff, Student");
        }
        //------------------------------------------------------
        try{ //Test 4
            instance.addJob(jobID4, jobTitle4, jobType4, salary4, jobDescription4, expirationDate4, contactEmail4);
        }
        catch(IllegalArgumentException salaryEx){
            System.out.println("Error, invalid salary format");
        }
        //------------------------------------------------------
        try{ //Test 5
            instance.addJob(jobID5, jobTitle5, jobType5, salary5, jobDescription5, expirationDate5, contactEmail5);
        }
        catch(IllegalArgumentException expirationDateEx){
            System.out.println("Error, invalid expirationDate");
        }
        //------------------------------------------------------
        try{ //Test 6
            instance.addJob(jobID6, jobTitle6, jobType6, salary6, jobDescription6, expirationDate6, contactEmail6);
        }
        catch(IllegalArgumentException expirationDateEx){
            System.out.println("Error, invalid contactEmail");
        }
         try{ //Test 7
            instance.addJob(jobID7, jobTitle7, jobType7, salary7, jobDescription7, expirationDate7, contactEmail7);
        }
        catch(IllegalArgumentException duplicateEx){
            System.out.println("Error, Job Entry already exists.");
        }
    }

    /**
     * Test of removeJob method, of class JobManager.
     */
    @Test
    public void testRemoveJob() {
        System.out.println("removeJob");
        String jobID = "J030913";
        String jobTitle = "Teaching Assistant";
        String jobType = "Faculty";
        String salary = "$5000";
        String jobDescription = "To grade stuff.";
        String expirationDate = "08/08/2017";
        String contactEmail = "getajob@hotmail.com";
        JobManager instance = new JobManager();
        instance.addJob(jobID, jobTitle, jobType, salary, jobDescription, expirationDate, contactEmail);
        String expResult = jobID;
        String result = instance.removeJob(jobID);
        assertEquals(expResult, result);
    }

    /**
     * Test of printAvailableJobs method, of class JobManager.
     */
    @Test
    public void testPrintAvailableJobs() {
        System.out.println("printAvailableJobs");
        JobManager instance = new JobManager();
         //JOB INFORMATION (VALID INFO)
        String jobID = "J030913";
        String jobTitle = "Teaching Assistant";
        String jobType = "Faculty";
        String salary = "$5000";
        String jobDescription = "To grade stuff.";
        String expirationDate = "08/08/2017";
        String contactEmail = "getajob@hotmail.com";
   
        String jobID2 = "J098342";
        String jobTitle2 = "IT Desk Helper";
        String jobType2 = "Staff";
        String salary2 = "$2500";
        String jobDescription2 = "Helps individuals with technical issues.";
        String expirationDate2 = "03/05/2017";
        String contactEmail2 = "itguy@hotmail.com";
        instance.addJob(jobID, jobTitle, jobType, salary, jobDescription, expirationDate, contactEmail);
        instance.addJob(jobID2, jobTitle2, jobType2, salary2, jobDescription2, expirationDate2, contactEmail2);
        //TEST PRINT returns if the test passed.
        instance.printAvailableJobs();
    }

    /**
     * Test of modifyJob method, of class JobManager.
     * Input exceptions mirror that of addJob method and are therefore omitted.
     */
    @Test
    public void testModifyJob() {
        System.out.println("modifyJob");
        //SAMPLE JOB TO ADD
        String jobID1 = "J030913";
        String jobTitle1 = "Teaching Assistant";
        String jobType1 = "Faculty";
        String salary1 = "$5000";
        String jobDescription1 = "To grade stuff.";
        String expirationDate1 = "08/08/2017";
        String contactEmail1 = "getajob@hotmail.com";
        
        //INFORMATION TO MODIFY SAMPLE JOB (VALID Inputs)
        String jobID2 = "J123456";
        String jobTitle2 = "Shuttle Driver";
        String jobType2 = "Staff";
        String salary2 = "$3000";
        String jobDescription2 = "I do more stuff";
        String expirationDate2 = "09/09/2017";
        String contactEmail2 = "getajob2@hotmail.com";
        
        //INFORMATION TO MODIFY SAMPLE JOB (INVALID Inputs)
        String jobID3 = "J153456";
        String jobTitle3 = "Shuttle Driver";
        String jobType3 = "Guy"; // Invalid jobType
        String salary3 = "$3000";
        String jobDescription3 = "I do more stuff";
        String expirationDate3 = "09/09/2017";
        String contactEmail3 = "getajob2@hotmail.com";
        JobManager instance = new JobManager();
        instance.addJob(jobID1, jobTitle1, jobType1, salary1, jobDescription1, expirationDate1, contactEmail1);
        boolean expResult = true;
        boolean result = instance.modifyJob(jobID1, jobTitle1, jobType1, salary1, jobDescription1, expirationDate1, contactEmail1);
        //modifyJob() returns a boolean that verifies the job has been modified.
        //EXPECTED RESULT is true == true or in other words, the job was successfully modified.
        assertEquals(expResult, result);
    }

    /**
     * Test of checkExpiration method, of class JobManager.
     */
    @Test
    public void testCheckExpiration() {
        System.out.println("checkExpiration");
        String jobID = "J123456";
        String jobTitle = "Shuttle Driver";
        String jobType = "Staff";
        String salary = "$3000";
        String jobDescription = "I do more stuff";
        String expirationDate = "09/09/2017";
        String contactEmail = "getajob2@hotmail.com";
        
        String jobID2 = "J023456";
        String jobTitle2 = "Shuttle Driver";
        String jobType2 = "Staff";
        String salary2 = "$3000";
        String jobDescription2 = "I do more stuff";
        String expirationDate2 = "09/09/2017";
        String contactEmail2 = "getajob2@hotmail.com";
        
        JobManager instance = new JobManager();
        instance.addJob(jobID, jobTitle, jobType, salary, jobDescription, expirationDate, contactEmail);
        instance.addJob(jobID2, jobTitle2, jobType2, salary2, jobDescription2, expirationDate2, contactEmail2);
        Job job = instance.getJobAtIndex(jobID2);
        job.setStatus("Expired");
        instance.checkExpiration();
    }

    /**
     * Test of closeJobHiring method, of class JobManager.
     * Succeeds if it returns and prints a message with closed jobs.
     */
    @Test
    public void testCloseJobHiring() {
        System.out.println("closeJobHiring");
        JobManager instance = new JobManager();
        JobSystemCoordinator.jobManager.addJob(
                "J010000", "Programmer", "Faculty", "$10000",
                "Programming Chiev of Awesomness", "11/11/17",
                "getajob2@hotmail.com"
        );
        Job expResult = new Job("J010000", "Programmer", "Faculty", "$10000",
                "Programming Chiev of Awesomness", "11/11/17",
                "getajob2@hotmail.com");
        Job result = instance.getJobAtIndex("J010000");
        instance.closeJobHiring("J010000", "getajob2@hotmail.com");
    }

    /**
     * Test of getJobAtIndex method, of class JobManager.
     * Succeeds if it returns a job as the result and that result is equal to the expected result.
     */
    @Test
    public void testGetJobAtIndex() {
        System.out.println("getJobAtIndex");
        JobManager instance = new JobManager();
        JobSystemCoordinator.jobManager.addJob(
                "J010000", "Programmer", "Faculty", "$10000",
                "Programming Chief of Awesomness", "11/11/17",
                "getajob2@hotmail.com"
        );
        Job expResult = new Job("J010000", "Programmer", "Faculty", "$10000",
                "Programming Chief of Awesomness", "10/10/17",
                "getajob2@hotmail.com");
        Job result = JobSystemCoordinator.jobManager.getJobAtIndex("J010000");
        assertEquals(expResult, result);
    }

    /**
     * Test of viewSpecificJob method, of class JobManager.
     * Test Passes if the function returns and correctly prints the formatted job information.
     */
    @Test
    public void testViewSpecificJob() {
        System.out.println("viewSpecificJob");
        String jobID = "J030913";
        String jobTitle = "Teaching Assistant";
        String jobType = "Student";
        String salary = "$5000";
        String jobDescription = "To grade stuff.";
        String expirationDate = "08/08/2017";
        String contactEmail = "getajob@hotmail.com";
        JobManager instance = new JobManager();
        instance.addJob(jobID, jobTitle, jobType, salary, jobDescription, expirationDate, contactEmail);
        instance.viewSpecificJob(jobID);
    }

    /**
     * Test of getJobs method, of class JobManager.
     * Compares the job added to the job retrieved from getJobs() to make sure that getJobs()
     * is accurately retrieving an instance of the Jobs ArrayList.
     */
    @Test
    public void testGetJobs() {
        System.out.println("getJobs");
        JobManager instance = new JobManager();
        String jobID1 = "J030913";
        String jobTitle1 = "Teaching Assistant";
        String jobType1 = "Faculty";
        String salary1 = "$5000";
        String jobDescription1 = "To grade stuff.";
        String expirationDate1 = "08/08/2017";
        String contactEmail1 = "getajob@hotmail.com";
        
        instance.addJob(jobID1, jobTitle1, jobType1, salary1, jobDescription1, expirationDate1, contactEmail1);
        ArrayList<Job> result = instance.getJobs();
        assertEquals(instance.getJobAtIndex(jobID1), result.get(0));
    }

    /**
     * Test of setUpInterview method, of class JobManager.
     * Expired, Filled, Available
     */
    @Test
    public void testSetUpInterview() {
        System.out.println("setUpInterview");
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

        JobSystemCoordinator.appManager.submitApplication(
                "joe@google.com", "J010000", "really want to get the job",
                "i am super awesome"
        );
        ArrayList<Application> applications = JobSystemCoordinator.appManager.getPendingApplications("J030913");
        JobSystemCoordinator.jobManager.setUpInterview("J010000", "joe@google.com");
    }
    
}


