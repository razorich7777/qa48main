package com.phonebook;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase{
    @Test(enabled = false)
    public void newUserRegistrationPositive(){
        int i = (int)((System.currentTimeMillis()/1000)%3600);
        //click on login link
        clinOnLoginLink();
        //enter email
        fillRegisterLoginForm(new User().setEmail("sss" + i + "@ss.com").setPassword("Aa11111!"));
        //click on registration button
        clickOnRegistrationButton();
        //verify singout is displayed
        Assert.assertTrue(isSignOutPresent());
    }

    @Test
    public void existedUserRegistrationNegativeTest(){
        //click on login link
        clinOnLoginLink();
        //enter email
        fillRegisterLoginForm(new User().setEmail("sss@ss.com").setPassword("Aa11111!"));


        //click on registration button
        clickOnRegistrationButton();

        //verify alert is displayed
        Assert.assertTrue(isAlertDisplayed());
    }

}
