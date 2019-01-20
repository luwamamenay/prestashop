package com.prestashop.pages;

import com.prestashop.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {


    public HomePage() {
        PageFactory.initElements(Driver.getDriver(), this);

    }

    @FindBy(xpath = "//a[@class='login']")
    public WebElement signInLink;

    @FindBy(xpath = "(//a[@class='product_img_link']/img)[3]")
    public WebElement printedDress_1;


    @FindBy(xpath = "//div[@class='shopping_cart']/a")
    public WebElement hoveroverCart;


    @FindBy(xpath = "//div[@class='product-name']/a")
    public WebElement nameOfproduct;

    @FindBy(xpath = "(//a[@class='product_img_link']/img)[4]")
    public WebElement printedDress_2;


}
