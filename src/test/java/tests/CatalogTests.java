package tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageObjects.ProductsGrid;

import java.util.List;

public class CatalogTests extends TestBase {

    @Test
    public void checkCatalogNavigationItems() {
        List<String> catalogNavigationItems = onCatalogPage().getCatalogNavigationItems();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(catalogNavigationItems.contains("Электроника"), "TopNav Menu Item name is incorrect");
        softAssert.assertTrue(catalogNavigationItems.contains("Компьютеры и сети"), "TopNav Menu Item name is incorrect");
        softAssert.assertTrue(catalogNavigationItems.contains("Бытовая техника"), "TopNav Menu Item name is incorrect");
        softAssert.assertTrue(catalogNavigationItems.contains("Стройка и ремонт"), "TopNav Menu Item name is incorrect");
        softAssert.assertTrue(catalogNavigationItems.contains("Дом и сад"), "TopNav Menu Item name is incorrect");
        softAssert.assertTrue(catalogNavigationItems.contains("Авто и мото"), "TopNav Menu Item name is incorrect");
        softAssert.assertTrue(catalogNavigationItems.contains("Красота и спорт"), "TopNav Menu Item name is incorrect");
        softAssert.assertTrue(catalogNavigationItems.contains("Детям и мамам"), "TopNav Menu Item name is incorrect");
        softAssert.assertTrue(catalogNavigationItems.contains("Работа и офис"), "TopNav Menu Item name is incorrect");
        softAssert.assertTrue(catalogNavigationItems.contains("Еда"), "TopNav Menu Item name is incorrect");
        softAssert.assertAll();
    }

    @Test
    public void checkSectionLeftMenuItems() {
        List<String> catalogLeftNavItems = onCatalogPage().clickOn("Компьютеры и сети").getLeftMenuItems();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(catalogLeftNavItems.contains("Комплектующие"), "Название пункта меню неверное");
        softAssert.assertTrue(catalogLeftNavItems.contains("Ноутбуки, компьютеры, мониторы"), "Название пункта меню неверное");
        softAssert.assertTrue(catalogLeftNavItems.contains("Хранение данных"), "Название пункта меню неверное");
        softAssert.assertTrue(catalogLeftNavItems.contains("Сетевое оборудование"), "Название пункта меню неверное");
        softAssert.assertAll();
    }

    @Test
    public void checkProductsGrid() {
        ProductsGrid productsGrid = onCatalogPage().clickOn("Компьютеры и сети").clickOnLeftMenuItem("Комплектующие");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(productsGrid.checkProductTitleExist(), "Not all items have title");
        softAssert.assertTrue(productsGrid.checkProductDescriptionExist(), "Not all items have description");
        softAssert.assertAll();
    }

}
