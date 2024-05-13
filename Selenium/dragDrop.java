import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class dragDrop {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/drag-drop");
        System.out.println("Title: "+driver.getTitle());
        WebElement draggable = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[1]"));
        WebElement droppable = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]"));
        WebElement clickable = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/img"));
        new Actions(driver)
                .dragAndDrop(clickable,draggable)
                .dragAndDrop(draggable,droppable)
                .perform();
        //driver.quit();
    }
}
