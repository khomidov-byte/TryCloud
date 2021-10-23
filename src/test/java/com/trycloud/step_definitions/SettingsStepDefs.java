package com.trycloud.step_definitions;

import com.trycloud.pages.FilesPage;
import com.trycloud.pages.SettingsPage;
import com.trycloud.utility.BrowserUtil;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class SettingsStepDefs {

    SettingsPage settingsPage=new SettingsPage();

    @When("user clicks Settings on the left bottom corner")
    public void user_clicks_settings_on_the_left_bottom_corner() {
        new FilesPage().settingsButton.click();
    }
    @Then("user should be able to click any buttons")
    public void user_should_be_able_to_click_any_buttons() {
        BrowserUtil.waitFor(2);
        boolean beforeClick = settingsPage.settingCBoxesValue.get(2).isSelected();
        settingsPage.settingCBoxes.get(2).click();

        BrowserUtil.waitFor(2);
        boolean afterClick = settingsPage.settingCBoxesValue.get(2).isSelected();

        Assert.assertTrue(!beforeClick==afterClick);

    }

}
