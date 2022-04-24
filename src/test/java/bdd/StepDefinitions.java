package bdd;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.List;

public class StepDefinitions {
    SubcategoryMenuItems subcategoryMenuItems = new SubcategoryMenuItems();
    HomePage homePage = new HomePage();

    @Given("^open browser with Onliner Home page$")
    public void onHomePage() {
        homePage.open();
    }

    @When("^user hovers over the root (.*) in the top nav$")
    public void hoverCategory(String string) {
        homePage.hoverTopCategory(string);
    }

    @Then("^(.*) menu with subcategories is shown$")
    public void topNavCategoryMenuIsShown(String string) {
        Assert.assertEquals(string, subcategoryMenuItems.menuIsShown(string));
    }

    @And("^(.*) are shown$")
    public void subcategoriesAreShown(String string) {
        List<String> catalogNavigationItems = subcategoryMenuItems.get2thCategoryItemNames();
        Assert.assertTrue(catalogNavigationItems.contains(string));
    }

}
