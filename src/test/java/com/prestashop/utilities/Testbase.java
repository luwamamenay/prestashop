package com.prestashop.utilities;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public abstract class Testbase {

protected WebDriver driver;
protected WebElement element;
protected Faker fake;
protected Actions actions;
protected Random random;
    public static void verifyTextMatches(String s1, String s2){
        Assert.assertTrue(s1.equals(s2));

    }

    public static void verifyTextContains(String s1 , String s2){

        Assert.assertTrue(s1.contains(s2));
    }



   @BeforeClass
    public void setUp(){



       driver =Driver.getDriver();
       actions = new Actions(driver);
        random = new Random();
}

   @BeforeMethod
    public void openBrowser(){
        driver.get("http://automationpractice.com/index.php");
       driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
       fake = new Faker();
   }





    @AfterMethod
    public void tearDown(){

     //   driver.quit();
    }


    public static void clickMe(WebDriver driver, String xpath){
      Actions  actions = new Actions(driver);
      actions.moveToElement(driver.findElement(By.xpath(xpath))).click().perform();

    }




}
