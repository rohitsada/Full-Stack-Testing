import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.Color;

public class colorNameGetter {

    public static void main(String[] args) {
        // Setup the Firefox driver(GeckoDriver)
        WebDriverManager.firefoxdriver().setup();

        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();

        // Print the title of the webpage
        System.out.println(driver.getTitle());

        // Navigate to the webpage
        driver.get("https://v1.training-support.net/selenium/target-practice");

        // Locate the element whose color you want to determine
        WebElement element = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div/div/div/div[2]/div[1]/button[1]"));

        // Get the color of the element
        String colorHex = element.getCssValue("background-color");
        System.out.println(colorHex);
        Color color = Color.fromString(colorHex);

        // Get RGB values from Color object
        int r = color.getColor().getRed();
        int g = color.getColor().getGreen();
        int b = color.getColor().getBlue();

        // Initialize ColorUtils
        ColorUtils colorUtils = new ColorUtils();

        // Get the closest color name
        String colorName = colorUtils.getColorNameFromRgb(r, g, b);

        // Print or use the obtained color name
        System.out.println("Color name: " + colorName);

        // Close the browser
        driver.quit();
    }
}