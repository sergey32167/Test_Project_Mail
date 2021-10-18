package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class MyselfPage extends BasePage{
    private final static By themetext = By.xpath("//div[@class = 'thread__subject-line']/h2");
    private final static By messagetext = By.xpath("//div[@data-signature-widget= 'container']/.. /div");
    private final static By deleteicon = By.xpath("//span[@class= 'button2__txt' and normalize-space()='Удалить']");
    private final static String endpoint = "tomyself/";

    public MyselfPage(boolean openPageByUR) {
        super(openPageByUR);
    }

    @Override
    public boolean isPageOpened() {
        try {
            return getDeleteIcon().isDisplayed();
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    @Override
    public void openPage() {

    }

    public WebElement getDeleteIcon() {
        return driver.findElement(deleteicon);
    }

    public WebElement getThemeText (){
        return driver.findElement(themetext);
    }

    public WebElement getMessageText (){
        return driver.findElement(messagetext);
    }


    public String themeGetText() {

        return getThemeText().getText();
    }

    public String messageGetText() {

        return getMessageText().getText();
    }

}
