package steps;

import baseEntities.BaseStep;
import core.BrowsersService;
import elements.DropDownMenu;
import org.openqa.selenium.By;
import pages.InMailPage;
import pages.LetterPage;

public class WritingALetterStep extends BaseStep {
    public WritingALetterStep(BrowsersService browsersService) {
        super(browsersService);
    }

    public void sendLetter() throws InterruptedException {
        InMailPage inMailPage = new InMailPage(browsersService, false);
        inMailPage.clickDdmBtn();
        Thread.sleep(1000);
        DropDownMenu dropDownMenu = new DropDownMenu(browsersService, By.xpath("//div[@class = 'dropdown__menu'] / descendant :: span[@class = 'list-item__text']"));
        dropDownMenu.selectByName("Написать себе");
        LetterPage letterPage = new LetterPage(browsersService, false);
        letterPage.setInputText("Hello Sergey");
        letterPage.clickSendButton();
    }
}
