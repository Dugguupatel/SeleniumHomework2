package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.Timestamp;

public class Refer_A_Product_to_friend {

    static String expextedReferAProductToFriendCompleteMsg = "Your message has been sent.";
    @BeforeMethod
    public static void openBrowser(){
        driver = new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/");
    }
    @AfterMethod
    public static void closeBrowser(){
        driver.close();
    }
    @Test
    public static void registeredUserShouldBeAbleToReferAProductToAfriend() {
       //click on register button
        clickOnElements(By.className("ico-register"));
        //Type first name
        typetext(By.id("FirstName"),"harry");
        //Type Last name
        typetext(By.id("LastName"),"potter");
        //Type Email address
        typetext(By.name("Email"),"abcd12345"+timestamp()+"@gmail.com");
        //type password
        typetext(By.id("Password"),"1234567");
        //Type confirm password
        typetext(By.id("ConfirmPassword"),"1234567");
        //click on Register submit button
        clickOnElements(By.id("register-button"));
        //use should loged in
        //gettext from webelement
        String actualMessage = getTestFromElement(By.className("Your registration completed)"));
        System.out.println("My massage:"+actualMessage);

//Click on log in
        clickOnElements(By.className("ico-login"));
        //Type Email
        typetext(By.xpath("//input[@class='email']"),"abcd12345"+timestamp()+"@gmail.com");
        //Type password
        typetext(By.xpath("//input[@class='password']"),"1234567");
        //Click on Log in
        clickOnElements(By.xpath("//button[@class=button-1 login-button]"));
        //Click on Build your own computer
        clickOnElements(By.className("product-title"));
        //click on Email a friend
        clickOnElements(By.className("Email a friend"));
        //Type friends email
        typetext(By.className("Enter friend's email."), "xyzabc6789"+timestamp()+"@gmail.com");
        //Type your email;
        typetext(By.className("Enter your email address."),"abcd12345"+timestamp()+"@gmail.com");
        //Type personal message
        typetext(By.className("Enter personal message (optional)"),"Hello");
        //Click on Send email button
        clickOnElements(By.name("send-email"));
        //GetText
        actualMessage = getTestFromElement(By.className("Your message has been sent)"));
        System.out.println("My massage:"+actualMessage);

        Assert.assertEquals("Registration is Completed","Thanks for Registratiom");
        //Close URL
    }
        protected static WebDriver driver;

        public static void clickOnElements (By by){
            driver.findElement(by).click();
        }

        public static void typetext (By by, String text){
            driver.findElement(by).sendKeys(text);
        }

        public static String getTestFromElement(By by){
            String actualMessage = driver.findElement(by).getText();
            return actualMessage;
        }

        public static long timestamp () {
            Timestamp timestamp1 = new Timestamp(System.currentTimeMillis());
            return timestamp1.getTime();
        }





    }
