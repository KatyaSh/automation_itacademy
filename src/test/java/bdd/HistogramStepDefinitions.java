package bdd;

import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Attachment;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import pageObjects.HistogramPage;

import static com.codeborne.selenide.Selenide.$;

public class HistogramStepDefinitions {
    private static final Logger logger = LogManager.getLogger(HistogramStepDefinitions.class);
    HistogramPage histogramPage = new HistogramPage();


    @Given("Histogram view is opened")
    public void histogram_view_is_opened() {
        logger.info("***********************");
        histogramPage.clickOnTab();
    }

    @When("Hover over a bar with {int}")
    public void hoverOverBar(int index) {
        histogramPage.hoverBar(index);
    }

    @Then("Check boundaries and number of orders are displayed")
    public void checkBoundariesAndOrderNumber() {
        Assert.assertTrue(histogramPage.checkTooltipInfoIsDisplayed(), "Tooltip info is not displayed");
        makeScreenshot();
    }

    @And("Click on the bar with {int}")
    public void clickOnBar(int index) {
        histogramPage.clickOnBar(index);
    }

    @After
    public void logout(){
        $("a[title='Sign Out']").click();
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public static byte[] makeScreenshot() {
        return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
