package com.hospital;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import java.time.Duration;

public class ApplicationManager {
    WebDriver driver;

    public void init() {
        System.err.close(); // закрывает системные ошибки/предупреждения (в нач каждого теста)
        ChromeOptions options = new ChromeOptions();
        options.addArguments("remote-allow-origins=*");
        driver = new ChromeDriver(options); // подключение и инициализация драйвера
        driver.get("http://localhost:3000/hospital_react_ts"); // подключение к странице
        driver.manage().window().maximize(); // разворачивает на весь экран
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // установка не явного времени ожидания (ждёт не зависимо от результата)
    }

    public void stop() {
        driver.quit(); // закрывает браузер
    }

    // Универсальный метод для поиска эл-та по стратегии с локатору
    public boolean isElementPresent(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException exception) {
            return false;
        }
    }

    public boolean isElementsPresent(By locator) {
        try {
            driver.findElements(locator);
            return true;
        } catch (NoSuchElementException exception) {
            return false;
        }
    }

    // ввод текста в поле ввода
    public void type(By locator, String text) {
        if (text != null) {
            driver.findElement(locator).click();
            driver.findElement(locator).clear();
            driver.findElement(locator).sendKeys(text);
        }
    }

    // проверка наличия элемента
    public void assertTrueElement(By locator) {
        Assert.assertTrue(isElementPresent(locator));
    }

    // проверка отсутствие элемента
    public void assertFalseElement(By locator) {
        Assert.assertFalse(isElementPresent(locator));
    }

    // наличие формы логина
    public boolean isLoginLinkPresent() {
        return isElementPresent(By.xpath("//h2[contains(.,'Autorisierung')]"));
    }

    // заполнить форму логина
    public void fillLoginForm(User user) {
        type(By.xpath("//input[@placeholder='Login']"), user.getLogName());
        type(By.xpath("//input[@placeholder='Password']"), user.getPassword());

        // клик на кнопку "далее"
        click(By.xpath("//button[contains(.,'Weiter')]"));

        // выбор стационара (клик по радио-баттон)
        click(By.xpath(user.getStationXpathLocator()));
    }

    public void fillFindPatient(Patient patient) {
        type(By.xpath("//input[@name='name']"), patient.getName());
    }

    // клик
    public void click(By locator) {
        driver.findElement(locator).click();
    }

    // клик кнопки "Выход"
    public void clickOnSignoutButton() {
        click(By.xpath("//button[contains(.,'Abmelden')]"));
    }

    // клик кнопки входа
    public void clickOnLoginButton() {
        click(By.xpath("//button[contains(.,'Log In')]"));
    }

    // пользователь залогинен
    public void isLoggedUser() {
        assertTrueElement(By.xpath("//button[contains(.,'Abmelden')]"));
    }

    // форма логина присутствует
    public void isLoginFormPresent() {
        assertTrueElement(By.xpath("//h2[contains(.,'Autorisierung')]"));
    }

    public void isNewRequestPresent() {
        assertTrueElement(By.xpath("//h2[contains(.,'Neue Bestellung')]"));
    }

    public void isModalFindPatientPresent() {
        assertTrueElement(By.xpath("//h3[contains(.,'Wählen Sie einen Patient aus')]"));
    }

    public void isFoundPatientsPresent() {
        Assert.assertTrue(isElementsPresent(By.className("css-16uxjix")));
    }

    public void isNotSecondaryInfoPresent() {
        assertFalseElement(By.xpath("//h4[contains(.,'Wohnort')]"));
    }

    public void isSecondaryInfoPresent() {
        assertTrueElement(By.xpath("//h4[contains(.,'Wohnort')]"));
    }

    public void clickOnInfoButton() {
        click(By.name("InfoButton"));
    }

    public void isPatientPresent() {
        assertTrueElement(By.className("css-l2t4tz"));
    }

    public void clickOnSelectButton() {
        click(By.xpath("//p[contains(.,'Wählen')]"));
    }

    public void clickOnNewRequstButton() {
        click(By.xpath("//button[contains(.,'Erstellen Sie eine Bestellung')]"));
    }

    public void clickOnFindPatientButton() {
        click(By.xpath("//button[contains(.,'Wählen Sie einen Patient aus')]"));
    }

    public void clickOnFindButton() {
        click(By.xpath("//button[contains(.,'Finden')]"));
    }

    public void clickOnRemoveFoundPatientButton() {
        click(By.name("ClearButton"));
    }

    public void isFindPatientButtonPresent() {
        assertTrueElement(By.xpath("//button[@aria-label='find patient']"));
    }

    public void isPatientNotFound() {
        assertTrueElement(By.className("css-1xpd0js"));
    }

    public boolean isHomeComponentPresent(){
        try {
            driver.findElement(By.xpath("//button[contains(.,'Weiter')]"));
            return true;
        } catch (NoSuchElementException exception){
            return false;
        }
    }

    public void clickOnOkButton() {
        click(By.xpath("//button[contains(.,'Ok')]"));
    }

    public void isModalErrorPresent() {
        assertTrueElement(By.xpath("//p[contains(.,'Benutzerdaten wurden falsch eingegeben')]"));
    }
}
