package com.hospital;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {
    // пользователь не зарегистрирован
    @BeforeMethod
    public void ensurePrecondition() {
        if (!isElementPresent(By.xpath("//h2[contains(.,'Autorisierung')]"))) {
            driver.findElement(By.xpath("//button[contains(.,'Abmelden')]"));
        }
    }

    @Test(priority = 1)
    public void loginUserPositiveTest() {
        // проверка, наличие логин-формы
        assertTrueElement(By.xpath("//h2[contains(.,'Autorisierung')]"));

        // заполнение логин и пароль
        type(By.xpath("//input[@placeholder='Login']"), "qwe");
        type(By.xpath("//input[@placeholder='Password']"), "qwe123");

        // клик на кнопку "далее"
        click(By.xpath("//button[contains(.,'Weiter')]"));

        // выбор стационара (клик по радио-баттон)
        click(By.xpath("//input[@value='chirurgisch']"));

        // клик по кнопке "Логин"
        click(By.xpath("//button[contains(.,'Log In')]"));

        // проверка, залогинился ли пользователь
        assertTrueElement(By.xpath("//button[contains(.,'Abmelden')]"));
    }

    @Test(priority = 2)
    public void loginUserWithInvalidLoginNegativeTest() {
        // проверка, наличие логин-формы
        assertTrueElement(By.xpath("//h2[contains(.,'Autorisierung')]"));

        // заполнение логин и пароль
        type(By.xpath("//input[@placeholder='Login']"), "asd");
        type(By.xpath("//input[@placeholder='Password']"), "qwe123");

        // клик на кнопку "далее"
        click(By.xpath("//button[contains(.,'Weiter')]"));

        // выбор стационара (клик по радио-баттон)
        click(By.xpath("//input[@value='chirurgisch']"));

        // клик по кнопке "Логин"
        click(By.xpath("//button[contains(.,'Log In')]"));

        // проверка, наличия ошибки
        assertTrueElement(By.xpath("//p[contains(.,'Benutzerdaten wurden falsch eingegeben')]"));

        // клик по кнопке Ок
        click(By.xpath("//button[contains(.,'Ok')]"));
    }

    @Test(priority = 3)
    public void loginUserWithInvalidPasswordNegativeTest() {
        // проверка, наличие логин-формы
        assertTrueElement(By.xpath("//h2[contains(.,'Autorisierung')]"));

        // заполнение логин и пароль
        type(By.xpath("//input[@placeholder='Login']"), "qwe");
        type(By.xpath("//input[@placeholder='Password']"), "asd123");

        // клик на кнопку "далее"
        click(By.xpath("//button[contains(.,'Weiter')]"));

        // выбор стационара (клик по радио-баттон)
        click(By.xpath("//input[@value='chirurgisch']"));

        // клик по кнопке "Логин"
        click(By.xpath("//button[contains(.,'Log In')]"));

        // проверка, наличия ошибки
        assertTrueElement(By.xpath("//p[contains(.,'Benutzerdaten wurden falsch eingegeben')]"));

        // клик по кнопке Ок
        click(By.xpath("//button[contains(.,'Ok')]"));
    }

    @Test(priority = 4)
    public void loginUserWithInvalidStationNegativeTest() {
        // проверка, наличие логин-формы
        assertTrueElement(By.xpath("//h2[contains(.,'Autorisierung')]"));

        // заполнение логин и пароль
        type(By.xpath("//input[@placeholder='Login']"), "qwe");
        type(By.xpath("//input[@placeholder='Password']"), "qwe123");

        // клик на кнопку "далее"
        click(By.xpath("//button[contains(.,'Weiter')]"));

        // выбор стационара (клик по радио-баттон)
        click(By.xpath("//input[@value='neurologisch']"));

        // клик по кнопке "Логин"
        click(By.xpath("//button[contains(.,'Log In')]"));

        // проверка, наличия ошибки
        assertTrueElement(By.xpath("//p[contains(.,'Benutzerdaten wurden falsch eingegeben')]"));

        // клик по кнопке Ок
        click(By.xpath("//button[contains(.,'Ok')]"));
    }
}
