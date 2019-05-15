package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    private static final By CREATE_NEW_CUSTOMER = By.cssSelector("a[href^=\"addcustomerpage.php\"]");

    public void clickCreateCustomer() {
        driver.findElement(CREATE_NEW_CUSTOMER).click();
    }
}
