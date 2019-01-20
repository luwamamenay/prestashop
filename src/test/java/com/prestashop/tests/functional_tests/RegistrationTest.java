package com.prestashop.tests.functional_tests;

import com.github.javafaker.Faker;
import com.prestashop.utilities.Testbase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class RegistrationTest extends Testbase {


    @Test
    public void open() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().fullscreen();

        // 2..Go to http://automationpractice.com/index.php
        driver.get("http://automationpractice.com/index.php");

        //3..Click Sign inlink

        driver.findElement(By.xpath("//a[@class='login']")).click();

        //4..Enter newvalidemail to the email field

        // Faker fake = new Faker();

        String email = fake.internet().emailAddress();


        driver.findElement(By.id("email_create")).sendKeys(email);

        //5..Click on Create Account

        driver.findElement(By.name("SubmitCreate")).click();

        //6..Verify that that email link displays currentemail

        System.out.println("long xpath | " + driver.findElement(By.xpath("//div[@class='account_creation']/div[4]//input")).getAttribute("value"));
        WebElement element1 = driver.findElement(By.xpath("//*[@id='email']"));

        String currentemail = element1.getAttribute("value");
        System.out.println(currentemail + " | " + element1.getText());

        Assert.assertEquals(email, currentemail);

        // Thread.sleep(1000);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        //7...Fill out all the required steps
        String name = fake.name().firstName();
        String lastname = fake.name().lastName();
        String psd = fake.internet().password();
        String fullname = name + " " + lastname;

        driver.findElement(By.xpath("//input[@id='customer_firstname']")).sendKeys(name);

        driver.findElement(By.id("customer_lastname")).sendKeys(lastname);


        driver.findElement(By.id("passwd")).sendKeys(psd);


        WebElement ele = driver.findElement(By.id("days"));
        ele.click();
        Select selsct = new Select(ele);

        selsct.selectByIndex(3);


        WebElement ele1 = driver.findElement(By.id("months"));
        ele.click();
        Select selsct1 = new Select(ele1);

        selsct1.selectByIndex(3);


        WebElement ele2 = driver.findElement(By.id("years"));
        ele.click();
        Select selsct2 = new Select(ele2);

        selsct2.selectByIndex(29);


        driver.findElement(By.id("firstname")).sendKeys(name);
        driver.findElement(By.id("lastname")).sendKeys(lastname);

        String adress = fake.address().streetAddress();
        driver.findElement(By.id("address1")).sendKeys(adress);

        String city = fake.address().city();
        driver.findElement(By.id("city")).sendKeys(city);

        String state = fake.address().state();
        driver.findElement(By.id("id_state")).sendKeys(state);

        String zipcode = fake.address().zipCode().substring(0, 5);
        driver.findElement(By.id("postcode")).sendKeys(zipcode);

        String phonenu = fake.phoneNumber().cellPhone();
        driver.findElement(By.id("other")).sendKeys(phonenu);
        driver.findElement(By.id("phone_mobile")).sendKeys("2027254564");


        //8..click on register
        driver.findElement(By.id("submitAccount")).click();

        //9..Verify that correct first and last name isdisplayedcorrectly on top right

        String actual = driver.findElement(By.xpath("//a[@class='account']/*")).getText();


        Assert.assertEquals(actual, fullname);

        //10..Click on My personal information
        WebElement pesonalinfo = driver.findElement(By.xpath("//span[.='My personal information']"));
        pesonalinfo.click();

        //11..Verify that personal information is displayedcorrectly

        // Thread.sleep(1000);
        String actualname = driver.findElement(By.xpath("(//div[@class='required form-group']/input)[1]")).getAttribute("value");
        System.out.println("actna" + actualname + "expecna" + name);
        Assert.assertEquals(actualname, name);


        String actuallastname = driver.findElement(By.xpath("(//input[@id='lastname'])[1]")).getAttribute("value");
        System.out.println("acclast" + actuallastname + "explast" + lastname);
        Assert.assertEquals(actuallastname, lastname);

        String actualemail = driver.findElement(By.cssSelector("#email")).getAttribute("value");
        Assert.assertEquals(actualemail, email);


        String curremail = driver.findElement(By.xpath("(//input[@id='old_passwd'])[1]")).getAttribute("value");
        System.out.println("curreem" + curremail + "exp" + psd);//this is supposed to fail since we dont have a current psd displayed

        //12..click on back to your account

        WebElement backtoacc = driver.findElement(By.xpath("(//a[@class='btn btn-default button button-small'])[2]"));
        backtoacc.click();

        //13..Click on My addresses verify that addressinformation is displayed correctly

        WebElement myadress = driver.findElement(By.xpath("//span[.='My addresses']"));
        myadress.click();

        String actadree = driver.findElement(By.xpath("//span[@class='address_address1']")).getText();
        Assert.assertEquals(actadree, adress);
        String acccity = driver.findElement(By.xpath("//ul[@class='last_item item box']/li[5]/span[1]")).getText();

        System.out.println("accci" + acccity + "city" + city);
        Assert.assertEquals(acccity.substring(0, acccity.length() - 1), city);

        String accstat = driver.findElement(By.xpath("//ul[@class='last_item item box']/li[5]/span[2]")).getText();
        Assert.assertEquals(accstat, state);

        String acczip = driver.findElement(By.xpath("//ul[@class='last_item item box']/li[5]/span[3]")).getText();
        Assert.assertEquals(acczip, zipcode);


        //Click onsign outlink

        WebElement signout = driver.findElement(By.xpath("//a[@class='logout']"));
        signout.click();

        //Login using the email and password if the current user
        driver.findElement(By.id("email")).sendKeys("luwam@gmail.com");
        driver.findElement(By.id("passwd")).sendKeys("password");
        driver.findElement(By.id("SubmitLogin")).click();

        //Verify that correct first and last name isdisplayedcorrectly on top right
        WebElement accctualnamed = driver.findElement(By.xpath("//span[.='lu ame']"));
        String namedisoplayed = accctualnamed.getText();
        String expecteddisplay = "lu ame";
        Assert.assertEquals(namedisoplayed, expecteddisplay);


    }

}
