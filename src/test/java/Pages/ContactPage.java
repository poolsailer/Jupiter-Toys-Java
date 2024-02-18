package Pages;

import Base.BaseSetup;
import io.qameta.allure.internal.shadowed.jackson.databind.ser.Serializers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ContactPage extends BaseSetup {

    public static String forename_xpath = "//*[@id=\"forename\"]";
    public static String surname_xpath = "//*[@id=\"surname\"]";
    public static String email_xpath = "//*[@id=\"email\"]";
    public static String telephone_xpath = "//*[@id=\"telephone\"]";
    public static String message_xpath = "//*[@id=\"message\"]";

    public static String submit_xpath ="/html/body/div[2]/div/form/div/a";
    public static String forename_err_xpath = "//*[@id=\"forename-err\"]";
    public static String email_err_xpath = "//*[@id=\"email-err\"]";
    public static String message_err_xpath = "//*[@id=\"email-err\"]";
    public static String success_xpath = "/html/body/div[2]/div/div";
    public static String back_to_contact_xpath = "/html/body/div[2]/div/a";
    public static void enter_mandatory_fields() throws InterruptedException{
        driver.findElement(By.id("forename")).sendKeys("Test Forename");
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
        driver.findElement(By.id("email")).sendKeys("test@gmail.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
        driver.findElement(By.id("message")).sendKeys("testmessage");
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
    }

    public static void submit_contact() {
        driver.findElement(By.xpath(submit_xpath)).click();

        try {
            driver.findElement(By.xpath(forename_err_xpath));
            driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
        } catch(Exception e) {
            Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(back_to_contact_xpath)));
        }

        //driver.manage().timeouts().implicitlyWait(Duration.ofMillis(20000));
    }
    public static void checkForenameError() throws InterruptedException {
        if(driver.findElements(By.xpath(forename_err_xpath)).isEmpty()) {
            System.out.println("Forename Error Message is not displayed") ;
        }   else {
            System.out.println("Forname Error Message is displayed");
        }
    }
    public static void checkEmailError() throws InterruptedException {
        if(driver.findElements(By.xpath(email_err_xpath)).isEmpty()) {
            System.out.println("Email Error Message is not displayed.");
        }   else {
            System.out.println("Email Error Message is displayed.");
        }
    }
    public static void checkMessageError() throws InterruptedException {
        if(driver.findElements(By.xpath(message_err_xpath)).isEmpty()) {
            System.out.println("Message Error is not displayed.");
        }   else {
            System.out.println("Message Error is displayed.");
        }
    }

    public static void checkSuccess() throws InterruptedException {
        if(driver.findElements(By.xpath(success_xpath)).isEmpty()) {
            System.out.println("Unsuccessful");
        } else {
            System.out.println("Successful");
        }

    }

    public static void backToContact() throws InterruptedException{
        driver.findElement(By.xpath(back_to_contact_xpath)).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
    }



}
