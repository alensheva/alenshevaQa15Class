import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OpenChromeTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();

    }

    @Test
    public void testOpenBrowser(){
        driver.navigate().to("https://btl.gov.il/Pages/default.aspx");
    }
    @AfterMethod
    public void tearDown(){
      driver.quit();
    }
}
