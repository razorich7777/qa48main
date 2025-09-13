package com.demowebshop;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CreateAccountTests extends TestBase{
    @BeforeMethod
    public void precondition() {
        if (!app.getUser().isLoginLinkPresent()) {
            app.getUser().clickOnSignOutButton();
        }
    }

    @DataProvider
    public Iterator<Object[]> newRegistrationData(){
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"Oliver", "Kan", "kan656@gmail.com", "Aa11111!", "Aa11111!"});
        list.add(new Object[]{"Sergey", "Perlov", "sergius656@gmail.com", "Aa95111!", "Aa95111!"});
        list.add(new Object[]{"Alex", "Man", "aman656@gmail.com", "Aa16611!", "Aa16611!"});
        return list.iterator();
    }

    @Test(dataProvider = "newRegistrationData")
    public void newUserRegistrationPositive(String name, String lastName, String email, String password, String surePassword){
        app.getRegister().clickByRegister();
        app.getRegister().clickByRadio();
        app.getRegister().fillForm(name, lastName, email, password, surePassword);
        app.getRegister().clickByBtnRegister();
        Assert.assertTrue(app.getUser().isElementPresentCss("[href='/logout']"));
    }

}
