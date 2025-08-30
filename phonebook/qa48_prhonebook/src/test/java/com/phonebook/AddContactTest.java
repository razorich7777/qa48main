package com.phonebook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class AddContactTest extends TestBase{
    //pre-condition login
    @BeforeMethod
    public void precondition(){
        click(By.cssSelector("[href='/login']"));

        //enter email
        type(By.name("email"), "sss@ss.com");

        //enter password
        type(By.name("password"), "Aa11111!");

        //click on Login button
        click(By.name("login"));
    }

    @Test
    public void addContactPositiveTest() {
        //click on link ADD
        click(By.cssSelector("[href='/add']"));
        //enter name
        type(By.cssSelector("input:nth-child(1)"), "Sergey");
        //enter lastname
        type(By.cssSelector("input:nth-child(2)"), "Perlov");
        //enter phone
        type(By.cssSelector("input:nth-child(3)"), "1234567890");
        //enter email
        type(By.cssSelector("input:nth-child(4)"), "Serius@gmail.com");
        //enter adress
        type(By.cssSelector("input:nth-child(5)"), "Tel Aviv");
        //enter description
        type(By.cssSelector("input:nth-child(6)"), "QA Manual");
        //click on SAVE button
        click(By.cssSelector(".add_form__2rsm2 button"));
        //verify contact is added
        Assert.assertTrue(isContactAdded("Sergey"));
    }

    private boolean isContactAdded(String name) {
        List<WebElement> contacts = driver.findElements(By.cssSelector("h2"));
        for (WebElement el: contacts){
            if (el.getText().contains(name))
                return true;
        }
        return false;
    }

    @AfterMethod
    public void postCondition(){
        driver.findElement(By.cssSelector(".contact-item_card__2SOIM")).click();
        driver.findElement(By.xpath("//button[.='Remove']")).click();
    }

}
