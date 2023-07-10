
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
//import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class selenium_actions {

    WebDriver driver;
    //helps to generate the logs in the test report.
    private ExtentSparkReporter spark;
    private ExtentReports extent;
    private ExtentTest logger;


    @BeforeClass
    public void setup() {


// Create an object of Extent Reports
        extent = new ExtentReports();


        spark = new ExtentSparkReporter(System.getProperty("user.dir") + "/Selenium_Actions.html");
        extent.attachReporter(spark);
        extent.setSystemInfo("Host Name", "https://the-internet.herokuapp.com/ Application - Home Plan");
        extent.setSystemInfo("Environment", "Production");
        extent.setSystemInfo("User Name", "Test Team");
        spark.config().setDocumentTitle("herokuapp Application QA ");
// Name of the report
        spark.config().setReportName("herokuapp Application Using Selenium testNG ");
// Dark Theme
        spark.config().setTheme(Theme.DARK);
        logger = extent.createTest("Validate herokuapp Application Using Selenium testNG");


        System.out.println("##### Starting Chrome Browser ############");


        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));
        logger.info("The Application launched successfully ...");
    }


    @Test
    public void validate_Click_Functionality() {
        try {
            driver.navigate().to("https://the-internet.herokuapp.com/");
            driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));


// CLick on A/B Testing , Click & Element Present Functionality using Selenium ...


            if (driver.findElement(By.xpath("//a[text()='A/B Testing']")).isDisplayed()) {
                driver.findElement(By.xpath("//a[text()='A/B Testing']")).click();
                driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));
                if (driver.findElement(By.xpath("//h3[text()='A/B Test Control']")).isDisplayed()) {
                    logger.pass("Click functionality is working fine for A/B Testing");
                }
            }
        } catch (Exception e) {
            System.out.println(e);
            logger.fail("Click functionality is not working for A/B Testing");
        }
    }


    @Test
    public void validate_CleckBox_Functionality() {
        try {
            driver.navigate().to("https://the-internet.herokuapp.com/checkboxes");


// First Validate Checkbox 1 is not checked and 2 is checked ...


            boolean chkb1 = !driver.findElement(By
                            .xpath("//form[@id='checkboxes']/input[1]"))
                    .isSelected();
            boolean chkb2 = driver.findElement(By
                            .xpath("//form[@id='checkboxes']/input[2]"))
                    .isSelected();
            if (chkb1 & chkb2) {
                logger.pass("By default checkbox 1 is not selected ...");
                logger.pass("By default checkbox 2 is selected ...");
            } else {
                logger.fail("Checkbox functionality is not working");
            }


// Check and unchecj the Checkboxex .....


            driver.findElement(By
                    .xpath("//form[@id='checkboxes']/input[1]")).click();
            driver.findElement(By
                    .xpath("//form[@id='checkboxes']/input[2]")).click();
            Thread.sleep(2000);


// Now Validate Checkbox 1 is checked and 2 is unchecked ...


            chkb1 = driver.findElement(By
                            .xpath("//form[@id='checkboxes']/input[1]"))
                    .isSelected();
            chkb2 = !driver.findElement(By
                            .xpath("//form[@id='checkboxes']/input[2]"))
                    .isSelected();
            if (chkb1 & chkb2) {
                logger.pass("After clicking checkbox 1 is now selected ...");
                logger.pass("After clicking checkbox 2 is now Unchecked ...");
            } else {
                logger.fail("Checkbox functionality is not working");
            }
        } catch (Exception e) {
            System.out.println(e);
            logger.fail("Checkbox functionality is not working");
        }
    }


    @AfterClass
    public void tearDown() {
        driver.quit();
        extent.flush();
    }


}
