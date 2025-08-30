package com.demowebshop;

import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteProduct extends TestBase{
    @BeforeMethod
    public void routeToCart(){
        click(By.cssSelector("[href='/login']"));
        type(By.xpath("//input[@name='Email']"), "Sssssssss@ss.com");
        type(By.xpath("//input[@name='Password']"), "Aa11111!");
        click(By.xpath("//input[@class='button-1 login-button']"));


        click(By.cssSelector("[href='/books']"));
        click(By.xpath("(//input[@value='Add to cart'])[1]"));
        pause(2000);
        //   click(By.xpath("(//input[@value='Add to cart'])[2]"));
        //  click(By.xpath("(//input[@value='Add to cart'])[3]"));
        click(By.cssSelector("[href='/cart']"));
        pause(2000);

    }
    @Test
    public void deleteCartPositive(){

        int sizeBefore = driver.findElements(By.cssSelector(".remove-from-cart > input")).size();
        System.out.println("sizeBefore = " + sizeBefore);
        pause(2000);
        click(By.xpath("//input[@name='removefromcart']"));
        pause(2000);
        click(By.cssSelector(".update-cart-button"));
        pause(2000);
        int sizeAfter = driver.findElements(By.cssSelector(".remove-from-cart > input")).size();
        //.remove-from-cart > input
        System.out.println("sizeAfter = " + sizeAfter);


        Assert.assertEquals(sizeBefore-1, sizeAfter);
    }

}
