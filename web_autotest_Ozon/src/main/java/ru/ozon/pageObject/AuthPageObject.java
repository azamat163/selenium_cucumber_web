package ru.ozon.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.By;
/**
 * Created by azamat on 10.02.17.
 */
public class AuthPageObject {
  private  WebDriver driver;

   public AuthPageObject (WebDriver driver){
       this.driver = driver;
   }

    public By button_my_ozon = By.xpath("//span[text() = 'Мой OZON']/parent::*");

    public By button_personal_study = By.xpath("//div[@href = '/context/my/']");

    public By input_my_login = By.xpath("//input[@id = 'Login']");

    public By input_my_password = By.xpath("//input[@id = 'Passw']");

    public By button_continue = By.xpath("//input[@id = 'Authentication']/parent::*");

    public By assert_account_name = By.xpath("//span[text() = 'Test']");

    public By assert_personal_study = By.xpath("//h1[text() = 'Личный кабинет']");

    public By assert_welcome_text = By.xpath("//div[text() = 'Мы рады вам, ']");

    public By button_enty = By.xpath("(//span[@class = 'ePanelLinks_count']/parent::*)[4]");

    public By input_login = By.xpath("//input[@id = 'jsLogin']");

    public By input_password = By.xpath("//input[@id = 'jsPassword']");



    public void click_button(By element){
       driver.findElement(element).click();
    }

    public void enter_field(By element, String text){
       driver.findElement(element).sendKeys(text);
    }

}
