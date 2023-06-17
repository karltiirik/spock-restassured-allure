import com.codeborne.selenide.Condition
import org.openqa.selenium.By

import static com.codeborne.selenide.Selenide.$
import static com.codeborne.selenide.Selenide.open

class E2ETest extends GenericSpecification {

    def "UI POC test"() {
        given: "https://jsonplaceholder.typicode.com/ is opened"
        open("https://jsonplaceholder.typicode.com/")

        when: "user opens guide"
        $(By.linkText("Guide")).click()

        then: "Guide page is displayed"
        $("title").shouldHave(Condition.attribute("text", "JSONPlaceholder - Guide"))
    }
}
