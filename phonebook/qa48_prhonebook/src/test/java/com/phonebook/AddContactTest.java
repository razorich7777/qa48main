package com.phonebook;

import com.phonebook.models.Contact;
import com.phonebook.models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddContactTest extends TestBase{
    //pre-condition login
    @BeforeMethod
    public void precondition(){
        if(!app.getUser().isLoginLinkPresent()){
            app.getUser().clickOnSignOutButton();
        }
        app.getUser().clickOnLoginLink();

        //enter email
        app.getUser().fillRegisterLoginForm(new User().setEmail("sss@ss.com").setPassword("Aa11111!"));

        //click on Login button
        app.getUser().clickOnLoginButton();
    }

    @Test
    public void addContactPositiveTest() {
        //click on link ADD
        app.getContact().clickOnAddLink();
        //enter name
        app.getContact().fillContentForm(new Contact("Sergey", "Perlov", "1234567890", "Serius@gmail.com", "Tel Aviv", "QA Manual"));
        //click on SAVE button
        app.getContact().clickOnSaveButton();
        //verify contact is added
        Assert.assertTrue(app.getContact().isContactAdded("Sergey"));
    }

    @AfterMethod
    public void postCondition(){
        app.getContact().deleteContact();
    }

}
