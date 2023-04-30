package com.hospital;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {
    // пользователь не зарегистрирован
    @BeforeMethod
    public void ensurePrecondition() {
        if (!isLoginLinkPresent()) {
            clickOnSignoutButton();
        }
    }

    @Test(priority = 1)
    public void loginUserPositiveTest() {
        // проверка, наличие логин-формы
        isLoginFormPresent();

        // заполнение логин и пароль
        fillLoginForm("qwe", "qwe123", "//input[@value='chirurgisch']");

        // клик по кнопке "Логин"
        clickOnLoginButton();

        // проверка, залогинился ли пользователь
        isLoggedUser();
    }

    @Test(priority = 2)
    public void loginUserWithInvalidLoginNegativeTest() {
        // проверка, наличие логин-формы
        isLoginFormPresent();

        // заполнение логин и пароль
        fillLoginForm("asd", "qwe123", "//input[@value='chirurgisch']");

        // клик по кнопке "Логин"
        clickOnLoginButton();

        // проверка, наличия ошибки
        isModalErrorPresent();

        // клик по кнопке Ок
        clickOnOkButton();
    }

    @Test(priority = 3)
    public void loginUserWithInvalidPasswordNegativeTest() {
        // проверка, наличие логин-формы
        isLoginFormPresent();

        // заполнение логин и пароль
        fillLoginForm("qwe", "asd123", "//input[@value='chirurgisch']");

        // клик по кнопке "Логин"
        clickOnLoginButton();

        // проверка, наличия ошибки
        isModalErrorPresent();

        // клик по кнопке Ок
        clickOnOkButton();
    }

    @Test(priority = 4)
    public void loginUserWithInvalidStationNegativeTest() {
        // проверка, наличие логин-формы
        isLoginFormPresent();

        // заполнение логин и пароль
        fillLoginForm("qwe", "qwe123", "//input[@value='neurologisch']");

        // клик по кнопке "Логин"
        clickOnLoginButton();

        // проверка, наличия ошибки
        isModalErrorPresent();

        // клик по кнопке Ок
        clickOnOkButton();
    }

    private void clickOnOkButton() {
        click(By.xpath("//button[contains(.,'Ok')]"));
    }

    private void isModalErrorPresent() {
        assertTrueElement(By.xpath("//p[contains(.,'Benutzerdaten wurden falsch eingegeben')]"));
    }
}
