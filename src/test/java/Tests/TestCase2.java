package Tests;

/*
    Test Case 2:
    1.From the home page go to contact page
    2.Populate mandatory fields
    3.click submit button
    4.Validate successful submission message

    Note:Run the test 5 times to ensure 100% pass rate
 */


import Base.BaseSetup;
import Pages.ContactPage;
import Pages.HomePage;
import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCase2 extends BaseSetup {
    @BeforeTest
    public void setup() {
        initialization();
    }

    @Test(invocationCount = 5)
    public void testcase2() throws InterruptedException {
        //use start for the start time


        //1.From the home page go to contact page
        //HomePage.click_contact();
        BaseSetup.nav_contact();

        //2.Populate mandatory fields
        ContactPage.enter_mandatory_fields();

        //3.click submit button
        ContactPage.submit_contact();

        //4.Validate successful submission message
        ContactPage.checkSuccess();

        //Go Back to Blank Contact Page
        //driver.findElement(By.xpath("/html/body/div[2]/div/a")).click();
        ContactPage.backToContact();



    }

    @AfterTest
    public void end() {
        driver.quit();
    }

}
