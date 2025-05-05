package Testpckg;

import HomePage.HomePage;
import com.microsoft.playwright.Page;
import opencart.BaseTest.BaseTest;
import opencart.Playfac;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {
    @Test
            public void homePageUrl() {
                String url = homePage.HomePageUrl();
                Assert.assertEquals(url, "https://www.saucedemo.com/v1/");
                System.out.println("Home Page URL: " + url);
            }

    @Test
            public  void homePageTitle() {
                String title = homePage.HomePageTitle();
        Assert.assertEquals(title, "Swag Labs");
                System.out.println("Home Page Title: " + title);
            }


    }


