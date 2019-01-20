package com.prestashop.tests.functional_tests;

import com.prestashop.utilities.Testbase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class CartDetails  extends Testbase {


  @Test
  public void productNotOnSale() throws InterruptedException {
      driver.get("http://automationpractice.com/index.php");

      driver.findElement(By.xpath("(//img[@class='replace-2x img-responsive'])[2]")).click();
      WebElement iframe = driver.findElement(By.xpath("//iframe[@class='fancybox-iframe']"));
      driver.switchTo().frame(iframe);
      WebElement quantity1 = driver.findElement(By.xpath("//a[@class='btn btn-default button-plus product_quantity_up']"));
      int qa = random.nextInt(3) + 1;
            for (int i = 0; i <= qa; i++) {
                 clickMe(driver, "(//p[@id='quantity_wanted_p']/a)[2]");
      }
      WebElement size = driver.findElement(By.id("group_1"));
      Select sizes = new Select(size);
      sizes.selectByIndex((Math.random() <= 0.5) ? 1 : 2);


      driver.findElement(By.id("add_to_cart")).click();

      String actual=driver.findElement(By.xpath("(//div[@class='layer_cart_product col-xs-12 col-md-6'])//h2")).getText();
      String expected ="Product successfully added to your shopping cart";
      Assert.assertEquals(actual,expected);


      driver.findElement(By.xpath("//span[@class='cross']")).click();

      driver.findElement(By.xpath("(//div[@id='header_logo'])//a")).click();
      System.out.println("clicking logo");


      //Click on any productthat isonsale

      driver.findElement(By.xpath("(//img[@class='replace-2x img-responsive'])[5]")).click();
      WebElement iframee = driver.findElement(By.xpath("//iframe[@class='fancybox-iframe']"));
      driver.switchTo().frame(iframee);
      //Enter a random quantity between 2and 5
      Thread.sleep(100);

      //WebElement quantity2 =driver.findElement(By.xpath("//a[@class='btn btn-default button-plus product_quantity_up']"));


      int qa2 =random.nextInt(3)+1;
      for (int i = 0; i <= qa2; i++) {
          clickMe(driver,"(//p[@id='quantity_wanted_p']/a)[2]");

      }
      Thread.sleep(100);
      WebElement size2 = driver.findElement(By.id("group_1"));
      Select sizes2 = new Select(size2);
      sizes2.selectByIndex((Math.random() <= 0.5) ? 1 : 2);



      driver.findElement(By.id("add_to_cart")).click();

      String actual1=driver.findElement(By.xpath("(//div[@class='layer_cart_product col-xs-12 col-md-6'])//h2")).getText();
      String expected1 ="Product successfully added to your shopping cart";
      Assert.assertEquals(actual1,expected1);


      driver.findElement(By.xpath("//span[@class='cross']")).click();


      WebElement hoverover =driver.findElement(By.xpath("//div[@class='shopping_cart']//b"));

      actions.moveToElement(hoverover).perform();

      driver.findElement(By.xpath("(//div[@class='cart-prices-line last-line']//span)[1]")).isDisplayed();
      driver.findElement(By.xpath("(//div[@class='cart-prices-line first-line']//span)[1]")).isDisplayed();

  }
}
