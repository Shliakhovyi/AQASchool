package trello;

import core.BrowserFactory;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import trello.pages.BoardsPage;
import trello.pages.LoginPage;

public class LoginTest extends BrowserFactory {

    private LoginPage loginPage;
    private BoardsPage boardsPage;

    @BeforeTest
    public void setUpTest() {
        loginPage = new LoginPage();
        boardsPage = new BoardsPage();
    }

    @Test
    public void login() {
        loginPage.open();
        loginPage.login("shliakhovyi.sviatoslav@pdffiller.team", "906578grib");
        Assert.assertTrue(!driver.findElements(By.cssSelector(".mod-add")).isEmpty(), "Board page not opened");
    }

    @Test(dependsOnMethods = { "login" })
    public void logout() {
        boardsPage.logout();
        Assert.assertTrue(!driver.findElements(By.xpath("//*[@href='/login']")).isEmpty(), "Log Out page not opened");
    }
}
