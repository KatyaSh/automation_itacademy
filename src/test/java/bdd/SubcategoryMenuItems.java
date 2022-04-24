package bdd;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;


import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SubcategoryMenuItems {

    public String menuIsShown(String text) {
        ElementsCollection resultLinks = $$("a.b-main-navigation__dropdown-title-link");
        SelenideElement element = resultLinks.findBy(text(text));
        element.shouldBe(Condition.visible);
        return element.text();
    }

    public List<String> get2thCategoryItemNames() {
        ElementsCollection selenideElements = $$("span.b-main-navigation__dropdown-advert-sign");
        List<String> subcategoriesItemsNames = new ArrayList<>();
        for (SelenideElement item : selenideElements) {
            subcategoriesItemsNames.add(item.text());
        }
        return subcategoriesItemsNames;
    }

}