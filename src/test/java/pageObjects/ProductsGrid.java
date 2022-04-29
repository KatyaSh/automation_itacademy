package pageObjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

import org.apache.log4j.Logger;
import org.apache.log4j.LogManager;

import static com.codeborne.selenide.Selenide.$$;

public class ProductsGrid {
    private static final Logger logger = LogManager.getLogger(NavigationItems.class);

    @Step
    public boolean checkProductTitleExist() {
        ElementsCollection selenideElements = $$(By.xpath("//div[@class ='catalog-navigation-list__aside-item catalog-navigation-list__aside-item_active']/div/div/a/span/span[@class='catalog-navigation-list__dropdown-title']"));
        for (SelenideElement item : selenideElements) {
            if (!item.text().isEmpty()) {
                return true;
            }
        }
                return false;
    }

    @Step
    public boolean checkProductDescriptionExist() {
        logger.debug("logger debug test message");
        ElementsCollection selenideElements = $$(By.xpath("//div[@class ='catalog-navigation-list__aside-item catalog-navigation-list__aside-item_active']/div/div/a/span/span[@class='catalog-navigation-list__dropdown-description']"));
        for (SelenideElement item : selenideElements) {
            if (!item.text().isEmpty()) {
                return true;
            }
        }
        return false;
    }
}
