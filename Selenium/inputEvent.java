import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class inputEvent {
    public static void main(String[] args) {
        // Setup the Firefox driver(GeckoDriver)
        WebDriverManager.firefoxdriver().setup();

        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/input-events");
        System.out.println(driver.getTitle());

        WebElement clickable = driver.findElement(By.xpath("/html/body"));
        new Actions(driver)
                .click(clickable)
                .pause(Duration.ofSeconds(2))
                .perform();
        WebElement clickable1 = driver.findElement(By.xpath("/html/body"));
        WebElement number2=driver.findElement(By.className("active"));
        System.out.println("Side:"+number2.getText());

        new Actions(driver)
                .doubleClick(clickable1)
                .pause(Duration.ofSeconds(1))
                .perform();
        WebElement clickable2 = driver.findElement(By.xpath("/html/body"));
        WebElement number1=driver.findElement(By.className("active"));
        System.out.println("Side:"+number1.getText());
        new Actions(driver)
                .contextClick(clickable2)
                .pause(Duration.ofSeconds(2))
                .perform();
        WebElement number=driver.findElement(By.className("active"));
        System.out.println("Side:"+number.getText());




    }
}
