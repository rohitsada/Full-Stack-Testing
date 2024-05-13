import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class act10 {
    public static void main(String[] args){
        // Setup the Firefox driver(GeckoDriver)
        WebDriverManager.firefoxdriver().setup();

        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();

        // Open the browser
        driver.get("https://v1.training-support.net/selenium/dynamic-controls");

        String title = driver.getTitle();
        System.out.println(title);
        WebElement checkBox=driver.findElement(By.xpath("//*[@id=\"dynamicCheckbox\"]/label"));
        System.out.println(checkBox.isDisplayed());
        WebElement removeCheckBox= driver.findElement(By.xpath("//*[@id=\"toggleCheckbox\"]"));
        removeCheckBox.click();
        System.out.println(checkBox.isDisplayed());
        driver.quit();

    }
}