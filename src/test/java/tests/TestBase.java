package tests;

import org.testng.annotations.BeforeMethod;
import pageObjects.CatalogPage;

public class TestBase {
    @BeforeMethod
    public void onCatalogPage() {
        CatalogPage catalogPage = new CatalogPage();
        catalogPage.open();
    }
}
