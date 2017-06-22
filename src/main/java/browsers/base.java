package browsers;

import com.relevantcodes.extentreports.ExtentReports;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * Created by musti on 20/04/2017.
 */
public class base {

    public static WebDriver driver =null; // null means command can work for any browser decleared below.

    //         setting up TestNG report




    @BeforeTest
    public void setup() throws IOException {




        /* Properties extension - to excess with the help of peoperties class */
        Properties p = new Properties();


        FileInputStream fi = new FileInputStream("C:\\WIP2\\InterviewTests\\David\\src\\main\\java\\browsers\\global.properties");
        p.load(fi);

        if (p.getProperty("browser").contains("firefox")) {// the 'browser' is pointing to the browser in the global.properties file under the class 'base' under package 'browsers'
            driver = new FirefoxDriver();

        }else if(p.getProperty("browser").contains("chrome")){
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\musti\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
            driver = new ChromeDriver();
        }else {
            System.setProperty("webdriver.IE.driver", "C:\\WIP\\FirstAutomationProject\\IEDriver\\IEDriverServer.exe");
            driver = new InternetExplorerDriver();
        }

        driver.get(p.getProperty("url"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

}
