package com.phonebook;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase{
    @Test(enabled = false)
    public void newUserRegistrationPositive(){
        int i = (int)((System.currentTimeMillis()/1000)%3600);
        //click on login link
        click(By.cssSelector("[href='/login']"));
        //enter email
        type(By.name("email"), "sss" + i + "@ss.com");

        //enter password
        type(By.name("password"), "Aa11111!");


        //click on registration button
        click(By.name("registration"));

        //verify singout is displayed
        Assert.assertTrue(isElementPresent(By.xpath("//*[.='Sign Out']")));
    }

    @Test
    public void existedUserRegistrationNegativeTest(){
        //click on login link
        click(By.cssSelector("[href='/login']"));
        //enter email
        type(By.name("email"), "sss@ss.com");

        //enter password
        type(By.name("password"), "Aa11111!");


        //click on registration button
        click(By.name("registration"));

        //verify alert is displayed
        Assert.assertTrue(isAlertDisplayed());
    }

}
