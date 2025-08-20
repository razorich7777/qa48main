package com.telran.qa48;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class FindElementTests {



        WebDriver driver;



        @BeforeMethod

        public void setUp(){

            driver = new ChromeDriver();

            driver.get("https://icarro-v1.netlify.app");

            driver.manage().window().maximize();

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));



        }

        @AfterMethod

        public void tearDown(){

            driver.quit();

        }



        @Test

        public void findElementByTagName(){

            //find element by tagName

            WebElement element = driver.findElement(By.tagName("h1"));

            System.out.printf(element.getText());

        }
}
