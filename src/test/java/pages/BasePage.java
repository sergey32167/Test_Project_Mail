package pages;

import core.BrowsersService;
import core.ReadProperties;
import core.WebDriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utils.Utils;
import utils.Waits;

public abstract class BasePage {
    protected static final int WAIT_FOR_PAGE_LOADING_SEC = 10;
    protected ReadProperties properties;
    protected WebDriver driver;
    protected Waits waits;

    public abstract boolean isPageOpened();

    public abstract void openPage();

    public BasePage( boolean openPageByUR) {
        this.driver = WebDriverSingleton.getDriverInstance();
        this.properties = ReadProperties.getInstance();
        this.waits = new Waits(driver, properties.getTimeOut());
        if (openPageByUR) {
            openPage();
        }
        waitForOpen();
    }

    protected void waitForOpen() {
        int secondsCount = 0;
        boolean isPageOpenedIndicator = isPageOpened();

        while (!isPageOpenedIndicator && secondsCount < WAIT_FOR_PAGE_LOADING_SEC) {
            Utils.sleep(1000);
            secondsCount++;
            isPageOpenedIndicator = isPageOpened();
        }
        if (!isPageOpenedIndicator) {
            throw new AssertionError("Page was not opened");
        }
    }
}
