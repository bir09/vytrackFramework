package com.vytrack.pages;

import com.vytrack.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public LoginPage() {
        // page object classes needs contructor. here we have to call the PageFactory.initElements
        // from selenium and pass a webdriver object and this class as param
        PageFactory.initElements(Driver.getDriver(), this);

    }
    @FindBy(id = "prependedInput")
    public WebElement username;

    @FindBy(id = "prependedInput2")
    public WebElement password;

    @FindBy(id = "_submit")
    public WebElement logIn;

    public void login(String username, String password){
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        logIn.click();
    }

}
