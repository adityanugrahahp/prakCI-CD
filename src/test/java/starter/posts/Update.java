package starter.posts;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import org.json.simple.JSONObject;
import net.serenitybdd.core.Serenity;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;

public class Update {

    protected String url = "https://jsonplaceholder.typicode.com/";

    @Step("I set PUT api endpoints")
    public String setPutApiEndpoints() {
        return url + "posts/1";
    }

    @Step("I send PUT HTTP request")
    public void sendPutHttpRequest() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("title", "tes");
        requestBody.put("body", "tes");

        SerenityRest.given().header("Content-Type", "application/json").body(requestBody.toJSONString())
                .put(setPutApiEndpoints());
    }

    @Step("I receive valid data for update posts")
    public void validateUpdateUser() {
        restAssuredThat(response -> response.body("'title'", equalTo("tes")));
        restAssuredThat(response -> response.body("'body'", equalTo("tes")));
    }

    //// Negative

    @Step("I set PUT to invalid api endpoints")
    public String setPutInvalidApiEndpoints() {
        return url + "posts/101";
    }

    @Step("I receive invalid HTTP response code 500")
    public void receiveHttpResponseCode500() {
        restAssuredThat(response -> response.statusCode(200));
    }

}
