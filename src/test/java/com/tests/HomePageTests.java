package com.tests;

import org.testng.annotations.Test;

public class HomePageTests extends TestBase {

    @Test
    public void openHomePageTest(){
//        driver.findElement(By.xpath("//button[contains(.,'Weiter')]")); // находим елемент: кнопка с текстом "Weiter"
//        System.out.println(isHomeComponentPresent());
//        System.out.println(isElementPresent(By.xpath("//button[contains(.,'Weiter')]")));
        app.getHomePage().isHomeComponentPresent();
    }
}
