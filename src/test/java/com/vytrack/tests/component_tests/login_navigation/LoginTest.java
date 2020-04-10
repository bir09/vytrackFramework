package com.vytrack.tests.component_tests.login_navigation;

import com.vytrack.base.TestBase;
import com.vytrack.pages.LoginPage;
import com.vytrack.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginTest extends TestBase {
    //Login	test (positive)
    private String storeManagerUsername = ConfigurationReader.getProperty("store_manager_username");
    private String storeManagerPassword = ConfigurationReader.getProperty("store_manager_password");
    private String salesManagerUsername = ConfigurationReader.getProperty("sales_manager_username");
    private String salesManagerPassword = ConfigurationReader.getProperty("sales_manager_password");
    private String driverUsername = ConfigurationReader.getProperty("driver_username");
    private String driverPassword = ConfigurationReader.getProperty("driver_password");

    @Test
    public void test(){
        driver.get(ConfigurationReader.getProperty("url"));
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        LoginPage log = new LoginPage();
        //todo Login as a Store Manager
        log.login(storeManagerUsername, storeManagerPassword);
        wait.until(ExpectedConditions.titleIs("Dashboard"));
        String storeManagerFullName = getUsernameElement().getText();
        //todo Verify name of the store	manager is displayed on	top	right
        Assert.assertTrue(storeManagerFullName.contains(" ") && storeManagerFullName.length() > 1);
        //todo Verify Dashboard page is open
        Assert.assertEquals(getPageName().getText(), "Dashboard");
        logOut();
        //todo Login as a Sales Manager
        log.login(salesManagerUsername, salesManagerPassword);
        wait.until(ExpectedConditions.titleIs("Dashboard"));
        String salesManagerFullName = getUsernameElement().getText();
        //todo Verify that A different name	displayed on top right
        Assert.assertNotEquals(storeManagerFullName, salesManagerFullName);
        //todo Verify Dashboard page is open
        Assert.assertEquals(getPageName().getText(), "Dashboard");
        logOut();
        //todo Login as a Driver
        log.login(driverUsername, driverPassword);
        wait.until(ExpectedConditions.titleIs("Dashboard"));
        String driverFullName = getUsernameElement().getText();
        //todo Verify that A different name	displayed on top right
        Assert.assertNotEquals(driverFullName, salesManagerFullName);
        //todo Verify Quick Launchpad page is open
        Assert.assertEquals(getPageName().getText(), "Quick Launchpad");
    }

    private void logOut(){
        WebElement usernameDropdown = getUsernameElement();
        WebElement logOut = driver.findElement(By.xpath("//li[@class='last']/a[@class='no-hash']"));
        actions.moveToElement(usernameDropdown).pause(2000).click().moveToElement(logOut).click().build().perform();
    }
    private WebElement getPageName(){
        WebElement current = driver.findElement(By.xpath("//h1[@class='oro-subtitle']"));
        return  current;
    }
    private WebElement getUsernameElement(){
        return driver.findElement(By.cssSelector("#user-menu"));
    }

}
