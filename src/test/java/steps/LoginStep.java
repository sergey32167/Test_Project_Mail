package steps;

import io.cucumber.java.en.When;
import pages.HomePage;

public class LoginStep extends BaseStep {

    @When("User with {string} and {string} is logged in")
    public void loginWithCorrectDate(String username, String password){
        HomePage homePage = new HomePage(true);
        homePage.setUsername(properties.getUsername());
        homePage.clickPswBtn();
        homePage.waitsPasswordInput();
        homePage.setPassword(properties.getPassword());
        homePage.clickComeInBtn();
    }
}
