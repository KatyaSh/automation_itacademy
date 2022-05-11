package pageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    private final By usernameField = By.cssSelector("input[type='text']");
    private final By passwordField = By.cssSelector("input[type='password']");
    private final By submitButton = By.cssSelector("button[role='submit']");

    public void login(String username, String password) {
        $(usernameField).setValue(username);
        $(passwordField).setValue(password);
        $(submitButton).click();
        $("button.app-transparent-btn.position-relative.ml-1").shouldBe(Condition.visible);
    }


    public String getHomePageUrl2() {
        return WebDriverRunner.getWebDriver().getCurrentUrl();
    }

}
