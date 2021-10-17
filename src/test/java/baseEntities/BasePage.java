package baseEntities;

import core.BrowsersService;
import core.ReadProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    protected static final int WAIT_FOR_PAGE_LOADING_SEC = 10;
    protected WebDriver driver;
    protected ReadProperties properties;
    protected final BrowsersService browsersService;

    protected abstract void openPage();

    public abstract boolean isPageOpened();

    public BasePage(BrowsersService browsersService, boolean openPageByURL) {
        this.browsersService = browsersService;
        this.driver = browsersService.getDriver();
        properties = ReadProperties.getInstance();

        if (openPageByURL) {
            openPage();
        }
        waitForOpen();
    }

    protected void waitForOpen() {
        int secondsCount = 0;
        boolean isPageOpenedIndicator = isPageOpened();

        while (!isPageOpenedIndicator && secondsCount < WAIT_FOR_PAGE_LOADING_SEC) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            secondsCount++;
            isPageOpenedIndicator = isPageOpened();
        }
        if (!isPageOpenedIndicator) {
            throw new AssertionError("Page was not opened");
        }
    }
}
