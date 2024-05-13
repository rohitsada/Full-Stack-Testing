import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class random {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.selenium.dev/documentation/webdriver/interactions/frames/#using-a-webelement");

//        WebDriverWait c = new WebDriverWait(driver, Duration.ofSeconds(20));
//        c.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div[1]/div/main/div/div[7]/a")));
        driver.findElement(By.xpath("/html/body/div/div[1]/div/main/nav/ol/li[1]/a")).click();
//        driver.switchTo().defaultContent();
}}
