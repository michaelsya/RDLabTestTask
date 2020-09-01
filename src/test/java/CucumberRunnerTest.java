import Utils.DriverManager;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

import static io.cucumber.junit.CucumberOptions.SnippetType.CAMELCASE;


@RunWith(Cucumber.class)
@CucumberOptions(
        snippets = CAMELCASE,
        features = {"src/test/java/Features/"},
        tags = {"@123"},
        glue = {"StepDefs"},
        plugin = {"pretty"}
)
public class CucumberRunnerTest {

    @AfterClass
    public static void tearDown() {
        DriverManager.closeDriver();
    }

}
