package com.tests;

import com.hospital.model.Patient;
import com.hospital.model.User;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveFoundPatientTests extends TestBase {
    // precondition:
    // 1. пользователь разлогинен
    // 2. логинемся
    // 3. поиск пациента
    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.getUser().isLoginFormPresent()) {
            app.getUser().clickOnSignoutButton();
        } else {
            // Login
            app.getUser().fillLoginForm(new User()
                    .setLogName("qwe")
                    .setPassword("qwe123")
                    .setStation("chirurgisch")
            );
            app.getUser().clickOnLoginButton();
            app.getUser().isLoggedUser();

            // find Patient
            app.getPatient().clickOnNewRequstButton();
            app.getPatient().isNewRequestPresent();
            app.getPatient().clickOnFindPatientButton();
            app.getPatient().isModalFindPatientPresent();
            app.getPatient().fillFindPatient(new Patient().setName("Emma Weber"));
            app.getPatient().clickOnFindButton();
            app.getPatient().isFoundPatientsPresent();
            app.getPatient().clickOnSelectButton();
            app.getPatient().isPatientPresent();
        }
    }

    @Test
    public void removePatientTest() {
        app.getPatient().clickOnRemoveFoundPatientButton(); // клик: кнопка "Удалить пациента"

        app.getPatient().isFindPatientButtonPresent(); // проверка: информации о пациенте нет
    }
}

// int sizeBefore = sizeOfContacts();
// ...
// pause(1000); // ???
// int sizeAfter = sizeOfContacts();
// Assert.assertEquals(sizeBefore - 1, sizeAfter);

// public int sizeOfContacts() {
//     if (driver.findElements(locator.size() > 0)) {
//         return driver.findElements(locator.size();
//     } else {
//         return 0;
//     }
// }

// public void pause(int millis) {
//     try {
//         Thread.sleep(millis);
//     } catch (InterruptedException e) {
//         throw new RuntimeException(e):
//     }
// }