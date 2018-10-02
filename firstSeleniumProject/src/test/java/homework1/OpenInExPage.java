package homework1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
// БЛИН,ГЛЮЧНЫЙ ЭТОТ ЭКСПЛОРЕР. КОГДА Я ПЕРВЫЙ РАЗ ДЕЛАЛА ЭТУ ДОМАШКУ(ДО ТОГО КАК Я ВСЕ СНЕСЛА) У МЕНЯ
// НЕ ЗАГРУЖАЛСЯ САЙТ,КАК Я ВЫЯСНИЛА ПОЗЖЕ,ИЗ-ЗА ТОГО,ЧТО МАСШТАБ СТРАНИЦЫ СТОЯЛ НА 125%,А ОНИ ХОТЯТ
// ТОЛЬКО НА 100% ЗАПУСКАТЬ УПРАВЛЕНИЕ ПО. СЕГОДНЯ ВРОДЕ УСТАНОВИЛА ПО НОВОЙ,ДЕЛАЮ ДОМАШКУ - ДВА ДРУГИХ
// БРАУЗЕРА РАБОТАЮТ НА УРА, А ЭТОТ НЕ ЗАКРЫВАЕТ ВИКИПЕДИЮ ПОЧЕМУ-ТО. В ЧЕМ ПРОБЛЕМА?//
public class OpenInExPage {
    WebDriver wd;

    @BeforeMethod
    public void setUp(){
        wd = new InternetExplorerDriver();
    }
    @Test
    public void openWiki(){
        wd.navigate().to("https://wikipedia.org/");
    }
    @AfterMethod
    public void tearDown(){
        wd.quit();
    }

}
