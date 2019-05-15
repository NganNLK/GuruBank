package tests;

import com.fasterxml.jackson.databind.ObjectMapper;
import data.Data;
import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pom.*;

import java.io.File;
import java.io.IOException;

public class Deposit {

    private Data testData;
    private WebDriver driver;

    @BeforeMethod
    public void setUp() throws IOException {

        testData = getData();

        Driver chromeDriverForTest = new Driver();
        driver = chromeDriverForTest.getDriver();
    }

    @Test
    public void createDeposit() throws InterruptedException {
        //create customer
        driver.navigate().to(testData.getUrl());
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(testData.getUsername(), testData.getPassword());
        HomePage homePage = new HomePage(driver);
        homePage.clickCreateCustomer();
        CreateCustomerPage createCustomerPage = new CreateCustomerPage(driver);
        createCustomerPage.createCustomerSuccessful(testData.getName(), testData.getDob(), testData.getAddress(),
                testData.getCity(), testData.getState(), testData.getPin(), testData.getMobileNumber(),testData.getEmail(),
                testData.getPassword());

        Thread.sleep(9000);

        // create account
        String id = driver.findElement(By.xpath("//*[@id='customer']/tbody/tr[4]/td[2]")).getText();
        CreateAccountPage createAccount = new CreateAccountPage(driver);
        createAccount.createAccountSuccessful(id, testData.getDeposit());

        Thread.sleep(9000);

        //deposit
        String accId = driver.findElement(By.xpath("//*[@id='account']/tbody/tr[4]/td[2]")).getText();
        DepositPage deposit = new DepositPage(driver);
        deposit.setDeposit(accId, testData.getAmount(), testData.getDescription());
    }

    @AfterMethod
    public void endTest() {
        driver.quit();
    }

    private Data getData() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File(
                "/Users/ngannguyen/Desktop/NganQA-master/src/test/java/data/test.json"), Data.class);
    }
}
