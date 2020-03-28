package test.TestCases1To5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.Utilities.utilitiess;

public class Test1To5 {
    private WebDriver driver;


    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.manage().window().maximize();

        utilitiess.wait(2);

        WebElement registirationForm = driver.findElement(By.xpath("//*[text()='Registration Form']"));
        System.out.println(registirationForm.toString());
        registirationForm.click();

        utilitiess.wait(2);
    }



    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void birthTest() {


        WebElement dateOfBirth = driver.findElement(By.xpath("(//input[@type=\"text\"])[5]"));
        dateOfBirth.sendKeys("wrong_dob", Keys.ENTER);

        String expected = "The date of birth is not valid";
        String actual = dateOfBirth.findElement(By.xpath("//*[text()='The date of birth is not valid']")).getText();


        Assert.assertEquals(actual, expected);

        utilitiess.wait(2);

    }
/*
 @Test
public void languageTest(){




}
*/





}


