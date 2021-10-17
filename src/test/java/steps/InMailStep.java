package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.InMailPage;

public class InMailStep extends BaseStep {

    @When("User cleans mailbox")
    public void clean_mail_box() {
        InMailPage inMailPage = new InMailPage(false);
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
}

