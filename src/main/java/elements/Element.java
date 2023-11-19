package elements;

import com.codeborne.selenide.SelenideElement;

public class Element {
    public Element clickOnElement(SelenideElement element) {
        element.click();
        return this;
    }

    public void fillInFieldAndClickEnter(SelenideElement element, String inputData) {
        element.setValue(inputData).pressEnter();
    }
}
