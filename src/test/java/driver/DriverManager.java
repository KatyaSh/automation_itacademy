package driver;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {
    private static WebDriver driver;

    private DriverManager() {
    }

    public static WebDriver getWebDriver() {
        if(driver==null) {
          ChromeDriverManager.getInstance("chrome").setup();
          driver = new ChromeDriver();
        }
        return driver;
    }

    public static void disposeDriver() {
        driver.close();
        driver = null;
    }
}
