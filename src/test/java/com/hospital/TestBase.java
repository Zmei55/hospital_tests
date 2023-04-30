package com.hospital;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class TestBase {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("remote-allow-origins=*");
        driver = new ChromeDriver(options); // подключение и инициализация драйвера
        driver.get("http://localhost:3000/hospital_react_ts"); // подключение к странице
        driver.manage().window().maximize(); // разворачивает на весь экран
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // установка не явного времени ожидания (ждёт не зависимо от результата)
    }

    @AfterMethod(enabled = false)
    public void tearDown() {
        driver.quit(); // закрывает браузер
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

    // метод - клик
    public void click(By locator) {
        driver.findElement(locator).click();
    }

    // метод - ввод текста в поле ввода
    public void type(By locator, String text) {
        driver.findElement(locator).click();
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }

    // метод - проверка наличия элемента
    public void assertTrueElement(By locator) {
        Assert.assertTrue(isElementPresent(locator));
    }

    public void assertFalseElement(By locator) {
        Assert.assertFalse(isElementPresent(locator));
    }
}
