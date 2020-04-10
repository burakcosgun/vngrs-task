package testRunner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "C:\\Users\\bcosg\\IdeaProjects\\vngrsPlaidTest\\features\\Toolbar.feature" ,
        glue = "stepDefinitions")
public class TestRunner {
}
