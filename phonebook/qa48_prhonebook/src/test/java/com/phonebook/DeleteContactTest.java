package com.phonebook;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteContactTest extends TestBase{

    @BeforeMethod
    public void precondition(){
        //precondition
        //login
        //-----------------------------------------------
        click(By.cssSelector("[href='/login']"));

        //enter email
        type(By.name("email"), "sss@ss.com");

        //enter password
        type(By.name("password"), "Aa11111!");

        //click on Login button
        click(By.name("login"));


        //add
        //--------------------------------------------
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

    }

    @Test
    public void deleteContactTest(){
        int sizeBefore = sizeOfContacts();
        //click on the cart
        driver.findElement(By.cssSelector(".contact-item_card__2SOIM")).click();
        driver.findElement(By.xpath("//button[.='Remove']")).click();
        pause(1000);
        int sizeAfter = sizeOfContacts();
        Assert.assertEquals(sizeAfter,sizeBefore - 1);
        //click on Remove button
        //verify contact is deleted(by size)
    }
    public void pause(int millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public int sizeOfContacts() {
        if(isElementPresent(By.cssSelector(".contact-item_card__2SOIM"))){
            return driver.findElements(By.cssSelector(".contact-item_card__2SOIM")).size();
        }
        return 0;
    }
}
