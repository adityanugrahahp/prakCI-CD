package starter.posts;

import net.serenitybdd.rest.SerenityRest;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;
import net.thucydides.core.annotations.Step;

public class Get {

    protected static String url = "https://jsonplaceholder.typicode.com/";

    ////Positive

    @Step("I set GET api endpoints")
    public String setApiEndpoint() {
        return url + "posts/1";
    }

    @Step("I send GET HTTP request")
    public void setGetHttpRequest() {
        SerenityRest.given().get(setApiEndpoint());
    }

    @Step("I receive valid HTTP response code 200")
    public void validateHttpResponseCode200() {
        restAssuredThat(response -> response.statusCode(200));
    }

    @Step("I receive valid data for all of the posts")
    public void validateDataDetailUser() {
        restAssuredThat(response -> response.body("userId", equalTo(1)));
        restAssuredThat(response -> response.body("title", equalTo("sunt aut facere repellat provident occaecati excepturi optio reprehenderit")));
    }

    ////Negative
    
    @Step("I set typo GET api endpoints")
    public String setApiEndpoint2() {
        return url + "post/1";
    }

    @Step("I send typo GET HTTP request")
    public void setGetHttpRequest2() {
        SerenityRest.given().get(setApiEndpoint2());
    }

    @Step("I receive invalid HTTP response code 404 Not Found")
    public void validateHttpResponseCode404() {
        restAssuredThat(response -> response.statusCode(404));
    }

    @Step("I receive nothing from the page")
    public void receiveNothing() {
        restAssuredThat(response -> response.noRootPath());
    }
}
