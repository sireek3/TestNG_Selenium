package test_script;

import com.beust.jcommander.Parameter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import support.Support;

import java.time.Duration;

public class Ford_Testing {
    public WebDriver driver;
    public Support obj;

    @BeforeClass
    public void first_step() throws Exception {
        obj = new Support();
//initialization of the chrome drive class
        driver = new ChromeDriver();


// launch the browser
        driver.get(obj.read_properties_file("url"));


//Maximize the browser
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


    }

    @Test
    @Parameters({"user", "password"})
    public void ford_signin_validation(String user, String password) {
        try {
            if (driver.findElement(By.xpath("(//span[@class='user-menu-icon fgx-icon icon-account-outline fgx-icon--20'])[2]")).isDisplayed()) {
                System.out.println("Ford sign in icon is displayed====> PASS");
                driver.findElement(By.xpath("(//span[@class='user-menu-icon fgx-icon icon-account-outline fgx-icon--20'])[2]")).click();
                driver.findElement(By.xpath("(//li[@data-fgx-item-template='Sign In'])[2]")).click();
                Thread.sleep(5000);
                driver.findElement(By.id("username")).sendKeys(user);
                driver.findElement(By.id("password")).sendKeys(password);
                driver.findElement(By.id("submit-btn")).click();
                Thread.sleep(5000);
            }
        } catch (Exception e) {
        }


    }

    @AfterClass
    public void quit_the_session() {
        driver.quit();
    }


}






