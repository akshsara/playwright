package HomePage;

import com.microsoft.playwright.Page;

public class HomePage {
    private final Page page;
    private String user_name = "//input[@id='user-name']";
    private String password = "//input[@id='password']";
    private String search_button = "//input[@id='login-button']";

    public HomePage(Page page) {
        this.page = page;
    }

    public String HomePageTitle() {
        String title = page.title();
        System.out.println("Home Page Title: " + title);
        return title;
    }


    public String HomePageUrl() {
        String url = page.url();
        System.out.println("Home Page URL: " + url);
        return url;
    }

    public String user_name(String user_name) {
        page.fill(user_name, "standard_user");
        page.fill(password, "secret_sauce");
        page.click(search_button);
        //return page.textContent(searchheader);


        return page.textContent(search_button);
    }
}