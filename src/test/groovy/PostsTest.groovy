import io.qameta.allure.Epic
import io.qameta.allure.Feature
import io.qameta.allure.Link
import io.qameta.allure.Story
import io.restassured.response.Response
import steps.Steps

import static org.hamcrest.Matchers.is

@Link("https://jsonplaceholder.typicode.com/")
@Epic("/posts")
class PostsTest extends GenericSpecification {

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
    @Story("Get all posts")
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
