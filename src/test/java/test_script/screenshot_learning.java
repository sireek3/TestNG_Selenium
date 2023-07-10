/*package test_script;

public class screenshot_learning {
 String    "C:\Users\babuk\IdeaProjects\Selenium_TestNG\Screenshot"
}*/
package test_script;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.apache.commons.io.FileUtils;


import java.io.File;
import java.time.Duration;


public class screenshot_learning {
    private WebDriver driver;
    String Screenshotpath = "/Users/ashug/IdeaProjects/Selanium_testNG1/Screenshot";


    @BeforeClass
    public void setup() {


        System.out.println("##### Starting Chrome Browser ############");


//ChromeOptions opt = new ChromeOptions();
//opt.addArguments("--remote-allow-origins=*");
//WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.docker.com");
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));
    }


    @Test
    public void Capture_Screenshot_during_fail() {
        try {
            driver.findElement(By.xpath("//abcd")).click();


        } catch (Exception e) {
            Capture_Screenshot("Docker_Logo");
        }
    }
    public void Capture_Screenshot(String Screenshotname) {
        try {
            File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotFile, new File(Screenshotpath + "/" + Screenshotname + ".png"));


        } catch (Exception e) {
        }
    }


}










