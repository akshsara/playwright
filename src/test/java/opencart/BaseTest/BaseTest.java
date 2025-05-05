package opencart.BaseTest;

import HomePage.HomePage;
import com.microsoft.playwright.Page;
import opencart.Playfac;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.Properties;

public class BaseTest {
    Properties prop;
    Playfac pf;
    Page page;
    protected HomePage homePage;
    @BeforeTest
    public void setUp() {
        pf = new Playfac();
        prop=pf.init_prop();
        page = pf.initBrowser(prop);
        homePage = new HomePage(page);
    }

    @AfterTest
    public void tearDown() {
        page.context().browser().close();
    }
}
