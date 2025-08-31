package com.phonebook;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteContactTest extends TestBase{

    @BeforeMethod
    public void precondition(){
        //precondition
        //login
        //-----------------------------------------------
        clinOnLoginLink();

        //enter email
        fillRegisterLoginForm(new User().setEmail("sss@ss.com").setPassword("Aa11111!"));

        //click on Login button
        clickOnLoginButton();


        //add
        //--------------------------------------------
        clickOnAddLink();
        //enter name
        fillContentForm(new Contact("Sergey", "Perlov", "1234567890", "Serius@gmail.com", "Tel Aviv", "QA Manual"));
        //click on SAVE button
        clickOnSaveButton();

    }

    @Test
    public void deleteContactTest(){
        int sizeBefore = sizeOfContacts();
        //click on the cart
        deleteContact();
        pause(1000);
        int sizeAfter = sizeOfContacts();
        Assert.assertEquals(sizeAfter,sizeBefore - 1);
        //click on Remove button
        //verify contact is deleted(by size)
    }

}
