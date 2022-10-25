import io.restassured.response.Response
import steps.JsonPlaceholderSteps

import static org.hamcrest.Matchers.is

class RestAssuredTest extends GenericSpecification {

    def "validate json response"() {
        given: "set up request"
        when: "get todos"
        Response response = JsonPlaceholderSteps.getUserData(1)

        then: "should 200 okay, response matching expected"
        response.then()
                .statusCode(200)
                .body("id", is(1))
                .body("name", is("Leanne Graham"))
                .body("company.name", is("Romaguera-Crona"))
    }

}
