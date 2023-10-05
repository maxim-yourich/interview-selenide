import com.bluep.pages.home.HomePage;
import com.bluep.pages.home.HomePageParamResolver;
import com.bluep.pages.search.SearchPage;
import com.bluep.pages.search.SearchPageParamResolver;
import com.bluep.pages.searchResult.SearchResultPage;
import com.bluep.pages.searchResult.SearchResultPageParamResolver;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

@Execution(ExecutionMode.CONCURRENT)
@ExtendWith({HomePageParamResolver.class, SearchPageParamResolver.class, SearchResultPageParamResolver.class})
public class WebTests extends BaseTest {
    String searchText = "test automation";

    @BeforeEach
    public void beforeTest(HomePage homePage) {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        homePage.navigate();
        homePage.denyCookies();
        homePage.fillInInput(searchText);
    }

    @Test
    @DisplayName("Search by -search icon- click")
    public void click(HomePage homePage, SearchPage searchPage) {
        homePage.clickSearchIcon();
        searchPage.getBanner().shouldHave(Condition.partialText("results found for: \"" + searchText + "\""));
    }

    @Test
    @DisplayName("Search by pressing -Enter-")
    public void seleniumTest2(HomePage homePage, SearchPage searchPage) {
        homePage.pressEnter();
        searchPage.getBanner().shouldHave(Condition.partialText("results found for: \"" + searchText + "\" babun"));
    }

    @AfterEach
    public void afterTest(SearchPage searchPage, SearchResultPage searchResultPage) {
        searchPage.clickFirstResult();
        searchResultPage.getBreadcrumb().shouldHave(Condition.partialText("Home"));
        searchResultPage.getBreadcrumb().shouldHave(Condition.partialText("Solutions"));
        searchResultPage.getBreadcrumb().shouldHave(Condition.partialText("Testing"));
    }
}
