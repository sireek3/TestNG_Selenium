package test_script;
//import org.Testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
//import org.testng.annotations.Test;

public class Google_Doc1
{
    @Test
    public void validate_google_page() {
        WebDriver driver=new ChromeDriver();
        driver.get("https:/google.com");
        driver.manage().window().maximize();
        driver.quit();
    }
}