package com.trycloud.pages;

import com.trycloud.utility.BrowserUtil;
import com.trycloud.utility.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class TalkPage {
    public TalkPage() {
        PageFactory.initElements(Driver.getDriver(), this);

    }

    @FindBy(css = ".app-navigation-search__input")
    public WebElement conversationBox;

    @FindBy(xpath = "//a[@id=\"commentsTabView\"]")
    public WebElement commentTab;

    @FindBy(xpath = "//div[@class='acli__content']")
    public List<WebElement> allUsers;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement submitButton;

    @FindBy(xpath = "//div[@role='textbox']")
    public WebElement messageBox;

    @FindBy(xpath = "(//span[contains(.,\"Today\")]/../..//div[@class='message__main__text'])")
    public List<WebElement> allMessages;

    public String checkMessage(int allMessages) {
        BrowserUtil.waitFor(3);
        return  Driver.getDriver().findElement(By.xpath("(//span[contains(.,\"Today\")]/../..//div[@class='message__main__text'])["+allMessages+"]")).getText();
    }
}
