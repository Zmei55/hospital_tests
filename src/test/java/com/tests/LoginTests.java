package com.tests;

import com.hospital.model.User;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {
    // пользователь не зарегистрирован
    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.getUser().isLoginFormPresent()) {
            app.getUser().clickOnSignoutButton();
        }
    }

    @Test(priority = 1)
    public void loginUserPositiveTest() {
        app.getUser().isLoginFormPresent(); // проверка, наличие логин-формы
        app.getUser().fillLoginForm(new User()
                .setLogName("qwe")
                .setPassword("qwe123")
                .setStation("chirurgisch")
        ); // заполнение логин и пароль
        app.getUser().clickOnLoginButton(); // клик по кнопке "Логин"
        app.getUser().isLoggedUser(); // проверка, залогинился ли пользователь
        logger.info("User logged in. Actual result: " + app.getUser().isLoggedUserBool() + ". Expected result: true");
    }

    @Test(priority = 2)
    public void loginUserWithInvalidLoginNegativeTest() {
        app.getUser().isLoginFormPresent(); // проверка, наличие логин-формы
        app.getUser().fillLoginForm(new User()
                .setLogName("asd")
                .setPassword("qwe123")
                .setStation("chirurgisch")
        ); // заполнение логин и пароль
        app.getUser().clickOnLoginButton(); // клик по кнопке "Логин"
        app.getUser().isModalErrorPresent(); // проверка, наличия ошибки
        app.getUser().clickOnOkButton(); // клик по кнопке Ок
    }

    @Test(priority = 3)
    public void loginUserWithInvalidPasswordNegativeTest() {
        app.getUser().isLoginFormPresent();
        app.getUser().fillLoginForm(new User()
                .setLogName("qwe")
                .setPassword("asd123")
                .setStation("chirurgisch")
        );
        app.getUser().clickOnLoginButton();
        app.getUser().isModalErrorPresent();
        app.getUser().clickOnOkButton();
    }

    @Test(priority = 4)
    public void loginUserWithInvalidStationNegativeTest() {
        app.getUser().isLoginFormPresent();
        app.getUser().fillLoginForm(new User()
                .setLogName("qwe")
                .setPassword("qwe123")
                .setStation("neurologisch")
        );
        app.getUser().clickOnLoginButton();
        app.getUser().isModalErrorPresent();
        app.getUser().clickOnOkButton();
    }
}
