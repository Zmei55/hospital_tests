package com.hospital;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {
    // пользователь не зарегистрирован
    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.isLoginLinkPresent()) {
            app.clickOnSignoutButton();
        }
    }

    @Test(priority = 1)
    public void loginUserPositiveTest() {
        // проверка, наличие логин-формы
        app.isLoginFormPresent();

        // заполнение логин и пароль
        app.fillLoginForm(new User()
                .setLogName("qwe")
                .setPassword("qwe123")
                .setStationXpathLocator("//input[@value='chirurgisch']")
        );

        // клик по кнопке "Логин"
        app.clickOnLoginButton();

        // проверка, залогинился ли пользователь
        app.isLoggedUser();
    }

    @Test(priority = 2)
    public void loginUserWithInvalidLoginNegativeTest() {
        // проверка, наличие логин-формы
        app.isLoginFormPresent();

        // заполнение логин и пароль
        app.fillLoginForm(new User()
                .setLogName("asd")
                .setPassword("qwe123")
                .setStationXpathLocator("//input[@value='chirurgisch']")
        );

        // клик по кнопке "Логин"
        app.clickOnLoginButton();

        // проверка, наличия ошибки
        app.isModalErrorPresent();

        // клик по кнопке Ок
        app.clickOnOkButton();
    }

    @Test(priority = 3)
    public void loginUserWithInvalidPasswordNegativeTest() {
        // проверка, наличие логин-формы
        app.isLoginFormPresent();

        // заполнение логин и пароль
        app.fillLoginForm(new User()
                .setLogName("qwe")
                .setPassword("asd123")
                .setStationXpathLocator("//input[@value='chirurgisch']")
        );

        // клик по кнопке "Логин"
        app.clickOnLoginButton();

        // проверка, наличия ошибки
        app.isModalErrorPresent();

        // клик по кнопке Ок
        app.clickOnOkButton();
    }

    @Test(priority = 4)
    public void loginUserWithInvalidStationNegativeTest() {
        // проверка, наличие логин-формы
        app.isLoginFormPresent();

        // заполнение логин и пароль
        app.fillLoginForm(new User()
                .setLogName("qwe")
                .setPassword("qwe123")
                .setStationXpathLocator("//input[@value='neurologisch']")
        );

        // клик по кнопке "Логин"
        app.clickOnLoginButton();

        // проверка, наличия ошибки
        app.isModalErrorPresent();

        // клик по кнопке Ок
        app.clickOnOkButton();
    }
}
