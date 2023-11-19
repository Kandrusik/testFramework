package task2;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import config.PropertiesConfig;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import static com.codeborne.selenide.Selenide.open;

public class BaseTest {

    @BeforeClass
    public void setUpBeforeClass() {
        Configuration.headless = true;
        initialPage();
    }

    @AfterClass
    public void tearDown() {
        Selenide.closeWebDriver();
    }

    private void initialPage() {
        var startUrlPage = PropertiesConfig.getProperty("google.url");
        open(startUrlPage);
    }
}
