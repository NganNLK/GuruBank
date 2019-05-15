package pom;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreateCustomerPage {

    private WebDriver driver;

    public CreateCustomerPage(WebDriver driver) {
        this.driver = driver;
    }

    private static final By CUSTOMER_NAME = By.name("name");
    private static final By CUSTOMER_DOB = By.name("dob");
    private static final By CUSTOMER_ADDRESS = By.name("addr");
    private static final By CUSTOMER_CITY = By.name("city");
    private static final By CUSTOMER_STATE = By.name("state");
    private static final By CUSTOMER_PIN = By.name("pinno");
    private static final By CUSTOMER_PHONE = By.name("telephoneno");
    private static final By CUSTOMER_EMAIL = By.name("emailid");
    private static final By CUSTOMER_PASS = By.name("password");
    private static final By SUBMIT_BTN = By.name("sub");
    private static final By CREATED_NAME = By.xpath("//*[@id=\"customer\"]/tbody/tr[5]/td[2]");

    public void createCustomerSuccessful(String name, String dob, String addr, String city, String state, String pin, String phone, String email, String pass) {
        driver.findElement(CUSTOMER_NAME).sendKeys(name);
        driver.findElement(CUSTOMER_DOB).sendKeys(dob);
        driver.findElement(CUSTOMER_ADDRESS).sendKeys(addr);
        driver.findElement(CUSTOMER_CITY).sendKeys(city);
        driver.findElement(CUSTOMER_STATE).sendKeys(state);
        driver.findElement(CUSTOMER_PIN).sendKeys(pin);
        driver.findElement(CUSTOMER_PHONE).sendKeys(phone);
        driver.findElement(CUSTOMER_EMAIL).sendKeys(email);
        driver.findElement(CUSTOMER_PASS).sendKeys(pass);
        driver.findElement(SUBMIT_BTN).click();
        String actual = driver.findElement(CREATED_NAME).getText();
        Assert.assertEquals(name,actual);
    }
}
