package com.tests;

import com.hospital.fw.ApplicationManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;
import java.util.Arrays;

public class TestBase {
    protected static ApplicationManager app = new ApplicationManager(); // ссылка на app, через кот тесты связываются с хелперами

    Logger logger = LoggerFactory.getLogger(TestBase.class); // подключение логгера

    @BeforeMethod
    public void setUp() {
        app.init();
    }

    @BeforeMethod
    public void startTest(Method m, Object[] p) {
        logger.info("Start test" + m.getName() + " with data: " + Arrays.asList(p));
    }

    @AfterMethod(enabled = true)
    public void tearDown() {
        app.stop();
    }

    @AfterMethod
    public void stopTest(ITestResult result) {
        if(result.isSuccess()) {
            logger.info("PASSED: " + result.getMethod().getMethodName());
        } else {
            logger.error("FAILED: " + result.getMethod().getMethodName() + "Screenshot: " + app.getUser().takeScreenshot());
        }
        logger.info("================================");
    }
}
