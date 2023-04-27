package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.Timestamp;
import java.util.concurrent.TimeUnit;

//import static java.awt.SystemColor.text;

public class CommunityPole {
    static String expectedCommunityPoleMsg = "Only registered users can vote";
    @BeforeMethod
    public static void openBrowser() {
        driver = new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/");
    }
    @AfterMethod
    public static void closeBrowser(){
        driver.close();
    }
    @Test
    public static void VerifyUserShouldBeAbleToPoleSuccessfully(){
        //click on good button
        clickOnElements(By.id("pollanswers-2"));
        //Click on vote button
        clickOnElements(By.id("block-poll-vote-error-1"));
        //Get text
        String actualMessage= getTextFromElement(By.className("poll-vote-error"));
        System.out.println("My message: "+actualMessage);
        //Click on poor button
        clickOnElements(By.id("vote-poll-1"));
        //grtText from webelement
        actualMessage = getTextFromElement(By.className("vote-poll-1"));
        System.out.println("<My message:"+actualMessage);

        Assert.assertEquals("Only registered users can vote","your vote for Good");
    }
    protected static WebDriver driver;
    //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    static Timestamp timestamp = new Timestamp(System.currentTimeMillis());
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
    public static long timestamp () {
        Timestamp timestamp1 = new Timestamp(System.currentTimeMillis());
        return timestamp1.getTime();
    }
        //type url

       //driver.findElement(By.id("block-poll-vote-error-1"));
       //For close the browser
       // driver.close();

        //Click on Poor button
        //driver.findElements(By.className("pollanswers-3")).click();
        //Click on vote
        //driver.findElements(By.xpath("//button[@id=\"vote-poll-1\"]")).click();
        //Show you error
       // driver.findElements(By.className("poll-vote-error")).getText();
       // System.out.println("Only registered users can vote");



    }

