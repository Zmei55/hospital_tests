package com.hospital;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveFoundPatientTests extends TestBase {
    // precondition:
    // 1. пользователь разлогинен
    // 2. логинемся
    // 3. поиск пациента
    @BeforeMethod
    public void ensurePrecondition() {
        if (!isElementPresent(By.xpath("//h2[contains(.,'Autorisierung')]"))) {
            driver.findElement(By.xpath("//button[contains(.,'Abmelden')]"));
        } else {
            // Login
            type(By.xpath("//input[@placeholder='Login']"), "qwe");
            type(By.xpath("//input[@placeholder='Password']"), "qwe123");
            click(By.xpath("//button[contains(.,'Weiter')]"));
            click(By.xpath("//input[@value='chirurgisch']"));
            click(By.xpath("//button[contains(.,'Log In')]"));
            assertTrueElement(By.xpath("//button[contains(.,'Abmelden')]"));

            // find Patient
            click(By.xpath("//button[contains(.,'Erstellen Sie eine Bestellung')]"));
            assertTrueElement(By.xpath("//h2[contains(.,'Neue Bestellung')]"));
            click(By.xpath("//button[contains(.,'Wählen Sie einen Patient aus')]"));
            assertTrueElement(By.xpath("//h3[contains(.,'Wählen Sie einen Patient aus')]"));
            type(By.xpath("//input[@name='name']"), "Emma Weber");
            click(By.xpath("//button[contains(.,'Finden')]"));
            assertTrueElement(By.className("css-16uxjix"));
            click(By.xpath("//p[contains(.,'Wählen')]"));
            assertTrueElement(By.className("css-l2t4tz"));
        }
    }

    @Test
    public void removePatientTest() {
        // клик: кнопка "Удалить пациента"
        click(By.name("ClearButton"));

        // проверка: информации о пациенте нет
        assertTrueElement(By.xpath("//button[contains(.,'Wählen Sie einen Patient aus')]"));
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