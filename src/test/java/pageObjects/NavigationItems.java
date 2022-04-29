package pageObjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import org.apache.log4j.Logger;
import org.apache.log4j.LogManager;


import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class NavigationItems {
    private static final Logger logger = LogManager.getLogger(NavigationItems.class);

    @Step
    public List<String> getLeftMenuItems() {
        ElementsCollection selenideElements = $$(By.xpath("//div[contains(@class,'catalog-navigation-list__aside-title')]"));
        List<String> leftMenuItemsNames = new ArrayList<>();
        for (SelenideElement item : selenideElements) {
            if (item.isDisplayed()) {
                leftMenuItemsNames.add(item.text());
            }
        }
        logger.error("test logger error message");
              return leftMenuItemsNames;
    }

    @Step
    public ProductsGrid clickOnLeftMenuItem(String text) {
        ElementsCollection resultElements = $$(By.xpath("//div[contains(@class,'catalog-navigation-list__aside-title')]"));
        resultElements.findBy(text(text)).click();
        logger.info("click On Left Menu Item");
             return page(ProductsGrid.class);
    }

}