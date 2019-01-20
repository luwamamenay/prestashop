package com.prestashop.tests;

import com.prestashop.utilities.Testbase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PositiveLoginTests  extends Testbase {



    @Test

    public void openBrowser(){
        driver= new ChromeDriver();
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");


        //3.Verify title equals “Web Orders Login”
        String actual = driver.getTitle();
        String expected = "Web Orders Login";
        Assert.assertEquals(actual,expected);

        //4.Enter username “Tester”

       driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");

       //Enter password “test”
       driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
       //6.Click on Login button
       driver.findElement(By.id("ctl00_MainContent_login_button")).click();

      //Verify title equals “Web Orders”
       driver.findElement(By.xpath("//h1[.='Web Orders']"));
       String actualtitle =driver.getTitle();
       String exoectedtitle = "Web Orders";

       Assert.assertEquals(actualtitle,exoectedtitle);


    //Verify url equals http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx


        String actualUrl =driver.getCurrentUrl();
        String expectedUrl ="http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx";

        Assert.assertEquals(actualUrl,expectedUrl);//fails the test it doesnt match





    }





}
