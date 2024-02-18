package Samples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

/*
    1.Buy 2 Stuffed Frog, 5 Fluffy Bunny, 3 Valentine Bear
    2.Go to the cart page
    3.Verify the subtotal for each product is correct
    4.Verify the price for each product
    5.Verify that total = sum(sub totals)
 */
public class SimpleTestCase3 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://jupiter.cloud.planittesting.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

        //Step1:Buy 2 Stuffed Frog, 5 Fluffy Bunny, 3 Valentine Bear
        driver.findElement(By.linkText("Shop")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));

        driver.findElement(By.xpath("//*[@id=\"product-2\"]/div/p/a")).click();
        driver.findElement(By.xpath("//*[@id=\"product-2\"]/div/p/a")).click();

        driver.findElement(By.xpath("//*[@id=\"product-4\"]/div/p/a")).click();
        driver.findElement(By.xpath("//*[@id=\"product-4\"]/div/p/a")).click();
        driver.findElement(By.xpath("//*[@id=\"product-4\"]/div/p/a")).click();
        driver.findElement(By.xpath("//*[@id=\"product-4\"]/div/p/a")).click();
        driver.findElement(By.xpath("//*[@id=\"product-4\"]/div/p/a")).click();

        driver.findElement(By.xpath("//*[@id=\"product-7\"]/div/p/a")).click();
        driver.findElement(By.xpath("//*[@id=\"product-7\"]/div/p/a")).click();
        driver.findElement(By.xpath("//*[@id=\"product-7\"]/div/p/a")).click();

        //Step2:Go to the cart page
        driver.findElement(By.xpath("//*[@id=\"nav-cart\"]/a")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

        //Step3:Verify the subtotal for each product is correct
        String quantity1 = driver.findElement(By.xpath("/html/body/div[2]/div/form/table/tbody/tr[1]/td[3]/input")).getAttribute("value");
        int quantity1I = Integer.parseInt(quantity1);
        String quantity2 = driver.findElement(By.xpath("/html/body/div[2]/div/form/table/tbody/tr[2]/td[3]/input")).getAttribute("value");
        int quantity2I = Integer.parseInt(quantity2);
        String quantity3 = driver.findElement(By.xpath("/html/body/div[2]/div/form/table/tbody/tr[3]/td[3]/input")).getAttribute("value");
        int quantity3I = Integer.parseInt(quantity3);

        String price1 = driver.findElement(By.xpath("/html/body/div[2]/div/form/table/tbody/tr[1]/td[2]")).getText().substring(1);
        double price1d = Double.parseDouble(price1);
        String price2 = driver.findElement(By.xpath("/html/body/div[2]/div/form/table/tbody/tr[2]/td[2]")).getText().substring(1);
        double price2d = Double.parseDouble(price2);
        String price3 = driver.findElement(By.xpath("/html/body/div[2]/div/form/table/tbody/tr[3]/td[2]")).getText().substring(1);
        double price3d = Double.parseDouble(price3);

        System.out.println(quantity1I * price1d + quantity2I * price2d + quantity3I * price3d);

    }
}
