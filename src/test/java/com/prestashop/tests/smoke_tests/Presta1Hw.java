package com.prestashop.tests.smoke_tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Presta1Hw {

    WebDriver driver;
    WebElement product;
    WebElement price;
    String productName;
    String productprice;

    @BeforeMethod
    public void openBroswer() {
        //1.Go to http://automationpractice.com/index.php
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        product = driver.findElement(By.linkText("Printed Dress"));
        productName = product.getText();
        price = driver.findElement(By.xpath("(//span[@class='price product-price'])[6]"));
        productprice = price.getText();

    }

    @Test

    public void shop() {
        product.click();
        // WebElement productHomPage = driver.findElement(By.xpath("(//a[@class='product-name'])[3]"));
        //productHomPage.getText();

        //3.Verify that same name and price displayed as on the home page

        WebElement productfterClick = driver.findElement(By.xpath("//h1[.='Printed Dress']"));

        String productafter = productfterClick.getText();

        Assert.assertEquals(productName, productafter);

        //price

        WebElement priceafterclick = driver.findElement(By.id("our_price_display"));

        String priceafter = priceafterclick.getText();

        Assert.assertEquals(priceafter, productprice);

    }

    //4.that default quantity is 1
    @Test
    public void quantity() {
        product.click();
        WebElement qty = driver.findElement(By.id("quantity_wanted"));
        //qty.getText();
        String expectedqty = "1";
        String actulqty = qty.getAttribute("value");
        Assert.assertEquals(actulqty, expectedqty);

    }
    //5.Verify that defaultsize is S

    @Test
    public void getsize() {
        product.click();
        WebElement size = driver.findElement(By.id("group_1"));

        Select select = new Select(size);
        String actualsize = "S";
        String expectedsize = select.getFirstSelectedOption().getText();

        Assert.assertEquals(actualsize, expectedsize);


        //6.Verify that size options are S, M, L

        List<String> expectedopt = new ArrayList<String>();
        expectedopt.add("S");
        expectedopt.add("M");
        expectedopt.add("L");

        List<WebElement> actualopt = select.getOptions();

        for (int i = 0; i <actualopt.size() ; i++) {

            System.out.println("act"+actualopt.get(i).getText()+"exp"+expectedopt.get(i));

        }

    }


    @Test
    //7.Click on Add to cart
    public void addCart() {
      product.click();

      WebElement cart = driver.findElement(By.xpath("//span[.='Add to cart']"));
          cart.click();


    //8.Verify confirmation message “Product successfully added to your shopping cart”
     String expectedMessage = "Product successfully added to your shopping cart";

        WebElement confirmationMsg= driver.findElement(By.xpath("//div[@class='layer_cart_product col-xs-12 col-md-6']//h2"));
           confirmationMsg.click();
     String actualMsg= confirmationMsg.getText();
     Assert.assertEquals(actualMsg,expectedMessage);


         WebElement qtyafteradd = driver.findElement(By.id("layer_cart_product_quantity"));
           String actualqtyafter = qtyafteradd.getText();
           String expectedqtyfter = "1";
        //System.out.println("act"+actualqtyafter +"exp"+expectedqtyfter);
           Assert.assertEquals(expectedqtyfter,actualqtyafter);


           //Verify that defaultsize is S

        WebElement sizeafter = driver.findElement(By.id("layer_cart_product_attributes"));
        String actualizeAfter = sizeafter.getText();

        String expectedasizeaafter = "S";

        System.out.println("act"+actualizeAfter.substring(actualizeAfter.indexOf(","))+"exp"+expectedasizeaafter);
        
         //Verify that same name and price displayed as on the home page



         WebElement nameatcart =driver.findElement(By.xpath("//span[@id='layer_cart_product_title']")) ;
         String name=  nameatcart.getText();

       // System.out.println("name after "+name);

        Assert.assertEquals(name,productName);

        WebElement priceafter =driver.findElement(By.xpath("//span[@id='layer_cart_product_price']"));
        String priceatcart = priceafter.getText();
        System.out.println("prichomepage"+productprice +"priceat cart"+ priceatcart);

        Assert.assertEquals(priceatcart,productprice);


    }

     @AfterMethod
        public void tearDown () throws InterruptedException {
            Thread.sleep(3000);
            driver.quit();
        }
    
}





        
        























