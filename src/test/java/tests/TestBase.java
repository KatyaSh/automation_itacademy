package tests;

import org.testng.annotations.BeforeClass;
import rest.RestAssured;

import static NavigationURL.Navigation.APPLICATION_URL;

public class TestBase {

    @BeforeClass
    public void login() {
        RestAssured restAssured = new RestAssured();
        restAssured.getResponse(APPLICATION_URL);
    }
}
