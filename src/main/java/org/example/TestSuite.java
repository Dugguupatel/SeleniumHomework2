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

public class TestSuite {
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
    public static void verifyuserShouldBeAbleToRegisterSuccessfully(){
        //click on register button
        clickOnElements(By.className("ico-register"));
        //Type first name
        typetext(By.id("FirstName"), "harry");
        //Type Last name
        typetext(By.id("LastName"), "potter");
        //Type Email address
        typetext((By.name("Email")), "abcd12345"+timestamp()+"@gmail.com");
        //type password
        typetext(By.id("Password"), "1234567");
        //Type confirm password
        typetext(By.id("ConfirmPassword"),"1234567");
        //click on Register submit button
        clickOnElements(By.id("register-button"));
        //use should loged in
        //gettext from webelement
        String actualMessage = getTestFromElement((By.xpath("//div[@class='result']")));
        System.out.println("My massage:"+actualMessage);
        //Close URL
        Assert.assertEquals("Registration is Completed","Thanks for Registratiom");
    }
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
    public static void verifyUserShouldBeAbleToSendEmailToFriendSuccessfully() {
        //Click on Products
        clickOnElements(By.className("Add to cart of Apple MacBook Pro 13-inch"));
        //Click on Email a friend button
        clickOnElements(By.className("email-a-friend-button)"));
        //Type your email
        typetext((By.name("Email")), "test1email" + timestamp() + "@gmail.com");
        //Type friend's email
        typetext((By.name("Email")), "test2email" + timestamp() + "@gmail.com");
        //Type msg for friend
        typetext((By.id("PersonalMessage")), "Hello");
        //Click on Send email button
        clickOnElements(By.name("send-email"));
        //GetText from webelement
        String actualMessage = getTextFromElement(By.linkText("Only registered customers can use email a friend feature"));
        //show error
        System.out.println("My massage:" + actualMessage);

        Assert.assertEquals("Only registered customers can use email a friend feature", "you have sent succesfully");
    }
    public static void verifyuserShouldBeAbleToCompareProductsSuccessfully(){
        //Click on compare button
        clickOnElements(By.xpath("//button[@class=\"button-2 add-to-compare-list-button\"]"));
        //Click omn compare button
        clickOnElements(By.xpath("//button[@class=\"button-2 add-to-compare-list-button\"]"));
        //getText for compared products
        String actualMessage = getTextFromElement(By.className("content"));
        System.out.println("My message: "+actualMessage);
        //click on Product compare button
        clickOnElements(By.id("product comparison"));
        //Click on remove sign
        clickOnElements(By.className("remove-product"));
        //Click on remove sign
        clickOnElements(By.className("remove-product"));
        //getText
        actualMessage = getTextFromElement(By.className("no-data"));
        System.out.println("My message:"+actualMessage);

        Assert.assertEquals("The product has been added to your ","Products not compared");

    }
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
    public static void registeredUserShouldBeAbleToReferAProductToAfriend() {
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
        String actualMessage = getTestFromElement(By.className("Your message has been sent)"));
        System.out.println("My massage:"+actualMessage);

        Assert.assertEquals("Registration is Completed","Thanks for Registratiom");
        //Close URL
    }
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
