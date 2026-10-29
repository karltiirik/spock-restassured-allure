import io.qameta.allure.Description
import io.qameta.allure.Epic
import io.qameta.allure.Feature
import io.qameta.allure.Issue
import io.qameta.allure.Link
import io.qameta.allure.Story
import io.qameta.allure.TmsLink
import io.restassured.response.Response

import static org.hamcrest.Matchers.is

@Link("https://jsonplaceholder.typicode.com/")
@Epic("/users")
class UsersTest extends Spec {

	@Issue("123")
	@Feature("/users/{}")
	@Story("Get a single user's data")
	@Description("Some detailed info")
	def "Querying existing user #name returns 200 OK and user's info"() {
		when: "GET /users/#id"
		Map response = Steps
				.getUsersById(id)
				.then()
				.statusCode(200)
				.extract()
				.as(Map.class)

		then: "response is correct"
		response["id"] == id
		response["name"] == name
		response["company"]["name"] == companyName

		where:
		id | name               | companyName
		1  | "Leanne Graham"    | "Romaguera-Crona"
		2  | "Ervin Howell"     | "Deckow-Crist"
		3  | "Clementine Bauch" | "Romaguera-Jacobson"
	}

	@Link(name = "MORE_INFO", url = "https://jsonplaceholder.typicode.com/guide/")
	@TmsLink("test-1")
	@Feature("/users")
	@Story("Get all user's data")
	def "Querying all users returns JSON with 10 users"() {
		when: "GET /users"
		Response response = Steps
				.getUsers()

		then: "response status is 200 and 10 users are returned"
		response
				.then()
				.statusCode(200)
				.body("size()", is(10))
	}

}
