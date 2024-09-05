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

public class SearchProduct {

    WebDriver driver;

    @BeforeMethod
    public void testPage(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.automationexercise.com/");
    }

    @Test
    public void productSearch() throws InterruptedException {
        WebElement productButton = driver.findElement(By.xpath("//a[@href='/products']"));
        productButton.click();

        //Type "top" and search tops
        WebElement search = driver.findElement(By.xpath("//input[@id='search_product']"));
        search.sendKeys("top");

        WebElement searchButton = driver.findElement(By.xpath("//button[@id='submit_search']"));
        searchButton.click();

        //Move to products and add to cart
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//div[@class='col-sm-9 padding-right']//div[2]//div[1]//div[1]//div[2]"))).perform();

        WebElement addCartButton = driver.findElement(By.xpath("//body[1]/section[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/a[1]"));
        addCartButton.click();
        Thread.sleep(3000);

        WebElement continueShoppingButton = driver.findElement(By.xpath("//button[normalize-space()='Continue Shopping']"));
        continueShoppingButton.click();

        Actions actions1 = new Actions(driver);
        actions1.moveToElement(driver.findElement(By.xpath("//div[@class='col-sm-9 padding-right']//div[3]//div[1]//div[1]//div[2]"))).perform();


        WebElement addCartButton1 = driver.findElement(By.xpath("//body[1]/section[2]/div[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/a[1]"));
        Thread.sleep(3000);
        addCartButton1.click();
        Thread.sleep(2000);

        WebElement viewCartButton = driver.findElement(By.xpath("//u[normalize-space()='View Cart']"));
        viewCartButton.click();

        //Verify checkout page
        String actualTitleCheckout = driver.getTitle();
        String expectedTitleCheckout = "Automation Exercise - Checkout";
        Assert.assertEquals(actualTitleCheckout, expectedTitleCheckout, "Value mismatched");
    }

    @AfterMethod
    public void close(){
        driver.quit();
    }

}
