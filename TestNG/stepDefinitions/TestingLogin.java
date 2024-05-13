package stepDefinitions;
import org.openqa.selenium.*;
import io.cucumber.java.en.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class TestingLogin {
    WebDriver driver;
    WebDriverWait wait;

    @Given("^User is on Login page$")
    public void userIsOnLoginPage() throws Throwable {
        //Create a new instance of the Firefox driver
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //Open the browser
        driver.get("https://v1.training-support.net/selenium/login-form");
    }

    @When("^User enters username and password$")
    public void userenterusernameandpassword() throws Throwable {
        WebElement username =driver.findElement(By.id("username"));
        new Actions(driver)
                .click(username)
                .sendKeys("admin")
                .sendKeys(Keys.TAB)
                .sendKeys("password")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER)
                .perform();

    }
    @Then("^Read the page title and confirmation message$")
    public void readtitleandconfirmation() throws Throwable {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("action-confirmation")));
        String resultStats = driver.findElement(By.id("action-confirmation")).getText();
        System.out.println("Title message " + driver.getTitle());
        System.out.println("Confirmation message " + resultStats);
    }

    @And("^Close browser$")
    public void closeTheBrowser() throws Throwable {
        driver.close();
    }
}