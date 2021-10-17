package tests;

import Pages.HomePage;
import Pages.InMailPage;
import Pages.LetterPage;
import baseEntities.BaseTest;
import elements.DropDownMenu;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class SmokeTests extends BaseTest {

    @Test
    public void test1() throws InterruptedException {
        HomePage homePage = new HomePage(browsersService, true);
        homePage.setUsername("sergeytestmail");
        homePage.clickPswBtn();
        homePage.waitsPasswordInput();
        homePage.setPassword("122333444455555qaz");
        homePage.clickComeInBtn();
        InMailPage inMailPage = new InMailPage(browsersService, false);
        inMailPage.clickDdmBtn();
        Thread.sleep(1000);
        DropDownMenu dropDownMenu = new DropDownMenu(browsersService, By.xpath("//div[@class = 'dropdown__menu'] / descendant :: span[@class = 'list-item__text']"));
        dropDownMenu.selectByName("Написать себе");
        LetterPage letterPage = new LetterPage(browsersService, false);
        letterPage.setInputText("Hello Sergey");
        letterPage.clickSendButton();
        inMailPage.getMyselfMail().isDisplayed();
        inMailPage.getNewMail().isDisplayed();

    }
}
