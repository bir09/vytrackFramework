package com.vytrack.base;

import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {
    protected WebDriver driver;
    protected Actions actions;
    protected WebDriverWait wait;
    @BeforeMethod
    public void setup(){
        driver = Driver.getDriver();
        actions = new Actions(driver);
        wait = new WebDriverWait(driver, 5);
    }

    @AfterMethod
    public void teardown(){
        Driver.closeDriver();
    }
}
