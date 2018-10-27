import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class TrelloBase {

    WebDriver wd;

    @BeforeMethod
    public void start(){
        openPage();
    }

    public void openPage() {
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wd.navigate().to("https://trello.com/");
    }

    public void loginTrello(String username, String password) {
        wd.findElement(By.xpath("//a[@class='global-header-section-button']")).click();
        type(By.name("user"),username);
        type(By.name("password"),password);
        wd.findElement(By.xpath("//input[@id='login']")).click();
    }

    public void type(By locator, String text) {
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        closePage();
    }

    public void closePage() throws InterruptedException {
        Thread.sleep(9000);

        wd.quit();
    }
}
