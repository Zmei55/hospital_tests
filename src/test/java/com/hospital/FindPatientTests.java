package com.hospital;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FindPatientTests extends TestBase {
    // precondition:
        // 1. пользователь разлогинен
        // 2. логинемся
    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.isLoginLinkPresent()) {
            app.clickOnSignoutButton();
        } else {
            app.fillLoginForm(new User()
                    .setLogName("qwe")
                    .setPassword("qwe123")
                    .setStationXpathLocator("//input[@value='chirurgisch']")
            );
            app.clickOnLoginButton();
            app.isLoggedUser();
        }
    }

    @Test
    public void findPatientPositiveTest() {
        // клик: "Новый запрос"
        app.clickOnNewRequstButton();

        // проверка: находимся на странице "Новый запрос"
        app.isNewRequestPresent();

        // клик: "Выбрать пациента"
        app.clickOnFindPatientButton();

        // проверка: находимся в модальном окне поиска пациента
        app.isModalFindPatientPresent();

        // ввод: данные пациента
        app.fillFindPatient(new Patient().setName("Emma Weber"));

        // клик: кнопка "Поиск"
        app.clickOnFindButton();

        // проверка: пациент нашёлся
        app.isFoundPatientsPresent();

        // выбрать пациента (клик: "Выбрать")
        app.clickOnSelectButton();

        // проверка: блок с информацией пациента появился
        app.isPatientPresent();

        // клик: кнопка "Доп.инфа" чтоб открылась
        app.clickOnInfoButton();

        // проверка: блок с дополнительной информацией пациента появился
        app.isSecondaryInfoPresent();

        // клик: кнопка "Доп.инфа" чтоб закрылась
        app.clickOnInfoButton();

        // проверка: блок с дополнительной информацией пациента исчез
        app.isNotSecondaryInfoPresent();
    }

    @Test
    public void findPatientWithInvalidNameTest() {
        app.clickOnNewRequstButton();
        app.isNewRequestPresent();
        app.clickOnFindPatientButton();
        app.isModalFindPatientPresent();
        app.fillFindPatient(new Patient().setName("Garry Osborn"));
        app.clickOnFindButton();
        app.isPatientNotFound();
    }
}
