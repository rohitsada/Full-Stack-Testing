import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class targetPract {
    public static void main(String[] args) {
        // Setup the Firefox driver(GeckoDriver)
        WebDriverManager.firefoxdriver().setup();

        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();
        System.out.println(driver.getTitle());
        driver.get("https://v1.training-support.net/selenium/target-practice");

        WebElement checkInput=driver.findElement(By.xpath("//*[@id=\"third-header\"]"));

        System.out.println(checkInput.getText());
        WebElement colour=driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div/div/div/div[1]/h5"));

        System.out.println(colour.getCssValue("color"));
        WebElement violet = driver.findElement(By.cssSelector(".violet"));
        System.out.println(violet.getAttribute("class"));

        WebElement grey=driver.findElement(By.cssSelector(".grey"));
        System.out.println(grey.getText());

    }
}
