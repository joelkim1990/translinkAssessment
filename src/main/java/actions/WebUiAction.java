package actions;

import exceptions.WebElementNotFoundException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebUiAction {
    public static WebDriver driver;

    public WebUiAction(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToUrl(String url) {
        driver.navigate().to(url);
    }

    public void click(String xpath) throws WebElementNotFoundException {
        driver.findElement(By.xpath(xpath)).click();
        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void inputText(String xpath, String text) throws WebElementNotFoundException {
        WebElement webElement = driver.findElement(By.xpath(xpath));
        webElement.clear();
        webElement.sendKeys(text);
    }

    public boolean isPresent(String xpath) {
        WebElement webElement = driver.findElement(By.xpath(xpath));
        return webElement.isDisplayed();
    }

    public void waitXSeconds(int sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public int getSizeOfIframes() {
        return driver.findElements(By.tagName("iframe")).size();
    }

    public void switchToIframe(int index) {
        driver.switchTo().frame(index);
    }
}
