package test.TestCases1To5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.Utilities.utilitiess;

import javax.swing.text.Utilities;
import java.util.List;

public class Test1To5 {
    private WebDriver driver;

    private By cplusplus = By.xpath("//label[text()='C++']/preceding-sibling::input");
    private By javaBy = By.xpath("//label[text()='Java']/preceding-sibling::input");
    private By javascriptBy = By.xpath("//label[text()='JavaScript']/preceding-sibling::input");
    private By firstNameBy = By.name("firstname");
    private By lastNameBy = By.name("lastname");
    private By usernameBy = By.name("username");
    private By passwordBy = By.name("password");
    private By phoneBy = By.name("phone");
    //private By dateOfBirthBy = By.name("birthday");
    private By departmentBy = By.name("department");
    private By maleBy = By.xpath("//input[@value='male']");
    private By femaleBy = By.xpath("//input[@value='female']");
    private By otherBy = By.cssSelector("input[value='other']");
    private By jobTitleBy = By.name("job_title");
    private By signUpBy = By.id("wooden_spoon");

private Select departmentSelect;
private Select jobTitleSelect;

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

/*
Step 3. Enter “wrong_dob” into date of birth input box.
Step 4. Verify that warning message is displayed: “The date of birth is not valid”
 */
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
Step 3. Verify that following options for programming languages are displayed: c++, java, JavaScript
 */
 @Test
public void languageTest(){
       JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,700)","");
        utilitiess.wait(3);

     Assert.assertTrue(driver.findElement(cplusplus).isDisplayed());
     utilitiess.wait(3);
     Assert.assertTrue(driver.findElement(javaBy).isDisplayed());
     utilitiess.wait(3);
     Assert.assertTrue(driver.findElement(javascriptBy).isDisplayed());
     utilitiess.wait(3);

     driver.findElement(cplusplus).click();
     driver.findElement(javaBy).click();
     driver.findElement(javascriptBy).click();

}

/*
Step 3. Enter only one alphabetic character into first name input box.
Step 4. Verify that warning message is displayed: “first name must be more than 2 and less than 64 characters long”
 */
@Test
public void test3(){
driver.findElement(firstNameBy).sendKeys("S");
utilitiess.wait(2);
WebElement warningMessage = driver.findElement(By.xpath("//small[text()='first name must be more than 2 and less than 64 characters long']"));
Assert.assertTrue(warningMessage.isDisplayed());

}

/*
Step 3. Enter only one alphabetic character into last name input box.
Step 4. Verify that warning message is displayed: “The last name must be more than 2 and less than 64 characters long”
 */
@Test
public void test4(){
    driver.findElement(lastNameBy).sendKeys("G");
WebElement warningMessage = driver.findElement(By.xpath("//small[text()='The last name must be more than 2 and less than 64 characters long']"));
Assert.assertTrue(warningMessage.isDisplayed());

}
/*
 Step 3. Enter any valid first name
Step 4. Enter any valid last name
Step 5. Enter any valid user name
Step 6. Enter any valid password
Step 7. Enter any valid phone number
Step 8. Select gender.
Step 9. Enter any valid date of birth
Step 10. Select any department.
Step 11. Enter any job title.
Step 12. Select java as a programming language. Step 13. Click Sign up.
Step 14. Verify that following success message is displayed: “You've successfully completed registration!”
 */
@Test
public void tet5(){
driver.findElement(firstNameBy).sendKeys("Seda");
driver.findElement(lastNameBy).sendKeys("Gedik");
driver.findElement(usernameBy).sendKeys("olalala");
driver.findElement(passwordBy).sendKeys("123321123");
driver.findElement(phoneBy).sendKeys("555-536-2334");
driver.findElement(femaleBy).click();
driver.findElement(By.xpath("(//input[@type=\"text\"])[5]")).sendKeys("01/01/2001");
departmentSelect = new Select(driver.findElement(departmentBy));
departmentSelect.selectByVisibleText("Department of Engineering");

jobTitleSelect = new Select(driver.findElement(jobTitleBy));
jobTitleSelect.selectByVisibleText("QA");

driver.findElement(cplusplus).click();
driver.findElement(signUpBy).click();

    String expected = "You've successfully completed registration!";
    String actual = driver.findElement(By.tagName("p")).getText();

    Assert.assertEquals(actual, expected);
}


}


