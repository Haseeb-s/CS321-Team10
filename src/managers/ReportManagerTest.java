/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managers;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import coordinators.JobSystemCoordinator;
import entities.Job;
import java.util.ArrayList;

/**
 * @author Haseeb Shuaib
 */

public class ReportManagerTest {

    private int numberofJobCreated = 0, currentNumberOfJobs = 0, jobPostingsFilled = 0, jobsNoLongerAvailable = 0,
            numJobListingsStudents = 0, numJobListingsStaff = 0, numJobListingsFaculty = 0;
    private double avgNumApps = 0, avgNumPostFilled = 0, avgNumAppsNotAvailJobs = 0;
    private String error = "";
    public ReportManagerTest() {

    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of checkDates method, of class ReportManager.
     *
     * Includes letters which should not be a valid input
     */
    @Test
    public void testCheckDates00() {
        System.out.println("checkDates");
        String monthYear = "te3T/9012";
        String date = "thisshould/fail";
        ReportManager instance = new ReportManager();
        boolean expResult = false;
        boolean result = instance.checkDates(monthYear, date);
        assertEquals(expResult, result);
    }

    /**
     * Test of checkDates method, of class ReportManager.
     *
     * This format should work perfectly
     */
    @Test
    public void testCheckDates01() {
        System.out.println("checkDates");
        String monthYear = "11/17";
        String date = "2017-11-30";
        ReportManager instance = new ReportManager();
        boolean expResult = true;
        boolean result = instance.checkDates(monthYear, date);
        assertEquals(expResult, result);
    }

    /**
     * Test of checkDates method, of class ReportManager.
     *
     * The date that the user is requesting to create a report for is in the future,
     * thus not possible.
     */
    @Test
    public void testCheckDates02() {
        System.out.println("checkDates");
        String monthYear = "11/19";
        String date = "2017-11-30";
        ReportManager instance = new ReportManager();
        boolean expResult = false;
        boolean result = instance.checkDates(monthYear, date);
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class ReportManager.
     */
    @Test
    public void testToString() {

        JobSystemCoordinator.jobManager.addJob("J010913", "Asst. Professor", "Faculty",
                "$90000","Assistant Professor in ECE department", "10/31/17",
                "universitycontact@hr.com");
        JobSystemCoordinator.jobManager.addJob("J020913", "Asst. Professor", "Faculty",
                "$92000","Assistant Professor in ECE department", "10/31/17",
                "universitycontact@hr.com");
        JobSystemCoordinator.jobManager.addJob("J030913", "Shuttle Driver", "Staff",
                "$60000","Driving university shuttle in several routes", "10/31/17",
                "universitycontact@hr.com");
        JobSystemCoordinator.jobManager.addJob("J040913", "Gym Front Desk", "Student",
                "$92000","Assistant Professor in ECE department", "10/31/17",
                "universitycontact@hr.com");
        JobSystemCoordinator.jobManager.addJob("J050913", "Gym Front Desk", "Faculty",
                "$92000","Assistant Professor in ECE department", "10/31/17",
                "universitycontact@hr.com");
        JobSystemCoordinator.jobManager.addJob("J060913", "Gym Front Desk", "Staff",
                "$92000","Assistant Professor in ECE department", "10/31/17",
                "universitycontact@hr.com");
        JobSystemCoordinator.jobManager.addJob("J070913", "Gym Front Desk", "Student",
                "$92000","Assistant Professor in ECE department", "10/31/17",
                "universitycontact@hr.com");
        JobSystemCoordinator.jobManager.addJob("J080913", "Gym Front Desk", "Staff",
                "$92000","Assistant Professor in ECE department", "10/31/17",
                "universitycontact@hr.com");
        JobSystemCoordinator.jobManager.addJob("J090913", "Gym Front Desk", "Faculty",
                "$92000","Assistant Professor in ECE department", "10/31/17",
                "universitycontact@hr.com");
        ArrayList<Job> joblist = JobSystemCoordinator.jobManager.getJobs();
        joblist.get(8).setStatus("EXPIRED");
        joblist.get(3).newApplicant();
        joblist.get(3).newApplicant();
        joblist.get(3).newApplicant();
        joblist.get(3).newApplicant();
        joblist.get(3).newApplicant();
        joblist.get(3).newApplicant();
        joblist.get(3).newApplicant();
        joblist.get(3).newApplicant();
        joblist.get(3).newApplicant();
        joblist.get(3).newApplicant();
        joblist.get(3).newApplicant(); // job 7 has 11 applicants
        joblist.get(8).newApplicant();
        joblist.get(8).newApplicant();
        joblist.get(7).newApplicant();
        JobSystemCoordinator.jobManager.closeJobHiring("J080913", "DOESNTMATTER@WHATEVER.COM");
        JobSystemCoordinator.jobManager.closeJobHiring("J070913", "DOESNTMATTER@WHATEVER.COM");
        JobSystemCoordinator.jobManager.closeJobHiring("J060913", "DOESNTMATTER@WHATEVER.COM");



        System.out.println("toString");
        String monthyear = "01/17";
        ReportManager instance = new ReportManager();

        double numberOfApplicants = 14;
        numberofJobCreated = 9;
        currentNumberOfJobs = 5;
        jobPostingsFilled = 3;
        jobsNoLongerAvailable = 4;
        numJobListingsStudents = 2;
        numJobListingsStaff = 3;
        numJobListingsFaculty = 4;
        avgNumApps = numberOfApplicants / numberofJobCreated;
        avgNumPostFilled = 1 / (double)jobPostingsFilled;
        avgNumAppsNotAvailJobs = 3/(double)jobsNoLongerAvailable;

        String expResult = String.format("=================MONTHLY STATISTICS================\n" +
                        "Month/Year: " + monthyear + "\n" +
                        "Query type                                  Count\n" +
                        "---------------------------------------------------\n" +
                        "Total job created: %28s\n" +
                        "Post filled status: %27s\n" +
                        "No longer available: %26s\n" +
                        "Avg. applicants(all jobs): %22.3f\n" +
                        "Avg. applicants(post filled): %19.3f\n" +
                        "Avg. applicants(no longer available): %11.3f\n" +
                        "Job listing (faculty): %24s\n" +
                        "Job listing (student): %24s\n" +
                        "Job listing (staff): %26s\n%s",numberofJobCreated,jobPostingsFilled,
                jobsNoLongerAvailable,avgNumApps,avgNumPostFilled,avgNumAppsNotAvailJobs, numJobListingsFaculty,numJobListingsStudents,
                numJobListingsStaff, error);
        String result = instance.toString(monthyear);
        //System.out.println("\n\n\n" + expResult + "\n ~~~~~~~~~~~~~~~~VS RUNTIME~~~~~~~~~~~~~~\n" + result);
        assertEquals(expResult, result);
    }

    
}