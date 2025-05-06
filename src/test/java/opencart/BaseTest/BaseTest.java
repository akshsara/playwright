package opencart.BaseTest;

import HomePage.HomePage;
import com.microsoft.playwright.Page;
import opencart.Playfac;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


import java.util.Properties;

public class BaseTest {
    protected Properties prop;
    Playfac pf;
    Page page;
    protected HomePage homePage;

    @BeforeClass  // ✅ Changed from @BeforeTest
    public void setUp() {
        pf = new Playfac();
        prop = pf.init_prop();

        // Initialize browser and page
        page = pf.initBrowser(prop);

        if (page != null) {
            System.out.println("Page initialized successfully.");
        }

        // Initialize homePage with the page object
        homePage = new HomePage(page);

        if (homePage != null) {
            System.out.println("HomePage initialized successfully.");
        }
    }

    @AfterClass  // ✅ Changed from @AfterTest
    public void tearDown() {
        if (page != null) {
            page.context().browser().close();
        }
    }
}