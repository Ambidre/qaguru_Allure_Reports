package gmail.anastasiacoder.test;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class SelenideTest {

    @Test
    @DisplayName("Selenide")
    @Owner("Anastasia Nosova")
    @Feature("Repository")
    @Story("Check that issues tab is present on repository page")
    @Severity(SeverityLevel.NORMAL)
    public void checkIssueInRepositoryTest(){
        SelenideLogger.addListener("allure6", new AllureSelenide());

        open("https://github.com/");
        $("[data-test-selector=nav-search-input]").setValue("Ambidre/qaguru_Allure_Reports").pressEnter();
        $(linkText("Ambidre/qaguru_Allure_Reports")).click();
        $(partialLinkText("Issues")).click();
        $(withText("#1")).should(Condition.visible);
    }
}