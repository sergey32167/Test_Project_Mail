package core;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;


public class BrowsersService {
    private static  ReadProperties properties;
    private static Browsers browser;

    public BrowsersService(ReadProperties properties) {
        this.properties = properties;
    }

    public static WebDriver createDriver() {
        String browserName = properties.getBrowserName();
        browser = Browsers.getBrowser(browserName);
        switch (browser) {
            case CHROME:
                WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setHeadless(properties.isHeadless());
                chromeOptions.addArguments("--start-fullscreen");
                return new ChromeDriver(chromeOptions);

            case FIREFOX:
                WebDriverManager.getInstance(DriverManagerType.FIREFOX).setup();
                return new FirefoxDriver();

            default:
                throw new RuntimeException("Browser " + browserName + " is not supported.");
        }
    }
}