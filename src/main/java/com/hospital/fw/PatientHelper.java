package com.hospital.fw;

import com.hospital.model.Patient;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class PatientHelper extends BaseHelper {
    public PatientHelper(WebDriver driver) {
        super(driver);
    }

    public void fillFindPatient(Patient patient) {
        type(By.xpath("//input[@name='name']"), patient.getName());
    }

    public void isNewRequestPresent() {
        assertTrueElement(By.xpath("//h2[contains(.,'Neue Bestellung')]"));
    }

    public void isModalFindPatientPresent() {
        assertTrueElement(By.xpath("//h3[contains(.,'Sie einen Patient aus')]"));
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
        click(By.xpath("//p[contains(.,'hlen')]"));
    }

    public void clickOnNewRequstButton() {
        click(By.xpath("//button[contains(.,'Erstellen Sie eine Bestellung')]"));
    }

    public void clickOnFindPatientButton() {
        click(By.xpath("//button[contains(.,'Sie einen Patient aus')]"));
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
}
