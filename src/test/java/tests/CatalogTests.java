package tests;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageObjects.CatalogPage;
import pageObjects.ProductsGrid;

import java.util.List;

public class CatalogTests extends TestBase {
    CatalogPage catalogPage = new CatalogPage();

    @Test
    @Severity(value = SeverityLevel.CRITICAL)
    @Description(value = "Тест проверяет топ категории каталога")
    public void checkCatalogNavigationItems() {
        List<String> catalogNavigationItems = catalogPage.getCatalogNavigationItems();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(catalogNavigationItems.contains("Электроника"), "Электроника category name doesn't match");
        softAssert.assertTrue(catalogNavigationItems.contains("Компьютеры и сети"), "Компьютеры и сети category name doesn't match");
        softAssert.assertTrue(catalogNavigationItems.contains("Бытовая техника"), "Бытовая техника category name doesn't match");
        softAssert.assertTrue(catalogNavigationItems.contains("Стройка и ремонт"), "Стройка и ремонт category name doesn't match");
        softAssert.assertTrue(catalogNavigationItems.contains("Дом и сад"), "Дом и сад category name doesn't match");
        softAssert.assertTrue(catalogNavigationItems.contains("Авто и мото"), "Авто и мото category name doesn't match");
        softAssert.assertTrue(catalogNavigationItems.contains("Красота и спорт"), "Красота и спорт category name doesn't match");
        softAssert.assertTrue(catalogNavigationItems.contains("Детям и мамам"), "Детям и мамам category name doesn't match");
        softAssert.assertTrue(catalogNavigationItems.contains("Работа и офис"), "Работа и офис category name doesn't match");
        softAssert.assertTrue(catalogNavigationItems.contains("Onlíner Prime"), "Onlíner Prime category name doesn't match");
        makeScreenshot();
        softAssert.assertAll();
    }

    @Test
    @Severity(value = SeverityLevel.CRITICAL)
    @Description(value = "Тест проверяет подкатегории каталога в левом меню")
    public void checkSectionLeftMenuItems() {
        List<String> catalogLeftNavItems = catalogPage.clickOnTopCategory("Компьютеры и сети").getLeftMenuItems();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(catalogLeftNavItems.contains("Комплектующие"), "Название пункта меню неверное");
        softAssert.assertTrue(catalogLeftNavItems.contains("Ноутбуки, компьютеры, мониторы"), "Название пункта меню неверное");
        softAssert.assertTrue(catalogLeftNavItems.contains("Хранение данных"), "Название пункта меню неверное");
        softAssert.assertTrue(catalogLeftNavItems.contains("Сетевое оборудование"), "Название пункта меню неверное");
        makeScreenshot();
        softAssert.assertAll();
    }

    @Test
    @Flaky
    @Severity(value = SeverityLevel.NORMAL)
    @Description(value = "Тест проверяет, что все товары имеют описание")
    public void checkProductsGrid()  {
        ProductsGrid productsGrid = catalogPage.clickOnTopCategory("Компьютеры и сети").clickOnLeftMenuItem("Комплектующие");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(productsGrid.checkProductTitleExist(), "Not all items have title");
        softAssert.assertTrue(productsGrid.checkProductDescriptionExist(), "Not all items have description");
        makeScreenshot();
        softAssert.assertAll();
    }

    @Attachment (value = "Page screenshot", type = "image/png")
    public static byte[] makeScreenshot(){
        return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }

}
