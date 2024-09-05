package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Registration {

    WebDriver driver;

    @BeforeMethod
    public void testPage(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.automationexercise.com/");
    }

    @Test
    public void register(){
        WebElement signup = driver.findElement(By.xpath("//a[normalize-space()='Signup / Login']"));
        signup.click();

        //Verify 'New User Signup!' page is visible
        String actualTitle = driver.getTitle();
        String expectedTitle = "Automation Exercise - Signup / Login";
        Assert.assertEquals(actualTitle, expectedTitle, "Value mismatched");

        //Enter username and password
        WebElement userName = driver.findElement(By.xpath("//input[@placeholder='Name']"));
        userName.sendKeys("Rony");
        WebElement email = driver.findElement(By.xpath("//input[@data-qa='signup-email']"));
        email.sendKeys("rony123@gmail.com");

        WebElement signupButton = driver.findElement(By.xpath("//button[normalize-space()='Signup']"));
        signupButton.click();

        //Verify that 'ENTER ACCOUNT INFORMATION' is visible
        String actualAccInfoTitle = driver.getTitle();
        String expectedAccInfoTitle = "Automation Exercise - Signup";
        Assert.assertEquals(actualAccInfoTitle, expectedAccInfoTitle, "Value mismatched");

        //Fill account information
        WebElement title = driver.findElement(By.xpath("//input[@id='id_gender2']"));
        title.click();

        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("rony123");

        WebElement dateDropDown = driver.findElement(By.xpath("//select[@id='days']"));
        Select select  = new Select(dateDropDown);//this can be used if the dropdown starts with <select> tag
        select.selectByIndex(5);

        WebElement monthDropDown = driver.findElement(By.xpath("//select[@id='months']"));
        Select select1  = new Select(monthDropDown);//this can be used if the dropdown starts with <select> tag
        select1.selectByIndex(8);

        WebElement yearDropDown = driver.findElement(By.xpath("//select[@id='years']"));
        yearDropDown.sendKeys("1998");

        boolean newsLetter = driver.findElement(By.xpath("//input[@id='newsletter']")).isSelected();
        boolean offers = driver.findElement(By.xpath("//input[@id='newsletter']")).isSelected();

        if (!newsLetter){
            driver.findElement(By.xpath("//input[@id='newsletter']")).click();
        } else if (!offers) {
            driver.findElement(By.xpath("//input[@id='newsletter']")).click();
        }

        WebElement firstName = driver.findElement(By.xpath("//input[@id='first_name']"));
        firstName.sendKeys("Rony");

        WebElement lastName = driver.findElement(By.xpath("//input[@id='last_name']"));
        lastName.sendKeys("Silvester");

        WebElement company = driver.findElement(By.xpath("//input[@id='company']"));
        company.sendKeys("ABC");

        WebElement address = driver.findElement(By.xpath("//input[@id='address1']"));
        address.sendKeys("62, ABC");

        WebElement countryDropDown = driver.findElement(By.xpath("//select[@id='country']"));
        countryDropDown.sendKeys("United States");

        WebElement state = driver.findElement(By.xpath("//input[@id='state']"));
        state.sendKeys("Texas");

        WebElement city = driver.findElement(By.xpath("//input[@id='city']"));
        city.sendKeys("Austin");

        WebElement zipCode = driver.findElement(By.xpath("//input[@id='zipcode']"));
        zipCode.sendKeys("73301");

        WebElement mobileNo = driver.findElement(By.xpath("//input[@id='mobile_number']"));
        mobileNo.sendKeys("7654345");
        WebElement createAccButton = driver.findElement(By.xpath("//button[normalize-space()='Create Account']"));
        createAccButton.click();

        //Verify that 'ACCOUNT CREATED!' is visible
        String actualTitleAccountCreated = driver.getTitle();
        String expectedTitleAccountCreated = "Automation Exercise - Account Created";
        Assert.assertEquals(actualTitleAccountCreated, expectedTitleAccountCreated, "Value mismatched");

        WebElement accCreated = driver.findElement(By.xpath("//a[normalize-space()='Continue']"));
        accCreated.click();
    }

    @AfterMethod
    public void close(){
        driver.quit();
    }
}