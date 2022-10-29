package Shopping_cart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Add_Delete_Item {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\eclipse-workspace\\Automation testing_ Amazon\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.amazon.com/");
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, 120);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("twotabsearchtextbox")));
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("Iphone X");
        //searchBox.submit();
        driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
        driver.findElement(By.xpath("//span[contains(text(),'Apple iPhone X, 64GB, Space Gray - Fully Unlocked ')]")).click();


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='quantity']")));
        Select quantity = new Select(driver.findElement(By.xpath("//select[@id='quantity']")));
        quantity.selectByIndex(1);

        driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body/div[4]/div[3]/div[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[3]/form[1]/span[1]/span[1]/input[1]")));
        driver.findElement(By.xpath("//body/div[4]/div[3]/div[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[3]/form[1]/span[1]/span[1]/input[1]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body/div[@id='a-page']/div[2]/div[3]/div[3]/div[1]/div[2]/div[1]/div[1]/form[1]/div[2]/div[3]/div[4]/div[1]/div[2]/div[1]/span[2]/span[1]/input[1]")));
        driver.findElement(By.xpath("//body/div[@id='a-page']/div[2]/div[3]/div[3]/div[1]/div[2]/div[1]/div[1]/form[1]/div[2]/div[3]/div[4]/div[1]/div[2]/div[1]/span[2]/span[1]/input[1]")).click();
    }
}
