package com.vytrack.tests.component_tests.fleet;

import com.vytrack.base.TestBase;
import com.vytrack.pages.LoginPage;
import com.vytrack.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class VehicleContractTest extends TestBase {

    LoginPage log;
    @BeforeMethod
    public void before(){
        driver.get(ConfigurationReader.getProperty("url"));
        log = new LoginPage();
    }
    @Test
    public void StoreManager(){
        String username = ConfigurationReader.getProperty("store_manager_username");
        String password = ConfigurationReader.getProperty("store_manager_password");
        log.login(username, password);
        clickVehicleContracts();
        try{
            getAlertElement();
            System.out.println("Store Manager Does NOT have an access for Vehicle Contracts");
            Assert.fail("No Access to Vehicle Contracts");
        }catch (NoSuchElementException e){
            System.out.println("Store Manager HAS an access for Vehicle Contracts");
        }
    }

    @Test
    public void SalesManager(){
        String username = ConfigurationReader.getProperty("sales_manager_username");
        String password = ConfigurationReader.getProperty("sales_manager_password");
        log.login(username, password);
        clickVehicleContracts();
        try{
            getAlertElement();
            System.out.println("Sales Manager Does NOT have an access for Vehicle Contracts");
            Assert.fail("No Access to Vehicle Contracts");
        }catch (NoSuchElementException e){
            System.out.println("Sales Manager HAS an access for Vehicle Contracts");
        }
    }

    @Test
    public void driverAccess(){
        String username = ConfigurationReader.getProperty("driver_username");
        String password = ConfigurationReader.getProperty("driver_password");
        log.login(username, password);
        clickVehicleContracts();
        try{
            getAlertElement();
            System.out.println("Driver Does NOT have an access for Vehicle Contracts");
            Assert.fail("No Access to Vehicle Contracts");
        }catch (NoSuchElementException e){
            System.out.println("Driver HAS an access for Vehicle Contracts");
        }
    }


    private void clickVehicleContracts(){
        wait.until(ExpectedConditions.titleIs("Dashboard"));
       // WebElement fleetButton = driver.findElement(By.xpath("//i[@*='fa-asterisk menu-icon']/.."));
        WebElement fleetButton = driver.findElement(By.xpath("//*[contains(text(),'Fleet')]/../span[@class='title title-level-1']"));
        WebElement vehicleContractsButton = driver.findElement(By.xpath("//span[@*='title title-level-2'][text()='Vehicle Contracts']"));
        wait.until(ExpectedConditions.visibilityOf(fleetButton));
        actions.moveToElement(fleetButton).pause(2000).moveToElement(vehicleContractsButton).click().build().perform();
        try{
            Thread.sleep(2000);
        }catch (InterruptedException e){}
    }

    private WebElement getAlertElement(){
        return driver.findElement(By.xpath("//div[@*='flash-messages-holder']/div[2]/div"));
    }

}
