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

    public void fillForm() {
        type(By.cssSelector(".inputs:nth-child(2) > .text-box.single-line"), "Sergey");
        type(By.cssSelector(".inputs:nth-child(3) > .text-box.single-line"), "Perlov");
        int i = (int)((System.currentTimeMillis()/1000)%3600);
        type(By.cssSelector(".inputs:nth-child(4) > .text-box.single-line"), "Sssssssss" + i + "@ss.com");
        //password
        type(By.cssSelector(".inputs:nth-child(1) > .text-box.single-line"), "Aa11111!");
        type(By.xpath("//input[@id='ConfirmPassword']"), "Aa11111!");
    }

    public void clickByRadio() {
        clickByXPath("//input[@type='radio'][@id='gender-male']");
    }

    public void clickByRegister() {
        clickByCss("[href='/register']");
    }


}
