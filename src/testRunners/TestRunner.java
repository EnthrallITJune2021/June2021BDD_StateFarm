package testRunners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "features",
					glue = "stepDefs",
					dryRun = false,
					monochrome = true,
					publish = false)

public class TestRunner {

}
