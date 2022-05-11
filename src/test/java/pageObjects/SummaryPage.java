package pageObjects;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class SummaryPage {
    private static final Logger logger = LogManager.getLogger(SummaryPage.class);

    private final By settingsButton = By.cssSelector("a[title='Settings']");
    private final By benchmarkSelector = By.cssSelector("div.d-flex.align-items-center.benchmark-selection");
    private final By appTopMenuTabs = By.xpath("//div[@class='ml-1 modes']//div[@class='app-title']");
    private final By appTopMenu = By.xpath("//div[@class='ml-1 modes']");


    @Step
    public String getSummaryPageUrl() {
        $("div.align-items-center.h-100.header__menu").shouldBe(visible);
        return WebDriverRunner.getWebDriver().getCurrentUrl();
    }

    @Step
    public boolean checkSettingsButton() {
        logger.info("Check Settings button is visible");
        return $(settingsButton).shouldBe(visible).isDisplayed();
    }

    @Step
    public boolean checkBenchmarkSelector() {
        logger.info("Check BenchmarkSelector button is visible");
        return $(benchmarkSelector).shouldBe(visible).isDisplayed();
    }

    @Step
    public boolean checkAppTopMenu() {
        logger.info("Check top menu tabs are visible");
        return $(appTopMenu).shouldBe(visible).isDisplayed();
    }

    @Step
    public boolean checkAppTopMenuTabs(String tab) {
        logger.info("Check the tab with name: " + tab + " is presented in top menu");
        return $$(appTopMenuTabs).findBy(text(tab)).isDisplayed();
    }

}
