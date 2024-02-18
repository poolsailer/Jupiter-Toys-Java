package Pages;

import Base.BaseSetup;
import org.openqa.selenium.By;

import java.time.Duration;


public class HomePage extends BaseSetup {


    public static String start_shopping_xpath = "/html/body/div[2]/div/div/div[1]/p[2]/a";







    public static void start_shopping() {
        driver.findElement(By.xpath(start_shopping_xpath)).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
    }
}
