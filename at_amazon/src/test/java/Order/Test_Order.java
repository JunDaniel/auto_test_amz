package Order;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test_Order {
    public static final String PATH = "C:\\Users\\Admin\\eclipse-workspace\\Automation testing_ Amazon\\chromedriver.exe";
    public static final String DRIVER = "webdriver.chrome.driver";
    public static final String URL = "https://www.amazon.com";

    String fileInputPath = "src/Order/data_order.xlsx";
    String fileOutputPath = "src/Order/output_order.xlsx";

    WebDriver driver = null;
    ReadExcel readExcel = new ReadExcel();
    List<Address> listAddress;
    List<HashMap<String,Object>> testResultExport = new ArrayList<>();
    Map<String, Object> testResult = new HashMap<String, Object>();

    @Test(priority = 0)
    public void importTestData() throws IOException {
        listAddress = readExcel.readDataExcel(fileInputPath);

    }

    @DataProvider(name = "data_order")
    public Object[][] dataOrder() {
        int numberCases = listAddress.size();
        Object[][] Cred = new Object[numberCases][9];
        for (int i = 0; i < numberCases; i++) {
            Address x = (Address) listAddress.get(i);
            Cred[i][0] = x.getIDtc();
            Cred[i][1] = x.getfullName();
            Cred[i][2] = x.getstreetAddress();
            Cred[i][3] = x.getcity();
            Cred[i][4] = x.getzipCode();
            Cred[i][5] = x.getphoneNumber();
            Cred[i][6] = x.getcardNumber();
            Cred[i][7] = x.getNameonCard();
            Cred[i][8] = x.getexpirationDate();
        }
        System.out.println("object data" + Cred);
        return Cred;
    }
    @Test(dataProvider = "data_order", priority = 1)
    public void Order(String IDtc, String fullName, String streetAddress, String city, String zipCode, String phoneNumber, String cardNumber, String NameonCard, String expirationDate)throws IOException {
        WebDriverWait wait = new WebDriverWait(driver, 120);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body[1]/div[5]/div[1]/div[1]/div[3]/h1[1]")));

        driver.findElement(By.xpath("//input[@id='address-ui-widgets-enterAddressFullName']")).sendKeys(fullName);
        driver.findElement(By.cssSelector("#address-ui-widgets-enterAddressLine1")).sendKeys(streetAddress);
        driver.findElement(By.xpath("//input[@id='address-ui-widgets-enterAddressCity']")).sendKeys(city);
        driver.findElement(By.xpath("//input[@id='address-ui-widgets-enterAddressPostalCode']")).sendKeys(zipCode);
        driver.findElement(By.xpath("//input[@id='address-ui-widgets-enterAddressPhoneNumber']")).sendKeys(phoneNumber);

        driver.findElement(By.xpath("//body/div[@id='a-page']/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/form[1]/div[1]/span[3]/span[1]/span[1]/input[1]")).click();
        driver.findElement(By.xpath("//body/div[@id='a-page']/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/form[1]/div[1]/span[3]/span[1]/span[1]/input[1]")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#pp-4dFrHf-69")));
        driver.findElement(By.cssSelector("#pp-4dFrHf-69")).click();

        testResult.put("IDtc", IDtc);
        testResult.put("Full name", fullName );
        testResult.put("Street address", streetAddress);
        testResult.put("City", city);
        testResult.put("Zip code", zipCode);
        testResult.put("Phone number", phoneNumber);
        testResult.put("Card number", cardNumber);
        testResult.put("Name on Card", NameonCard);
        testResult.put("Expiration Date", expirationDate);

        switch(IDtc) {
            case "01":
                break;
            case "02":
                break;
            case "03":
                break;
            case "04":
                break;
            case "05":
                break;
            case "06":
                break;
            case "07":
                break;
            case "08":
                break;
            case "09":
                break;
            case "10":
                break;
        }
        testResultExport.add((HashMap<String, Object>) testResult);
    }
    @BeforeTest
    public void openBrowser() {
        System.setProperty(DRIVER, PATH);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL);
        driver.get(URL);

        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//header/div[@id='navbar']/div[@id='nav-belt']/div[3]/div[1]/a[2]/span[1]"))).perform();
        WebElement li = driver.findElement(By.xpath("//header/div[@id='navbar']/div[@id='nav-belt']/div[3]/div[1]/a[2]/span[1]"));
        actions.moveToElement(li.findElement(By.xpath("//header/div[@id='navbar']/div[@id='nav-flyout-anchor']/div[@id='nav-flyout-accountList']/div[2]/div[1]/div[1]/div[1]/a[1]/span[1]"))).click().perform();
        WebDriverWait wait = new WebDriverWait(driver, 120);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='ap_email']")));
        driver.findElement(By.xpath("//input[@id='ap_email']")).sendKeys("ngocvu1541@gmail.com");
        driver.findElement(By.xpath("//input[@id='continue']")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='ap_password']")));
        driver.findElement(By.xpath("//input[@id='ap_password']")).sendKeys("Ngoc12345@");
        driver.findElement(By.xpath("//input[@id='signInSubmit']")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='nav-cart']")));
        driver.findElement(By.xpath("//a[@id='nav-cart']")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body/div[@id='a-page']/div[2]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/span[1]/span[1]/span[1]/input[1]")));
        driver.findElement(By.xpath("//body/div[@id='a-page']/div[2]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/span[1]/span[1]/span[1]/input[1]")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='address-ui-widgets-countryCode-dropdown-nativeId']")));
        Select dropCountry = new Select(driver.findElement(By.xpath("//select[@id='address-ui-widgets-countryCode-dropdown-nativeId']")));
        dropCountry.selectByVisibleText("Vietnam");
    }

    @AfterTest
    public void closebrowser() {
    }
}
