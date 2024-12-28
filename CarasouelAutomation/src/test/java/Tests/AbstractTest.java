package Tests;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
//import io.github.bonigarcia.wdm.WebDriverManager;

public abstract class AbstractTest {

    protected WebDriver driver;
    // settting up the driver - here we will be using chrome driver
    @BeforeTest
    public void setDriver() throws MalformedURLException {
        // driver setup
        //WebDriverManager.chromedriver().setup();
        //this.driver = new ChromeDriver();
        this.driver = getRemoteWebDriver();
    }

    private WebDriver getRemoteWebDriver() throws MalformedURLException {

        // Chrome options
        //Capabilities capabilities = new ChromeOptions();
        Capabilities capabilities = new FirefoxOptions();
        URL url = new URL("http://localhost:4444/wd/hub");
        return new RemoteWebDriver(url, capabilities);
    }

    // quit driver
    @AfterTest
    public void quitDriver() {
        this.driver.quit();
    }
}
