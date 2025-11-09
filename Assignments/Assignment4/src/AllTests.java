import java.util.List;

import org.junit.runner.Result;
import org.junit.runner.RunWith;
import org.junit.runner.notification.Failure;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * Do NOT change this testing suite.
 * 
 * @author Baba Kofi Weusijana
 *
 */
@RunWith(Suite.class)
@SuiteClasses({ GuessingGameTest.class })
public class AllTests {
    public static void main(String[] args) {
        try {
            Result result = org.junit.runner.JUnitCore.runClasses(GuessingGameTest.class);
            List<Failure> failures = result.getFailures();
            if (failures != null && failures.size() > 0) {
                System.err.println(failures);
            } else {
                System.out.println("All tests passed!");
            }
        } catch (Exception e) {
            System.err.println(e.getLocalizedMessage());
            e.printStackTrace();
        }
    }
}
