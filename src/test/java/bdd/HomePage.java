package bdd;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;

import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class HomePage {

    public void open() {
        Selenide.open("https://onliner.by/");
    }

    public List<String> getTopNavCategories() {
        List<String> topCategoryNames = $$("span.b-main-navigation__text").texts();
        return topCategoryNames;
    }

    public void hoverTopCategory(String text) {
        ElementsCollection resultLinks = $$("span.b-main-navigation__text");
        resultLinks.findBy(text(text)).hover();
    }
}
