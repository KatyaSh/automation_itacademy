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
import pageObjects.GridPage;

public class GridPageStepDefinitions {
    private static final Logger logger = LogManager.getLogger(GridPageStepDefinitions.class);
    GridPage gridPage = new GridPage();

    @When("Grid & Chart view is opened")
    public void openGrid() {
        logger.info("***********************");
        gridPage.clickOnTab();
    }

    @Then("Open Filter Configurator control")
    public void openFilter() {
        gridPage.clickOnFilterButton();
        makeScreenshot();
    }

    @And("^check/uncheck Filter checkbox and verify column display$")
    public void checkIfColumnDisplayFilter() {
        Assert.assertTrue(gridPage.checkSwitchColumnDisplayFilter(), "Id filter works incorrectly");
    }

    @Then("Open Tool panel")
    public void openToolPanel() {
        gridPage.clickOnToolPanel();
        makeScreenshot();
    }

    @And("^check/uncheck Tool panel checkbox and verify column display$")
    public void checkIfColumnDisplayTool() {
        Assert.assertTrue(gridPage.checkSwitchColumnDisplayToolPanel(), "Id filter in Tool panel works incorrectly");
    }

    @Then("Open filter for Id column and switch to the 3rd tab")
    public void openColumnFilter() {
        gridPage.openColumnFilter();
        makeScreenshot();
    }

    @And("^check/uncheck column checkbox and verify column display$")
    public void checkIfColumnDisplayColumnFilter() {
        Assert.assertTrue(gridPage.checkSwitchColumnDisplayColumnFilter(), "Id filter in Column header works incorrectly");
    }

    @And("delete sort filter if applied")
    public void deleteAnySortFilter() {
        gridPage.closeColumnFilterIfExists();
    }

    @Then("^Click on the column (.*) to apply sort$")
    public void clickOnColumn(String string) {
        gridPage.clickOnColumnHeader(string);
    }

    @And("check asc sort button appears")
    public void ascSortButtonShown() {
        Assert.assertTrue(gridPage.checkAscSortButtonDisplay(), "Asc sort button is not shown");
    }

    @And("check desc sort button appears")
    public void descSortButtonShown() {
        Assert.assertTrue(gridPage.checkDeckSortButtonDisplay(), "Desc sort button is not shown");
    }

    @And("^Make sure the sort is applied  the column (.*)$")
    public void ascSortIsApplied(String string) {
        Assert.assertTrue(gridPage.checkAscSortColumnHeader(string), "Asc sort  is not applied");
        makeScreenshot();
    }

    @And("^Make sure the desc sort is applied  the column (.*)$")
    public void descSortIsApplied(String string) {
        Assert.assertTrue(gridPage.checkDescSortColumnHeader(string), "Desc sort  is not applied");
        makeScreenshot();
    }

    @And("^Check the sort is reset on the column (.*)$")
    public void SortIsNotApplied(String string) {
        Assert.assertTrue(gridPage.checkNoSortApplied(string), "the sort is not reset");
        makeScreenshot();
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public static byte[] makeScreenshot() {
        return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }

}

