package com.hospital.fw;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class ApplicationManager {
    static WebDriver driver;

    UserHelper user; // объявили хелпер
    PatientHelper patient;
    HomePageHelper homePage;

    // геттеры, ссылки на хелперы


    public UserHelper getUser() { return user; }

    public PatientHelper getPatient() { return patient; }

    public HomePageHelper getHomePage() { return homePage; }

    public void init() {
        System.err.close(); // закрывает системные ошибки/предупреждения (в нач каждого теста)
        ChromeOptions options = new ChromeOptions();
        options.addArguments("remote-allow-origins=*");
        driver = new ChromeDriver(options); // подключение и инициализация драйвера
        driver.get("http://localhost:3000/hospital_react_ts"); // подключение к странице
        driver.manage().window().maximize(); // разворачивает на весь экран
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // установка не явного времени ожидания (ждёт не зависимо от результата)

        user = new UserHelper(driver); // инициализировали хелпер
        patient = new PatientHelper(driver);
        homePage = new HomePageHelper(driver);
    }

    public void stop() {
        driver.quit(); // закрывает браузер
    }

}
