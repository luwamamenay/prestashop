package com.prestashop.tests;

import com.prestashop.utilities.Testbase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class WONegativeLoginTests extends Testbase {

@Test
    public void negativeLoginTest2(){
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        String actual= driver.getTitle();
        String expected = "Web Orders Login";

        verifyTextMatches(actual,expected);

        String actualUrl = driver.getCurrentUrl();
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Test");
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("Test");
        driver.findElement(By.id("ctl00_MainContent_login_button")).click();





        String  expectedUrl = driver.getCurrentUrl();
        verifyTextMatches(actualUrl,expectedUrl);


    }

    @Test

    public void negativeLoginTest3(){

        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        String actual= driver.getTitle();
        String expected = "Web Orders Login";

        verifyTextMatches(actual,expected);

        String actualUrl = driver.getCurrentUrl();
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("Tester");
        driver.findElement(By.id("ctl00_MainContent_login_button")).click();





        String  expectedUrl = driver.getCurrentUrl();
        verifyTextMatches(actualUrl,expectedUrl);

    }


    @Test

    public void negativeLoginTest4(){

        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        String actual= driver.getTitle();
        String expected = "Web Orders Login";

        verifyTextMatches(actual,expected);

        String actualUrl = driver.getCurrentUrl();

        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("Tester");
        driver.findElement(By.id("ctl00_MainContent_login_button")).click();





        String  expectedUrl = driver.getCurrentUrl();
        verifyTextMatches(actualUrl,expectedUrl);



    }
    @Test
    public void negativeLoginTest5(){
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        String actual= driver.getTitle();
        String expected = "Web Orders Login";

        verifyTextMatches(actual,expected);

        String actualUrl = driver.getCurrentUrl();
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");

        driver.findElement(By.id("ctl00_MainContent_login_button")).click();





        String  expectedUrl = driver.getCurrentUrl();
        verifyTextMatches(actualUrl,expectedUrl);



    }





}
