import com.codeborne.selenide.logevents.SelenideLogger
import io.qameta.allure.restassured.AllureRestAssured
import io.qameta.allure.selenide.AllureSelenide
import io.restassured.RestAssured
import io.restassured.filter.log.RequestLoggingFilter
import io.restassured.filter.log.ResponseLoggingFilter

class BeforeAll {

    BeforeAll() {
        // Rest Assured settings
        // Log all requests and responses locally and in allure report
        RestAssured.filters(new AllureRestAssured(), new RequestLoggingFilter(), new ResponseLoggingFilter())

        // Selenide settings
        // Log selenide steps in allure
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide())
    }

}
