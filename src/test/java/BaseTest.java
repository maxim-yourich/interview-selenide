import com.bluep.commons.managers.TestResultCollector;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(TestResultCollector.class)
public class BaseTest {
    @BeforeAll
    public static void beforeAllTests() {
        System.setProperty("selenide.browser", "Chrome");
        Configuration.headless = true;
    }
}
