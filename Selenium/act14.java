import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class act14 {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();

        WebDriver driver = new FirefoxDriver();

        driver.get("https://v1.training-support.net/selenium/tables");

        System.out.println(driver.getTitle());

        // find rows
        List<WebElement> rows = driver.findElements(By.xpath("//table[@class = 'ui sortable celled table']/tbody/tr"));
        System.out.println("Number of rows is " + rows.size());
        // number of columns
        List <WebElement> column = driver.findElements(By.xpath("//table[@class = 'ui sortable celled table']/tbody/tr[1]/td"));
        System.out.println("Number of column is " + column.size());

        // print value of second row second column
        WebElement value = driver.findElement(By.xpath("//table[@class = 'ui sortable celled table']/tbody/tr[2]/td[2]"));
        System.out.println("Value of 2nd rows 2nd column is " + value.getText());

        // print value of second row second column after clicking name header
        WebElement header = driver.findElement(By.xpath("//table[@class = 'ui sortable celled table']/thead/tr[1]/th[1]"));
        header.click();
        WebElement value2 = driver.findElement(By.xpath("//table[@class = 'ui sortable celled table']/tbody/tr[2]/td[2]"));
        System.out.println("Value of 2nd rows 2nd column is " + value2.getText());

        // print footer
        WebElement value3 = driver.findElement(By.xpath("//table[@class = 'ui sortable celled table']/tfoot/tr[1]"));
        System.out.println("Value of footer is " + value3.getText());

        driver.quit();

    }

}