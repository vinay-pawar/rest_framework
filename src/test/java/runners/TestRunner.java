package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
  features = "src/test/java/apiTests/features",
  glue = {"apiTests.stepDefinitions"},
  plugin= {"pretty", "html:target/cucumber-reports/report.html", "timeline:target/cucumber-reports/timeline-report", }
)
public class TestRunner {
}
