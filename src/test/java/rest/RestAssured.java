package rest;

import io.restassured.response.Response;
import org.json.JSONException;
import org.testng.annotations.Test;

import static NavigationURL.Navigation.APPLICATION_URL;
import static io.restassured.RestAssured.given;

public class RestAssured {
    public String getAccessToken() throws JSONException {
        Response response =
                given()
                        .header("Authorization", "Basic d2ViYXBwOg==")
                        .queryParams("grant_type", "password")
                        .queryParams("username", "selenium_chrome")
                        .queryParams("password", "Axa@Demo")
                        .queryParams("scope", "deltix.axa.user")
                        .post(APPLICATION_URL + "oauth/token")
                        .then()
                        .extract()
                        .response();

        return response.jsonPath().getString("access_token");
    }

    public Response getResponse(String URL) {
        Response response =
                given()
                        .header("Authorization", "bearer " + getAccessToken())
                        .get(URL)
                        .then()
                        .extract()
                        .response();
        return response;
    }
}
