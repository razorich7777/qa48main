package com.demowebshop.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BookHelper extends BaseHelper{

    public BookHelper(WebDriver driver) {
        super(driver);
    }

    public void addNBooks(int n){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
        for (int i = 1; i <= n; i++) {
            By addBtn = By.xpath("(//div[contains(@class,'product-item')]//input[@value='Add to cart'])[" + i + "]");
            WebElement el = wait.until(ExpectedConditions.elementToBeClickable(addBtn));
            ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView({block:'center'});", el);
            el.click();

            // ждём баннер, закрываем и ждём исчезновения (важно!)
            By success = By.cssSelector(".bar-notification.success");
            wait.until(ExpectedConditions.visibilityOfElementLocated(success));
            click(By.cssSelector(".bar-notification.success .close"));
            wait.until(ExpectedConditions.invisibilityOfElementLocated(success));
        }
    }

    public void deleteNBooks(int n){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        System.out.println("1");
        clickByXPath("(//td[contains(@class,'remove-from-cart')]//input[@name='removefromcart'])[" +  1 + "])");
        for (int i = 1; i <= n; i++) {
            clickByXPath("(//td[contains(@class,'remove-from-cart')]//input[@name='removefromcart'])[" +  i + "])");
            // WebElement el = wait.until(ExpectedConditions.elementToBeClickable(deleteBtn));
            pause(1000);
            System.out.println("2");
           // ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView({block:'center'});", el);
           // pause(1000);
            //System.out.println("3");
          //  el.click();
          //  pause(1000);
          //  System.out.println("4");

        }
        click(By.cssSelector(".update-cart-button"));
        System.out.println("3 finish");
        pause(1000);
        //driver.findElement(By.xpath("//*[contains(text(), 'Your Shopping Cart is empty!')]"));

    }



    public void clickByBook() {
        clickByCss("[href='/books']");
    }

    public void clickByAddToCart() {
        clickByXPath("(//input[@value='Add to cart'])[1]");
    }

    public int countElements(By locator){
        int count = 0;

        if(isElementPresent(locator))
        count = driver.findElements(locator).size();

        return count;
    }

    public void deleteAllCarts() {
        int count = countElements(By.xpath("//td[contains(@class,'remove-from-cart')]//input[@name='removefromcart']"));
        System.out.println(count);
        for (int i = 1; i <= count; i++) {
            pause(1000);
            clickByXPath("(//td[contains(@class,'remove-from-cart')]//input[@name='removefromcart'])[" + i + "]");
            System.out.println("delete");
        }
        pause(2000);
        clickByCss(".update-cart-button");
        // deleteNBooks(count);
        pause(2000);
    }

    public void deleteCart() {
        pause(2000);
        clickByXPath("//td[contains(@class,'remove-from-cart')]//input[@name='removefromcart']");
        pause(2000);
        clickByCss(".update-cart-button");
        pause(2000);
    }
}
