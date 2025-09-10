package com.phonebook;

import com.phonebook.fw.ApplicaticationManager;
import org.openqa.selenium.remote.Browser;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
// те функции что имеют аннотации

public class TestBase {

    protected static ApplicaticationManager app = new ApplicaticationManager(System.getProperty("browser",
            Browser.CHROME.browserName()));

    @BeforeSuite
    public void setUp() {
        app.init();
    }

    @AfterSuite
    public void tearDown(){
        app.exit();
    }

}
