package com.vytrack.tests.component_tests.login_navigation;

import com.vytrack.base.TestBase;
import com.vytrack.pages.LoginPage;
import com.vytrack.utilities.ConfigurationReader;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest_negative extends TestBase {

    @Test
    public void test() throws InterruptedException {
        driver.get(ConfigurationReader.getProperty("url"));
        String expectedUrl = driver.getCurrentUrl();
        String expectedTitle = driver.getTitle();
        LoginPage log = new LoginPage();
        //todo Sign In using Valid username and Invalid password
        log.login(ConfigurationReader.getProperty("driver_username"), "incorrectPassword");
        Thread.sleep(1000);
        //todo Verify that alert is Displayed
        boolean alertMessage = log.incorrectAlert.isDisplayed();
        Assert.assertTrue(alertMessage);
        //todo Verify alert message
        Assert.assertEquals(log.incorrectAlert.getText(), "Invalid user name or password.");
        //todo Verify URL remained same
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);
        //todo Verify Title remained same
        Assert.assertEquals(driver.getTitle(), expectedTitle);
    }
}
