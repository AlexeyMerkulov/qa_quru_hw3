import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class GitHubSelenideTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://github.com/selenide";
    }

    @Test
    void testJunit5CodeExampleIsDisplayed() {
        open("/selenide");
        $("#wiki-tab").click();
        $("li.Box-row.wiki-more-pages-link button").click();
        $("li.Box-row a[href='/selenide/selenide/wiki/SoftAssertions']")
                .shouldBe(visible)
                .shouldHave(text("SoftAssertions"))
                .click();
        $("#wiki-content").shouldHave(text(
                "@ExtendWith({SoftAssertsExtension.class})\n" +
                        "class Tests {\n" +
                        "@Test\n" +
                        "void test() {\n" +
                        "Configuration.assertionMode = SOFT;\n" +
                        "open(\"page.html\");\n" +
                        "$(\"#first\").should(visible).click();\n" +
                        "$(\"#second\").should(visible).click();\n" +
                        "}"
        ));
    }
}
