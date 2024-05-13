import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import io.github.bonigarcia.wdm.WebDriverManager;
//import testNGActivity5.testNGDataProvider;

public class testNGActivitySimpleForm {
    WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/simple-form");
    }

    @Test(dataProvider = "Authentication", dataProviderClass =testNGDataProvider.class)
    public void testCase(String firstname, String lastname, String email, String number, String message) {
        WebElement firstName = driver.findElement(By.id("firstName"));
        WebElement lastName = driver.findElement(By.id("lastName"));
        WebElement emailId = driver.findElement(By.id("email"));
        WebElement phNumber = driver.findElement(By.id("number"));
        WebElement testMessage = driver.findElement(By.xpath("//textarea"));

        firstName.sendKeys(firstname);
        lastName.sendKeys(lastname);
        emailId.sendKeys(email);
        phNumber.sendKeys(number);
        testMessage.sendKeys(message);

        WebElement submitButton = driver.findElement(By.xpath("//input[@type='submit']"));
        submitButton.click();

        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }
}
