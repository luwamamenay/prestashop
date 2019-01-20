package com.prestashop.tests.smoke_tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AccountForPresta {
    WebDriver driver;

@BeforeMethod
    public void myAccount() {
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    driver.manage().window().fullscreen();
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    driver.get("http://automationpractice.com/index.php");

    WebElement signIn = driver.findElement(By.linkText("Sign in"));
    signIn.click();

    WebElement username = driver.findElement(By.id("email"));
    username.sendKeys("lu@gmail.com");

    WebElement password =driver.findElement(By.id("passwd"));
    password.sendKeys("password");

    WebElement clickSingIn =driver.findElement(By.id("SubmitLogin"));
    clickSingIn.click();

   // fullNameTop = driver.findElement(By.xpath("//a[@class='account']//span")).getText();



}
@Test
        public void myaccount(){

    WebElement myacc= driver.findElement(By.xpath("//span[@class='navigation_page']"));
   String actual = myacc.getText();
   String expected ="My account";

    System.out.println("acc"+actual+"exp"+expected);

    Assert.assertTrue(driver.getTitle().contains(expected));


    //5.Verify that account holder full name is displayed next to the Sign out link
  WebElement fullname = driver.findElement(By.xpath("//span[.='lu ame']"));
  String actualname= fullname.getText();

  String expectedname = "lu ame";

 Assert.assertEquals(actualname,expectedname);
    }

    @Test

    //6.Click on My personal informationbutton
    public void personalinfo() {
        WebElement persinfo = driver.findElement(By.xpath("//span[.='My personal information']"));
        persinfo.click();


        //7.Verify title contains Identity

        String expected = "Identity";
        Assert.assertTrue(driver.getTitle().contains(expected));


        //8.Verify thatfirst name and last name matches the full name on top

        WebElement firstname = driver.findElement(By.id("firstname"));
        String ffirstname = firstname.getAttribute("value");

        WebElement lastname = driver.findElement(By.id("lastname"));
        String llastname = lastname.getAttribute("value");

        String fullnamee = ffirstname + " " + llastname;


        WebElement fullname = driver.findElement(By.xpath("//span[.='lu ame']"));
        String actualname = fullname.getText();

        System.out.println(actualname + fullnamee);

        Assert.assertEquals(actualname, fullnamee);


        //.Click on Save button
        WebElement savebtn = driver.findElement(By.name("submitIdentity"));
        savebtn.click();


        // Verify error message “The password you entered is incorrect.”

        // WebElement invalidpsd = driver.findElement()




        WebElement actualerro =driver.findElement(By.xpath("//li[.='The password you entered is incorrect.']"));
        String actualerrormsg=actualerro.getText();
        String expectederrormsg ="The password you entered is incorrect.";

        System.out.println("act.err.msg"+actualerrormsg+"exp.err.msg"+expectederrormsg);

      Assert.assertEquals(actualerrormsg,expectederrormsg);


      //Click onBack to your account

        WebElement backtoaccount =driver.findElement(By.xpath("//i[@class='icon-chevron-left']"));
        backtoaccount.click();

        //Verify that titlecontainsMy account

        WebElement myAccount = driver.findElement(By.xpath("//span[@class='navigation_page']"));
        String actualAccount =myAccount.getText();

        String expectedAccount= "My account";
        Assert.assertEquals(actualAccount,expectedAccount);
    }



@Test
    public void myAdress(){
    //  click on my adress
    WebElement clickMyAdress = driver.findElement(By.xpath("//span[.='My addresses']"));
    clickMyAdress.click();

//Clickon Adda new address
    WebElement newAdress = driver.findElement(By.xpath("//span[.='Add a new address']"));
    newAdress.click();

    //Verify thatfirst name and last name matches the full name on top

    WebElement firstName =driver.findElement(By.id("firstname"));
    String firstName1=firstName.getAttribute("value");

    WebElement lastName =driver.findElement(By.id("lastname"));
    String lastName1 = lastName.getAttribute("value");

    String fullName1 = firstName1 +" "+ lastName1;

    WebElement fullname =driver.findElement(By.xpath("//span[.='lu ame']"));
    String fullName2 =fullname.getText();

    Assert.assertEquals(fullName1,fullName2);


    // delete first name

    firstName.clear();


    //Click save

    WebElement clicksave =driver.findElement(By.xpath("//button[@id='submitAddress']"));
    clicksave.click();

    //Verify error message “firstname is required.”

    WebElement firstNmaeReq =driver.findElement(By.xpath("//div[@class='alert alert-danger']//ol/li[1]"));
    String reqired = firstNmaeReq.getText();
     String expected ="firstname is required.";

     Assert.assertEquals(reqired,expected);

}




















}
