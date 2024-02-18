package Pages;

import org.openqa.selenium.By;

import java.time.Duration;

import Base.BaseSetup;



public class ShopPage extends BaseSetup{
    public static String stuffed_frog_xpath = "//*[@id=\"product-2\"]/div/p/a";
    public static String stuffed_frog_price_xpath = "//*[@id=\"product-2\"]/div/p/span";
    public static String fluffy_bunny_xpath = "//*[@id=\"product-4\"]/div/p/a";
    public static String fluffy_bunny_price_xpath = "//*[@id=\"product-4\"]/div/p/span";
    public static String valentine_bear_xpath = "//*[@id=\"product-7\"]/div/p/a";
    public static String valentine_bear_price_xpath = "//*[@id=\"product-7\"]/div/p/span";
    public static String cart_xpath = "//*[@id=\"nav-cart\"]/a";

    public static void buy(String item, int quantity) {
        switch (item) {
            case "Stuffed Frog" -> {
                for (int i = 0; i < quantity; i++) {
                    driver.findElement(By.xpath(stuffed_frog_xpath)).click();
                    driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
                }
            }
            case "Fluffy Bunny" -> {
                for (int i = 0; i < quantity; i++) {
                    driver.findElement(By.xpath(fluffy_bunny_xpath)).click();
                    driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
                }
            }
            case "Valentine Bear" -> {
                for (int i = 0; i < quantity; i++) {
                    driver.findElement(By.xpath(valentine_bear_xpath)).click();
                    driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
                }
            }
        }
    }

    public static void nav_cart() {
        driver.findElement(By.xpath(cart_xpath)).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
    }

    public static String get_price(String item) {
        String price = "";
        switch (item) {
            case "Stuffed Frog" -> {
                price = driver.findElement(By.xpath(stuffed_frog_price_xpath)).getText().substring(1);
            }
            case "Fluffy Bunny" -> {
                price =  driver.findElement(By.xpath(fluffy_bunny_price_xpath)).getText().substring(1);
            }
            case "Valentine Bear" -> {
                price =  driver.findElement(By.xpath(valentine_bear_price_xpath)).getText().substring(1);
            }
        }
        return price;
    }
}
