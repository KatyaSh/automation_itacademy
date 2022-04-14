package waits;

import driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.List;

public class Waits {



    public  WebDriverWait getWebDriverWait(long time) {
        return new WebDriverWait(DriverManager.getWebDriver(), time);
    }


    public void waitUntilElementIsVisible (WebElement element) {
        WebDriverWait webDriverWait = getWebDriverWait(200);
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitUntilElementIsClickable(WebElement element) {
        WebDriverWait webDriverWait = getWebDriverWait(200);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
    }
    public void waitUntilElementIsClickable(By element) {
        WebDriverWait webDriverWait = getWebDriverWait(200);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitUntilElementsAreVisible (List<WebElement> elements) {
        WebDriverWait webDriverWait = getWebDriverWait(200);
        webDriverWait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }



}
