package com.demowebshop;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddCart extends TestBase{
    @Test
    public void AddToShoppingCartPositive(){
        click(By.cssSelector("[href='/books']"));
        click(By.xpath("(//input[@value='Add to cart'])[1]"));
     //   click(By.xpath("(//input[@value='Add to cart'])[2]"));
      //  click(By.xpath("(//input[@value='Add to cart'])[3]"));
        click(By.cssSelector("[href='/cart']"));
        int count = driver.findElements(By.cssSelector(".remove-from-cart > input")).size();
        Assert.assertEquals(count, 1);
    }
}
