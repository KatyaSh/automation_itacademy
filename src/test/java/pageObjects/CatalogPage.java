package pageObjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;

import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class CatalogPage {

    public CatalogPage open() {
        System.setProperty("chromeoptions.mobileEmulation", "deviceName=Galaxy Note 3");
        Selenide.open("https://catalog.onliner.by/");
        return this;
    }

    public List<String> getCatalogNavigationItems() {
        List<String> catalogNavigationItems = $$("span[class='catalog-navigation-classifier__item-title-wrapper']").texts();
        return catalogNavigationItems;
    }

    public NavigationItems clickOn(String text) {
        ElementsCollection resultLinks = $$("span[class='catalog-navigation-classifier__item-title-wrapper']");
        resultLinks.findBy(text(text)).click();
        return page(NavigationItems.class);
    }
}
