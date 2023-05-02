package com.hospital.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class BaseHelper {
    WebDriver driver;

    public BaseHelper(WebDriver driver) {
        this.driver = driver;
    }

    // Универсальный метод для поиска эл-та по стратегии с локатору
    public boolean isElementPresent(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException exception) {
            return false;
        }
    }

    public boolean isElementsPresent(By locator) {
        try {
            driver.findElements(locator);
            return true;
        } catch (NoSuchElementException exception) {
            return false;
        }
    }

    // ввод текста в поле ввода
    public void type(By locator, String text) {
        if (text != null) {
            driver.findElement(locator).click();
            driver.findElement(locator).clear();
            driver.findElement(locator).sendKeys(text);
        }
    }

    public void assertTrueElement(By locator) {
        Assert.assertTrue(isElementPresent(locator));
    } // проверка наличия элемента

    public void assertFalseElement(By locator) {
        Assert.assertFalse(isElementPresent(locator));
    } // проверка отсутствие элемента

    public void click(By locator) {
        driver.findElement(locator).click();
    } // клик

    public void pause(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    } // пауза между методами
}
