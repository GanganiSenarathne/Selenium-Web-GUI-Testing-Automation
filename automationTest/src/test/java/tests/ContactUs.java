package tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ContactUs {

    WebDriver driver;

    @BeforeMethod
    public void testPage(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.automationexercise.com/");
    }

    @Test
    public void contactUsPage() throws InterruptedException {
        WebElement contact = driver.findElement(By.xpath("//a[normalize-space()='Contact us']"));
        contact.click();

        WebElement name = driver.findElement(By.xpath("//input[@placeholder='Name']"));
        name.sendKeys("Rony Silvester");

        WebElement email = driver.findElement(By.xpath("//input[@placeholder='Email']"));
        email.sendKeys("rony123@gmail.com");

        WebElement subject = driver.findElement(By.xpath("//input[@placeholder='Subject']"));
        subject.sendKeys("Test Subject");

        WebElement message = driver.findElement(By.xpath("//textarea[@id='message']"));
        message.sendKeys("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam");

        String data = "C:\\Users\\Gangani\\Downloads\\download.jpeg";
        WebElement upload = driver.findElement(By.xpath("//input[@name='upload_file']"));
        upload.sendKeys(data);

        WebElement submit = driver.findElement(By.xpath("//input[@name='submit']"));
        submit.click();

        Alert alert1 = driver.switchTo().alert();
        Thread.sleep(3000);
        alert1.dismiss();
    }

    @AfterMethod
    public void close(){
        driver.quit();
    }

}
