package com.trycloud.pages;

import com.github.javafaker.Faker;
import com.trycloud.utility.BrowserUtil;
import com.trycloud.utility.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class FilesPage {



    public FilesPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "//label[@for='select_all_files']")
    public WebElement selectAllCbox;

    @FindBy(xpath = "//td[@class='selection']/input ")
    public List<WebElement> allCboxInFiles;

    @FindBy(xpath = "//div/div[contains(@style,'folder')]")
    public List<WebElement> allFolders;


    /**
     * locators for add button options
     */

    @FindBy(xpath = "//div[@class='actions creatable']//li")
    public List<WebElement> allAddOptions;

    @FindBy(css = ".button.new")
    public WebElement addIcon;

    @FindBy(xpath = "//a[@class='menuitem']/span[2]")
    public WebElement addFolder;

    @FindBy(xpath = "//input[contains(@value,'New')]")
    public WebElement folderNameInput;

    @FindBy(xpath = "//li/a/form/input[@type='submit']")
    public WebElement folderSubmit;

    /**
     * locators for favorites
     */

    @FindBy(xpath = "//a[@class='action action-menu permanent']")
    public List<WebElement> allActionsInFiles;

    @FindBy(xpath = "(//tbody[@id='fileList'])[3]//span[@class='nametext']/span")
    public List<WebElement> allFileNamesInFavorites;

    @FindBy(css = ".icon.icon-starred")
    public List<WebElement> allFavoritesInFiles;

    /**
     *
     * locators for upload
     */
    @FindBy(css = "#uploadprogressbar")
    public WebElement progressbar;

    @FindBy(css = "#file_upload_start")
    public WebElement uploadFile;

    @FindBy(xpath = "//span[@class='nametext']/span[@class='innernametext']")
    public List<WebElement> allFileNamesInFiles;

    /**
     * locators for delete subModule
     */
    @FindBy(xpath = "(//tbody[@id='fileList'])[12]//tr//span[@class='nametext extra-data']/span[@class='innernametext']")
    public List<WebElement> deletedFileNames;

    @FindBy(css = ".settings-button")
    public WebElement settingsButton;

    @FindBy(xpath = "//li[@id='quota']//p")
    public WebElement storageUsage;




    public void createFolder() {

        Faker faker = new Faker();

        while (allCboxInFiles.size() < 3) {
            addIcon.click();
            addFolder.click();
            String folderName = faker.funnyName().name();
            System.out.println(folderName+" is added");
            folderNameInput.sendKeys(folderName);
            folderSubmit.click();
            BrowserUtil.waitFor(3);
            // can be progress bar dissappear
        }
    }

    public void createWithOption(String option) {
        Driver.getDriver().findElement(By.xpath("//div[@class='newFileMenu popovermenu bubble menu open menu-left']//span[normalize-space(.)='"+option+"']")).click();
    }


    public String chooseRandomFileInFilesPage() {

        /**
         * allActionsInFiles  is List  0-----size-1
         * 1-----size
         */
        int number = allActionsInFiles.size();
        String expectedFileName = Driver.getDriver().findElement(By.xpath("(//span[@class='nametext'])["+number+"]/span")).getText();
        System.out.println(expectedFileName);
        allActionsInFiles.get(number-1).click();


        return expectedFileName;

    }

    public void chooseAction(String action) {


        BrowserUtil.waitFor(2);
        Driver.getDriver().findElement(By.xpath("//li//span[contains(normalize-space(.),'"+action+"')]")).click();
    }

    public void chooseSubModule(String subModule) {
        Driver.getDriver().findElement(By.xpath("//ul[@class='with-icon']//a[normalize-space(.)='"+subModule+"']")).click();
    }


    public String removeFavorite() {
        int random = BrowserUtil.randomNumber(1,allFavoritesInFiles.size());

        String expectedFileName = Driver.getDriver().findElement(By.xpath("(//span[@class='nametext'])["+random+"]/span")).getText();
        System.out.println(expectedFileName);
        allActionsInFiles.get(random-1).click();


        return expectedFileName;
    }

    public void waitUntilProgressbarDisappear() {
        try {
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 1000);
            wait.until(ExpectedConditions.invisibilityOf(progressbar));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
