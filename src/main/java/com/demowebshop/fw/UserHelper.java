package com.demowebshop.fw;

import com.demowebshop.models.User;
import com.google.common.io.Files;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class UserHelper extends BaseHelper{

    public UserHelper(WebDriver driver) {
        super(driver);
    }
    public void fillFormRegistration(User user) {
        type(By.xpath("//input[@name='Email']"), user.getName());
        type(By.xpath("//input[@name='Password']"), user.getPassword());
    }

    public String takeScreenshot() {
        File tmp = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File screenshot = new File("screenshots/screen-" + System.currentTimeMillis() + ".png");
        try {
            Files.copy(tmp, screenshot);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return screenshot.getAbsolutePath();
    }
}
