import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
public class act16 {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        driver.get("https://v1.training-support.net/selenium/dynamic-attributes");
        System.out.println(driver.getTitle());
        String username = "Rohit";
        WebElement clickable = driver.findElement(By.xpath("//input[@id='date_input']"));
        new Actions(driver)
                .click(clickable)
                .sendKeys(username)//username
                .sendKeys(Keys.TAB)
                .sendKeys("password")//pw
                .sendKeys(Keys.TAB)
                .sendKeys("password")//re-enter pw
                .sendKeys(Keys.TAB)
                .sendKeys("rohit@gmail.com")//mail ID
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER)//enter
                .perform();
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@id=\"action-confirmation\"]"), "Thank you for registering, " +username));
        WebElement logmsg = driver.findElement(By.xpath("//*[@id=\"action-confirmation\"]"));
        System.out.println("Login Message: " + logmsg.getText());
    }
}