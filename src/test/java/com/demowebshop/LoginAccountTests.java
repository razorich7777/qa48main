package com.demowebshop;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginAccountTests extends TestBase{
    @Test
    public void loginUserPositive(){
        click(By.cssSelector("[href='/login']"));
        type(By.xpath("//input[@name='Email']"), "Sssssssss@ss.com");
        type(By.xpath("//input[@name='Password']"), "Aa11111!");
        click(By.xpath("//input[@class='button-1 login-button']"));
        Assert.assertTrue(isElementPresent(By.cssSelector("[href='/logout']")));
    }
}
