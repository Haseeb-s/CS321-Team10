package managers;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(managers.ReportManagerTest.class, managers.ApplicationManagerTests.class,
                managers.SignUpManagerTest.class,  managers.JobManagerTest.class);

        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }

        System.out.println("Successful: " + result.wasSuccessful() + " ran " + result.getRunCount() + " tests");
    }
}