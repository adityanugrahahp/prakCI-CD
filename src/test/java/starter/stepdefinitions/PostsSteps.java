package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.posts.Delete;
import starter.posts.Get;
import starter.posts.Post;
import starter.posts.Update;

public class PostsSteps {
    @Steps
    Get get;

    @Steps
    Post post;

    @Steps
    Update update;

    @Steps
    Delete delete;

    // GET
    //// Positive

    @Given("I set GET api endpoints")
    public void setGetApiEndpoints() {
        get.setApiEndpoint();

    }

    @When("I send GET HTTP request")
    public void setGetHttpRequest() {
        get.setGetHttpRequest();

    }

    @Then("I receive valid HTTP response code 200")
    public void receiveValidHttpResponse() {
        get.validateHttpResponseCode200();

    }

    @And("I receive valid data for all of the posts")
    public void receiveValidDataForDetailUser() {
        get.validateDataDetailUser();
    }

    // GET
    //// Negative

    @Given("I set typo GET api endpoints")
    public void setGetApiEndpoints2() {
        get.setApiEndpoint2();
    }

    @When("I send typo GET HTTP request")
    public void setGetHttpRequest2() {
        get.setGetHttpRequest2();
    }

    @Then("I receive invalid HTTP response code 404 Not Found")
    public void receiveInvalidHttpResponse() {
        get.validateHttpResponseCode404();
    }

    @And("I receive nothing from the page")
    public void receiveNothing() {
        get.receiveNothing();
    }

    // POST
    //// Positive

    @Given("I set POST api endpoints")
    public void setPostApiEndpoints() {
        post.setPostApiEndpoint();
    }

    @When("I send POST HTTP request")
    public void sendPostHttpRequest() {
        post.sendPostHttpRequest();
    }

    @Then("I receive valid HTTP response code 201")
    public void receiveValidHttp201() {
        post.receiveHttpResponseCode201();
    }

    @And("I receive valid data for new posts")
    public void validateDataNewUser() {
        post.validateDatanewUser();
    }

    // POST
    //// Negative

    @Given("I set typo POST api endpoints")
    public void setPostInvalidApiEndpoints() {
        post.setPostInvalidApiEndpoint();
    }

    @When("I send typo POST HTTP request")
    public void setPostHttpRequest() {
        post.setPostInvalidHttpRequest();
    }

    // UPDATE
    //// Positive

    @Given("I set PUT api endpoints")
    public void setPutApiEndpoints() {
        update.setPutApiEndpoints();
    }

    @When("I send PUT HTTP request")
    public void sendPutHttpRequest() {
        update.sendPutHttpRequest();
    }

    @And("I receive valid data for update posts")
    public void validateUpdateUser() {
        update.validateUpdateUser();
    }

    // UPDATE
    //// Negative

    @Given("I set PUT to invalid api endpoints")
    public void setPutInvalidApiEndpoints() {
        update.setPutInvalidApiEndpoints();
    }

    @Then("I receive invalid HTTP response code 500")
    public void receiveHttpResponseCode500() {
        update.receiveHttpResponseCode500();
    }

    // DELETE
    //// Positive

    @Given("I set DELETE api endpoints")
    public void setDeleteApiEndpoints() {
        delete.setDeleteApiEndpoints();
    }

    @When("I send DELETE HTTP request")
    public void sendDeleteApiEndpoints() {
        delete.sendDeleteApiEndpointsRequest();
    }

    // DELETE
    //// Negative

    @Given("I set DELETE to invalid api endpoints")
    public void setDeleteInvalidApiEndpoints() {
        delete.setDeleteInvalidApiEndpoints();
    }

}