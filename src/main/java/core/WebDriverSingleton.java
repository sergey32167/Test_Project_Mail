package core;

import org.openqa.selenium.WebDriver;

public class WebDriverSingleton {
    private static volatile WebDriver driver;

    public static synchronized WebDriver getDriverInstance() {
        if(driver == null){
         driver = BrowsersService.createDriver();
        }
        return driver;
    }

    public static synchronized void cleanCookies(){
        driver.manage().deleteAllCookies();
        driver.navigate().refresh();
    }

    public static synchronized void quit(){
        driver.quit();
        driver = null;
    }
}
