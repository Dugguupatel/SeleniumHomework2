package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.Timestamp;
import java.util.concurrent.TimeUnit;

public class Email_A_Friend {
    static String expextedEmailAFriendMsg = "Email to friend";
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
public static void verifyUserShouldBeAbleToSendEmailToFriendSuccessfully(){
        //Click on Products
     clickOnElements(By.className("Add to cart of Apple MacBook Pro 13-inch"));
     //Click on Email a friend button
     clickOnElements(By.className("email-a-friend-button)"));
     //Type your email
     typetext((By.name("Email")),"test1email"+timestamp1()+"@gmail.com");
     //Type friend's email
     typetext((By.name("Email")),"test2email"+timestamp1()+"@gmail.com");
     //Type msg for friend
     typetext((By.id("PersonalMessage")),"Hello");
     //Click on Send email button
     clickOnElements(By.name("send-email"));
     //GetText from webelement
     String actualMessage = getTextFromElement(By.linkText("Only registered customers can use email a friend feature"));
     //show error
     System.out.println("My massage:" + actualMessage);

     Assert.assertEquals("Only registered customers can use email a friend feature","you have sent succesfully");


}
    protected static WebDriver driver;

    public static void clickOnElements(By by){
        driver.findElement(by).click();
    }
    public static void typetext(By by, String text){
        driver.findElement(by).sendKeys(text);
    }
    public static String getTextFromElement(By by) {
        String actualMessage = driver.findElement(by).getText();
        return actualMessage;
    }
    public static long timestamp1 () {
        Timestamp timestamp1 = new Timestamp (System.currentTimeMillis());
        return timestamp1.getTime();




            //type url

            //Click on Add to cart of Apple MacBook Pro 13-inch
            //driver.findElement(By.className("")).click();

            //Click on Email a friend

            //driver.findElement(By.className("email-a-friend-button)")).click();
            //Enter friend's email

            //driver.findElement(By.name("Email")).sendKeys("test1email" + timestamp1.getTime() + "@gmail.com");
            //Enter your Email

            //driver.findElement(By.name("Email")).sendKeys("test2email" + timestamp1.getTime() + "@gmail.com");
            //Enter personal message

            //driver.findElement(By.id("PersonalMessage")).click();
            //Click on Send Email button

            //driver.findElement(By.name("send-email")).click();

            //Gettext from Web element

        }
    }
//<button type="button" class="button-2 product-box-add-to-cart-button" >Add to cart</button>
// Failed to execute 'evaluate' on 'Document': The string '//div[@class="Add to cart"])' is not a valid XPath expression.