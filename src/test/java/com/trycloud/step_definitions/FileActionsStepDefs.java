package com.trycloud.step_definitions;

import com.trycloud.pages.FilesPage;
import com.trycloud.utility.BrowserUtil;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class FileActionsStepDefs {
    FilesPage filesPage = new FilesPage();
    String expectedName;

    /**
     * Add To favorites
     */
    @When("user click action-icon  from any file on the page")
    public void user_click_action_icon_from_any_file_on_the_page() {
        expectedName = filesPage.chooseRandomFileInFilesPage();
    }

    @When("user choose {string} option")
    public void user_choose_option(String action) {
        /*
        if(action.equals("Delete")){
            filesPage.chooseToDelete(action);

        }

         */

        filesPage.chooseAction(action);
    }

    @When("user click {string} sub-module on the left side")
    public void user_click_sub_module_on_the_left_side(String subModule) {
        filesPage.chooseSubModule(subModule);
    }

    @Then("Verify the chosen file is listed on the table")
    public void verify_the_chosen_file_is_listed_on_the_table() {
        List<String> favoritesListNames = BrowserUtil.getElementsText(filesPage.allFileNamesInFavorites);
        System.out.println("favoritesListNames = " + favoritesListNames);
        System.out.println("expectedName = " + expectedName);

        Assert.assertTrue(favoritesListNames.contains(expectedName));
    }

    /**
     * Remove From Favorites
     *
     */

    @When("user click action-icon from any file on the page to remove")
    public void user_click_action_icon_from_any_file_on_the_page_to_remove() {
        expectedName = filesPage.removeFavorite();


    }
    @Then("Verify that the file is removed from Favorites sub-module’s table")
    public void verify_that_the_file_is_removed_from_favorites_sub_module_s_table() {
        List<String> allFavoriteName = BrowserUtil.getElementsText(filesPage.allFileNamesInFavorites);
        System.out.println("allFavoriteName = " + allFavoriteName);
        System.out.println("expectedName = " + expectedName);

        Assert.assertFalse(allFavoriteName.contains(expectedName));

    }
    /**
     * Delete
     */

    @Then("Verify the deleted file is displayed on the page.")
    public void verify_the_deleted_file_is_displayed_on_the_page() {


        List<String> actualDeletedFileNames = BrowserUtil.getElementsText(filesPage.deletedFileNames);
        System.out.println("actualDeletedFileNames = " + actualDeletedFileNames);

        System.out.println("expectedName = " + expectedName);

        Assert.assertTrue(actualDeletedFileNames.contains(expectedName));

    }

}
