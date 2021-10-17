package pages;

import core.BrowsersService;
import core.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {

    private final static By username = By.cssSelector(".email-input");
    private final static By passwordbutton = By.cssSelector(".button.svelte-1tib0qz");
    private final static By password = By.cssSelector(".password-input");
    private final static By comeinbutton = By.cssSelector(".second-button");
    private final static By searchbutton = By.id("search:submit");
    private final static By writeletterbutton = By.xpath("//div[@class = 'i-link-deco']");

    public HomePage(boolean openPageByUR) {
        super(openPageByUR);
    }

    @Override
    public boolean isPageOpened() {
        try {
            return getSearchBtn().isDisplayed();
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    @Override
    public void openPage() {
        driver.get(properties.getURL());
    }

    public WebElement getName (){
        return driver.findElement(username);
    }

    public WebElement getPassword (){
        return driver.findElement(password);
    }

    public WebElement getPswBtn (){
        return driver.findElement(passwordbutton);
    }

    public WebElement getComeInBtn (){
        return driver.findElement(comeinbutton);
    }

    public WebElement getSearchBtn (){
        return driver.findElement(searchbutton);
    }

    public WebElement getWriteBtn (){ return driver.findElement(writeletterbutton);}

    public void setUsername(String text){
        getName().sendKeys(text);
    }

    public void setPassword(String text){
        getPassword().sendKeys(text);
    }

    public void clickPswBtn() {
        getPswBtn().click();
    }

    public void clickComeInBtn() {
        getComeInBtn().click();
    }

    public void clickWriteBtn() {
        getWriteBtn().click();
    }

    public void waitsPasswordInput() {
        waits.waitForVisibility(password);
    }

}
