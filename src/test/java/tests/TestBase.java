package tests;

import org.testng.annotations.BeforeMethod;
import pageObjects.CatalogPage;

public class TestBase {
    @BeforeMethod
    public static CatalogPage onCatalogPage() {
        CatalogPage catalogPage = new CatalogPage();
        return catalogPage.open();
    }
}
