package Samples;
/*
    Test case 1:
    1.From the home page go to contact page
    2.Click submit button
    3.Verify error messages
    4.Populate mandatory fields
    5.Validate errors are gone
 */



import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Simple_TestCase1 {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://jupiter.cloud.planittesting.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

        //Step1: From the home page go to contact page
        driver.findElement(By.linkText("Contact")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

        //Step2:Click submit button
        driver.findElement(By.linkText("Submit")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

        //Step3:Verify error messages
        try {
            driver.findElement(By.id("forename-err"));
        } catch(NoSuchElementException e) {
            e.printStackTrace();
        }

        //Step4:4.Populate mandatory fields
        driver.findElement(By.id("forename")).sendKeys("Test Forename");
        driver.findElement(By.id("email")).sendKeys("test@gmail.com");
        driver.findElement(By.id("message")).sendKeys("testmessage");

        //Step5: Validate errors are gone
        try {
            driver.findElement(By.id("forename-err"));
        } catch(NoSuchElementException e) {
            e.printStackTrace();
        }
    }
}