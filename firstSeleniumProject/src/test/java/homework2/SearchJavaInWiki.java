package homework2;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchJavaInWiki extends TestBase2{

    @Test
    public void testLookingTForJavaInWiki(){
        writeJavaInSearchBar();
        clickOnTheLoupeButton();

        String currentUrl = wd.getCurrentUrl();
        //System.out.println(currentUrl);
        Assert.assertEquals(currentUrl, "https://ru.wikipedia.org/wiki/Java");
        //У меня комп на русском,поэтому он упорно посылает меня на русскую версию сайта.Заботоливый)).
        //Поэтому я поменяла в exp.res с en на ru.
    }

}
