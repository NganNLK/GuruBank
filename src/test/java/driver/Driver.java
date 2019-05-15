package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {
    public WebDriver getDriver() {
        System.setProperty("webdriver.chrome.driver", "/Users/ngannguyen/Desktop/NganQA-master/src/test/java/driver/chromedriver");
        return new ChromeDriver();
    }
}
