package Pages;

import Base.BaseSetup;
import Pages.ShopPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.*;


public class CartPage extends BaseSetup {

    /*
    public static int row_num() {
        return driver.findElements(By.name("quantity")).size();
    }
    */


    public static void verifySubtotal() {
        System.out.println("************************************************************************");
        System.out.println("Step3://Verify the subtotal for each product is correct");
        int row_num = driver.findElements(By.name("quantity")).size();
        for (int i = 0; i < row_num; i++) {
            double price = Double.parseDouble(driver.
                    findElement(By.xpath("/html/body/div[2]/div/form/table/tbody/tr[" + (i + 1) + "]/td[2]")).
                    getText().substring(1));
            int quantity = Integer.parseInt(driver.
                    findElement(By.xpath("/html/body/div[2]/div/form/table/tbody/tr[" + (i + 1) + "]/td[3]/input")).
                    getAttribute("value"));
            double subtotal = Double.parseDouble(driver.
                    findElement(By.xpath("/html/body/div[2]/div/form/table/tbody/tr[" + (i + 1) + "]/td[4]")).
                    getText().substring(1));

            if (price * quantity == subtotal) {
                System.out.println(" the subtotal is verified!" + price + " " + quantity + " " + subtotal);
            } else {
                System.out.println("the subtotal is not verified!!!" + price + " " + quantity + " " + subtotal);
            }
        }

    }

    public static void verifyTotal() {
        System.out.println("************************************************************************");
        System.out.println("Step5://Verify that total = sum(sub totals)");
        double sum = 0;
        int row_num = driver.findElements(By.name("quantity")).size();
        double total = Double.parseDouble(driver.findElement(By.xpath("/html/body/div[2]/div/form/table/tfoot/tr[1]/td/strong")).getText().substring(7));
        for (int i = 0; i < row_num; i++) {
            double subtotal = Double.parseDouble(driver.
                    findElement(By.xpath("/html/body/div[2]/div/form/table/tbody/tr[" + (i + 1) + "]/td[4]")).
                    getText().substring(1));
            sum += subtotal;
        }
        if (sum == total) {
            System.out.println(" the total is verified!");
        } else {
            System.out.println("the total is not verified!!!");
        }
    }

    public static void verifyPriceForEachProduct() {
        System.out.println("Step5://Verify the price for each product");

        //Use the HashMap to store the items and prices
        HashMap<String, String> item_Price = new HashMap<>();
        int row_num = driver.findElements(By.name("quantity")).size();
        for (int i = 0; i < row_num; i++) {
            String item = driver.findElement(By.xpath("/html/body/div[2]/div/form/table/tbody/tr[" + (i + 1) + "]/td[1]")).getText();
            String price = driver.
                    findElement(By.xpath("/html/body/div[2]/div/form/table/tbody/tr[" + (i + 1) + "]/td[2]")).
                    getText().substring(1);
            item_Price.put(item, price);
        }

        /*go to the ShopPage*/
        BaseSetup.nav_shop();

        /* Compare the price of each item with the ShopPage */
        for (Map.Entry m : item_Price.entrySet()) {
            //System.out.println(m.getKey() + " " + m.getValue());
            if(m.getValue().equals(ShopPage.get_price(m.getKey().toString()))) {
                System.out.println(m.getKey() + "'s price is verified, it is " + m.getKey()) ;
            } else {
                System.out.println(m.getKey() + "'s price is not verified, it is " + m.getValue() + ", price in SHOPPage is " + ShopPage.get_price(m.getKey().toString()));
            }
        }

        BaseSetup.nav_cart();
    }
}
