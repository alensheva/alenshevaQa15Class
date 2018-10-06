package homework2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class TestBase2 {

    WebDriver wd;

    @BeforeMethod
    public void setUp() throws InterruptedException {
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        openWikipedia();
        Thread.sleep(4000);
    }

    public void openWikipedia() {
        wd.get("https://www.wikipedia.org/");
    }

    public void clickOnTheLoupeButton() {
        wd.findElement(By.cssSelector("i.sprite.svg-search-icon")).click();
    }

    public void writeJavaInSearchBar() {
        wd.findElement(By.name("search")).sendKeys("java");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        wd.quit();
    }
}
