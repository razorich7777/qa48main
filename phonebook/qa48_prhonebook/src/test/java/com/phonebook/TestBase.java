package com.phonebook;

import com.phonebook.fw.ApplicaticationManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
// те функции что имеют аннотации

public class TestBase {

    protected ApplicaticationManager app = new ApplicaticationManager();

    @BeforeMethod
    public void setUp() {
        app.init();
    }

    @AfterMethod(enabled = false)
    public void tearDown(){
        app.exit();
    }

}
