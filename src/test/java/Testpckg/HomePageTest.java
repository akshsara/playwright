package Testpckg;

import opencart.BaseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {

    @Test
    public void homePageUrl() {
        // If homePage is null, this line will throw a NullPointerException
        String url = homePage.HomePageUrl();
        Assert.assertEquals(url, prop.getProperty("url"));
        System.out.println("Home Page URL: " + url);
    }

    @Test
    public void homePageTitle() {
        // If homePage is null, this line will throw a NullPointerException
        String title = homePage.HomePageTitle();
        Assert.assertEquals(title, "Swag Labs");
        System.out.println("Home Page Title: " + title);
    }
}
