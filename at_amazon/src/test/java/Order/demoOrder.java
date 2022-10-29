package Order;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

public class demoOrder {
    public static final String PATH = "D:\\Automation Test\\ngocvu\\TestProjectAmazon\\Automation testing_ Amazon\\chromedriver.exe";
    public static final String DRIVER = "webdriver.chrome.driver";
    public static final String URL = "https://www.amazon.com";

    public void orderItem() {

    }

    WebDriver driver = null;

    @BeforeTest
    public void openBrowser() {
        System.setProperty(DRIVER, PATH);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL);

        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//header/div[@id='navbar']/div[@id='nav-belt']/div[3]/div[1]/a[2]/span[1]"))).perform();
        WebElement li = driver.findElement(By.xpath("//header/div[@id='navbar']/div[@id='nav-belt']/div[3]/div[1]/a[2]/span[1]"));
        actions.moveToElement(li.findElement(By.xpath("//header/div[@id='navbar']/div[@id='nav-flyout-anchor']/div[@id='nav-flyout-accountList']/div[2]/div[1]/div[1]/div[1]/a[1]/span[1]"))).click().perform();
        WebDriverWait wait = new WebDriverWait(driver, 120);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='ap_email']")));
    }

    @AfterTest
    public void closebrowser() {
    }

}
