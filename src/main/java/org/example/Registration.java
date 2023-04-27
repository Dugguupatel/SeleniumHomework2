package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.Timestamp;

public class Registration {
    static String expectedRegistrationCompleteMsg = "Registration is Completed";
    @BeforeMethod
    public static void openBrowser(){
        driver = new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/");
    }
    @AfterMethod
    public static void closeBrowser(){
        driver.close();
    }
    // @Test public static void compareproducts(){

    // }
    @Test
    public static void verifyuserShouldBeAbleToRegisterSuccessfully(){
        //click on register button
        clickOnElements(By.className("ico-register"));
        //Type first name
        typetext(By.id("FirstName"), "TestFirstName");
        //Type Last name
        typetext(By.id("LastName"), "testLastName");
        //Type Email address
        typetext((By.name("Email")), "ap21"+timestamp()+"@gmail.com");
        //type password
        typetext(By.id("Password"), "Test10234");
        //Type confirm password
        typetext(By.id("ConfirmPassword"),"Test10234");
        //click on Register submit button
        clickOnElements(By.id("register-button"));
        //use should loged in
        //gettext from webelement
        String actualMessage = getTesxFromElement(By.xpath("//div[@class='result']"));
        System.out.println("My massage:"+actualMessage);
        //Close URL

        Assert.assertEquals("Registration is Completed","Thanks for Registratiom");

    }
    protected static WebDriver driver;
    public  static void clickOnElements(By by){
        driver.findElement(by).click();
    }
    public static void typetext(By by, String text){
        driver.findElement(by).sendKeys(text);
    }
    public static String getTesxFromElement(By by) {
        String actualMessage = driver.findElement(by).getText();
        return actualMessage;
    }
    public static long timestamp (){
        Timestamp timestamp1= new  Timestamp (System.currentTimeMillis());
        return timestamp1.getTime();
    }


}

