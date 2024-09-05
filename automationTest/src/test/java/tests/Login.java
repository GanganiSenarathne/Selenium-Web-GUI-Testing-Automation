package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Login {

    WebDriver driver;

    @BeforeMethod
    public void testPage(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.automationexercise.com/");
    }

    @Test
    public void loginPage(){
        WebElement signup = driver.findElement(By.xpath("//a[normalize-space()='Signup / Login']"));
        signup.click();

        //Verify login page is visible
        String actualTitle = driver.getTitle();
        String expectedTitle = "Automation Exercise - Signup / Login";
        Assert.assertEquals(actualTitle, expectedTitle, "Value mismatched");

        //Check if the email field is empty or not and enter email and password
        WebElement loginEmail = driver.findElement(By.xpath("//input[@data-qa='login-email']"));
        String loginEmailValue = loginEmail.getAttribute("value");

        if (loginEmailValue == null || loginEmailValue.trim().isEmpty()) {
            loginEmail.sendKeys("rony123@gmail.com");
        }

        WebElement password = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        password.sendKeys("rony123");

        WebElement loginButton = driver.findElement(By.xpath("//button[normalize-space()='Login']"));
        loginButton.click();

    }

    @AfterMethod
    public void close(){
        driver.quit();
    }
}
