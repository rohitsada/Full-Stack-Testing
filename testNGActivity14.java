import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;
import java.util.List;

public class testNGActivity14 {
    WebDriver driver;

    @BeforeClass
    public void beforeMethod() {
        // Setup the Firefox driver(GeckoDriver)
        WebDriverManager.firefoxdriver().setup();

        // Create a new instance of the Firefox driver
        driver = new FirefoxDriver();

        // Open the browser
        driver.get("https://alchemy.hguy.co/crm/");

    }

    @Test
    public void testCase1() {
        // Check the title of the page
        String title = driver.getTitle();

        // Print the title of the page
        System.out.println("Page title is: " + title);

        // Log in
        WebElement userName = driver.findElement(By.id("user_name"));
        userName.sendKeys("admin");

        WebElement password = driver.findElement(By.id("username_password"));
        password.sendKeys("pa$$w0rd");
        password.sendKeys(Keys.ENTER);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement salesOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"grouptab_0\"]")));
        salesOption.click();

        // Click on Opportunities
        WebElement opportunitiesOption = driver.findElement(By.xpath("//*[@id=\"moduleTab_9_Opportunities\"]"));
        opportunitiesOption.click();

        // Click on Filter icon
        WebElement filterIcon = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[4]/div/div[3]/form[2]/div[3]/table/thead/tr[2]/td/table/tbody/tr/td[1]/ul[3]/li/a")));
        filterIcon.click();

        // Click on Advanced Filter
        WebElement advancedFilter = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[4]/div/div[3]/div/div/div/div[1]/ul/li[2]")));
        advancedFilter.click();

        // Select filter options
        Select opportunityAmountFilter = new Select(driver.findElement(By.id("advsrch_advopportunityamount")));
        opportunityAmountFilter.selectByVisibleText("Equals");
        WebElement opportunityAmountInput = driver.findElement(By.id("advsrch_advopportunityamount_input"));
        opportunityAmountInput.sendKeys("10000");

        Select salesStageFilter = new Select(driver.findElement(By.id("advsrch_advsalesstage")));
        salesStageFilter.selectByVisibleText("Needs Analysis");

        Select leadSourceFilter = new Select(driver.findElement(By.id("advsrch_advleadsource")));
        leadSourceFilter.selectByVisibleText("Cold Call");

        Select directionFilter = new Select(driver.findElement(By.id("advsrch_advdirection")));
        directionFilter.selectByVisibleText("Inbound");

        // Click Search
        WebElement searchButton = driver.findElement(By.id("search_form_submit"));
        searchButton.click();

        // Print Account Names displayed
        List<WebElement> accountNames = driver.findElements(By.xpath("//table[@class='list view table-responsive']//td[@field='account_name']"));
        for (WebElement account : accountNames) {
            System.out.println(account.getText());
        }

        // Reset filter
        WebElement resetButton = driver.findElement(By.xpath("//input[@id='search_form_clear']"));
        resetButton.click();
    }

//    @AfterClass
//    public void afterMethod() {
//        driver.quit();
//    }
}
