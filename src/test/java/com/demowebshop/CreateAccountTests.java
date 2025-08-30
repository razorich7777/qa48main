package com.demowebshop;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase{

    @Test
    public void newUserRegistrationPositive(){
        click(By.cssSelector("[href='/register']"));
        click(By.xpath("//input[@type='radio'][@id='gender-male']"));
        type(By.cssSelector(".inputs:nth-child(2) > .text-box.single-line"), "Sergey");
        type(By.cssSelector(".inputs:nth-child(3) > .text-box.single-line"), "Perlov");
        int i = (int)((System.currentTimeMillis()/1000)%3600);
        type(By.cssSelector(".inputs:nth-child(4) > .text-box.single-line"), "Sssssssss" + i + "@ss.com");
        //password
        type(By.cssSelector(".inputs:nth-child(1) > .text-box.single-line"), "Aa11111!");
        type(By.xpath("//input[@id='ConfirmPassword']"), "Aa11111!");
        click(By.xpath("//input[@value='Register']"));
        Assert.assertTrue(isElementPresent(By.cssSelector("[href='/logout']")));
    }
}
