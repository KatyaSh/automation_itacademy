package pageObjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class NavigationItems {


    public List<String> getLeftMenuItems() {
        ElementsCollection selenideElements = $$(By.xpath("//div[contains(@class,'catalog-navigation-list__aside-title')]"));
        List<String> leftMenuItemsNames = new ArrayList<>();
        for (SelenideElement item : selenideElements) {
            if (item.isDisplayed()) {
                leftMenuItemsNames.add(item.text());
            }
        }
        return leftMenuItemsNames;
    }

    public ProductsGrid clickOnLeftMenuItem(String text) {
        ElementsCollection resultElements = $$(By.xpath("//div[contains(@class,'catalog-navigation-list__aside-title')]"));
        resultElements.findBy(text(text)).click();
        return page(ProductsGrid.class);
    }

}