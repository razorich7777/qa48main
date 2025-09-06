package com.phonebook.fw;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

// те функции что не имеют аннотаций
// веб драйвер нужен и в аппменеджер и в бейзхелпере
public class ApplicaticationManager {

    WebDriver driver;

    UserHelper user;
    ContactHelper contact;

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

    public ContactHelper getContact() {
        return contact;
    }

    public void setContact(ContactHelper contact) {
        this.contact = contact;
    }

    public HomePageHelper getHome() {
        return home;
    }

    public void setHome(HomePageHelper home) {
        this.home = home;
    }

    HomePageHelper home;

    public void init() {
        driver = new ChromeDriver();
        driver.get("https://telranedu.web.app/home");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        user = new UserHelper(driver);
        contact = new ContactHelper(driver);
        home = new HomePageHelper(driver);
    }

    public void exit() {
        driver.quit();
    }

}
