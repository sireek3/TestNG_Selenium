package test_script;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.nio.file.Path;


public class Print_links_inreport {


    //helps to generate the logs in the test report.
    private ExtentSparkReporter spark;
    private ExtentReports extent;
    private ExtentTest logger;
    private WebDriver driver;


    @BeforeClass
    public void setup() {


// initialize the HtmlReporter


// Create an object of Extent Reports
        extent = new ExtentReports();
        spark = new ExtentSparkReporter(System.getProperty("user.dir") + "/printlinks.html");

        extent.attachReporter(spark);
        extent.setSystemInfo("Host Name", "Sirisha-QATester");
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("User Name", "Test Team");
        spark.config().setDocumentTitle("Amazon homepage testing ");
// Name of the report
        spark.config().setReportName("Amazon Application Using Selenium testNG ");
// Dark Theme
        spark.config().setTheme(Theme.STANDARD);
        logger = extent.createTest("Validate pizzahut Checkout Application Using Selenium testNG");

         driver = new ChromeDriver();
        driver.get("https://Amazon.com");
        driver.manage().window().maximize();


    }

    @Test
    public void print_all_links() {
        try {
            int link_count= driver.findElements(By.xpath("//a")).size();
            for(int i=1;i<link_count;i++)
            {
                String link=driver.findElement(By.xpath("(//a)["+i+"]")).getText();
                String href=driver.findElement(By.xpath("(//a)["+i+"]")).getAttribute("href");
                String innerHTML=driver.findElement(By.xpath("(//a)["+i+"]")).getAttribute("innerHTML");
                System.out.println("The link name is==>"+innerHTML);
                logger.info(link);
                logger.info(href);
            }
        } catch (Exception e)
        {
        }
    }
    @AfterClass
    public void quit_the_session() {
        driver.quit();
        extent.flush();
    }




}
