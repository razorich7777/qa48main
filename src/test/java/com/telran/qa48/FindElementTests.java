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

            driver.get("https://demowebshop.tricentis.com");

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
            WebElement element = driver.findElement(By.tagName("H2"));
            //WebElement element = driver.findElement(By.id("vote-poll-1"));
            System.out.println("-------------------------");
            System.out.println(element.getText());
            System.out.println("-------------------------");
        }
        @Test
        public void findElementByClassName(){

        //find element by tagName
        //WebElement element = driver.findElement(By.tagName("H2"));
        WebElement element = driver.findElement(By.className("ico-register"));
        System.out.println("-------------------------");
        System.out.println(element.getText());
        System.out.println("-------------------------");
    }

    @Test
    public void findElementById(){

        //find element by tagName
        //WebElement element = driver.findElement(By.tagName("H2"));
        WebElement element = driver.findElement(By.id("vote-poll-1"));
        System.out.println("-------------------------");
        System.out.println(element.getAccessibleName());
        System.out.println("-------------------------");
    }

}
