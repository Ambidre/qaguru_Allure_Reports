package gmail.anastasiacoder.test;

import gmail.anastasiacoder.steps.WebSteps;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StepAnnotatedTest {
    private static final String REPOSITORY = "Ambidre/qaguru_Allure_Reports";
    private static final int ISSUE_NUMBER = 1;

    private WebSteps steps = new WebSteps();

    @Test
    @Owner("Anastasia Nosova")
    @Feature("Repository")
    @Story("Check that issues tab is present on repository page")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Selenide ")
    public void checkIssueInRepositoryStepsTest(){
        steps.openMainPage().
                searchForRepository(REPOSITORY).
                goToRepository(REPOSITORY).
                openIssueTab().
                shouldSeeIssueWithNumber(ISSUE_NUMBER);
    }
}