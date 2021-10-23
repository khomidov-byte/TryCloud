package com.trycloud.step_definitions;

import com.github.javafaker.Faker;
import com.trycloud.pages.FilesPage;
import com.trycloud.utility.BrowserUtil;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class CreateFolderStepDefs {
    FilesPage filesPage=new FilesPage();
    String expectedName;

    @When("user click {string}")
    public void user_click(String addOption) {
        filesPage.createWithOption(addOption);
    }
    @When("user write a folder name")
    public void user_write_a_folder_name() {
        expectedName = new Faker().funnyName().name();
        filesPage.folderNameInput.sendKeys(expectedName);
    }
    @When("user click submit icon")
    public void user_click_submit_icon() {
        filesPage.folderSubmit.click();
    }
    @Then("Verify the folder is displayed on the page")
    public void verify_the_folder_is_displayed_on_the_page() {
        BrowserUtil.waitFor(2);
        List<String> actualFileNames = BrowserUtil.getElementsText(filesPage.allFileNamesInFiles);
        System.out.println(actualFileNames);
        System.out.println("expectedName = " + expectedName);
        Assert.assertTrue(actualFileNames.contains(expectedName));

    }
}
