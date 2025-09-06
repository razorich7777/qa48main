package com.phonebook;

import com.phonebook.models.User;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest  extends TestBase{
    @Test
    public void loginPositiveTest(){

        //click on login link
        app.getUser().clickOnLoginLink();

        //enter email
        app.getUser().fillRegisterLoginForm(new User().setEmail("sss@ss.com").setPassword("Aa11111!"));

        //click on Login button
        app.getUser().clickOnLoginButton();

        Assert.assertTrue(app.getUser().isSignOutPresent());
    }@Test
    public void loginNegativeWithoutMailTest(){

        //click on login link
        app.getUser().clickOnLoginLink();

        //enter email
        app.getUser().fillRegisterLoginForm(new User().setPassword("Aa11111!"));

        //click on Login button
        app.getUser().clickOnLoginButton();

        Assert.assertTrue(app.getUser().isAlertDisplayed());
    }

}
