package pages;

import elements.DropDownMenu;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import utils.Utils;

import java.util.List;

public class InMailPage extends BasePage {

    private final static By writeletter = By.xpath("//span[text() = 'Написать письмо']");
    private final static By tomyself = By.xpath("//div[text()= 'Письма себе']");
    private final static By innerletters = By.xpath("//div[text()= 'Входящие']");
    private final static By selectall = By.xpath("//span[@class= 'button2__explanation' and normalize-space()='Выделить все']");
    private final static By countmessagesontopbar = By.xpath("//a[text()='Почта']/span");
    private final static By deleteicon = By.xpath("//span[@class= 'button2__txt' and normalize-space()='Удалить']");
    private final static By confirmbutton = By.xpath("//div[contains(@class,'layer-confirm-folder')]//span[@class= 'button2__txt' and normalize-space()='Очистить']");
    private final static By socialnetwork = By.xpath("//div[text()= 'Социальные сети']");
    private final static By mailings = By.xpath("//div[text()= 'Рассылки']");
    private final static By basket = By.xpath("//div[text()= 'Корзина']");
    private final static By news = By.xpath("//div[text()= 'Новости']");
    private final static By cleanbasket = By.xpath("//span[text()= 'Очистить']");
    private final static By mailrubtn = By.xpath("//a[@data-click-counter = '360866022, 61021854']");
    private final static By mailbtn = By.xpath("//a[@data-click-counter = '360866021, 61021856']");
    private final static By maillogo = By.cssSelector(".portal-menu-logo__logo__img");
    private final static By ddmbutton = By.xpath("//a[@title='Написать письмо']/../div//span[@class='button2__wrapper button2__wrapper_centered']");
    private final static By myselfmail = By.cssSelector(".badge.badge_size_m");
    private final static By newmailbtn = By.cssSelector(".ph-project__counter.svelte-1dxh3mc");
    private final static By allmyselfmail = By.cssSelector(".mt-t.mt-t_tomyself.mt-t_ponymode");
    private final static By allmymail1 = By.cssSelector(".llc__item.llc__item_title");
    private final static By listreceivedletters = By.cssSelector(".llc__container");
    private final static By drobdawnarrow = By.xpath("//div[@class = 'dropdown__menu'] / descendant :: span[@class = 'list-item__text']");
    private final static String endpoint = "inbox/";

    public InMailPage(boolean openPageByUR) {
        super(openPageByUR);
    }

    @Override
    public boolean isPageOpened() {
        try {
            return getMailLogo().isDisplayed();
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    @Override
    public void openPage() {
        driver.get(properties.getURL() + endpoint);
    }

    public void selectDropDawnByOptions(String option) {
        DropDownMenu dropDownMenu = new DropDownMenu(driver, drobdawnarrow);
        Utils.sleep(1000);
        dropDownMenu.selectByName(option);
    }

    public WebElement getMailLogo() {
        return driver.findElement(maillogo);
    }

    public WebElement getBasket() {
        return driver.findElement(basket);
    }

    public WebElement getCleanBasket() {
        return driver.findElement(cleanbasket);
    }

    public WebElement getWriteLetter() {
        return driver.findElement(writeletter);
    }

    public WebElement getToMyself() {
        return driver.findElement(tomyself);
    }

    public WebElement getSocialNetwork() {
        return driver.findElement(socialnetwork);
    }

    public WebElement getMailings() {
        return driver.findElement(mailings);
    }

    public WebElement getNews() {
        return driver.findElement(news);
    }

    public WebElement getMailRuBtn() {
        return driver.findElement(mailrubtn);
    }

    public WebElement getMailBtn() {
        return driver.findElement(mailbtn);
    }

    public WebElement getDdmBtn() {
        return driver.findElement(ddmbutton);
    }

    public WebElement getNewMail() {
        return driver.findElement(newmailbtn);
    }

    public WebElement getInnerLetterButton() {
        return driver.findElement(innerletters);
    }

    public WebElement getMyselfMail() {
        return driver.findElement(myselfmail);
    }

    public WebElement getAllMyselfMail() {
        return driver.findElement(allmyselfmail);
    }

    public WebElement getAllMyMail1() {
        return driver.findElement(allmymail1);
    }


    public void clickWriteLetter() {
        getWriteLetter().click();
    }

    public void clickAllMyselfMail() {
        getAllMyselfMail().click();
    }

    public void clickAllMyMail1() {
        getAllMyMail1().click();
    }

    public void clickBasket() {
        getBasket().click();
    }

    public void clickCleanBasket() {
        getCleanBasket().click();
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
        waits.waitForVisibility(ddmbutton).click();
    }

    public void newMailViz() {
        getNewMail().isDisplayed();
    }

    public boolean myselfMailViz() {
        List<WebElement> webElementList = driver.findElements(myselfmail);
        return !webElementList.isEmpty();
    }

    public void MyMailViz() {
        getAllMyMail1().isDisplayed();
    }

    public void selectAllMessages() {
        waits.waitForClickable(selectall).click();
    }

    public void clickDeleteIcon() {
        waits.waitForVisibility(deleteicon).click();
    }

    public void clickConfirmButton() {
        waits.waitForVisibility(confirmbutton).click();
    }

    public String getCountMessagesFromTopBar() {
        return waits.waitForVisibility(countmessagesontopbar).getText();
    }

    public String getCountMessagesFromTabWriteMe() {
        return waits.waitForVisibility(myselfmail).getText();
    }

    public String getTextFirstLetterFromTop() {
        waits.waitForVisibility(listreceivedletters);
        List<WebElement> list = driver.findElements(listreceivedletters);
        return list.get(0).getText();
    }

    public void clickFirstMessageFromTop() {
        waits.waitForVisibility(listreceivedletters);
        List<WebElement> list = driver.findElements(listreceivedletters);
        list.get(0).click();
    }

    public void clickInnerLetters() {
        getInnerLetterButton().click();
    }

    public void clickBasketButton() {
        getBasket().click();
    }

}
