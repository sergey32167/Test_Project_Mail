package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.InMailPage;
import pages.LetterPage;
import pages.MyselfPage;
import utils.Utils;

public class InMailStep {

    @When("User cleans mailbox")
    public void clean_mail_box() {
        InMailPage inMailPage = new InMailPage(false);
        Utils.sleep(2000);
        if (inMailPage.myselfMailViz()) {
            inMailPage.clickToMyself();
            inMailPage.selectAllMessages();
            inMailPage.clickDeleteIcon();
            inMailPage.clickConfirmButton();
        }
    }

    @Then("User validates count {string} of received messages on top menu bar")
    public void userValidatesCountOfReceivedMessagesOnTopMenuBar(String count) {
        InMailPage inMailPage = new InMailPage(false);
        String countMessages = inMailPage.getCountMessagesFromTopBar();
        Assert.assertEquals(countMessages.trim(), count);
    }

    @And("User validates count {string} of received messages on 'Письма себе' tab")
    public void userValidatesCountOfReceivedMessagesOnTab(String count) {
        InMailPage inMailPage = new InMailPage(false);
        String countMessages = inMailPage.getCountMessagesFromTabWriteMe();
        Assert.assertEquals(countMessages.trim(), count);
    }

    @And("User expands 'ПИСЬМА СЕБЕ' row")
    public void userExpandsRow() {
        InMailPage inMailPage = new InMailPage(false);
        inMailPage.clickAllMyselfMail();
    }

    @And("User clicks 'Письма себе' button")
    public void userClicksMyLettersButton() {
        InMailPage inMailPage = new InMailPage(false);
        inMailPage.clickAllMyMail1();
    }

    @And("User clicks on first message")
    public void userClickMessage() {
        InMailPage inMailPage = new InMailPage(false);
        inMailPage.clickFirstMessageFromTop();
    }

    @Then("User validates received row message from {string}")
    public void userValidatesReceivedRowMessageFrom(String from) {
        InMailPage inMailPage = new InMailPage(false);
        String[] textFrom = inMailPage.getTextFirstLetterFromTop().split("\n");
        Assert.assertEquals(from, textFrom[0]);
    }

    @Then("User validates received message with expected text {string} and theme {string}")
    public void userValidatesExpectedText(String text, String theme) {
        MyselfPage myselfPage = new MyselfPage(false);
        Assert.assertEquals(theme, myselfPage.themeGetText());
        Assert.assertEquals(text,myselfPage.messageGetText());
    }

    @When("User clicks 'Входящие' button")
    public void userClicksInnerButton() {
        InMailPage inMailPage = new InMailPage(false);
        inMailPage.clickInnerLetters();
    }

    @And("User clicks send message button")
    public void userClicksSendMessageButton() {
        LetterPage letterPage = new LetterPage(false);
        letterPage.clickSendButton();
    }

    @And("User clicks basket button")
    public void userClicksBasketButton() {
        InMailPage inMailPage = new InMailPage(false);
        inMailPage.clickBasketButton();
    }

}

