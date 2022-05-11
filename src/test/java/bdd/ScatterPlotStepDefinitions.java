package bdd;

import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Attachment;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import pageObjects.ScatterPlotPage;

public class ScatterPlotStepDefinitions {
    private static final Logger logger = LogManager.getLogger(ScatterPlotStepDefinitions.class);
    ScatterPlotPage scatterPlotPage = new ScatterPlotPage();

    @When("Scatter-plot view is opened")
    public void ScatterPlotViewIsOpened() {
        logger.info("*********************");
        scatterPlotPage.clickOnTab();
    }

    @Then("^Change X Attribute to (.*)$")
    public void changeXAttribute(String string) {
        scatterPlotPage.selectXAttribute(string);
    }

    @And("^check  name of the X-axis changed to (.*)$")
    public void checkNameXAxis(String string) {
        Assert.assertTrue(scatterPlotPage.getXAxesTitle().contains(string), "X-axis name is not correct");
        makeScreenshot();
    }

    @Then("^Change Y Attribute to (.*)$")
    public void changeYAttribute(String string) {
        scatterPlotPage.selectYAttribute(string);
    }

    @And("^check  name of the Y-axis changed to (.*)$")
    public void checkNameYAxis(String string) {
        Assert.assertTrue(scatterPlotPage.getYAxesTitle().contains(string), "Y-axis name is not correct");
        makeScreenshot();
    }

    @Then("Change interval to {int}")
    public void changeInterval(int interval) {
        scatterPlotPage.selectInterval(interval);
    }

    @And("check {int} points are shown on the Scatter-plot")
    public void checkInterval(int interval) {
        Assert.assertTrue(scatterPlotPage.getPointsOnPlot(interval), "Points amount is not correct");
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public static byte[] makeScreenshot() {
        return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
