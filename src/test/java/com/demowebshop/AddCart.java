package com.demowebshop;
import com.demowebshop.fw.ApplicationManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddCart extends TestBase{
    @BeforeMethod
    public void precondition() {
        if (!app.getUser().isLoginLinkPresent()) {
            app.getUser().clickOnSignOutButton();
        }
    }


    @Test
    public void AddToShoppingCartPositive(){
        app.getBook().clickByBook();
        app.getBook().addNBooks(3);

       // click(By.xpath("(//input[@value='Add to cart'])[1]"));
       // click(By.xpath("(//input[@value='Add to cart'])[2]"));
       // click(By.xpath("(//input[@value='Add to cart'])[3]"));

      //  ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0);");
      //  pause(2000);
        app.getUser().clickByShoppingCart();
        int count = app.getSizeOfElement(".remove-from-cart > input");
        Assert.assertEquals(count, 3);
    }
   /* @Test
    public void addAndCheckCartPositive(){
        app.getUser().clickByBook();
        String s1;
        WebElement productItem = app.getUser().findElementByXPath("(//div[contains(@class,'product-item') and .//input[@value='Add to cart'] and .//h2[@class='product-title']])[1]");

        WebElement titleElement = productItem.findElement(By.xpath(".//h2[@class='product-title']"));
        s1 = titleElement.getText();
        System.out.println("s1 = " + s1);
        // href="/computing-and-internet"

        app.getUser().clickByAddToCart();
        }

    */



}
