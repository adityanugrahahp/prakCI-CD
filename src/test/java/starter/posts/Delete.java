package starter.posts;

import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;
import net.serenitybdd.rest.SerenityRest;

public class Delete {
    protected String url = "https://jsonplaceholder.typicode.com/";

    //// Positive

    @Step("I set DELETE api endpoints")
    public String setDeleteApiEndpoints() {
        return url + "posts/1";
    }

    @Step("I send DELETE HTTP request")
    public void sendDeleteApiEndpointsRequest() {
        SerenityRest.given().delete(setDeleteApiEndpoints());
    }

    @Step("I receive valid HTTP response code 200")
    public void validateHttpResponseCode200() {
        restAssuredThat(response -> response.statusCode(200));
    }

    //// Negative

    @Step("I set DELETE to invalid api endpoints")
    public String setDeleteInvalidApiEndpoints() {
        return url + "posts";
    }

    @Step("I receive nothing from the page")
    public void receiveNothing() {
        restAssuredThat(response -> response.noRootPath());
    }

}
