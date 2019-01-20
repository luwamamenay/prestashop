package com.prestashop.pages;

import com.prestashop.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignIn {

    public SignIn() {
        PageFactory.initElements(Driver.getDriver(), this);

    }


      @FindBy(css="#email")
       public WebElement  email;

       @FindBy(css="#passwd")

        public WebElement password;

      @FindBy(css="#SubmitLogin")
      public WebElement login;


      @FindBy(xpath = "//span/i[@class='icon-chevron-left']")
      public WebElement home;
}
