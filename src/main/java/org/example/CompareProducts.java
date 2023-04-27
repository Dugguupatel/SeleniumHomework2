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

public class CompareProducts {
    static String expectedRegistrationCompleteMsg = "Registration is Completed";
    @BeforeMethod
    public static void openBrowser(){
        driver = new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/");
    }
    @AfterMethod
    public static void closeBrowser(){
       // driver.close();
    }
    @Test
    public static void compareproducts(){

    }
    @Test
    public static void verifyuserShouldBeAbleToCompareProductsSuccessfully(){
        //Click on compare button
        clickOnElements(By.xpath("//button[@class=\"button-2 add-to-compare-list-button\"]"));
        //Click omn compare button
        clickOnElements(By.xpath("//button[@class=\"button-2 add-to-compare-list-button\"]"));
        //getText for compared products
        String actualMessage = getTesxFromElement(By.className("content"));
        System.out.println("My message: "+actualMessage);
        //click on Product compare button
        clickOnElements(By.id("product comparison"));
        //Click on remove sign
        clickOnElements(By.className("remove-product"));
        //Click on remove sign
        clickOnElements(By.className("remove-product"));
        //getText
        actualMessage = getTesxFromElement(By.className("no-data"));
        System.out.println("My message:"+actualMessage);

        Assert.assertEquals("The product has been added to your ","Products not compared");

    }
    protected static WebDriver driver;
     //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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
   // public static void main(String[] args) {

        //type url
        //Click on compare button of

        //driver.findElement(By.xpath("//button[@class=\"button-2 add-to-compare-list-button\"]")).click();
        //Click on "Virtual Gift Card"

       //driver.findElement(By.xpath("\"//button[@class=\\\"button-2 add-to-compare-list-button\\\"")).click();
        //Notification //driver.findElement(By.className("content")).getText();

        //Click on compare products notification

        //driver.findElement()).click();
        //You can see your products comparision
        //Click on remove mark

        //driver.findElement(By.className("remove-product")).click();
        //click on remove mark

       //driver.findElement(By.className("remove-product")).click();
        //you can get text
       //driver.findElement(By.className("no-data")).getText();

    }

