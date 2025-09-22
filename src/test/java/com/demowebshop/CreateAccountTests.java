package com.demowebshop;

import com.demowebshop.utils.DataProviders;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CreateAccountTests extends TestBase{
    @BeforeMethod
    public void precondition() {
        if (!app.getUser().isLoginLinkPresent()) {
            app.getUser().clickOnSignOutButton();
        }
    }



    @Test(dataProvider = "newRegistrationData", dataProviderClass = DataProviders.class)
    public void newUserRegistrationPositive(String name, String lastName, String email, String password, String surePassword){
        app.getRegister().clickByRegister();
        app.getRegister().clickByRadio();
        app.getRegister().fillForm(name, lastName, email, password, surePassword);
        app.getRegister().clickByBtnRegister();
        Assert.assertTrue(app.getUser().isElementPresentCss("[href='/logout']"));
    }

    @Test(dataProvider = "registretionUserWithCSV", dataProviderClass = DataProviders.class)
    public void newUserRegistrationPositiveWithCSV(String name, String lastName, String email, String password, String surePassword){
        app.getRegister().clickByRegister();
        app.getRegister().clickByRadio();
        app.getRegister().fillForm(name, lastName, email, password, surePassword);
        app.getRegister().clickByBtnRegister();
        Assert.assertTrue(app.getUser().isElementPresentCss("[href='/logout']"));
    }

}
