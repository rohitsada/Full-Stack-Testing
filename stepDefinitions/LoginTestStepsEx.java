package stepDefinitions;
import org.openqa.selenium.*;
import io.cucumber.java.en.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class LoginTestStepsEx {
    WebDriver driver;
    WebDriverWait wait;

    @Given("^User is on 5 Login page$")
    public void userIsOnLogin5() throws Throwable {
        //Create a new instance of the Firefox driver
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //Open the browser
        driver.get("https://v1.training-support.net/selenium/login-form");
    }

    @When("User enter {string} and {string}")
    public void userEnterString5(String username, String password) throws Throwable {
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));

        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        new Actions(driver)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER)
                .perform();
    }
    @Then("^Read the page title and confirmation message on page5$")
    public void readPageTitle5() throws Throwable {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("action-confirmation")));
        String resultStats = driver.findElement(By.id("action-confirmation")).getText();
        System.out.println("Title message " + driver.getTitle());
        System.out.println("Confirmation message " + resultStats);
    }

    @And("^Close the login browser5$")
    public void closeBrowser5() throws Throwable {
        driver.quit();
    }
}