package com.phonebook;

import com.phonebook.models.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CreateAccountTests extends TestBase{
    SoftAssert sf = new SoftAssert();
    @Test(enabled = false)
    public void newUserRegistrationPositive(){
        int i = (int)((System.currentTimeMillis()/1000)%3600);
        //click on login link
        app.getUser().clickOnLoginLink();
        //enter email
        app.getUser().fillRegisterLoginForm(new User().setEmail("sss" + i + "@ss.com").setPassword("Aa11111!"));
        //click on registration button
        app.getUser().clickOnRegistrationButton();
        //verify singout is displayed
        Assert.assertTrue(app.getUser().isSignOutPresent());
    }

    @Test
    public void existedUserRegistrationNegativeTest(){
        //click on login link
        app.getUser().clickOnLoginLink();
        //enter email
        app.getUser().fillRegisterLoginForm(new User().setEmail("sss@ss.com").setPassword("Aa11111!"));


        //click on registration button
        app.getUser().clickOnRegistrationButton();

        //verify alert is displayed
        sf.assertTrue(app.getUser().isAlertDisplayed());
        sf.assertTrue(app.getUser().isErrorDisplayed());

    }


}
