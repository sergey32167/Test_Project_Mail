package elements;

import core.BrowsersService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class DropDownMenu {
    private List<WebElement> options = new ArrayList<>();
    private WebDriver driver;

    public DropDownMenu(WebDriver driver, By by) {
        this.driver = driver;

        for (WebElement element : driver.findElements(by)) {
            options.add(element);
        }
    }
        public void selectByName(String name) {
            for (WebElement element : options) {
                String textValue = element.getText();
                if (textValue.equalsIgnoreCase(name)) {
                    element.click();
                    break;
                }
            }
        }
}
