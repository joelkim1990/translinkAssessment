import exceptions.WebElementNotFoundException;
import org.testng.annotations.Test;
import pages.HomePage;

public class TransLinkAssessment extends BaseTest {

    @Test
    public void TestScenario() throws WebElementNotFoundException {
        HomePage homePage = new HomePage(driver);
        homePage.regression("99");
    }
}
