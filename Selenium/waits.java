import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class waits {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/dynamic-controls");
        System.out.println("Title: "+driver.getTitle());
        WebElement clickable = driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/div[2]/button"));
        WebElement clickable1 = driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/div[2]/button"));
        WebElement checkbox = driver.findElement(By.tagName("input"));
        new Actions(driver)
                .click(clickable)
                .perform();
        new Actions(driver)
                .pause(Duration.ofSeconds(2))
                .click(clickable1)
                .perform();
        new Actions(driver)
                .pause(Duration.ofSeconds(1))
                .click(checkbox)
                .perform();


//        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(2));
//        wait.until(d -> checkbox.isDisplayed());

        //driver.quit();
    }
}
