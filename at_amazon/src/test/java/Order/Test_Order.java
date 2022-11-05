package Order;

import Sign_in.WriteExcel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.*;

public class Test_Order {
    public static final String PATH = "D:\\Automation Test\\code_at\\auto_test_amz\\at_amazon\\src\\test\\resources\\webdriver\\chromedriver.exe";
    public static final String DRIVER = "webdriver.chrome.driver";
    public static final String URL = "https://www.amazon.com";

    String fileInputPath = "D:\\Automation Test\\code_at\\auto_test_amz\\at_amazon\\src\\test\\resources\\data\\data_order.xlsx";
    String fileOutputPath = "D:\\Automation Test\\code_at\\auto_test_amz\\at_amazon\\src\\test\\resources\\data\\output_order.xlsx";

    WebDriver driver = null;
    ReadExcel readExcel = new ReadExcel();
    List<Address> listAddress;
    List<HashMap<String,Object>> testResultExport = new ArrayList<>();
    Map<String, Object> testResult = new HashMap<String, Object>();
    WriteExcel writeExcel = new WriteExcel();
    ArrayList<String> arrResult = new ArrayList<>();

    @Test(priority = 0)
    public void importTestData() throws IOException {
        listAddress = readExcel.readDataExcel(fileInputPath);
    }

