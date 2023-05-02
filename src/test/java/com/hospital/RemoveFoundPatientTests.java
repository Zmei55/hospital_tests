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
        if (!isLoginLinkPresent()) {
            clickOnSignoutButton();
        } else {
            // Login
            fillLoginForm(new User()
                    .setLogName("qwe")
                    .setPassword("qwe123")
                    .setStationXpathLocator("//input[@value='chirurgisch']")
            );
            clickOnLoginButton();
            isLoggedUser();

            // find Patient
            clickOnNewRequstButton();
            isNewRequestPresent();
            clickOnFindPatientButton();
            isModalFindPatientPresent();
            fillFindPatient(new Patient().setName("Emma Weber"));
            clickOnFindButton();
            isFoundPatientsPresent();
            clickOnSelectButton();
            isPatientPresent();
        }
    }

    @Test
    public void removePatientTest() {
        // клик: кнопка "Удалить пациента"
        clickOnRemoveFoundPatientButton();

        // проверка: информации о пациенте нет
        isFindPatientButtonPresent();
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