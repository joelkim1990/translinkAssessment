package pages;

import actions.WebUiAction;
import exceptions.WebElementNotFoundException;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class HomePage extends BasePage {
    public static Logger logger = Logger.getLogger(HomePage.class.getName());

    public HomePage(WebDriver driver) {
        super(driver);
        driver.navigate().to("https://new.translink.ca/");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    WebUiAction webUiAction = new WebUiAction(driver);

    public void regression(String busNumber) throws WebElementNotFoundException {
        webUiAction.click("//button[contains(@id, 'next')]");
        webUiAction.inputText("//input[@id='NextBusSearchTerm']", busNumber);
        webUiAction.click("//button[contains(text(), 'Find')]");
        webUiAction.click("//button[contains(@class, 'Fav')]");
        webUiAction.inputText("//textarea", "Translink Auto Homework");
        webUiAction.waitXSeconds(3);
        webUiAction.click("//button[contains(text(), 'Add')]");
        webUiAction.click("//a[contains(@href, 'favourites')]");

        for(int i=0; i<3; i++) {
            if(webUiAction.isPresent("//a[text()='Translink Auto Homework']")) {
                webUiAction.click("//a[text()='Translink Auto Homework']");
                break;
            }
            else {
                if(i!=2 && !webUiAction.isPresent("//a[text()='Translink Auto Homework']")) {
                    webUiAction.waitXSeconds(1);
                }
                else throw new WebElementNotFoundException("Favourite Name Not Present");
            }
        }

        webUiAction.switchToIframe(0);
        for(int j=0; j<3; j++) {
            if(!webUiAction.isPresent("//div[contains(text(), '99 Commercial')]")) {
                webUiAction.waitXSeconds(1);
            }
            else break;
        }
        if(!webUiAction.isPresent("//div[contains(text(), '99 Commercial')]")) {
            throw new WebElementNotFoundException("Bus Line Name Not Present");
        }

        webUiAction.click("//a[contains(@href, 'EAST')]");
        webUiAction.click("//a[contains(@href, '61935')]");

        if(!webUiAction.isPresent("//div[contains(text(), '61935')]")) {
            throw new WebElementNotFoundException("Bus Stop Number Not Present");
        }
    }
}
