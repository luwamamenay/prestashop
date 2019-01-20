package com.prestashop.pages;

import com.prestashop.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignOut {
    public SignOut (){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "(//div[@class='header_user_info']/a)[2]")
    public WebElement signout;

    @FindBy(xpath = "(//div[@class='shopping_cart']//span)[5]")

    public WebElement empty;
}
