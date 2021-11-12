package gmail.anastasiacoder.steps;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class WebSteps {

    @Step("Open main page")
    public WebSteps openMainPage(){
        open("https://github.com/");
        return this;
    }

    @Step("Search repository {repository}")
    public WebSteps searchForRepository(String repository){
        $("[data-test-selector=nav-search-input]").setValue(repository).pressEnter();
        return this;
    }

    @Step("Open repository {repository}")
    public WebSteps goToRepository(String repository){
        $(linkText(repository)).click();
        return this;
    }
    @Step("Open Issue Tab")
    public WebSteps openIssueTab(){
        $(partialLinkText("Issues")).click();
        return this;
    }
    @Step("Check Issue #{number}")
    public WebSteps shouldSeeIssueWithNumber(int number){
        $(withText("#" + number)).should(Condition.visible);
        return this;
    }
}