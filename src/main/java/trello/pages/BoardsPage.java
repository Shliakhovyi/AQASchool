package trello.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static core.BrowserFactory.driver;

public class BoardsPage {

    private By profileImg = By.xpath("//*[@class='member-initials']");
    private By logoutBtn = By.xpath("//*[@class='js-logout']");

    public void logout() {
        driver.findElement(profileImg).click();
        driver.findElement(logoutBtn).click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.urlToBe("https://trello.com/logged-out"));
    }
}
