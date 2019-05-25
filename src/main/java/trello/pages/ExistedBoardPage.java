package trello.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static core.BrowserFactory.driver;

public class ExistedBoardPage {

    private By moreBtn = By.xpath("//*[@class='board-menu-navigation-item-link js-open-more']");
    private By closeBoardBtn = By.xpath("//*[@class='board-menu-navigation-item-link js-close-board']");
    private By deleteBoardBtn = By.xpath("//*[@class='quiet js-delete']");

    public void deleteBoard() {
        By confirmDeleteBtn = By.xpath("//*[@class='js-confirm full negate']");
        driver.findElement(moreBtn).click();
        new WebDriverWait(driver, 2).until(ExpectedConditions.elementToBeClickable(closeBoardBtn));
        driver.findElement(closeBoardBtn).click();
        driver.findElement(confirmDeleteBtn).click();
        new WebDriverWait(driver, 2).until(ExpectedConditions.elementToBeClickable(deleteBoardBtn));
        driver.findElement(deleteBoardBtn).click();
        driver.findElement(confirmDeleteBtn).click();
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[.=\"Board not found.\"]")));
    }
}
