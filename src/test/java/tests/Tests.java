package tests;

import org.testng.annotations.Test;

import static NavigationURL.Navigation.APPLICATION_URL;
import static io.restassured.RestAssured.given;

public class Tests extends TestBase {

    @Test
    public void getResponseStatus(){
        given().when().get(APPLICATION_URL).then().assertThat().statusCode(200);
    }


//    @Attachment (value = "Page screenshot", type = "image/png")
//    public static byte[] makeScreenshot(){
//        return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
//    }

}
