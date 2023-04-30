package com.hospital;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FindPatientTests extends TestBase {
    // precondition:
        // 1. пользователь разлогинен
        // 2. логинемся
    @BeforeMethod
    public void ensurePrecondition() {
        if (!isElementPresent(By.xpath("//h2[contains(.,'Autorisierung')]"))) {
            driver.findElement(By.xpath("//button[contains(.,'Abmelden')]"));
        } else {
            type(By.xpath("//input[@placeholder='Login']"), "qwe");
            type(By.xpath("//input[@placeholder='Password']"), "qwe123");
            click(By.xpath("//button[contains(.,'Weiter')]"));
            click(By.xpath("//input[@value='chirurgisch']"));
            click(By.xpath("//button[contains(.,'Log In')]"));
            assertTrueElement(By.xpath("//button[contains(.,'Abmelden')]"));
        }
    }

    @Test
    public void findPatientPositiveTest() {
        // клик: "Новый запрос"
        click(By.xpath("//button[contains(.,'Erstellen Sie eine Bestellung')]"));

        // проверка: находимся на странице "Новый запрос"
        assertTrueElement(By.xpath("//h2[contains(.,'Neue Bestellung')]"));

        // клик: "Выбрать пациента"
        click(By.xpath("//button[contains(.,'Wählen Sie einen Patient aus')]"));

        // проверка: находимся в модальном окне поиска пациента
        assertTrueElement(By.xpath("//h3[contains(.,'Wählen Sie einen Patient aus')]"));

        // ввод: данные пациента
        type(By.xpath("//input[@name='name']"), "Emma Weber");
//        type(By.xpath("//input[@name='birthDate']"), "26051968");
//        type(By.xpath("//input[@name='cardNumber']"), "123456789");

        // клик: кнопка "Поиск"
        click(By.xpath("//button[contains(.,'Finden')]"));

        // проверка: пациент нашёлся
        assertTrueElement(By.className("css-16uxjix"));

        // выбрать пациента (клик: "Выбрать")
        click(By.xpath("//p[contains(.,'Wählen')]"));

        // проверка: блок с информацией пациента появился
        assertTrueElement(By.className("css-l2t4tz"));

        // клик: кнопка "Доп.инфа" чтоб открылась
        click(By.name("InfoButton"));

        // проверка: блок с дополнительной информацией пациента появился
        assertTrueElement(By.xpath("//h4[contains(.,'Wohnort')]"));

        // клик: кнопка "Доп.инфа" чтоб закрылась
        click(By.name("InfoButton"));

        // проверка: блок с дополнительной информацией пациента исчез
        assertFalseElement(By.xpath("//h4[contains(.,'Wohnort')]"));
    }
}
