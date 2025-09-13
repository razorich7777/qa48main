package com.demowebshop.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterHelper extends BaseHelper{

    public RegisterHelper(WebDriver driver) {
        super(driver);
    }

    public void clickByBtnRegister() {
        clickByXPath("//input[@value='Register']");
    }

    public void fillForm(String name, String lastName, String email, String password, String surePassword) {
        type(By.cssSelector(".inputs:nth-child(2) > .text-box.single-line"), name);
        type(By.cssSelector(".inputs:nth-child(3) > .text-box.single-line"), lastName);
      //  int i = (int)((System.currentTimeMillis()/1000)%3600);
        type(By.cssSelector(".inputs:nth-child(4) > .text-box.single-line"), email);
        //password
        type(By.cssSelector(".inputs:nth-child(1) > .text-box.single-line"), password);
        type(By.xpath("//input[@id='ConfirmPassword']"), surePassword);
    }

    public void clickByRadio() {
        clickByXPath("//input[@type='radio'][@id='gender-male']");
    }

    public void clickByRegister() {
        clickByCss("[href='/register']");
    }


}
