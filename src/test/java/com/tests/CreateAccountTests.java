package com.tests;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {
    // пользователь не зарегистрирован
    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.getUser().isLoginFormPresent()) {
            app.getUser().clickOnSignoutButton();
        }
    }

    @Test(enabled = false)
    public void newUserRegistrationPositiveTest() {
        // клик по кнопке ЛОГИН
        app.getUser().click(By.xpath("//a[contains(.,'LOGIN')]"));

        // проверка наличия формы регистрации
        app.getUser().assertTrueElement(By.className("login_login__3EHKB"));

        // заполнить форму регистрации
        app.getUser().type(By.cssSelector("[placeholder='Email']"), "e-mail");

        app.getUser().type(By.cssSelector("[placeholder='Password']"), "password");
        // проверить что поля правильно заполнились

        // клик по кнопке РЕГИСТРАЦИИ
        app.getUser().click(By.xpath("//button[contains(.,'Registration')]"));

        // проверка наличия кнопки ЛОГАУТ
        app.getUser().assertTrueElement(By.xpath("//button[contains(.,'Sign Out')]"));
    }

}
