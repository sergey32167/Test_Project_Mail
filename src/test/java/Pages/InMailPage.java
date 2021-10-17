package Pages;

import baseEntities.BasePage;
import core.BrowsersService;
import core.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class InMailPage extends BasePage {

    private final static By writeletter = By.xpath("//span[text() = 'Написать письмо']");
    private final static By tomyself = By.xpath("//div[text()= 'Письма себе']");
    private final static By socialnetwork = By.xpath("//div[text()= 'Социальные сети']");
    private final static By mailings = By.xpath("//div[text()= 'Рассылки']");
    private final static By news = By.xpath("//div[text()= 'Новости']");
    private final static By mailrubtn = By.xpath("//a[@data-click-counter = '360866022, 61021854']");
    private final static By mailbtn = By.xpath("//a[@data-click-counter = '360866021, 61021856']");
    private final static By maillogo = By.cssSelector(".portal-menu-logo__logo__img");
    private final static By ddmbutton = By.xpath("//span[@class = 'button2 button2_has-ico button2_has-ico-s button2_navigation_drop_down button2_rotate-ico button2_clean button2_always-bright button2_short button2_compact button2_hover-support'] / span[@class = 'button2__wrapper button2__wrapper_centered']");
    private final static By myselfmail = By.cssSelector(".badge.badge_size_m");
    private final static By newmailbtn = By.cssSelector(".ph-project__counter.svelte-1dxh3mc");
    private final static By allmyselfmail = By.cssSelector(".mt-t.mt-t_tomyself.mt-t_unread.mt-t_ponymode");
    private final static By allmymail1 = By.cssSelector(".ll-crpt");
    private final static String endpoint = "inbox/";

    public InMailPage(BrowsersService browsersService, boolean openPageByURL) {
        super(browsersService, openPageByURL);
    }

    @Override
    protected void openPage() {
            browsersService.getDriver().get(ReadProperties.getInstance().getURL() + endpoint);
        }

    @Override
    public boolean isPageOpened() {
        try {
            return getMailLogo().isDisplayed();
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public WebElement getMailLogo (){
        return driver.findElement(maillogo);
    }

    public WebElement getWriteLetter (){
        return driver.findElement(writeletter);
    }

    public WebElement getToMyself (){
        return driver.findElement(tomyself);
    }

    public WebElement getSocialNetwork (){
        return driver.findElement(socialnetwork);
    }

    public WebElement getMailings (){
        return driver.findElement(mailings);
    }

    public WebElement getNews (){ return driver.findElement(news);}

    public WebElement getMailRuBtn (){ return driver.findElement(mailrubtn);}

    public WebElement getMailBtn (){ return driver.findElement(mailbtn);}

    public WebElement getDdmBtn (){ return driver.findElement(ddmbutton);}

    public WebElement getNewMail (){ return driver.findElement(newmailbtn);}

    public WebElement getMyselfMail (){ return driver.findElement(myselfmail);}

    public WebElement getAllMyselfMail (){ return driver.findElement(allmyselfmail);}

    public WebElement getAllMyMail1 (){ return driver.findElement(allmymail1);}


    public void clickWriteLetter() {
        getWriteLetter().click();
    }

    public void clickToMyself() {
        getToMyself().click();
    }

    public void clickSocialNetwork() {
        getSocialNetwork().click();
    }

    public void clickMailings() {
        getMailings().click();
    }

    public void clickNews() {
        getNews().click();
    }

    public void clickMailRuBtn() {
        getMailRuBtn().click();
    }

    public void clickMailBtn() {
        getMailBtn().click();
    }

    public void clickDdmBtn() {
        getDdmBtn().click();
    }

}
