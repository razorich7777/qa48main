package com.demowebshop.fw;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseHelper {

    WebDriver driver;

    public BaseHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void pause(int millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean isElementPresent(By locator){
        // return driver.findElements(By.cssSelector("div:nth-child(2)>div>div>h1")).size()>0;
        return driver.findElements(locator).size()>0;
    }

    public void type(By locator, String text) {
        click(locator);
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public boolean isAlertDisplayed() {
        Alert alert = new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.alertIsPresent());
        if (alert == null){
            return false;
        }
        else{
            return true;
        }
    }

    public void clickByCss(String cssSelector) {
        click(By.cssSelector(cssSelector));
    }
    public WebElement findElementByXPath(String xpathExpression) {
        return driver.findElement(By.xpath(
                xpathExpression
        ));
    }

    public boolean isElementPresentCss(String cssSelector) {
        return isElementPresent(By.cssSelector(cssSelector));
    }

    public void clickByXPath(String xpathExpression) {
        click(By.xpath(xpathExpression));
    }

    public int getSizeOfElementXpath() {
        return driver.findElements(By.xpath("//td[contains(@class,'remove-from-cart')]//input[@name='removefromcart']")).size();
    }

    public void clickByShoppingCart() {
        clickByXPath("//*[contains(text(), 'Shopping cart')]");
    }

    public boolean isLoginLinkPresent() {
        return isElementPresent(By.cssSelector("[href='/login']"));
    }


    public void clickOnSignOutButton() {
        click(By.cssSelector("[href='/logout']"));
    }
}
