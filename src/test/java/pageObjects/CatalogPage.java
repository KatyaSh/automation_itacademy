package pageObjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;

import io.qameta.allure.Step;
import org.apache.log4j.Logger;
import org.apache.log4j.LogManager;

import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.page;

public class CatalogPage {
    private static final Logger logger = LogManager.getLogger(CatalogPage.class);

    @Step
    public CatalogPage open() {
        // System.setProperty("chromeoptions.mobileEmulation", "deviceName=Galaxy Note 3");
        Selenide.open("https://catalog.onliner.by/");
        logger.info("catalog page is opened");
        return this;
    }

    @Step
    public List<String> getCatalogNavigationItems() {
        List<String> catalogNavigationItems = $$("span.catalog-navigation-classifier__item-title-wrapper").texts();
        logger.warn("logger warn test message");
        return catalogNavigationItems;
    }

    @Step
    public NavigationItems clickOnTopCategory(String text) {
        ElementsCollection resultLinks = $$("span.catalog-navigation-classifier__item-title-wrapper");
        resultLinks.findBy(text(text)).click();
        logger.info("click on Top Category ");
        return page(NavigationItems.class);
    }
}
