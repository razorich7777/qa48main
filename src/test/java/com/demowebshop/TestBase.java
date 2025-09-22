package com.demowebshop;

import com.demowebshop.fw.ApplicationManager;
import org.openqa.selenium.remote.Browser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;

public class TestBase {
    Logger logger = LoggerFactory.getLogger(TestBase.class);

    protected static ApplicationManager app = new ApplicationManager(System.getProperty("browser",
            Browser.CHROME.browserName()));

    @BeforeSuite
    public void setUp() {
        app.init();
    }

    @AfterSuite
    public void tearDown(){
        app.exit();

    }
    @BeforeMethod
    public void startTest(Method method){
        logger.info("Start test " + method.getName());
    }

    @AfterMethod
    public void afterTest(ITestResult result){
        if (result.isSuccess()){
            logger.info("PASSED: " + result.getMethod().getMethodName());
        }
        else {
            logger.error("FAILED: "  + result.getMethod().getMethodName() + "Screenshot path : "+ app.getUser().takeScreenshot());
        }
        logger.info("Finish test");
        logger.info("*************************************");
    }
}
