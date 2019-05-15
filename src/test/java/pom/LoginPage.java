package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertEquals;

public class LoginPage {

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private static final By USERNAME_BY = By.name("uid");
    private static final By PASSWORD_BY = By.name("password");
    private static final By LOGIN_BUTTON_BY = By.name("btnLogin");


    public void login(String username, String password) {
        driver.findElement(USERNAME_BY).sendKeys(username);
        driver.findElement(PASSWORD_BY).sendKeys(password);
        driver.findElement(LOGIN_BUTTON_BY).click();
    }
}
