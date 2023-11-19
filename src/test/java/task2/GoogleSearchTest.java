package task2;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.GoogleCookiePage;
import pages.GoogleMainPage;

public class GoogleSearchTest extends BaseTest {
    private final String inputValue = "Joe Biden";

    @BeforeClass
    public void changeLanguageAndRejectCookie() {
        new GoogleCookiePage()
                .changeLanguageToEnglish()
                .clickOnRejectAllCookieButton();
    }

    @Test(description = "Verify search by Name")
    public void searchByNameTest() {
        new GoogleMainPage()
                .fillInSearchField(inputValue)
                .assertSearchResults(inputValue);
    }

    @Test(description = "Verify tooltip on search input", priority = 1)
    public void searchInputTooltipTest() {
        new GoogleMainPage()
                .clickOnLogoIcon()
                .assertSearchInputTooltip();
    }

    @Test(description = "Verify empty results area after clicking on the logo", priority = 2)
    public void emptyResultsAreaAfterLogoClickTest() {
        new GoogleMainPage()
                .fillInSearchField(inputValue)
                .clickOnLogoIcon()
                .assertEmptySearchResultsArea();
    }
}
