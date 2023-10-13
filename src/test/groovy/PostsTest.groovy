import io.qameta.allure.Epic
import io.qameta.allure.Feature
import io.qameta.allure.Link
import io.qameta.allure.Step
import io.qameta.allure.Story
import io.restassured.response.Response
import steps.Steps

import static org.hamcrest.Matchers.is

@Link("https://jsonplaceholder.typicode.com/")
@Epic("/posts")
class PostsTest extends GenericSpecification {

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
    def "Given: a post exists; When: a post is queried; Then: correct response is returned "() {
        given: "a post exists"
        when: "a post is queried"
        Response response = Steps.getPost(1)

        then: "should 200 okay, response matching expected"
        response.then()
                .statusCode(200)
                .body("id", is(1))
                .body("userId", is(1))
                .body("title", is("sunt aut facere repellat provident occaecati excepturi optio reprehenderit"))
                .body("body", is("quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto"))
    }

    @Feature("/posts")
    @Requirement("EXAMPLE")
    def "Given: posts exists; When: posts are queried; Then: all posts returned "() {
        given: "posts exists"
        when: "posts are queried"
        Response response = Steps.getPosts()

        then: "should 200 okay, all posts returned"
        response.then()
                .statusCode(200)
                .body("size()", is(100))
    }
}
