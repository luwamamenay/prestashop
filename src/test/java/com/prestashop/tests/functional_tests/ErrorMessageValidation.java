package com.prestashop.tests.functional_tests;

import com.prestashop.utilities.Testbase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class ErrorMessageValidation extends Testbase {


    @Test

    public void open() throws InterruptedException {
        driver= new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");

        WebElement signin =driver.findElement(By.xpath("//a[@class='login']"));
        signin.click();

        String email= fake.internet().emailAddress();

        driver.findElement(By.id("email_create")).sendKeys(email);
        WebElement element1 = driver.findElement(By.xpath("//*[@id='email']"));


        driver.findElement(By.cssSelector("#SubmitCreate")).click();

        Thread.sleep(1000);

        String lastname =fake.name().lastName();
        driver.findElement(By.id("customer_lastname")).sendKeys(lastname);

        String psd =fake.internet().password();
        driver.findElement(By.id("passwd")).sendKeys(psd);

       // driver.findElement(By.id("firstname")).sendKeys(namee);
        driver.findElement(By.id("lastname")).sendKeys(lastname);

        String adress =fake.address().streetAddress();
        driver.findElement(By.id("address1")).sendKeys(adress);

        String city = fake.address().city();
        driver.findElement(By.id("city")).sendKeys(city);

        String state =fake.address().state();
        driver.findElement(By.id("id_state")).sendKeys(state);

        String zipcode = fake.address().zipCode().substring(0,5);
        driver.findElement(By.id("postcode")).sendKeys(zipcode);

        String phonenu =fake.phoneNumber().cellPhone();
        driver.findElement(By.id("other")).sendKeys(phonenu);

        driver.findElement(By.id("submitAccount")).click();


        WebElement namerequired =driver.findElement(By.xpath("//b[.='firstname']"));
        System.out.println(namerequired.isDisplayed());

    }


}
