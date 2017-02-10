package ru.ozon.steps;


import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.ozon.pageObject.AuthPageObject;
import utils.JsonParseUtils;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

/**
 * Created by azamat on 10.02.17.
 */


public class AuthSteps {

    private WebDriver driver;
    private String baseUrl = "https://www.ozon.ru/";
    AuthPageObject authPageObject = new AuthPageObject(driver);
    JsonParseUtils jsonParse = new JsonParseUtils();


    @Given("^I open ozon$")
    public void I_open_ozon() throws Throwable{
        try {
            jsonParse.jsonParseUtils();
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.get(baseUrl);
            driver.manage().window().setSize(new Dimension(1920,1080));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @And("^I click button with name Мой Ozon$")
    public void I_click_button_my_ozon() throws Throwable{
        try {
            Actions actions = new Actions(driver);
            actions
                    .moveToElement(driver.findElement(authPageObject.button_my_ozon))
                    .build()
                    .perform();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Given("^I click button with name Личный кабинет$")
    public void I_click_button_personal_study() throws Throwable{
        try{
        WebElement webElement = (new WebDriverWait(driver,6000))
                .until(ExpectedConditions.elementToBeClickable(authPageObject.button_personal_study));
            webElement.click();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @When("^I enter in field Мой логин: \"([^\"]*)\"$")
    public void I_enter_my_login(String login) throws Throwable{
        try{
            WebElement webElement = (new WebDriverWait(driver,6000))
                    .until(ExpectedConditions.visibilityOfElementLocated(authPageObject.input_my_login));
            webElement.sendKeys(login);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @And("^I enter in field Мой пароль: \"([^\"]*)\"$")
    public void I_enter_my_pass(String pass) throws Throwable{
        try{
            WebElement webElement = (new WebDriverWait(driver,6000))
                    .until(ExpectedConditions.visibilityOfElementLocated(authPageObject.input_my_password));
            webElement.sendKeys(pass);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @And("^I click button with name Продолжить$")
    public void I_click_button_continue() throws Throwable{
        try{
            WebElement webElement = (new WebDriverWait(driver,6000))
                    .until(ExpectedConditions.elementToBeClickable(authPageObject.button_continue));
            webElement.click();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Then("^I should be see account name \"([^\"]*)\"$")
    public void assert_account_name(String name) throws Throwable{
        try{
            assertEquals("Account name didnt show!",driver.findElement(authPageObject.assert_account_name).getText(),name);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @And("^I should be see personal study text \"([^\"]*)\"$")
    public void assert_text_personal_study(String text) throws  Throwable{
        try{
            assertEquals("Text personal study didnt show!",driver.findElement(authPageObject.assert_personal_study).getText(),text);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @And("^I should be see welcome text \"([^\"]*)\"$")
    public void assert_text_welcome(String text) throws Throwable{
        try {
            assertEquals("Text welcome didnot show!", driver.findElement(authPageObject.assert_welcome_text).getText(), text);
            driver.quit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @Given("^I click  button with name Вход$")
    public void I_click_button_enty() throws Throwable{
        try{
            WebElement webElement = (new WebDriverWait(driver,6000))
                    .until(ExpectedConditions.elementToBeClickable(authPageObject.button_enty));
            webElement.click();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @When("^I enter in field логин: \"([^\"]*)\"$")
    public void I_enter_login(String login) throws Throwable{
        try{
            WebElement webElement = (new WebDriverWait(driver,6000))
                    .until(ExpectedConditions.visibilityOfElementLocated(authPageObject.input_login));
            webElement.sendKeys(login);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @And("^I enter in field пароль: \"([^\"]*)\"$")
    public void I_enter_pass(String pass) throws Throwable{
        try{
            WebElement webElement = (new WebDriverWait(driver,6000))
                    .until(ExpectedConditions.visibilityOfElementLocated(authPageObject.input_password));
            webElement.sendKeys(pass);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @And("^I click button with name Войти$")
    public void I_click_button_auth() throws Throwable{
        try{
            WebElement webElement = (new WebDriverWait(driver,6000))
                    .until(ExpectedConditions.elementToBeClickable(authPageObject.button_continue));
            webElement.click();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @After
    public void tearDown() throws Throwable{
        driver.quit();
    }

}
