package com.hospital;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FindPatientTests extends TestBase {
    // precondition:
        // 1. пользователь разлогинен
        // 2. логинемся
    @BeforeMethod
    public void ensurePrecondition() {
        if (!isLoginLinkPresent()) {
            clickOnSignoutButton();
        } else {
            fillLoginForm("qwe", "qwe123", "//input[@value='chirurgisch']");
            clickOnLoginButton();
            isLoggedUser();
        }
    }

    @Test
    public void findPatientPositiveTest() {
        // клик: "Новый запрос"
        clickOnNewRequstButton();

        // проверка: находимся на странице "Новый запрос"
        isNewRequestPresent();

        // клик: "Выбрать пациента"
        clickOnFindPatientButton();

        // проверка: находимся в модальном окне поиска пациента
        isModalFindPatientPresent();

        // ввод: данные пациента
        fillFindPatient("Emma Weber");

        // клик: кнопка "Поиск"
        clickOnFindButton();

        // проверка: пациент нашёлся
        isFoundPatientsPresent();

        // выбрать пациента (клик: "Выбрать")
        clickOnSelectButton();

        // проверка: блок с информацией пациента появился
        isPatientPresent();

        // клик: кнопка "Доп.инфа" чтоб открылась
        clickOnInfoButton();

        // проверка: блок с дополнительной информацией пациента появился
        isSecondaryInfoPresent();

        // клик: кнопка "Доп.инфа" чтоб закрылась
        clickOnInfoButton();

        // проверка: блок с дополнительной информацией пациента исчез
        isNotSecondaryInfoPresent();
    }

}
