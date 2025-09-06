package com.demowebshop.fw;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ApplicationManager {
    WebDriver driver;
    UserHelper user;

    public BookHelper getBook() {
        return book;
    }

    public void setBook(BookHelper book) {
        this.book = book;
    }

    public RegisterHelper getRegister() {
        return register;
    }

    public void setRegister(RegisterHelper register) {
        this.register = register;
    }

    BookHelper book;
    RegisterHelper register;

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public UserHelper getUser() {
        return user;
    }

    public void setUser(UserHelper user) {
        this.user = user;
    }

    public void init() {
        driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        user = new UserHelper(driver);
        book = new BookHelper(driver);
        register = new RegisterHelper(driver);
        book = new BookHelper(driver);
    }

    public void exit() {
        driver.quit();
    }

    public int getSizeOfElement(String cssSelector) {
        return driver.findElements(By.cssSelector(cssSelector)).size();
    }


}
