package com.vytrack.tests.smoke_tests;

import com.vytrack.base.TestBase;
import com.vytrack.pages.LoginPage;
import com.vytrack.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class MenuOptionsTest extends TestBase {

    private String currentTitle;


    @Test
    public void asADriver() throws InterruptedException {
        driver.get(ConfigurationReader.getProperty("url"));
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        LoginPage loginPage = new LoginPage();
        String username = ConfigurationReader.getProperty("driver_username");
        String password = ConfigurationReader.getProperty("driver_password");
        loginPage.login(username, password);

        //TODO -> Navigate	to	Fleet -> Vehicles,	verify	page	title	Car	- Entities	- System	- Car	- Entities	-
        //todo -> System,	page	name	Cars
        WebElement fleetButton = driver.findElement(By.xpath("//span[@class='title title-level-1']"));
        WebElement vehiclesButton = driver.findElement(By.xpath("//span[@class='title title-level-2']"));
        wait.until(ExpectedConditions.visibilityOf(fleetButton));
        currentTitle = driver.getTitle();
        moveElementsWait(fleetButton, vehiclesButton, currentTitle);
        //verify title
        Assert.assertEquals(driver.getTitle(), "Car - Entities - System - Car - Entities - System");
        //verify page name
        WebElement pageName = getPageName();
        Assert.assertEquals(pageName.getText(), "Cars");


        //TODO ->  Navigate	to	Customers -> Accounts,	verify	page	title	Accounts	- Customers,	verify	page
        //todo -> name	Accounts
        WebElement customersButton = driver.findElement(By.xpath("//i[@class='fa-users menu-icon']/.."));
        WebElement accountsButton = driver.findElement(By.xpath("//li[@data-route='oro_account_index']/a/span"));
        currentTitle = driver.getTitle();
        moveElementsWait(customersButton, accountsButton, currentTitle);
        //verify Title
        Assert.assertEquals(driver.getTitle(), "Accounts - Customers");
        //verify page name
        WebElement pageName2 = getPageName();
        Assert.assertEquals(pageName2.getText(), "Accounts");

        //todo -> Navigate	to	Customers -> Contacts,	verify	page	title	Contacts - Customers,	verify	page	name
        //todo -> Contacts
        WebElement contactsButton = driver.findElement(By.xpath("//span[@class='title title-level-2'][text()='Contacts']"));
        currentTitle = driver.getTitle();
        moveElementsWait(customersButton, contactsButton, currentTitle);
        //verify title
        Assert.assertEquals(driver.getTitle(), "Contacts - Customers");
        //verify page name
        Assert.assertEquals(getPageName().getText(), "Contacts");


        //todo -> Navigate	to	Activities -> Calendar	Events,	verify	page	title	Calendar	Events	- Activities,	page
        //todo -> name	Calendar	Events
        WebElement activitiesButton = driver.findElement(By.xpath("//i[@class='fa-puzzle-piece menu-icon']/.."));
        WebElement calendarEventsButton = driver.findElement(By.xpath("//li[@data-route='oro_calendar_event_index']/a/span"));
        currentTitle = driver.getTitle();
        moveElementsWait(activitiesButton, calendarEventsButton, currentTitle);
        //verify title
        Assert.assertEquals(driver.getTitle(), "Calendar Events - Activities");
        //verify page name
        WebElement pageName3 = getPageName();
        Assert.assertEquals(pageName3.getText(), "Calendar Events");




    }

    @Test
    public void AsAManager() throws InterruptedException {
        driver.get(ConfigurationReader.getProperty("url"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        LoginPage page = new LoginPage();
        String username = ConfigurationReader.getProperty("store_manager_username");
        String password = ConfigurationReader.getProperty("store_manager_password");
        page.login(username, password);


        //todo -> Navigate	to	Dashboards -> Dashboard,	verify	page	title	Dashboard	- Dashboards,	verify
        //todo -> page	name	Dashboard
        WebElement dashboardsButton = driver.findElement(By.xpath("//span[@class='title title-level-1']"));
        WebElement dashboardButton = driver.findElement(By.xpath("//li[@data-route='oro_dashboard_view']/a/span"));
        wait.until(ExpectedConditions.visibilityOf(dashboardsButton));
        currentTitle = driver.getTitle();
        moveElementsWait(dashboardsButton, dashboardButton, currentTitle);
        //verify title
        Assert.assertEquals(driver.getTitle(), "Dashboard - Dashboards");
        //verify page name
        Assert.assertEquals(getPageName().getText(), "Dashboard");

        //todo -> Navigate	to	Fleet -> Vehicles,	verify	page	title	All	- Car	- Entities	- System	- Car	- Entities	-
        //todo -> System,	page	name	All	Cars
        WebElement fleetButton = driver.findElement(By.xpath("//i[@*='fa-asterisk menu-icon']/.."));
        WebElement vehiclesButton = driver.findElement(By.xpath("//span[@class='title title-level-2'][text()='Vehicles']"));
        currentTitle = driver.getTitle();
        moveElementsWait(fleetButton, vehiclesButton, currentTitle);
        //verify title
        Assert.assertEquals(driver.getTitle(), "All - Car - Entities - System - Car - Entities - System");
        //verify page name
        Assert.assertEquals(getPageName().getText(), "All Cars");

        //todo -> Navigate	to	Customers -> Accounts,	verify	page	title	All - Accounts	– Customers, verify
        //todo -> page	name	All	Accounts
        WebElement customersButton = driver.findElement(By.xpath("//i[@class='fa-users menu-icon']/.."));
        WebElement accountsButton = driver.findElement(By.xpath("//span[@class='title title-level-2'][text()='Accounts']"));
        currentTitle = driver.getTitle();
        moveElementsWait(customersButton, accountsButton, currentTitle);
        //verify title
        Assert.assertEquals(driver.getTitle(), "All - Accounts - Customers");
        //verify page name
        Assert.assertEquals(getPageName().getText(), "All Accounts");

        //todo -> Navigate	to	Customers -> Contacts,	verify	page	title	All - Contacts - Customers,	verify	page
        //todo -> name	All	Contacts
        WebElement contactsButton = driver.findElement(By.xpath("//span[@class='title title-level-2'][text()='Contacts']"));
        currentTitle = driver.getTitle();
        moveElementsWait(customersButton, contactsButton, currentTitle);
        //verify title
        Assert.assertEquals(driver.getTitle(), "All - Contacts - Customers");
        //verify pageName
        Assert.assertEquals(getPageName().getText(), "All Contacts");

        //todo -> Navigate	to	Sales -> Opportunities,	verify	page	title	Open	Opportunities	- Opportunities	-
        //todo -> Sales,	verify page	name	Open	Opportunities
        WebElement salesButton = driver.findElement(By.xpath("//i[@*='fa-shopping-cart menu-icon']/.."));
        WebElement opportunitiesButton = driver.findElement(By.xpath("//span[@class='title title-level-2'][text()='Opportunities']"));
        currentTitle = driver.getTitle();
        moveElementsWait(salesButton, opportunitiesButton, currentTitle);
        //verify Title
        Assert.assertEquals(driver.getTitle(), "Open Opportunities - Opportunities - Sales");
        //verify page name
        Assert.assertEquals(getPageName().getText(), "Open Opportunities");

        //todo -> Navigate	to	Activities -> Calls	verify	page	title	All	- Calls - Activities,	page	name	All	Calls
        WebElement activitiesButton = driver.findElement(By.xpath("//i[@*='fa-puzzle-piece menu-icon']/.."));
        WebElement callsButton = driver.findElement(By.xpath("//span[@class='title title-level-2'][text()='Calls']"));
        currentTitle = driver.getTitle();
        moveElementsWait(activitiesButton, callsButton, currentTitle);
        //verify title
        Assert.assertEquals(driver.getTitle(), "All - Calls - Activities");
        //verify page name
        Assert.assertEquals(getPageName().getText(), "All Calls");

        //todo -> Navigate	to	Activities -> Calendar	Events,	verify	page	title	Calendar	Events	- Activities,	page
        //todo -> name	All	Calendar	Events
        WebElement calendarEventsButton = driver.findElement(By.xpath("//span[@class='title title-level-2'][text()='Calendar Events']"));
        currentTitle = driver.getTitle();
        moveElementsWait(activitiesButton, calendarEventsButton, currentTitle);
        //verify Title
        Assert.assertEquals(driver.getTitle(), "All - Calendar Events - Activities");
        //verify Page name
        Assert.assertEquals(getPageName().getText(), "All Calendar Events");




    }


    private WebElement getPageName(){
        WebElement current = driver.findElement(By.xpath("//h1[@class='oro-subtitle']"));
        return  current;
    }

    private void moveElementsWait(WebElement fromElement, WebElement toElement, String currentTitle) throws InterruptedException {
        actions.moveToElement(fromElement).pause(2000).moveToElement(toElement).click().build().perform();
        wait.until(ExpectedConditions.not(ExpectedConditions.titleIs(currentTitle)));
        Thread.sleep(2000);
    }

}
