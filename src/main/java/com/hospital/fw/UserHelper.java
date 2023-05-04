package com.hospital.fw;

import com.hospital.model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserHelper extends BaseHelper {
    public UserHelper(WebDriver driver) {
        super(driver);
    }


    public boolean isLoginFormPresent() {
        return isElementPresent(By.xpath("//h2[contains(.,'Autorisierung')]")); // наличие формы логина
    }


    public void fillLoginForm(User user) {
        type(By.xpath("//input[@placeholder='Login']"), user.getLogName()); // заполнить логин
        type(By.xpath("//input[@placeholder='Password']"), user.getPassword()); // заполнить пароль

        click(By.xpath("//button[contains(.,'Weiter')]")); // клик на кнопку "далее"

        click(By.xpath(isStationName(user.getStation()))); // выбор стационара (клик по радио-кнопке)
    }

    public String isStationName(String locator) {
        return "//input[@value="+"'"+locator+"'"+"]"; // локатор для стационара
    }

    public void clickOnSignoutButton() {
        click(By.xpath("//button[contains(.,'Abmelden')]")); // клик кнопки "Выход"
    }

    public void clickOnLoginButton() {
        click(By.xpath("//button[contains(.,'Log In')]"));
    } // клик кнопки входа

    public void isLoggedUser() {
        assertTrueElement(By.xpath("//button[contains(.,'Abmelden')]"));
    } // пользователь залогинен

    public void clickOnOkButton() {
        click(By.xpath("//button[contains(.,'Ok')]"));
    }

    public void isModalErrorPresent() {
        assertTrueElement(By.xpath("//p[contains(.,'Benutzerdaten wurden falsch eingegeben')]"));
    }

    public boolean isLoggedUserBool() {
        return isElementPresent(By.xpath("//button[contains(.,'Abmelden')]"));
    } // пользователь залогинен
}
