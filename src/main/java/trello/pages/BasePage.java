package trello.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static core.BrowserFactory.driver;
import static org.testng.Assert.assertTrue;

public class BasePage {

    private By homeBtn = By.xpath("//*[@class='header-btn js-back-menu']");

    public void backHome() {
        driver.findElement(homeBtn).click();
        new WebDriverWait(driver, 3).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".mod-add")));
        assertTrue(!driver.findElements(By.cssSelector(".mod-add")).isEmpty(), "Board page not opened");
    }
}
