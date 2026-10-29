import io.qameta.allure.Step
import io.restassured.response.Response

import static io.restassured.RestAssured.given

class Steps {

	@Step("GET /users/{userId}")
	static Response getUsersById(int userId = 1) {
		given()
				.when()
				.get("${Spec.url}/users/${userId}")
	}

	@Step("GET /users")
	static Response getUsers() {
		given()
				.when()
				.get("${Spec.url}/users")
	}

	@Step("GET /posts/{postId}")
	static Response getPostsById(int postId = 1) {
		given()
				.when()
				.get("${Spec.url}/posts/${postId}")
	}

	@Step("GET /posts")
	static Response getPosts() {
		given()
				.when()
				.get("${Spec.url}/posts")
	}
}
