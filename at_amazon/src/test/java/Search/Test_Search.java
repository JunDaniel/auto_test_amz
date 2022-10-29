package Search;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test_Search {
    public static final String PATH = "C:\\Users\\Admin\\eclipse-workspace\\Automation testing_ Amazon\\chromedriver.exe";
    public static final String DRIVER = "webdriver.chrome.driver";
    public static final String URL = "https://www.amazon.com";

    //@Test(priority = 1)
    public static void main(String[] arg) {
        System.setProperty(DRIVER, PATH);
        WebDriver driver = null;
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get(URL);
        WebDriverWait wait = new WebDriverWait(driver, 120);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("twotabsearchtextbox")));

        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("Iphone X");
        //searchBox.submit();
        driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
        driver.findElement(By.xpath("//span[contains(text(),'Apple iPhone XR, 64GB, Yellow - Unlocked (Renewed ')]")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='quantity']")));
        Select quantity = new Select(driver.findElement(By.xpath("//select[@id='quantity']")));
        quantity.selectByIndex(1);
    }
}
