package pageObjects;

import org.openqa.selenium.By;

public class LoginPage {
    private final By usernameField = By.xpath("//input[@type='text']");
    private final By passwordField = By.xpath("//input[@type='password']");
    private final By submitButton = By.xpath("//button[@type='submit']");
}
