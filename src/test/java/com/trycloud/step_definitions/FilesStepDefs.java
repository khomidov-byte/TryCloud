package com.trycloud.step_definitions;

import com.trycloud.pages.DashboardPage;
import com.trycloud.pages.FilesPage;
import com.trycloud.pages.LoginPage;
import com.trycloud.utility.BrowserUtil;
import com.trycloud.utility.ConfigReader;
import com.trycloud.utility.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class FilesStepDefs {
    FilesPage filesPage = new FilesPage();

    @Given("user on the dashboard page")
    public void user_on_the_dashboard_page() {
        Driver.getDriver().get(ConfigReader.read("url"));
        new LoginPage().login();
    }

    @When("user clicks {string} module")
    public void user_clicks_module(String moduleName) {
        new DashboardPage().navigateToModule(moduleName);
    }

    @Then("verify the page title is {string}")
    public void verify_the_page_title_is(String expectedTitle) {
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);

    }


    @When("user click the top left checkbox of the table")
    public void user_click_the_top_left_checkbox_of_the_table() {
        System.out.println("filesPage.allCboxInFiles = " + filesPage.allCboxInFiles.size());

        /**
         * optional
         */
        if(filesPage.allCboxInFiles.size()<3){
            filesPage.createFolder();
        }

        System.out.println("filesPage.allCboxInFiles = " + filesPage.allCboxInFiles.size());

        filesPage.selectAllCbox.click();


    }

    @Then("verify all the files are selected")
    public void verify_all_the_files_are_selected() {
        Assert.assertTrue(BrowserUtil.isAllSelected(filesPage.allCboxInFiles));
    }
}
