package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DepositPage {

    private WebDriver driver;

    public DepositPage(WebDriver driver) {
        this.driver = driver;
    }

    private static final By ACCOUNT_NUMBER = By.name("accountno");
    private static final By AMOUNT = By.name("ammount");
    private static final By DESCRIPTION = By.name("desc");
    private static final By SUBMIT_BTN = By.name("AccSubmit");
    private static final By DEPOSIT = By.cssSelector("a[href*=\"DepositInput.php\"]");

    public void setDeposit(String accno, String amount, String desc) throws InterruptedException {
        Thread.sleep(9000);
        driver.findElement(DEPOSIT).click();
        driver.findElement(ACCOUNT_NUMBER).sendKeys(accno);
        driver.findElement(AMOUNT).sendKeys(amount);
        driver.findElement(DESCRIPTION).sendKeys(desc);
        driver.findElement(SUBMIT_BTN).click();
    }
}
