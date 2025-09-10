package com.phonebook;

import com.phonebook.models.Contact;
import com.phonebook.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteContactTest extends TestBase{

    @BeforeMethod
    public void precondition(){
        if(!app.getUser().isLoginLinkPresent()){
            app.getUser().clickOnSignOutButton();
        }
        //precondition
        //login
        //-----------------------------------------------
        app.getUser().clickOnLoginLink();

        //enter email
        app.getUser().fillRegisterLoginForm(new User().setEmail("sss@ss.com").setPassword("Aa11111!"));

        //click on Login button
        app.getUser().clickOnLoginButton();


        //add
        //--------------------------------------------
        app.getContact().clickOnAddLink();
        //enter name
        app.getContact().fillContentForm(new Contact("Sergey", "Perlov", "1234567890", "Serius@gmail.com", "Tel Aviv", "QA Manual"));
        //click on SAVE button
        app.getContact().clickOnSaveButton();

    }

    @Test
    public void deleteContactTest(){
        int sizeBefore = app.getContact().sizeOfContacts();
        //click on the cart
        app.getContact().deleteContact();
        app.getContact().pause(1000);
        int sizeAfter = app.getContact().sizeOfContacts();
        Assert.assertEquals(sizeAfter,sizeBefore - 1);
        //click on Remove button
        //verify contact is deleted(by size)
    }

}
