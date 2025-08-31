package com.demowebshop;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class AddCart extends TestBase{
    @Test
    public void AddToShoppingCartPositive(){
        click(By.cssSelector("[href='/books']"));
        addFirstNBooks(2);
       // click(By.xpath("(//input[@value='Add to cart'])[1]"));
      //  click(By.xpath("(//input[@value='Add to cart'])[2]"));
       // click(By.xpath("(//input[@value='Add to cart'])[3]"));
        click(By.cssSelector("[href='/cart']"));
        int count = driver.findElements(By.cssSelector(".remove-from-cart > input")).size();
        Assert.assertEquals(count, 2);
    }
    public void addFirstNBooks(int n){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
        for (int i = 1; i <= n; i++) {
            By addBtn = By.xpath("(//div[contains(@class,'product-item')]//input[@value='Add to cart'])[" + i + "]");
            WebElement el = wait.until(ExpectedConditions.elementToBeClickable(addBtn));
            ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView({block:'center'});", el);
            el.click();

            // ждём баннер, закрываем и ждём исчезновения (важно!)
            By success = By.cssSelector(".bar-notification.success");
            wait.until(ExpectedConditions.visibilityOfElementLocated(success));
            driver.findElement(By.cssSelector(".bar-notification.success .close")).click();
            wait.until(ExpectedConditions.invisibilityOfElementLocated(success));
        }
    }

}
