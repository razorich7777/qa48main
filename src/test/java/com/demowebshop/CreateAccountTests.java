package com.demowebshop;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase{

    @Test
    public void newUserRegistrationPositive(){
        app.getRegister().clickByRegister();
        app.getRegister().clickByRadio();
        app.getRegister().fillForm();
        app.getRegister().clickByBtnRegister();
        Assert.assertTrue(app.getUser().isElementPresentCss("[href='/logout']"));
    }

}
