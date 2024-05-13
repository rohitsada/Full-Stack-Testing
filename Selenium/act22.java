import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
public class act22 {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        driver.get("https://v1.training-support.net/selenium/popups");
        System.out.println(driver.getTitle());
        WebElement webElement = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/button"));
        new Actions(driver)
                .moveToElement(webElement)
                .perform();
        String tooltipText = webElement.getAttribute("data-tooltip");
        System.out.println("Tooltip message:"+tooltipText);
        webElement.click();
        WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"username\"]")));
        new Actions(driver)
                .click(username)
                .sendKeys("admin")
                .sendKeys(Keys.TAB)
                .sendKeys("password")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER)
                .perform();
        WebElement logmsg = driver.findElement(By.id("action-confirmation"));
        System.out.println("Login Message: "+logmsg.getText());
    }
}