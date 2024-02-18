package Tests;

/*
    1.Buy 2 Stuffed Frog, 5 Fluffy Bunny, 3 Valentine Bear
    2.Go to the cart page
    3.Verify the subtotal for each product is correct
    4.Verify the price for each product
    5.Verify that total = sum(sub totals)

 */
import Base.BaseSetup;
import Pages.HomePage;
import Pages.ShopPage;
import Pages.CartPage;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCase3 extends BaseSetup {
    @BeforeTest
    public void setup() {
        initialization();
    }

    @Test
    public void testcase3() {
        BaseSetup.nav_shop();

        //Step1:Buy 2 Stuffed Frog, 5 Fluffy Bunny, 3 Valentine Bear
        ShopPage.buy("Stuffed Frog",  2);
        ShopPage.buy("Fluffy Bunny", 5);
        ShopPage.buy("Valentine Bear", 3);

        //Step2:Go to the cart page
        ShopPage.nav_cart();

        //Step3:Verify the subtotal for each product is correct
        CartPage.verifySubtotal();

        //Step4:4.Verify the price for each product
        CartPage.verifyPriceForEachProduct();

        //Step5:Verify that total = sum(sub totals)
        CartPage.verifyTotal();
    }
    @AfterTest
    public void end() {
        driver.quit();
    }
}