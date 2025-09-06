package com.demowebshop;

import com.demowebshop.models.User;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginAccountTests extends TestBase{
    @Test
    public void loginUserPositive(){
        app.getUser().clickByCss("[href='/login']");
        app.getUser().fillFormRegistration( new User( "Sssssssss@ss.com", "Aa11111!"));
        app.getUser().clickByXPath("//input[@class='button-1 login-button']");
        Assert.assertTrue(app.getUser().isElementPresentCss("[href='/logout']"));
    }
}
