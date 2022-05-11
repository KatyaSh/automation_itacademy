package bdd;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Attachment;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import pageObjects.LoginPage;
import pageObjects.SummaryPage;

import static navigationURL.Navigation.APPLICATION_URL;

public class SummaryPageStepDefinitions {
    private static final Logger logger = LogManager.getLogger(SummaryPageStepDefinitions.class);

    SummaryPage summaryPage = new SummaryPage();
    SoftAssert softAssert = new SoftAssert();

    static LoginPage loginPage = new LoginPage();

    @Before
    public void login() {
        Selenide.open(APPLICATION_URL);
        loginPage.login("selenium_chrome", "Axa@Demo");
    }

    @When("user is on Home page")
    public void user_is_on_home_page() {
        logger.info("**********************");
        Assert.assertTrue(summaryPage.getSummaryPageUrl().contains("summary-dashboard"));
    }

    @Then("^Settings button is shown at the right top corner$")
    public void settingButton() {
        Assert.assertTrue(summaryPage.checkSettingsButton(), "Settings button is not shown");
    }

    @And("^Benchmark Selector control is shown at the top of the page$")
    public void benchmarkSelectorCheck() {
        Assert.assertTrue(summaryPage.checkBenchmarkSelector(), "BenchmarkSelector button is not shown");
    }

    @And("^Application Toolbar with Summary, Grid & chart, Histogram, Scatter-plot and Reports tabs is shown$")
    public void ToolbarCheck() {
        softAssert.assertTrue(summaryPage.checkAppTopMenu(), "Top Menu with Tabs is not shown");
        softAssert.assertTrue(summaryPage.checkAppTopMenuTabs("Summary"), "tab Summary is not shown");
        softAssert.assertTrue(summaryPage.checkAppTopMenuTabs("Grid & chart"), "tab Grid & chart is not shown");
        softAssert.assertTrue(summaryPage.checkAppTopMenuTabs("Histogram"), "tab Histogram is not shown");
        softAssert.assertTrue(summaryPage.checkAppTopMenuTabs("Scatter-plot"), "tab Scatter-plot is not shown");
        softAssert.assertTrue(summaryPage.checkAppTopMenuTabs("Reports"), "tab Reports is not shown");
        makeScreenshot();
        softAssert.assertAll();
    }


    @Attachment(value = "Page screenshot", type = "image/png")
    public static byte[] makeScreenshot() {
        return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
