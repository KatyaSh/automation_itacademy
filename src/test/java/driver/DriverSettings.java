package driver;

import java.util.concurrent.TimeUnit;

public class DriverSettings {
    public static void setInitialConfiguration() {

        DriverManager.getWebDriver().manage().window().maximize();
    }

    public static void navigateToPage(String pageUrl) {

        DriverManager.getWebDriver().navigate().to(pageUrl);
    }

    public static void setInitialTimeOut() {
        DriverManager.getWebDriver().manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
    }
}
