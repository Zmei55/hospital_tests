package com.tests;

import com.hospital.model.Patient;
import com.hospital.model.User;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FindPatientTests extends TestBase {
    // precondition:
        // 1. пользователь разлогинен
        // 2. логинемся
    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.getUser().isLoginFormPresent()) {
            app.getUser().clickOnSignoutButton();
        } else {
            app.getUser().fillLoginForm(new User()
                    .setLogName("qwe")
                    .setPassword("qwe123")
                    .setStation("chirurgisch")
            );
            app.getUser().clickOnLoginButton();
            app.getUser().isLoggedUser();
        }
    }

    @Test
    public void findPatientPositiveTest() {
        app.getPatient().clickOnNewRequstButton(); // клик: "Новый запрос"
        app.getPatient().isNewRequestPresent(); // проверка: находимся на странице "Новый запрос"
        app.getPatient().clickOnFindPatientButton(); // клик: "Выбрать пациента"
        app.getPatient().isModalFindPatientPresent(); // проверка: находимся в модальном окне поиска пациента
        app.getPatient().fillFindPatient(new Patient().setName("Emma Weber")); // ввод: данные пациента
        app.getPatient().clickOnFindButton();// клик: кнопка "Поиск"
        app.getPatient().isFoundPatientsPresent(); // проверка: пациент нашёлся
        app.getPatient().clickOnSelectButton(); // выбрать пациента (клик: "Выбрать")
        app.getPatient().isPatientPresent(); // проверка: блок с информацией пациента появился
        app.getPatient().clickOnInfoButton(); // клик: кнопка "Доп.инфа" чтоб открылась
        app.getPatient().isSecondaryInfoPresent(); // проверка: блок с дополнительной информацией пациента появился
        app.getPatient().clickOnInfoButton(); // клик: кнопка "Доп.инфа" чтоб закрылась
        app.getPatient().isNotSecondaryInfoPresent(); // проверка: блок с дополнительной информацией пациента исчез
    }

    @Test
    public void findPatientWithInvalidNameTest() {
        app.getPatient().clickOnNewRequstButton();
        app.getPatient().isNewRequestPresent();
        app.getPatient().clickOnFindPatientButton();
        app.getPatient().isModalFindPatientPresent();
        app.getPatient().fillFindPatient(new Patient().setName("Garry Osborn"));
        app.getPatient().clickOnFindButton();
        app.getPatient().isPatientNotFound();
    }
}
