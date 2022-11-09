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

    @Step("Get a post")
    static Response getPost(int postId = 1) {
        given()
                .when()
                .get("${serviceUrl}/posts/${postId}")
    }

    @Step("Get all posts")
    static Response getPosts() {
        given()
                .when()
                .get("${serviceUrl}/posts")
    }
}
