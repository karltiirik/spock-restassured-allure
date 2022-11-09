package steps

import io.qameta.allure.Step
import io.restassured.response.Response
import static io.restassured.RestAssured.given

class Steps {

    static serviceUrl = "https://jsonplaceholder.typicode.com"

    @Step("Get user's data")
    static Response getUserData(int userId = 1) {
        given()
                .when()
                .get("${serviceUrl}/users/${userId}")
    }

    @Step("Get all user's data")
    static Response getUsersData() {
        given()
                .when()
                .get("${serviceUrl}/users")
    }

}
