package com.trycloud.step_definitions;

import com.trycloud.pages.TalkPage;
import com.trycloud.utility.BrowserUtil;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class TalkConversationStepDefs {
    TalkPage talkPage = new TalkPage();
    String expectedMessage = "Test for tryCloud";

    @When("user search user from searchbox")
    public void user_search_user_from_searchbox() {
        talkPage.conversationBox.sendKeys("User172");
        talkPage.allUsers.get(0).click();
    }

    @When("user write message")
    public void user_write_message() {
        talkPage.messageBox.sendKeys(expectedMessage);
        BrowserUtil.waitFor(2);
    }

    @When("user clicks to submit button")
    public void user_clicks_to_submit_button() {
        talkPage.submitButton.click();
    }

    @Then("user should be able to see message is displayed on the conversation log")
    public void user_should_be_able_to_see_message_is_displayed_on_the_conversation_log() {

        String actualMessage = talkPage.checkMessage(talkPage.allMessages.size());

        System.out.println("actualMessage = " + actualMessage);

        Assert.assertEquals(expectedMessage, actualMessage);
    }

}
