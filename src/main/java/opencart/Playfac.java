package opencart;

import com.microsoft.playwright.*;
import java.io.*;
import java.util.Properties;

public class Playfac {

    Properties prop = new Properties(); // ✅ inside class

    public Playwright playwright;
    Browser browser;
    BrowserContext context;
    Page page;

    public Page initBrowser(Properties prop) {
        playwright = Playwright.create();
        browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
        context = browser.newContext();
        page = context.newPage();
        page.navigate(prop.getProperty("url"));
        return page;
    }

    public Properties init_prop() {
        try {
            FileInputStream ip = new FileInputStream("src/resource/config.properties");
            prop.load(ip);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return prop;
    }
}
