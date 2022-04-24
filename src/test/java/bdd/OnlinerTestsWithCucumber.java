package bdd;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(plugin = {"pretty"}, features = "src/test/java/resources/onlinerTopNavMenu.feature", glue = {
        "src/test/java/bdd"})

public class OnlinerTestsWithCucumber {
}