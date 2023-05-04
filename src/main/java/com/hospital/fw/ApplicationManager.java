package com.hospital.fw;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class ApplicationManager {
    static WebDriver driver;
    String browser; // для кроссбраузерности

    UserHelper user; // объявили хелпер
    PatientHelper patient;
    HomePageHelper homePage;
    Logger logger = LoggerFactory.getLogger(ApplicationManager.class);

    public ApplicationManager(String browser) {
        this.browser = browser;
    }

    // геттеры, ссылки на хелперы


    public UserHelper getUser() { return user; }

    public PatientHelper getPatient() { return patient; }

    public HomePageHelper getHomePage() { return homePage; }

    public void init() {
        System.err.close(); // закрывает системные ошибки/предупреждения (в нач каждого теста)

//        if(browser.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("remote-allow-origins=*");
            driver = new ChromeDriver(options); // подключение и инициализация драйвера
//            logger.info("Test(s) start(s) in Chrome");

//        } else if (browser.equalsIgnoreCase("firefox")) {
//            driver = new FirefoxDriver();
//            logger.info("Test(s) start(s) in Firefox");
//        } // условий может быть много

        driver.get("http://localhost:3000/hospital_react_ts"); // подключение к странице

        logger.info("Current URL --> " + driver.getCurrentUrl()); // добавляет в лог текущую страницу

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
