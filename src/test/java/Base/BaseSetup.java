package Base;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;
import java.util.Properties;

public class BaseSetup {
    //Create variable for webdriver
    public static WebDriver driver;
    public static String home_xpath = "//*[@id=\"nav-home\"]/a";
    public static String shop_xpath = "//*[@id=\"nav-shop\"]/a";
    public static String contact_xpath = "//*[@id=\"nav-contact\"]/a";
    public static String cart_xpath = "//*[@id=\"nav-cart\"]/a";
    public static void initialization() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.get("https://jupiter.cloud.planittesting.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
    }

    public static void nav_home() {
        driver.findElement(By.xpath(home_xpath)).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
    }

    public static void nav_shop() {
        driver.findElement(By.xpath(shop_xpath)).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
    }

    public static void nav_contact(){
        driver.findElement(By.xpath(contact_xpath)).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
    }

    public static void nav_cart() {
        driver.findElement(By.xpath(cart_xpath)).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
    }
}
