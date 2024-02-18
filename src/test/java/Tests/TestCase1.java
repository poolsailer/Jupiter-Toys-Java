package Tests;

import Base.BaseSetup;
import Pages.HomePage;
import Pages.ContactPage;

import io.qameta.allure.internal.shadowed.jackson.databind.ser.Serializers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestCase1 extends BaseSetup {




    @BeforeTest
    public void setup() {
        initialization();
    }

    @Test
    public void testcase1() throws InterruptedException {
        //Step1:From the home page go to contact page

        BaseSetup.nav_contact();
        //Step2:Click submit button
        ContactPage.submit_contact();

        //Step3:Verify error messages
        System.out.println("*****************************\nStep3:Verify error messages");
        ContactPage.checkForenameError();
        ContactPage.checkEmailError();
        ContactPage.checkMessageError();

        //Step4:Populate mandatory fields

        ContactPage.enter_mandatory_fields();
        ContactPage.submit_contact();

        //Step5:Validate errors are gone
        System.out.println("*****************************\nStep 5: Validate errors are gone");
        ContactPage.checkForenameError();
        ContactPage.checkEmailError();
        ContactPage.checkMessageError();

    }

    @AfterTest
    public void end() {
        driver.quit();
    }

}
