package tests;

import org.testng.Assert;
import pages.HomePage;
import pages.InMailPage;
import pages.LetterPage;
import baseEntities.BaseTest;
import elements.DropDownMenu;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import steps.LoginStep;
import steps.WritingALetterStep;

public class SmokeTests extends BaseTest {

    @Test
    public void test1() throws InterruptedException {
        LoginStep loginStep = new LoginStep(browsersService);
        loginStep.loginWithCorrectDate("sergeytestmail", "122333444455555qaz");
        WritingALetterStep writingALetterStep = new WritingALetterStep(browsersService);
        writingALetterStep.sendLetter();

    }

    @Test
    public void test2(){
        LoginStep loginStep = new LoginStep(browsersService);
        loginStep.loginWithCorrectDate("sergeytestmail", "122333444455555qaz");
        InMailPage inMailPage = new InMailPage(browsersService, false);
        inMailPage.newMailViz();
        inMailPage.myselfMailViz();
    }

    @Test
    public void test3() throws InterruptedException {
        LoginStep loginStep = new LoginStep(browsersService);
        loginStep.loginWithCorrectDate("sergeytestmail", "122333444455555qaz");
        InMailPage inMailPage = new InMailPage(browsersService, false);
        inMailPage.clickAllMyselfMail();
        Thread.sleep(2000);
        inMailPage.MyMailViz();
    }

    @Test
    public void test4() throws InterruptedException {
        LoginStep loginStep = new LoginStep(browsersService);
        loginStep.loginWithCorrectDate("sergeytestmail", "122333444455555qaz");
        InMailPage inMailPage = new InMailPage(browsersService, false);
        inMailPage.clickAllMyselfMail();
        Thread.sleep(2000);
        inMailPage.clickAllMyMail1();
        inMailPage.waitsTextMail();
        Assert.assertEquals(inMailPage.textMail(), "Hello Sergey");

    }
}
