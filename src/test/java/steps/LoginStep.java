package steps;

import baseEntities.BaseStep;
import core.BrowsersService;
import pages.HomePage;

public class LoginStep extends BaseStep {

    public LoginStep(BrowsersService browsersService) {
        super(browsersService);
    }

    public void loginWithCorrectDate(String Email, String Password){
        HomePage homePage = new HomePage(browsersService, true);
        homePage.setUsername(Email);
        homePage.clickPswBtn();
        homePage.waitsPasswordInput();
        homePage.setPassword(Password);
        homePage.clickComeInBtn();
    }
}
