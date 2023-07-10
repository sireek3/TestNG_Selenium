package test_script;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import support.Support;

import java.time.Duration;

public class Amazon_printlinks {
    public WebDriver driver;
    public Support obj;

    @BeforeClass
    public void first_step() throws Exception {
        obj = new Support();
//initialization of the chrome drive class
        driver = new ChromeDriver();


// launch the browser
        driver.get(obj.read_properties_file("amazon_url"));


//Maximize the browser
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


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
            }
        } catch (Exception e)
        {
        }


    }

    @AfterClass
    public void quit_the_session() {
        driver.quit();
    }


}






