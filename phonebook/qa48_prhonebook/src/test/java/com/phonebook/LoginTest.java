package com.phonebook;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest  extends TestBase{
    @Test
    public void loginPositiveTest(){

        //click on login link
        clinOnLoginLink();

        //enter email
        fillRegisterLoginForm(new User().setEmail("sss@ss.com").setPassword("Aa11111!"));

        //click on Login button
        clickOnLoginButton();

        Assert.assertTrue(isSignOutPresent());
    }@Test
    public void loginNegativeWithoutMailTest(){

        //click on login link
        clinOnLoginLink();

        //enter email
        fillRegisterLoginForm(new User().setPassword("Aa11111!"));

        //click on Login button
        clickOnLoginButton();

        Assert.assertTrue(isAlertDisplayed());
    }

}
