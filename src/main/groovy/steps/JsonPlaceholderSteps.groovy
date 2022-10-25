package steps

import io.qameta.allure.Step
import io.restassured.response.Response
import static io.restassured.RestAssured.given

class JsonPlaceholderSteps {

    static serviceUrl = "https://jsonplaceholder.typicode.com"

    @Step("Get user data")
    static Response getUserData(int userId = 1) {
        given()
                .when()
                .get("${serviceUrl}/users/${userId}")
    }

}
