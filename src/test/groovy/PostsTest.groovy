import io.qameta.allure.Epic
import io.qameta.allure.Feature
import io.qameta.allure.Link
import io.qameta.allure.Step
import io.qameta.allure.Story
import io.restassured.response.Response

import static org.hamcrest.Matchers.is

@Link("https://jsonplaceholder.typicode.com/")
@Epic("/posts")
class PostsTest extends Spec {

	def setupSpec() { // runs once -  before the first feature method
		dummySetupStep()
	}

	def setup() { // runs before every feature method
		dummySetupStep()
	}

	def cleanup() { // runs after every feature method
		dummyCleanupStep()
	}

	def cleanupSpec() { // runs once -  after the last feature method
		dummyCleanupStep()
	}

	@Step("DummySetupStep")
	Boolean dummySetupStep() {
		return true
	}

	@Step("DummyCleanupStep")
	Boolean dummyCleanupStep() {
		return true
	}

	@Feature("/posts/{}")
	@Story("Get a post")
	def "Querying a post with ID=1 returns correct response"() {
		when: "GET /posts/1"
		Map response = Steps.getPostsById(1)
				.then().statusCode(200)
				.extract().as(Map.class)

		then: "should 200 okay, response matching expected"
		response["id"] == 1
		response["userId"] == 1
		response["title"] == "sunt aut facere repellat provident occaecati excepturi optio reprehenderit"
		response["body"] == "quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto"
	}

	@Feature("/posts")
	@Requirement("EXAMPLE REQUIREMENT")
	def "Querying all posts returns 100 posts "() {
		when: "GET /posts"
		Response response = Steps.getPosts()

		then: "response status is 200 and 100 posts are returned"
		response.then()
				.statusCode(200)
				.body("size()", is(100))
	}
}
