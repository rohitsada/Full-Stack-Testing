import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class waits2 {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get("https://v1.training-support.net/selenium/ajax");
        System.out.println("Title: " + driver.getTitle());

        WebElement violetButton = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/button"));
        violetButton.click();
        WebElement headingElement = driver.findElement(By.tagName("h1"));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("/html/body/div[2]/div/div[2]/h3"), "I'm late!"));
        WebElement nextElement = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/h3"));
        String headingText = headingElement.getText();
        String nextText = nextElement.getText();
        System.out.println("First Text: " + headingText);
        System.out.println("Second Text: " + nextText);

        driver.quit();
    }
}
