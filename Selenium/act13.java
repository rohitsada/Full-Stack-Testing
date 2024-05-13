import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class act13 {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();

        WebDriver driver = new FirefoxDriver();

        driver.get("https://v1.training-support.net/selenium/tables");

        System.out.println(driver.getTitle());

        WebElement table = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div[2]/table"));

        //System.out.println(table);
        // find rows
        List <WebElement> rows = driver.findElements(By.xpath("//table[@class = 'ui celled striped table']/tbody/tr"));
        System.out.println("Number of rows is " + rows.size());
        // number of columns
        List <WebElement> column = driver.findElements(By.xpath("//table[@class = 'ui celled striped table']/tbody/tr[1]/td"));
        System.out.println("Number of column is " + column.size());

        // print value of second row second column
        WebElement value = driver.findElement(By.xpath("//table[@class = 'ui celled striped table']/tbody/tr[2]/td[2]"));
        System.out.println("Value of 2nd rows 2nd column is " + value.getText());

        // print the 3rd row
        WebElement value2 = driver.findElement(By.xpath("//table[@class = 'ui celled striped table']/tbody/tr[3]"));
        System.out.println("Value of 3rd rows is " + value2.getText());

        // exit browser
        driver.quit();

    }
}