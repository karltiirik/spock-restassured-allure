import com.codeborne.selenide.Condition
import org.openqa.selenium.By

import static com.codeborne.selenide.Selenide.$
import static com.codeborne.selenide.Selenide.open

class E2ETest extends Spec {

	def "Guide title is 'JSONPlaceholder - Guide'"() {
		given: "open '#url'"
		open(url)

		when: "click on 'Guide' link"
		$(By.linkText("Guide")).click()

		then: "page title is 'JSONPlaceholder - Guide'"
		$("title").shouldHave(Condition.attribute("text", "JSONPlaceholder - Guide"))
	}
}
