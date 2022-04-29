package pageObjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$$;

public class ProductsGrid {

    public boolean checkProductTitleExist() {
        ElementsCollection selenideElements = $$(By.xpath("//div[@class ='catalog-navigation-list__aside-item catalog-navigation-list__aside-item_active']/div/div/a/span/span[@class='catalog-navigation-list__dropdown-title']"));
        for (SelenideElement item : selenideElements) {
            if (!item.text().isEmpty()) {
                return true;
            }
        }
        return false;
    }

    public boolean checkProductDescriptionExist() {
        ElementsCollection selenideElements = $$(By.xpath("//div[@class ='catalog-navigation-list__aside-item catalog-navigation-list__aside-item_active']/div/div/a/span/span[@class='catalog-navigation-list__dropdown-description']"));
        for (SelenideElement item : selenideElements) {
            if (!item.text().isEmpty()) {
                return true;
            }
        }
        return false;
    }
}
