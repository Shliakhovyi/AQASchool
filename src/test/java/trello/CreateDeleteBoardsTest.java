package trello;

import core.BrowserFactory;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import trello.pages.BasePage;
import trello.pages.BoardsPage;
import trello.pages.ExistedBoardPage;
import trello.pages.LoginPage;

public class CreateDeleteBoardsTest extends BrowserFactory {

    private BoardsPage boardsPage;
    private ExistedBoardPage existedBoardPage;
    private BasePage basePage;

    @BeforeTest
    public void setUpTest() {
        LoginPage loginPage = new LoginPage();
        loginPage.open();
        loginPage.login("shliakhovyi.sviatoslav@pdffiller.team", "1qaz@WSX");
        boardsPage = new BoardsPage();
        existedBoardPage = new ExistedBoardPage();
        basePage = new BasePage();
    }

    @Test
    public void createBoard() {
        boardsPage.createBoard();
    }

    @Test
    public void deleteBoard() throws InterruptedException {
        existedBoardPage.deleteBoard();
        basePage.backHome();
        driver.navigate().refresh();
        Assert.assertTrue(driver.findElements(By.xpath("//*[@title='testTitle']")).isEmpty(),
                "Board doesn't deleted");
    }
}
