package com.hospital;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveFoundPatientTests extends TestBase {
    // precondition:
    // 1. пользователь разлогинен
    // 2. логинемся
    // 3. поиск пациента
    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.isLoginLinkPresent()) {
            app.clickOnSignoutButton();
        } else {
            // Login
            app.fillLoginForm(new User()
                    .setLogName("qwe")
                    .setPassword("qwe123")
                    .setStationXpathLocator("//input[@value='chirurgisch']")
            );
            app.clickOnLoginButton();
            app.isLoggedUser();

            // find Patient
            app.clickOnNewRequstButton();
            app.isNewRequestPresent();
            app.clickOnFindPatientButton();
            app.isModalFindPatientPresent();
            app.fillFindPatient(new Patient().setName("Emma Weber"));
            app.clickOnFindButton();
            app.isFoundPatientsPresent();
            app.clickOnSelectButton();
            app.isPatientPresent();
        }
    }

    @Test
    public void removePatientTest() {
        // клик: кнопка "Удалить пациента"
        app.clickOnRemoveFoundPatientButton();

        // проверка: информации о пациенте нет
        app.isFindPatientButtonPresent();
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