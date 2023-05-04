package com.tests;

import com.hospital.fw.ApplicationManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;

public class TestBase {
    protected static ApplicationManager app = new ApplicationManager(); // ссылка на app, через кот тесты связываются с хелперами

    Logger logger = LoggerFactory.getLogger(TestBase.class); // подключение логгера

    @BeforeMethod
    public void setUp() {
        app.init();
    }

    @BeforeMethod
    public void startTest(Method m) {
        logger.info("Start test" + m.getName());
    }

    @AfterMethod(enabled = true)
    public void tearDown() {
        app.stop();
    }

    @AfterMethod
    public void stopTest(Method m) {
        logger.info("Stop test" + m.getName());
    }
}
