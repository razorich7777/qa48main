package com.demowebshop;
import com.demowebshop.fw.*;
import com.demowebshop.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteProduct extends TestBase{
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
        app.getUser().pause(2000);
        //   click(By.xpath("(//input[@value='Add to cart'])[2]"));
        //  click(By.xpath("(//input[@value='Add to cart'])[3]"));
        app.getUser().clickByShoppingCart();
        app.getUser().pause(2000);

    }
    @Test
    public void deleteCartPositive(){

        int sizeBefore = app.getSizeOfElement(".remove-from-cart > input");
        System.out.println("sizeBefore = " + sizeBefore);
        app.getBook().deleteCart();
        int sizeAfter = app.getUser().getSizeOfElementXpath();
        //.remove-from-cart > input
        System.out.println("sizeAfter = " + sizeAfter);


        Assert.assertEquals(sizeBefore-1, sizeAfter);
    }

}
