package com.hospital;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {
    // пользователь не зарегистрирован
    @BeforeMethod
    public void ensurePrecondition() {
        if (!isElementPresent(By.xpath("//a[contains(.,'LOGIN')]"))) {
            driver.findElement(By.xpath("//button[contains(.,'Sign Out')]"));
        }
    }

    @Test(enabled = false)
    public void newUserRegistrationPositiveTest() {
        // клик по кнопке ЛОГИН
        click(By.xpath("//a[contains(.,'LOGIN')]"));

        // проверка наличия формы регистрации
        assertTrueElement(By.className("login_login__3EHKB"));

        // заполнить форму регистрации
        type(By.cssSelector("[placeholder='Email']"), "e-mail");

        type(By.cssSelector("[placeholder='Password']"), "password");
        // проверить что поля правильно заполнились

        // клик по кнопке РЕГИСТРАЦИИ
        click(By.xpath("//button[contains(.,'Registration')]"));

        // проверка наличия кнопки ЛОГАУТ
        assertTrueElement(By.xpath("//button[contains(.,'Sign Out')]"));
    }

}
