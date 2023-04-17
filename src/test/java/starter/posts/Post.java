package starter.posts;

import net.serenitybdd.core.Serenity;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;

public class Post {

    protected String url = "https://jsonplaceholder.typicode.com/";

    //// Positive

    @Step("I set POST api endpoints")
    public String setPostApiEndpoint() {
        return url + "posts";
    }

    @Step("I send POST HTTP request")
    public void sendPostHttpRequest() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("userId", 10);
        requestBody.put("title", "tes");
        requestBody.put("body", "tes");

        SerenityRest.given().header("Content-Type", "application/json").body(requestBody.toJSONString())
                .post(setPostApiEndpoint());
    }

    @Step("I receive valid HTTP response code 201")
    public void receiveHttpResponseCode201() {
        restAssuredThat(response -> response.statusCode(201));
    }

    @Step("I receive valid data for new posts")
    public void validateDatanewUser() {
        restAssuredThat(response -> response.body("'userId'", equalTo(10)));
        restAssuredThat(response -> response.body("'title'", equalTo("tes")));
        restAssuredThat(response -> response.body("'body'", equalTo("tes")));
    }
    //// Negative

    @Step("I set typo POST api endpoints")
    public String setPostInvalidApiEndpoint() {
        return url + "post/1";
    }

    @Step("I send typo POST HTTP request")
    public void setPostInvalidHttpRequest() {
        SerenityRest.given().get(setPostInvalidApiEndpoint());
    }
    
}
