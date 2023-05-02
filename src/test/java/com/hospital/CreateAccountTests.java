package com.hospital;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {
    // пользователь не зарегистрирован
    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.isLoginLinkPresent()) {
            app.clickOnSignoutButton();
        }
    }

    @Test(enabled = false)
    public void newUserRegistrationPositiveTest() {
        // клик по кнопке ЛОГИН
        app.click(By.xpath("//a[contains(.,'LOGIN')]"));

        // проверка наличия формы регистрации
        app.assertTrueElement(By.className("login_login__3EHKB"));

        // заполнить форму регистрации
        app.type(By.cssSelector("[placeholder='Email']"), "e-mail");

        app.type(By.cssSelector("[placeholder='Password']"), "password");
        // проверить что поля правильно заполнились

        // клик по кнопке РЕГИСТРАЦИИ
        app.click(By.xpath("//button[contains(.,'Registration')]"));

        // проверка наличия кнопки ЛОГАУТ
        app.assertTrueElement(By.xpath("//button[contains(.,'Sign Out')]"));
    }

}
