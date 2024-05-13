import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.*;
import io.github.bonigarcia.wdm.WebDriverManager;


public class test9 {
    WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/javascript-alerts");
        driver.switchTo().defaultContent();
    }

    @Test
    public void simpleAlertTestCase()
    {
        driver.findElement(By.xpath("//*[@id=\"simple\"]")).click();
        Alert alert=driver.switchTo().alert();
        Reporter.log("Text in Simple Alert"+alert.getText());
        alert.accept();
    }
    @Test
    public void confirmAlertTestCase()
    {
        driver.findElement(By.xpath("//*[@id=\"confirm\"]")).click();
        Alert alert=driver.switchTo().alert();
        Reporter.log("Text in Confirm Alert"+alert.getText());
        alert.accept();
    }
    @Test
    public void promptAlertTestCase()
    {
        driver.findElement(By.xpath("//*[@id=\"prompt\"]")).click();
        Alert alert=driver.switchTo().alert();
        alert.sendKeys("HI");
        Reporter.log("Text in Prompt Alert"+alert.getText());
        alert.accept();
    }


    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }
}
