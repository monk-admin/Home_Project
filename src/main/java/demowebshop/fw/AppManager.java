package demowebshop.fw;

import demowebshop.utils.MyListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class AppManager {

    String browser;

    WebDriver driver;

    Logger logger = LoggerFactory.getLogger(AppManager.class);

    UserHelper user;
    CartHelper cart;
    HomePageHelper home;

    public AppManager(String browser) {
        this.browser = browser;
    }

    public void init() {
        if (browser.equalsIgnoreCase("chrome")){
            driver = new ChromeDriver();
            logger.info("Test start in Chrome browser");
        } else if(browser.equalsIgnoreCase("firefox")){
            driver = new FirefoxDriver();
            logger.info("Test start in Firefox browser");
        } else if (browser.equalsIgnoreCase("safari")) {
            driver = new SafariDriver();
            logger.info("Test start in Safari browser");
        }

        WebDriverListener listener = new MyListener();
        driver = new EventFiringDecorator<>(listener).decorate(driver);

        driver.get("https://demowebshop.tricentis.com/");
        logger.info("Current url --> " + driver.getCurrentUrl());
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        user = new UserHelper(driver);
        cart = new CartHelper(driver);
        home = new HomePageHelper(driver);
    }

    public void stop() {
        driver.quit();
    }

    public UserHelper getUser() {
        return user;
    }

    public CartHelper getCart() {
        return cart;
    }

    public HomePageHelper getHome() {
        return home;
    }
}
