package trello.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static core.BrowserFactory.driver;

public class BoardsPage {

    private By profileImg = By.xpath("//*[@class='member-initials']");
    private By logoutBtn = By.xpath("//*[@class='js-logout']");
    private By createNewBoardBtn = By.xpath("//*[@class='board-tile mod-add']");
    private By boardTitleFld = By.xpath("//*[@placeholder='Add board title']");

    public void logout() {
        driver.findElement(profileImg).click();
        driver.findElement(logoutBtn).click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.urlToBe("https://trello.com/logged-out"));
    }

    public void createBoard() {
        driver.findElement(createNewBoardBtn).click();
        driver.findElement(boardTitleFld).sendKeys("testTitle");
        driver.findElement(boardTitleFld).submit();
        new WebDriverWait(driver, 10).until(ExpectedConditions.urlContains("/testtitle"));
    }

    public void openBoard() {
        driver.findElement(By.xpath("(//*[@class=\"board-tile-details is-badged\"])[2]")).click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.urlContains("/testtitle"));
    }


}
