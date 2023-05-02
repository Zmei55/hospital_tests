package com.tests;

import com.hospital.fw.ApplicationManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {
    protected static ApplicationManager app = new ApplicationManager(); // ссылка на app, через кот тесты связываются с хелперами

    Logger logger = LoggerFactory.getLogger(TestBase.class); // подключение логгера

    @BeforeMethod
    public void setUp() {
        app.init();
    }

//    @BeforeMethod
//    public void startTest() {
//        logger.info("Start test");
//    }

    @AfterMethod(enabled = true)
    public void tearDown() {
        app.stop();
    }

//    @AfterMethod
//    public void stopTest() {
//        logger.info("Stop test");
//    }
}
