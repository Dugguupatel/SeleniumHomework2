package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.Timestamp;

public class Check_ShoppingCart {
    static String expextedCheckShoppingCartComplete = "The product has been added to your Cart";
    @BeforeMethod
    public static void openBrowser(){
        driver = new ChromeDriver();
        //type url
        driver.get("https://demo.nopcommerce.com/");
    }
    @AfterMethod
    public static void closeBrowser(){
        driver.close();
    }
    @Test
    public static void verifyUsershouldAbleToGetProductsInShoppingCart(){
        //Click on Electronics
        clickOnElements(By.name("Electronis"));
        //Click on camera
        clickOnElements(By.className("Camera & photo "));
        //Click on Leica T Digital Camera
        clickOnElements(By.className("product-item"));
        //Enter Products Quantity
        typetext(By.id("product_enteredQuantity_16"), "nos");
        //Click on Add to cart
        clickOnElements(By.id("add to cart"));
        //Get Text The product has been added to your
        String actualMessage =  getTextFromElement(By.className("content"));
        System.out.println("My massage:"+ actualMessage);

        Assert.assertEquals("The product has been added to your Cart", "Your products added successfully");

    }

    protected static WebDriver driver;
    public  static void clickOnElements(By by){
        driver.findElement(by).click();
    }
    public static void typetext(By by, String text){
        driver.findElement(by).sendKeys(text);
    }
    public static String getTextFromElement(By by) {
        String actualMessage = driver.findElement(by).getText();
        return actualMessage;
    }
    public static long timestamp (){
        Timestamp timestamp1= new  Timestamp (System.currentTimeMillis());
        return timestamp1.getTime();
    }
    static Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    //driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
  //  public static void main(String[] args) {



        //driver.findElement(By.name("Electronis")).click();


        //driver.findElement(By.className("Camera & photo ")).click();


        //driver.findElement(By.className("product-item")).click();


        //driver.findElement(By.id("product_enteredQuantity_16")).sendKeys("text");


        //driver.findElement(By.id("add to cart")).click();


        //driver.findElement(By.className("content")).getText();



        //driver.findElement(By.className("ico-cart")).isDisplayed();


    }


