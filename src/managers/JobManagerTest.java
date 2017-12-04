
package managers;

import org.junit.*;
import coordinators.JobSystemCoordinator;
import entities.Job;
import entities.Application;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Paul B
 */
public class JobManagerTest {
    
    public JobManagerTest() {
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
        String contactEmail6 = "getajob@hotmail.com";
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
     */
    @Test
    public void testCloseJobHiring() {
        System.out.println("closeJobHiring");
        String jobID = "";
        String email = "";
        JobManager instance = new JobManager();
        instance.closeJobHiring(jobID, email);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getJobAtIndex method, of class JobManager.
     */
    @Test
    public void testGetJobAtIndex() {
        System.out.println("getJobAtIndex");
        String jobID = "";
        JobManager instance = new JobManager();
        Job expResult = null;
        Job result = instance.getJobAtIndex(jobID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
    @Ignore
    @Test
    public void testSetUpInterview() {
        System.out.println("setUpInterview");
        String jobID1 = "J030913";
        String jobTitle1 = "Teaching Assistant";
        String jobType1 = "Faculty";
        String salary1 = "$5000";
        String jobDescription1 = "To grade stuff.";
        String expirationDate1 = "08/08/2017";
        String contactEmail1 = "getajob@hotmail.com";
        //ApplicationManager appList = JobSystemCoordinator.appManager.getPendingApplications(jobID1);
        //Application app = new Application();
        //JobManager instance = new JobManager();
        //instance.addJob(jobID1, jobTitle1, jobType1, salary1, jobDescription1, expirationDate1, contactEmail1);
        //instance.setUpInterview(jobID1, email);
    }
    
}
