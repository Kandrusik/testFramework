package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class GoogleMainPage extends GoogleCookiePage {
    private final SelenideElement SEARCH_INPUT_FIELD = $(byXpath("//*[@type='search']"));
    private final SelenideElement GOOGLE_LOGO = $(byId("logo"));
    private final SelenideElement SEARCH_RESULTS_AREA = $(byId("search"));

    public GoogleMainPage fillInSearchField(String inputValue) {
        element.fillInFieldAndClickEnter(SEARCH_INPUT_FIELD, inputValue);
        return this;
    }

    public GoogleMainPage clickOnLogoIcon() {
        element.clickOnElement(GOOGLE_LOGO);
        return this;
    }

    public void assertSearchResults(String expectedQuery) {
        SEARCH_RESULTS_AREA.shouldHave(Condition.text(expectedQuery));
    }

    public void assertSearchInputTooltip() {
        SEARCH_INPUT_FIELD.hover().shouldHave(Condition.attribute("title", "Search"));
    }

    public void assertEmptySearchResultsArea() {
        SEARCH_RESULTS_AREA.shouldNotBe(Condition.visible);
    }
}
