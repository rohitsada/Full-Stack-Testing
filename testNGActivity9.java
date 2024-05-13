import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class testNGActivity9 {
    WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/javascript-alerts");
        driver.switchTo().defaultContent();
    }

    @Test
    public void simpleAlertTestCase() {
        driver.findElement(By.xpath("//*[@id=\"simple\"]")).click();
        Alert simple = driver.switchTo().alert();
        Reporter.log("Text in Simple Alert");

        simple.accept();
    }

    @Test
    public void confirmAlertTestCase() {
        driver.findElement(By.xpath("//*[@id=\"confirm\"]")).click();
        Alert confirm = driver.switchTo().alert();
        Reporter.log("Text in Confirm Alert");
        confirm.accept();
    }

    @Test
    public void promptAlertTestCase() {
        driver.findElement(By.xpath("//*[@id=\"prompt\"]")).click();
        Alert prompt = driver.switchTo().alert();
        prompt.sendKeys("HI");
        Reporter.log("Text in Prompt Alert");
        prompt.accept();
    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }
}