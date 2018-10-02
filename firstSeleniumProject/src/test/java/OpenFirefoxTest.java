
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class OpenFirefoxTest {
  WebDriver wd;

@BeforeMethod
  public void setUp(){
    wd = new FirefoxDriver();
    wd.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
  }
  @Test
  public void openSiteTest(){
    wd.navigate().to("https://qalight.com.ua/baza-znaniy/dyimnoe-testirovanie/");
  }
  @AfterMethod
  public void tearDown() throws InterruptedException {
    Thread.sleep(2000);
    wd.quit();
  }

}
