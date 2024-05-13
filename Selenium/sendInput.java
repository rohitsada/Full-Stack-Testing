import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class sendInput {
    public static void main(String[] args) {
        // Setup the Firefox driver(GeckoDriver)
        WebDriverManager.firefoxdriver().setup();

        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();
        System.out.println(driver.getTitle());
        driver.get("https://v1.training-support.net/selenium/login-form");
        // Clear field to empty it from any previous data
        WebElement emailInput=driver.findElement(By.id("username"));
        emailInput.clear();
        //Enter Text
        String email="admin";
        emailInput.sendKeys(email);
        WebElement pwInput=driver.findElement(By.id("password"));
        pwInput.clear();
        //Enter Text
        String pw="password";
        pwInput.sendKeys(pw);
        WebElement checkInput=driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div/div/button"));
        checkInput.click();
        System.out.println(driver.getTitle());
    }
}
