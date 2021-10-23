package com.trycloud.step_definitions;

import com.github.javafaker.Faker;
import com.trycloud.pages.DetailsPage;
import com.trycloud.utility.BrowserUtil;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class CommentsStepDefs {

    DetailsPage detailsPage=new DetailsPage();
    String expectedComment="Godd job "+new Faker().funnyName().name();

    @When("user write a comment inside to the input box")
    public void user_write_a_comment_inside_to_the_input_box() {
        detailsPage.commentTab.click();

    }
    @When("user click the submit button to post it")
    public void user_click_the_submit_button_to_post_it() {
        detailsPage.newComment.sendKeys(expectedComment);
        detailsPage.submitComment.click();
        BrowserUtil.waitFor(3);

    }
    @Then("Verify the comment is displayed in the comment section.")
    public void verify_the_comment_is_displayed_in_the_comment_section() {

        String actualComment = detailsPage.lastComment.getText();
        System.out.println("actualComment = " + actualComment);
        System.out.println("expectedComment = " + expectedComment);
        Assert.assertEquals(expectedComment, actualComment);

    }
}
