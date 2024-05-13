import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
public class act12 {
    public static void main(String[] args){
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/dynamic-controls");
        String title = driver.getTitle();
        System.out.println(title);
        WebElement textbox=driver.findElement(By.xpath("//*[@id=\"input-text\"]"));
        System.out.println("Textbox enabled:"+textbox.isEnabled());
        WebElement select= driver.findElement(By.xpath("//*[@id=\"toggleInput\"]"));
        select.click();
        System.out.println("Textbox enabled:"+textbox.isEnabled());
    }
}