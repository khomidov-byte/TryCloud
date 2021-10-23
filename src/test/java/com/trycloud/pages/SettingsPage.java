package com.trycloud.pages;

import com.trycloud.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SettingsPage {
    public SettingsPage() {
        PageFactory.initElements(Driver.getDriver(), this);

    }
    @FindBy(xpath = "//div[@id='app-settings-content']//input[@type='checkbox']")
    public List<WebElement> settingCBoxesValue;

    @FindBy(xpath = "//div[@id='app-settings-content']//label[contains(.,'Show')]")
    public List<WebElement> settingCBoxes;



}
