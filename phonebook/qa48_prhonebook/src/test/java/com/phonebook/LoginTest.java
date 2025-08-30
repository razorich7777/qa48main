package com.phonebook;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest  extends TestBase{
    @Test
    public void loginPositiveTest(){

        //click on login link
        click(By.cssSelector("[href='/login']"));

        //enter email
        type(By.name("email"), "sss@ss.com");

        //enter password
        type(By.name("password"), "Aa11111!");

        //click on Login button
        click(By.name("login"));

        Assert.assertTrue(isElementPresent(By.xpath("//*[.='Sign Out']")));
    }
}
