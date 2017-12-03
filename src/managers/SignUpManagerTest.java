package managers;

import static org.junit.Assert.*;
import org.junit.*;
import entities.Applicant;
import coordinators.JobSystemCoordinator;

/**
 * Test Cases for the SignUpManager
 * @author Kevin Silvera
 */
public class SignUpManagerTest {

    Applicant applicant;

    @Before
    public void setUp(){
        JobSystemCoordinator.signUpManager = new SignUpManager();
        JobSystemCoordinator.signUpManager.addApplicant("Tyrion Lannister","theimp@kingslanding.com",
                "671 671 5577", "22031, heaven bay, Casterly Rock", "9023 1232 4985 2243",
                "11/22");
        applicant = JobSystemCoordinator.signUpManager.getApplicantData("theimp@kingslanding.com");

    }

    @Test
    public void getApplicantDataTest01(){
        //checks to see if correct applicant is returned
        Applicant check = JobSystemCoordinator.signUpManager.getApplicantData("theimp@kingslanding.com");
        assertEquals(applicant, check);

        //checks to see if null is returned if empty data is entered
        check = JobSystemCoordinator.signUpManager.getApplicantData("");
        assertEquals(null, check);
    }

    @Test
    public void addApplicantTest(){
        boolean result;

        //Addition was successful
        result = JobSystemCoordinator.signUpManager.addApplicant("John Snow", "jsnow@nightwatch.com", "571 571 5577",
                "22441, snow leaf ct. Winterfell","3423 1232 4345 4343","11/20");
        assertEquals(true, result);

        //Error checking if person with the same email exists
        result = JobSystemCoordinator.signUpManager.addApplicant("John Snow", "jsnow@nightwatch.com", "571 571 5577",
                "22441, snow leaf ct. Winterfell","3423 1232 4345 4343","11/20");
        assertEquals(false, result);
    }

    @After
    public void cleanUp(){
        applicant = null;
        JobSystemCoordinator.signUpManager = null;
    }
}