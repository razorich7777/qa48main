package com.demowebshop;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase{
    @BeforeMethod
    public void precondition() {
        if (!app.getUser().isLoginLinkPresent()) {
            app.getUser().clickOnSignOutButton();
        }
    }
    @Test
    public void newUserRegistrationPositive(){
        app.getRegister().clickByRegister();
        app.getRegister().clickByRadio();
        app.getRegister().fillForm();
        app.getRegister().clickByBtnRegister();
        Assert.assertTrue(app.getUser().isElementPresentCss("[href='/logout']"));
    }

}
