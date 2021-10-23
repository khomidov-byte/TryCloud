package com.trycloud.pages;

import com.trycloud.utility.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DashboardPage {

    public DashboardPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//ul[@id='appmenu']//span")
    public List<WebElement> allModules;


    public void navigateToModule(String moduleName){

        Driver.getDriver().findElement(By.xpath("//ul[@id='appmenu']//span[normalize-space(.)='"+moduleName+"']/..")).click();
    }

}
