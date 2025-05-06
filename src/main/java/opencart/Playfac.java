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
        try {
            // Create Playwright instance
            playwright = Playwright.create();

            // Launch browser
            browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));

            // Create a new context and page
            context = browser.newContext();
            page = context.newPage();

            // Load URL from properties
            String url = prop.getProperty("url");
            if (url == null || url.isEmpty()) {
                throw new RuntimeException("URL property is missing or empty in config.properties.");
            }

            System.out.println("Navigating to URL: " + url);
            page.navigate(url);

        } catch (Exception e) {
            System.err.println("Error initializing browser or navigating to URL: " + e.getMessage());
            e.printStackTrace();
        }

        return page;
    }

    public Properties init_prop() {
        try {
            // Load properties file
            FileInputStream ip = new FileInputStream("src/resource/config.properties");
            prop.load(ip);
        } catch (IOException e) {
            throw new RuntimeException("Error loading config.properties: " + e.getMessage(), e);
        }
        return prop;
    }
}
