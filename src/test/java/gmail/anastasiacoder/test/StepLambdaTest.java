package gmail.anastasiacoder.test;

import com.codeborne.selenide.Condition;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class StepLambdaTest {

    private static final String REPOSITORY = "Ambidre/qaguru_Allure_Reports";
    private static final int ISSUE_NUMBER = 1;

    @Test
    @DisplayName("Selenide")
    @Owner("Anastasia Nosova")
    @Feature("Repository")
    @Story("Check that issues tab is present on repository page")
    @Severity(SeverityLevel.NORMAL)
    public void checkIssueInRepositoryLambdaTest(){
        step("Open main page", () -> {
            open("https://github.com/");
        });
        step("Search repository " + REPOSITORY, () -> {
            $("[data-test-selector=nav-search-input]").setValue("Ambidre/qaguru_Allure_Reports").pressEnter();
        });
        step("Open repository " + REPOSITORY, () -> {
            $(linkText("Ambidre/qaguru_Allure_Reports")).click();
        });
        step("Open Issue Tab", () -> {
            $(partialLinkText("Issues")).click();
        });
        step("Check Issue #" + ISSUE_NUMBER + " exist", () -> {
            $(withText("#" + ISSUE_NUMBER)).should(Condition.visible);
        });
    }
}