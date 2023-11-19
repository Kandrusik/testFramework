package pages;

import base.BasePage;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class GoogleCookiePage extends BasePage {
    private final SelenideElement REJECT_All_COOKIE_BUTTON = $(byXpath("//*[text()='Reject all']"));
    private final SelenideElement CHOOSE_LANGUAGE_BUTTON = $(byXpath("//*[@alt='Google']/following-sibling::div/div/button"));

    public GoogleCookiePage changeLanguageToEnglish() {
        var englishLocator = "//li[contains(text(), 'English (United States)')]";
        element.clickOnElement(CHOOSE_LANGUAGE_BUTTON)
                .clickOnElement($(byXpath(englishLocator)));
        return this;
    }

    public void clickOnRejectAllCookieButton() {
        element.clickOnElement(REJECT_All_COOKIE_BUTTON);
        new GoogleMainPage();
    }
}
