package com.trycloud.step_definitions;

import com.trycloud.pages.FilesPage;
import com.trycloud.utility.BrowserUtil;
import com.trycloud.utility.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class StorageStepDefs {
    FilesPage filesPage = new FilesPage();
    String usageBeforeUpload;

    @When("user checks the current storage usage")
    public void user_checks_the_current_storage_usage() {
        usageBeforeUpload = filesPage.storageUsage.getText();
        int firstSpace = usageBeforeUpload.indexOf(" ");
        usageBeforeUpload = usageBeforeUpload.substring(0, firstSpace);
        System.out.println("usageBeforeUpload = " + usageBeforeUpload);

    }

    @When("user refreshs the page")
    public void user_refreshs_the_page() {
        BrowserUtil.waitFor(4);
        Driver.getDriver().navigate().refresh();
    }

    @Then("user should be able to see storage usage is increased")
    public void user_should_be_able_to_see_storage_usage_is_increased() {
        BrowserUtil.waitFor(3);
        String usageAfterUpload = filesPage.storageUsage.getText();
        int firstSpace = usageAfterUpload.indexOf(" ");
        usageAfterUpload = usageAfterUpload.substring(0, firstSpace);

        System.out.println("usageAfterUpload = " + usageAfterUpload);
        System.out.println("usageBeforeUpload = " + usageBeforeUpload);

        Assert.assertTrue(Integer.parseInt(usageBeforeUpload) < Integer.parseInt(usageAfterUpload));

    }
}
