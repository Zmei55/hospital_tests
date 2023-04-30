package com.hospital;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.Test;

public class HomePageTests extends TestBase {

    @Test
    public void openHomePageTest(){
//        driver.findElement(By.xpath("//button[contains(.,'Weiter')]")); // находим елемент: кнопка с текстом "Weiter"
//        System.out.println(isHomeComponentPresent());
//        System.out.println(isElementPresent(By.xpath("//button[contains(.,'Weiter')]")));
        isLoginFormPresent();
    }

    public boolean isHomeComponentPresent(){
        try {
            driver.findElement(By.xpath("//button[contains(.,'Weiter')]"));
            return true;
        } catch (NoSuchElementException exception){
            return false;
        }
    }

}
