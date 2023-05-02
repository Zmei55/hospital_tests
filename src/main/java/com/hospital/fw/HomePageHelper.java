package com.hospital.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class HomePageHelper extends BaseHelper {
    public HomePageHelper(WebDriver driver) {
        super(driver);
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
