package pages;

import baseEntities.BasePage;
import core.BrowsersService;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class LetterPage extends BasePage {

    private final static By whom = By.xpath("//input[@tabindex = '100']");
    private final static By theme = By.xpath("//input[@tabindex = '400']");
    private final static By sendbutton = By.xpath("//span[text() = 'Отправить']");
    private final static By savebutton = By.xpath("//span[text() = 'Сохранить']");
    private final static By cancelbutton = By.xpath("//span[text() = 'Отменить']");
    private final static By inputtext = By.xpath("//div[@tabindex = '505'] / child :: div");
    private final static By letterlogo = By.cssSelector(".container--2a9I2.container_full--2INh1");

    public LetterPage(BrowsersService browsersService, boolean openPageByURL) {
        super(browsersService, openPageByURL);
    }

    @Override
    protected void openPage() {

    }

    @Override
    public boolean isPageOpened() {
        try {
            return getLetterLogo().isDisplayed();
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public WebElement getLetterLogo (){
        return driver.findElement(letterlogo);
    }

    public WebElement getWhom (){
        return driver.findElement(whom);
    }

    public WebElement getTheme (){
        return driver.findElement(theme);
    }

    public WebElement getSendButton (){
        return driver.findElement(sendbutton);
    }

    public WebElement getSaveButton (){
        return driver.findElement(savebutton);
    }

    public WebElement getCancelButton (){ return driver.findElement(cancelbutton);}

    public WebElement getInputText (){ return driver.findElement(inputtext);}

    public void setWhom(String text){
        getWhom().sendKeys(text);
    }

    public void setTheme(String text){
        getTheme().sendKeys(text);
    }

    public void setInputText(String text){
        getInputText().sendKeys(text);
    }

    public void clickSendButton() {
        getSendButton().click();
    }

    public void clickSaveButton() {
        getSaveButton().click();
    }

    public void clickCancelButton() {
        getCancelButton().click();
    }


}
