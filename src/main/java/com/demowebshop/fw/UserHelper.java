package com.demowebshop.fw;

import com.demowebshop.models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserHelper extends BaseHelper{

    public UserHelper(WebDriver driver) {
        super(driver);
    }
    public void fillFormRegistration(User user) {
        type(By.xpath("//input[@name='Email']"), user.getName());
        type(By.xpath("//input[@name='Password']"), user.getPassword());
    }
}
