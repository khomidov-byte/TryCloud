package com.trycloud.step_definitions;

import com.trycloud.pages.FilesPage;
import com.trycloud.utility.BrowserUtil;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class FileUploadStepDefs {
    FilesPage filesPage = new FilesPage();
    int sizeBeforeAdd;

    @When("user clicks the add icon on top")
    public void user_clicks_the_add_icon_on_top() {
        filesPage.addIcon.click();
    }

    @When("user  uploads file with upload file option")
    public void user_uploads_file_with_upload_file_option() {
        String path="/Users/soyturk/IdeaProjects/B23/OfficeHours/tryCloudUIAutomation/src/test/resources/files/pluginForParallel.png";

        //filesPage.createRandomFile();

        sizeBeforeAdd=filesPage.allFileNamesInFiles.size();
        filesPage.uploadFile.sendKeys(path);

    }

    @Then("Verify the file is displayed on the page")
    public void verify_the_file_is_displayed_on_the_page() {
        BrowserUtil.waitFor(3);
        int sizeAfterAdd=filesPage.allFileNamesInFiles.size();
        System.out.println("sizeBeforeAdd = " + sizeBeforeAdd);
        System.out.println("sizeAfterAdd = " + sizeAfterAdd);

        Assert.assertTrue(sizeBeforeAdd+1==sizeAfterAdd);
    }

    @When("user choose a folder from the page")
    public void user_choose_a_folder_from_the_page() {
        filesPage.allFolders.get(0).click();
    }
}
