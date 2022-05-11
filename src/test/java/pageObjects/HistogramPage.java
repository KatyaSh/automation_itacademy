package pageObjects;

import com.codeborne.selenide.ElementsCollection;

import io.qameta.allure.Step;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class HistogramPage {
    private static final Logger logger = LogManager.getLogger(HistogramPage.class);

    private final By histogramTab = By.xpath("//div[contains(text(),'Histogram')]");
    private final By barTooltipAttribute = By.xpath("//div[@class='tooltip']/div[1]");
    private final By barTooltipCount = By.xpath("//div[@class='tooltip']/div[2]");
    private final By dataTable = By.cssSelector("ag-grid-angular[class='ag-theme-balham flex-1 h-100'] div[role='grid']");
    private final By bars = By.cssSelector("rect.bar");

    private ElementsCollection barsCollection = $$(bars);

    @Step
    public void clickOnTab() {
        $(histogramTab).shouldBe(visible).click();
        logger.info("Click on Histogram Tab at the top menu");
    }


    @Step
    public void hoverBar(int index) {
        logger.info("hover over the Bar");
        barsCollection.get(index).shouldBe(visible).hover();
        $(barTooltipAttribute).shouldBe(visible);
    }

    @Step
    public boolean checkTooltipInfoIsDisplayed() {
        logger.info("check the tooltip appears");
        if ($(barTooltipAttribute).getText().isEmpty()) {
            return false;
        }
        if ($(barTooltipCount).getText().isEmpty()) {
            return false;
        }
        return true;
    }

    @Step
    public void clickOnBar(int index) {
        logger.info("click on the Bar");
        barsCollection.get(index).shouldBe(visible).click();
        $(dataTable).shouldBe(visible);
    }


}
