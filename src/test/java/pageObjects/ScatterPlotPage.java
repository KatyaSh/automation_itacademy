package pageObjects;

import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ScatterPlotPage {
    private static final Logger logger = LogManager.getLogger(ScatterPlotPage.class);

    private final By scatterPlotTab = By.xpath("//div[contains(text(),'Scatter-plot')]");
    private final By xAttributeSetting = By.xpath("//div[contains(text(),'X Attribute')]/following-sibling::deltix-ng-autocomplete");
    private final By yAttributeSetting = By.xpath("//div[contains(text(),'Y Attribute')]/following-sibling::deltix-ng-autocomplete");
    private final By xAxesTitle = By.cssSelector("text.scatter-plot-x-label");
    private final By yAxesTitle = By.cssSelector("text.scatter-plot-y-label");
    private final By points = By.cssSelector("path.point");
    private final By intervalsSetting = By.xpath("//div[contains(text(),'Intervals')]/following-sibling::app-intervals-count-autocomplete-control");

    @Step
    public void clickOnTab() {
        $(scatterPlotTab).shouldBe(visible).click();
        logger.info("Click on Histogram Tab at the top menu");
        $(xAttributeSetting).shouldBe(visible);
    }

    @Step
    public void selectXAttribute(String string) {
        $(xAttributeSetting).click();
        $("div.autocomplete-dropdown-menu-wrapper>ul").shouldBe(visible);
        logger.info("Click on XAttribute");
        $$("li>a").findBy(text(string)).click();
        logger.info("Select XAttribute " + string);

    }

    @Step
    public String getXAxesTitle() {
        logger.info("check X-Axes Title ");
        return $(xAxesTitle).getText();

    }

    @Step
    public void selectYAttribute(String string) {
        $(yAttributeSetting).click();
        $("div.autocomplete-dropdown-menu-wrapper>ul").shouldBe(visible);
        logger.info("Click on YAttribute");
        $$("li>a").findBy(text(string)).click();
        logger.info("Select YAttribute " + string);
    }

    @Step
    public String getYAxesTitle() {
        logger.info("check Y-Axes Title ");
        return $(yAxesTitle).getText();
    }

    @Step
    public void selectInterval(int interval) {
        String intervalValue = String.valueOf(interval);
        $(intervalsSetting).click();
        logger.info("Click on Interval selector");
        $("div.autocomplete-dropdown-menu-wrapper>ul").shouldBe(visible);
        $$("li>a").findBy(text(intervalValue)).click();
        logger.info("Select interval " + intervalValue);
    }

    @Step
    public boolean getPointsOnPlot(int interval) {
        logger.info("check Points amount On the Plot");
        ElementsCollection pointAmount = $$(points);
        return (pointAmount.size() == interval);
    }


}
