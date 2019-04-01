package com.yourcompany.tests;

import com.yourcompany.Pages.InventoryPage;
import com.yourcompany.Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseWebDriverTest {
    @Test(dataProvider = "sauceBrowsers")
    public void loginTestValid2(String browser, String browserVersion, String platformName, RunType runType) {
        this.createDriver(browser, browserVersion, platformName, "loginTest", runType);
        LoginPage loginPage = new LoginPage(getWebDriver());
        InventoryPage inventoryPage = new InventoryPage(getWebDriver());
        loginPage.visitPage();
        loginPage.login("standard_user", "secret_sauce");
        Assert.assertTrue(inventoryPage.isOnPage());
    }

    @Test(dataProvider = "sauceBrowsers")
    public void loginTestInvalid(String browser, String browserVersion, String platformName, RunType runType) {
        this.createDriver(browser, browserVersion, platformName, "loginTest", runType);
        LoginPage loginPage = new LoginPage(getWebDriver());
        loginPage.visitPage();
        loginPage.login("invalid_user", "secret_sauce");
        Assert.assertTrue(loginPage.isOnPage());
    }
}