    @DataProvider(name = "data_order")
    public Object[][] dataOrder() {
        int numberCases = listAddress.size();
        Object[][] Cred = new Object[numberCases][7];
        for (int i = 0; i < numberCases; i++) {
            Address x = (Address) listAddress.get(i);
            Cred[i][0] = x.getIDtc();
            Cred[i][1] = x.getfullName();
            Cred[i][2] = x.getstreetAddress();
            Cred[i][3] = x.getcity();
            Cred[i][4] = x.getzipCode();
            Cred[i][5] = x.getphoneNumber();
            Cred[i][6] = x.getmessage();
        }
        System.out.println("object data" + Cred);
        return Cred;
    }
    @Test(dataProvider = "data_order", priority = 1)
    public void Order(String IDtc, String fullName, String streetAddress, String city, String zipCode, String phoneNumber, String message)throws IOException, InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement eleSelectAddr = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='address-ui-widgets-countryCode-dropdown-nativeId']")));
        Select dropCountry = new Select(eleSelectAddr);
        dropCountry.selectByVisibleText("Vietnam");;
        Thread.sleep(1000);

        WebElement FullName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='address-ui-widgets-enterAddressFullName']")));
        WebElement StreetAddress = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='address-ui-widgets-enterAddressLine1']")));
        WebElement City = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='address-ui-widgets-enterAddressCity']")));
        WebElement ZipCode = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='address-ui-widgets-enterAddressPostalCode']")));
        WebElement PhoneNumber =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='address-ui-widgets-enterAddressPhoneNumber']")));
        WebElement eleBtnSubmit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='address-ui-widgets-form-submit-button']")));

        switch(IDtc) {
            case "01":
                try {
                    setData(FullName, StreetAddress, City, ZipCode, PhoneNumber, fullName, streetAddress, city, zipCode, phoneNumber);
                    eleBtnSubmit.click();
                    String actualResult1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Please enter a name.')]"))).getText();
                    String status = "";
                    if (actualResult1.contentEquals(message)) {
                        testResult.put("result", "PASS");
                        status = "PASS";
                    } else {
                        testResult.put("result", "FAIL");
                        status = "FAIL";
                    }
                    testResult.put("IDtc", IDtc);
                    testResult.put("Full name", fullName );
                    testResult.put("Street address", streetAddress);
                    testResult.put("City", city);
                    testResult.put("Zip code", zipCode);
                    testResult.put("Phone number", phoneNumber);
                    testResult.put("Message", message);
                    String rst = IDtc + ";" + fullName + ";" + streetAddress + ";" + city + ";" + zipCode + ";" + phoneNumber + ";" + message + ";" + status;
                    arrResult.add(rst);
                } catch (Exception  e) {
                    e.printStackTrace ();
                }
                break;
            case "02":
                try {
                    setData(FullName, StreetAddress, City, ZipCode, PhoneNumber, fullName, streetAddress, city, zipCode, phoneNumber);
                    eleBtnSubmit.click();
                    String actualResult2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Please enter an address.')]"))).getText();
                    String status = "";
                    if (actualResult2.contentEquals(message)) {
                        testResult.put("result", "PASS");
                        status = "PASS";
                    } else {
                        testResult.put("result", "FAIL");
                        status = "FAIL";
                    }

                    testResult.put("IDtc", IDtc);
                    testResult.put("Full name", fullName );
                    testResult.put("Street address", streetAddress);
                    testResult.put("City", city);
                    testResult.put("Zip code", zipCode);
                    testResult.put("Phone number", phoneNumber);
                    testResult.put("Message", message);
                    String rst = IDtc + ";" + fullName + ";" + streetAddress + ";" + city + ";" + zipCode + ";" + phoneNumber + ";" + message + ";" + status;
                    arrResult.add(rst);
                } catch (Exception  e) {
                    e.printStackTrace ();
                }
                break;

            case "03":
                try {
                    setData(FullName, StreetAddress, City, ZipCode, PhoneNumber, fullName, streetAddress, city, zipCode, phoneNumber);
                    eleBtnSubmit.click();
                    String actualResult3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Please enter a ZIP or postal code.')]"))).getText();
                    String status = "";
                    if (actualResult3.contentEquals(message)) {
                        testResult.put("result", "PASS");
                        status = "PASS";
                    } else {
                        testResult.put("result", "FAIL");
                        status = "FAIL";
                    }

                    testResult.put("IDtc", IDtc);
                    testResult.put("Full name", fullName );
                    testResult.put("Street address", streetAddress);
                    testResult.put("City", city);
                    testResult.put("Zip code", zipCode);
                    testResult.put("Phone number", phoneNumber);
                    testResult.put("Message", message);
                    String rst = IDtc + ";" + fullName + ";" + streetAddress + ";" + city + ";" + zipCode + ";" + phoneNumber + ";" + message + ";" + status;
                    arrResult.add(rst);
                } catch (Exception  e) {
                    e.printStackTrace ();
                }
                break;
            case "04":
                try {
                    setData(FullName, StreetAddress, City, ZipCode, PhoneNumber, fullName, streetAddress, city, zipCode, phoneNumber);
                    eleBtnSubmit.click();
                    String actualResult4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Please enter a phone number so we can call if ther')]"))).getText();
                    String status = "";
                    if (actualResult4.contentEquals(message)) {
                        testResult.put("result", "PASS");
                        status = "PASS";
                    } else {
                        testResult.put("result", "FAIL");
                        status = "FAIL";
                    }

                    testResult.put("IDtc", IDtc);
                    testResult.put("Full name", fullName );
                    testResult.put("Street address", streetAddress);
                    testResult.put("City", city);
                    testResult.put("Zip code", zipCode);
                    testResult.put("Phone number", phoneNumber);
                    testResult.put("Message", message);
                    String rst = IDtc + ";" + fullName + ";" + streetAddress + ";" + city + ";" + zipCode + ";" + phoneNumber + ";" + message + ";" + status;
                    arrResult.add(rst);
                } catch (Exception  e) {
                    e.printStackTrace ();
                }
                break;
            case "05":
                try {
                    setData(FullName, StreetAddress, City, ZipCode, PhoneNumber, fullName, streetAddress, city, zipCode, phoneNumber);
                    eleBtnSubmit.click();
                    String status = "";
                    WebDriverWait waitWarning = new WebDriverWait(driver, 20);
                    WebElement eleWarning = waitWarning.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Please provide a valid phone number')]")));
                    if (eleWarning !=null){
                        String actualResult5 = eleWarning.getText();
                        if (actualResult5.contentEquals(message)) {
                            status = "PASS";
                        } else {
                            status = "FAIL";
                        }
                    }
                    testResult.put("result", status);
                    testResult.put("IDtc", IDtc);
                    testResult.put("Full name", fullName );
                    testResult.put("Street address", streetAddress);
                    testResult.put("City", city);
                    testResult.put("Zip code", zipCode);
                    testResult.put("Phone number", phoneNumber);
                    testResult.put("Message", message);
                    String rst = IDtc + ";" + fullName + ";" + streetAddress + ";" + city + ";" + zipCode + ";" + phoneNumber + ";" + message + ";" + status;
                    arrResult.add(rst);
                } catch (Exception e) {
                    String rst = IDtc + ";" + fullName + ";" + streetAddress + ";" + city + ";" + zipCode + ";" + phoneNumber + ";" + message + ";" + "FAIL";
                    arrResult.add(rst);
                }
                break;
            case "06":
                try {
                    setData(FullName, StreetAddress, City, ZipCode, PhoneNumber, fullName, streetAddress, city, zipCode, phoneNumber);
                    eleBtnSubmit.click();
                    String actualResult6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),\"We couldn't verify your address. Please make sure \")]"))).getText();
                    String status = "";
                    if (actualResult6.contentEquals(message)) {
                        testResult.put("result", "PASS");
                        status = "PASS";

                    } else {
                        testResult.put("result", "FAIL");
                        status = "FAIL";
                    }

                    testResult.put("IDtc", IDtc);
                    testResult.put("Full name", fullName );
                    testResult.put("Street address", streetAddress);
                    testResult.put("City", city);
                    testResult.put("Zip code", zipCode);
                    testResult.put("Phone number", phoneNumber);
                    testResult.put("Message", message);
                    String rst = IDtc + ";" + fullName + ";" + streetAddress + ";" + city + ";" + zipCode + ";" + phoneNumber + ";" + message + ";" + status;
                    arrResult.add(rst);
                } catch (Exception  e) {
                    e.printStackTrace ();
                }
                break;

        }
        for (int i=0; i<arrResult.size(); i++) {
            System.out.println("test == " + arrResult.get(i));
        }

    }
    @Test(priority = 2)
    public void export() throws IOException {
        //code function ghi ket qua test rieng cho chuc nang order va goi ham ghi data test order tai day
    }
    @BeforeTest
    public void openBrowser() {
        System.setProperty(DRIVER, PATH);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--user-data-dir=C:\\Users\\ASUS\\AppData\\Local\\Google\\Chrome\\User Data");
        options.addArguments("profile-directory=Default");
        options.addArguments("--remote-debugging-port=9222");
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("profile.exit_type", "Normal");
        options.setExperimentalOption("prefs", prefs);
        driver = new ChromeDriver(options);
        driver.navigate().to(URL);
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, 120);
        WebElement eleNav = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//header/div[@id='navbar']/div[@id='nav-belt']/div[3]/div[1]/a[2]/span[1]")));
        Actions actions = new Actions(driver);
        actions.moveToElement(eleNav).perform();
        WebElement eleLi = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//header/div[@id='navbar']/div[@id='nav-belt']/div[3]/div[1]/a[2]/span[1]")));
        actions.moveToElement(eleLi).click().perform();
        WebElement eleNavCart = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='nav-cart']")));
        eleNavCart.click();
        WebElement eleProceedToRetailCheckout = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='proceedToRetailCheckout']")));
        eleProceedToRetailCheckout.click();
        WebElement eleAddNewAddrPopover = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='add-new-address-popover-link']")));
        eleAddNewAddrPopover.click();
    }

    @AfterTest
    public void closebrowser() {
    }

    public void setData(WebElement FullName,
                        WebElement StreetAddress,
                        WebElement City,
                        WebElement ZipCode,
                        WebElement PhoneNumber,
                        String fullName,
                        String streetAddress,
                        String city,
                        String zipCode,
                        String phoneNumber) {
        FullName.clear();
        StreetAddress.clear();
        City.clear();
        ZipCode.clear();
        PhoneNumber.clear();

        FullName.sendKeys(fullName);
        StreetAddress.sendKeys(streetAddress);
        City.sendKeys(city);
        ZipCode.sendKeys(zipCode);
        PhoneNumber.sendKeys(phoneNumber);
    }
}
