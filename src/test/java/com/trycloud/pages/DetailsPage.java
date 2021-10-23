package com.trycloud.pages;

import com.trycloud.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DetailsPage {
    public DetailsPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a[@id=\"commentsTabView\"]")
    public WebElement commentTab;

    @FindBy(xpath = " //div[@class='message']")
    public WebElement newComment;

    @FindBy(xpath = " //input[@class='submit icon-confirm has-tooltip']")
    public WebElement submitComment;

    @FindBy(xpath = " (//ul[@class='comments']//div[@class='message'])[1]")
    public WebElement lastComment;



}
