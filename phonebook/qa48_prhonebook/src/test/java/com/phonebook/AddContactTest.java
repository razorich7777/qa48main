package com.phonebook;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddContactTest extends TestBase{
    //pre-condition login
    @BeforeMethod
    public void precondition(){
        clinOnLoginLink();

        //enter email
        fillRegisterLoginForm(new User().setEmail("sss@ss.com").setPassword("Aa11111!"));

        //click on Login button
        clickOnLoginButton();
    }

    @Test
    public void addContactPositiveTest() {
        //click on link ADD
        clickOnAddLink();
        //enter name
        fillContentForm(new Contact("Sergey", "Perlov", "1234567890", "Serius@gmail.com", "Tel Aviv", "QA Manual"));
        //click on SAVE button
        clickOnSaveButton();
        //verify contact is added
        Assert.assertTrue(isContactAdded("Sergey"));
    }

    @AfterMethod
    public void postCondition(){
        deleteContact();
    }

}
