import io.qameta.allure.Description
import io.qameta.allure.Epic
import io.qameta.allure.Feature
import io.qameta.allure.Issue
import io.qameta.allure.Link
import io.qameta.allure.Story
import io.qameta.allure.TmsLink
import io.restassured.response.Response
import steps.Steps

import static org.hamcrest.Matchers.is

@Link("https://jsonplaceholder.typicode.com/")
@Epic("/users")
class UsersTest extends GenericSpecification {

    @Issue("123")
    @Feature("/users/{}")
    @Story("Get a single user's data")
    @Description("Some detailed info")
    def "Given: user #name exists; When: an existing user #name is queried; Then: correct response is returned"() {
        given: "user #name exists"
        when: "get user's data"
        Response response = Steps.getUserData(id)

        then: "should 200 okay, response matching expected"
        response.then()
                .statusCode(200)
                .body("id", is(id))
                .body("name", is(name))
                .body("company.name", is(companyName))
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
    def "Given: users exist, When: all users are queried; Then: all users are returned"() {
        given: "10 users exist"
        when: "get all user's data"
        Response response = Steps.getUsersData()

        then: "should 200 okay, all users returned"
        response.then()
                .statusCode(200)
                .body("size()", is(10))
    }

}
