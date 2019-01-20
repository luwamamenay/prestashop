package com.prestashop.tests.functional_tests;

import com.prestashop.pages.*;
import com.prestashop.utilities.Testbase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartLoginP3 extends Testbase {

    HomePage homepage = new HomePage();
    Frames frams = new Frames();
    SignIn sign =new SignIn();
    SignOut signout = new SignOut();
    Products products = new Products();
    @Test

    public void cartlogin() throws Exception{
        homepage.printedDress_1.click();
        frams.switchFrame(driver);
        frams.addToCart.click();
        Thread.sleep(2000);
        String productName = frams.productName.getAttribute("innerText").trim();
        frams.continueShopping_button.click();

        actions.moveToElement(homepage.hoveroverCart).perform();
        String cartName =homepage.nameOfproduct.getAttribute("title").trim();
        System.out.println(productName+" | "+homepage.nameOfproduct.getAttribute("title"));
        Assert.assertTrue(productName.equals(cartName));

        homepage.signInLink.click();
        sign.email.sendKeys("lu@gmail.com");
        sign.password.sendKeys("password");
        sign.login.click();

        Thread.sleep(1000);

        actions.moveToElement(homepage.hoveroverCart).perform();
        String cartNamee =homepage.nameOfproduct.getAttribute("title").trim();
        System.out.println(productName+" | "+homepage.nameOfproduct.getAttribute("title"));
        Assert.assertTrue(productName.equals(cartNamee));

    }
@Test
    public void cartLogOut() throws InterruptedException {

    homepage.signInLink.click();
    sign.email.sendKeys("lu@gmail.com");
    sign.password.sendKeys("password");
    sign.login.click();
    sign.home.click();

    homepage.printedDress_2.click();
    frams.switchFrame(driver);
    frams.addToCart.click();
    Thread.sleep(2000);
    String productName = frams.productName.getAttribute("innerText").trim();
    frams.continueShopping_button.click();

    actions.moveToElement(homepage.hoveroverCart).perform();
    String cartName =homepage.nameOfproduct.getAttribute("title").trim();
    System.out.println(productName+" | "+homepage.nameOfproduct.getAttribute("title"));
    Assert.assertTrue(productName.equals(cartName));

    signout.signout.click();

    signout.empty.isDisplayed();


}


@Test
    public void cartIconDelete() throws InterruptedException {
    homepage.printedDress_2.click();
    frams.switchFrame(driver);
    frams.addToCart.click();
    Thread.sleep(2000);
    String productName = frams.productName.getAttribute("innerText").trim();
    frams.continueShopping_button.click();
    actions.moveToElement(homepage.hoveroverCart).perform();
    frams.deleteProduct.click();

    signout.empty.isDisplayed();

}

@Test
    public void cartCheckOutDelete() throws InterruptedException {
    homepage.printedDress_1.click();
    frams.switchFrame(driver);
    frams.addToCart.click();
    Thread.sleep(1000);
    String productName = frams.productName.getAttribute("innerText").trim();
    frams.continueShopping_button.click();

    homepage.printedDress_2.click();
    frams.switchFrame(driver);
    frams.addToCart.click();
    Thread.sleep(1000);
    frams.proceedToCheckout_button.click();
    String pronumber =driver.findElement(By.xpath("//div[@id='center_column']/h1/span")).getAttribute("innerText");
    //System.out.println( products.numberOfProducts.getAttribute("innerText"));
    Assert.assertTrue(pronumber.equals("Your shopping cart contains: 2 Products"));

    Thread.sleep(1000);
    actions.moveToElement(homepage.hoveroverCart).perform();
    frams.deleteProduct1.click();

    Thread.sleep(1000);
    String pronum=driver.findElement(By.xpath("//div[@id='center_column']/h1/span")).getAttribute("innerText");

    Assert.assertTrue(pronum.equals("Your shopping cart contains: 1 Product"));


    actions.moveToElement(homepage.hoveroverCart).perform();
    frams.deleteProduct2.click();


    Thread.sleep(1000);
    String empty =driver.findElement(By.xpath("//p[@class='alert alert-warning']")).getAttribute("innerText");
   Assert.assertTrue(empty.equals("Your shopping cart is empty."));


}

}
