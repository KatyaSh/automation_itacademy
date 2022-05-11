package tests;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features = "src/test/resources/features/",
        glue = {"bdd"},
        plugin = {"pretty"})

public class ProjectWithCucumberTest extends AbstractTestNGCucumberTests {


}
