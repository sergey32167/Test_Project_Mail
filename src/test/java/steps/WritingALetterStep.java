package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.InMailPage;
import pages.LetterPage;

public class WritingALetterStep extends BaseStep {
    @When("User selects {string} option from dropdown menu")
    public void sendLetter(String option) {
        InMailPage inMailPage = new InMailPage(false);
        inMailPage.clickDdmBtn();
        inMailPage.selectDropDawnByOptions(option);
    }

    @And("User writes {string} message in form")
    public void userWritesHelloSergeyMessageInForm(String message) {
        LetterPage letterPage = new LetterPage(false);
        letterPage.setInputText(message);
    }


    @And("User writes {string} massage in theme")
    public void userWritesHelloMessageInTheme(String message) {
        LetterPage letterPage = new LetterPage(false);
        letterPage.setTheme(message);
    }

    @And("User clicks send message button and wait for invisibility modal window 'Письмо отправлено'")
    public void userClicksSendMessageButton() {
        LetterPage letterPage = new LetterPage(false);
        letterPage.clickSendButton();
        letterPage.waitForVisibilityConfirmModal();
        letterPage.waitForInvisibilityConfirmModal();
    }

    @Then("User validates success message {string}")
    public void userValidatesSuccessMessage(String text) {
        LetterPage letterPage = new LetterPage(false);
        String successText = letterPage.getTextConfirmModal();
        Assert.assertEquals(text,successText);
    }

}
