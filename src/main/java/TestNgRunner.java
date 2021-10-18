import core.BrowsersService;
import core.ReadProperties;
import core.WebDriverSingleton;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.*;

@CucumberOptions(
        features = {"src/test/resources/features"},
        glue = {"steps"},
        plugin =
                {
                        "html:target/cucumber-html-report.html",
                        "html:target/cucumber-reports/cucumber-pretty.html",
                        "json:target/cucumber-json-report/cucumber.json",
                },
        tags = ""
)

public class TestNgRunner extends AbstractTestNGCucumberTests {
    protected final Logger logger = LogManager.getLogger(this);

    @AfterMethod
    public void cleanCookies(){ WebDriverSingleton. cleanCookies(); }

    @AfterSuite
    public void closeBrowser() {
        WebDriverSingleton.quit();
        logger.info("Закрытие браузера");
    }
}
