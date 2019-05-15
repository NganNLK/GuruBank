package pom;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreateAccountPage {

    private WebDriver driver;

    public CreateAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    private static final By CUSTOMER_ID= By.name("cusid");
    private static final By DEPOSIT = By.name("inideposit");
    private static final By SUBMIT_BTN = By.name("button2");
    private static final By NEW_ACCOUNT = By.cssSelector("a[href*=\"addAccount.php\"]");

    public void createAccountSuccessful(String id, String deposit) {
        driver.findElement(NEW_ACCOUNT).click();
        driver.findElement(CUSTOMER_ID).sendKeys(id);
        driver.findElement(DEPOSIT).sendKeys(deposit);
        driver.findElement(SUBMIT_BTN).click();
    }
}
