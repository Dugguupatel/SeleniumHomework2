package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.Timestamp;

import static org.example.CommunityPole.getTextFromElement;

public class RegisterUser_AbleTo_Vote {
    static String expectedRegistrationCompleteMsg = "Registered User Able to vote";
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
 public static void registeredUserShouldBeAbleToVoteSuccessfully(){
    //Click on log in
    clickOnElements(By.className("ico-login"));
    //Type Email
    typetext(By.xpath("//input[@class='email']"),"abcd12345"+timestamp()+"@gmail.com");
    //Type password
    typetext(By.xpath("//input[@class='password']"),"1234567");
    //Click on Log in button
    clickOnElements(By.xpath("//button[@class=button-1 login-button]"));
    //click on good button
    clickOnElements(By.id("pollanswers-2"));
    //Click on vote button
    clickOnElements(By.id("block-poll-vote-error-1"));
    //Click on poor button
    clickOnElements(By.id("vote-poll-1"));
    //grtText from webelement
    String actualMessage = getTextFromElement(By.className("vote-poll-1"));
    System.out.println("My message:"+actualMessage);

    Assert.assertEquals("Your voting for","vote for");

 }
    protected static WebDriver driver;
    public  static void clickOnElements(By by){
        driver.findElement(by).click();
    }
    public static void typetext(By by, String text){
        driver.findElement(by).sendKeys(text);
    }
    public static String getTestFromElement(By by) {
        String actualMessage = driver.findElement(by).getText();
        return actualMessage;
    }
    public static long timestamp (){
        Timestamp timestamp1= new  Timestamp (System.currentTimeMillis());
        return timestamp1.getTime();
    }
}
