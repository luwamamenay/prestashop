package com.prestashop.pages;

import com.prestashop.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Frames {
    public Frames(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


  @FindBy(xpath = "//iframe[@class='fancybox-iframe']")
   public WebElement iframs;
    public void switchFrame(WebDriver driver){
        driver.switchTo().frame(iframs);
    }


    @FindBy(xpath = "//span[.='Add to cart']")
    public WebElement addToCart;

    @FindBy(xpath = "//span[.='Add to cart']")
    public WebElement addToCart_button;

    @FindBy(className = "fancybox-iframe")
    public WebElement iframe;
    @FindBy(xpath = "//div[@class='button-container']/span")
    public WebElement continueShopping_button;

    @FindBy(xpath = "//div[@class='button-container']/a")
    public WebElement proceedToCheckout_button;

    @FindBy(xpath = "//div[@class='layer_cart_product_info']/span")
    public WebElement productName;


    @FindBy(xpath = "//span[@class='remove_link']//a")
    public WebElement deleteProduct;


   @FindBy(xpath = "(//span[@class='remove_link']/a)[1]")
   public  WebElement deleteProduct1;

    @FindBy(xpath = "(//span[@class='remove_link']/a)[2]")
    public  WebElement deleteProduct2;

//    @FindBy(xpath = "//p[@class='alert alert-warning']")
//    public WebElement shoppingcartEmpty;
}
