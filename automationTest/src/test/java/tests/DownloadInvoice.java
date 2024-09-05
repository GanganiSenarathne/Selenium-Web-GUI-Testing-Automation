package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;

public class DownloadInvoice {

    WebDriver driver;

    @BeforeMethod
    public void testPage(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.automationexercise.com/");
    }

    @Test
    public void invoiceDownload() throws InterruptedException {
        WebElement productButton = driver.findElement(By.xpath("//a[@href='/products']"));
        productButton.click();

        //Move to a product and add to cart
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//div[@class='col-sm-9 padding-right']//div[2]//div[1]//div[1]//div[2]"))).perform();

        WebElement addToCartButton = driver.findElement(By.xpath("//body[1]/section[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/a[1]"));
        addToCartButton.click();
        Thread.sleep(3000);

        WebElement viewCartButton = driver.findElement(By.xpath("//u[normalize-space()='View Cart']"));
        viewCartButton.click();

        WebElement proceedToCheckoutButton = driver.findElement(By.xpath("//a[normalize-space()='Proceed To Checkout']"));
        proceedToCheckoutButton.click();

        //Login to proceed
        WebElement loginButton = driver.findElement(By.xpath("//u[normalize-space()='Register / Login']"));
        loginButton.click();

        //Enter email after checking the field is empty or not
        WebElement loginEmail = driver.findElement(By.xpath("//input[@data-qa='login-email']"));
        String loginEmailValue = loginEmail.getAttribute("value");

        if (loginEmailValue == null || loginEmailValue.trim().isEmpty()) {
            loginEmail.sendKeys("rony123@gmail.com");
        }

        WebElement password = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        password.sendKeys("rony123");

        WebElement loginButton1 = driver.findElement(By.xpath("//button[normalize-space()='Login']"));
        loginButton1.click();

        WebElement cartButton = driver.findElement(By.xpath("//body[1]/header[1]/div[1]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[3]/a[1]"));
        cartButton.click();

        WebElement proceedToCheckoutButton1 = driver.findElement(By.xpath("//a[normalize-space()='Proceed To Checkout']"));
        proceedToCheckoutButton1.click();

        WebElement placeOrderButton = driver.findElement(By.xpath("//a[normalize-space()='Place Order']"));
        placeOrderButton.click();

        //Enter card details
        WebElement cardName = driver.findElement(By.xpath("//input[@name='name_on_card']"));
        cardName.sendKeys("Rony");

        WebElement cardNo = driver.findElement(By.xpath("//input[@name='card_number']"));
        cardNo.sendKeys("12345");

        WebElement cvsNo = driver.findElement(By.xpath("//input[@placeholder='ex. 311']"));
        cvsNo.sendKeys("311");

        WebElement expirationMonth = driver.findElement(By.xpath("//input[@placeholder='MM']"));
        expirationMonth.sendKeys("January");

        WebElement expirationYear = driver.findElement(By.xpath("//input[@placeholder='YYYY']"));
        expirationYear.sendKeys("2025");

        WebElement payConfirmButton = driver.findElement(By.xpath("//button[@id='submit']"));
        payConfirmButton.click();

        //Download invoice
        WebElement downloadInvoiceButton = driver.findElement(By.xpath("//a[normalize-space()='Download Invoice']"));
        downloadInvoiceButton.click();

        //Check if the downloaded invoice is there in the folder.(Validate)
        File file = new File("C:\\Users\\Gangani\\Downloads");
        File[] totalFiles = file.listFiles();//store all file which are in downloads in File[] array
        for (File findFile:totalFiles){
            if (findFile.getName().equals("invoice.txt")){
                System.out.println("File is downloaded");
                break;
            }
        }

        WebElement continueButton = driver.findElement(By.xpath("//a[normalize-space()='Continue']"));
        continueButton.click();


        //Delete account
        WebElement deleteAcc = driver.findElement(By.xpath("//a[normalize-space()='Delete Account']"));
        deleteAcc.click();

        WebElement deleteContinue = driver.findElement(By.xpath("//a[normalize-space()='Continue']"));
        deleteContinue.click();
    }

    @AfterMethod
    public void close(){
        driver.quit();
    }

}
