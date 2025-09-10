package com.demowebshop;

import com.demowebshop.models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteAllCarts extends TestBase{
    @BeforeMethod
    public void routeToCart(){

            if (!app.getUser().isLoginLinkPresent()) {
                app.getUser().clickOnSignOutButton();
            }

        app.getUser().clickByCss("[href='/login']");
        app.getUser().fillFormRegistration( new User( "Sssssssss@ss.com", "Aa11111!"));
        app.getUser().clickByXPath("//input[@class='button-1 login-button']");


        app.getBook().clickByBook();
        app.getBook().clickByAddToCart();
        app.getBook().pause(2000);
        //   click(By.xpath("(//input[@value='Add to cart'])[2]"));
        //  click(By.xpath("(//input[@value='Add to cart'])[3]"));
        app.getUser().clickByShoppingCart();
        app.getUser().pause(2000);

    }

    @Test
    public void deleteAllCartsPositive(){
        app.getBook().deleteAllCarts();
        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//*[contains(text(), 'Your Shopping Cart is empty!')]")));
    }


}
