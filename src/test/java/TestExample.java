import driver.DriverManager;
import driver.DriverSettings;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import waits.Waits;

import java.util.List;

import static navigation.ApplicationURL.APPLICATION_URL;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestExample {

    WebDriver driver = DriverManager.getWebDriver();
    Waits wait = new Waits();

    @BeforeEach
    public void beforeTest() {
        DriverManager.getWebDriver();
        DriverSettings.setInitialConfiguration();
        DriverSettings.navigateToPage(APPLICATION_URL);
        DriverSettings.setInitialTimeOut();
    }

    @Test
    public void test() {
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
//        driver.manage().window().maximize();
//        driver.get("https://onliner.by");

        wait.waitUntilElementIsClickable(driver.findElement(By.xpath("//span[text()='Ноутбуки']")));
        driver.findElement(By.xpath("//span[text()='Ноутбуки']")).click();
        wait.waitUntilElementIsVisible(driver.findElement(By.xpath(("//h1[contains(text(),'Ноутбуки')]"))));
        assertTrue(DriverManager.getWebDriver().getTitle().contains("Ноутбук купить в Минске"));

        WebElement checkboxAcer = driver.findElement(By.xpath("//ul[@class='schema-filter__list']//span[@class='schema-filter__checkbox-text'][normalize-space()='Acer']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", checkboxAcer);
        wait.waitUntilElementIsClickable(driver.findElement(By.xpath("//span[contains(@class,'button-style button-style_another button-style_base')]")));
        driver.findElement(By.xpath("//span[contains(@class,'button-style button-style_another button-style_base')]")).click();
        assertTrue(checkboxAcer.isEnabled(), "not enabled");
        checkboxAcer.click();
        wait.waitUntilElementIsClickable((By.xpath("//h1[contains(text(),'Ноутбуки Acer')]")));

        String pageURL = DriverManager.getWebDriver().getCurrentUrl();
        assertTrue(pageURL.contains("acer"));
        List<WebElement> brandList = driver.findElements(By.xpath("//span[@data-bind='html: product.extended_name || product.full_name']"));
        wait.getWebDriverWait(2000);
        for (WebElement item : brandList) {
            String itemHeader = item.getText();
            assertTrue(itemHeader.contains("Acer"), "The notebook header is not Acer: " + itemHeader);
        }
    }

    @AfterEach
    public void deInit() {
        DriverManager.disposeDriver();
    }
}