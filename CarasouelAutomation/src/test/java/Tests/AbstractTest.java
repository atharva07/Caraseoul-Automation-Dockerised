package Tests;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public abstract class AbstractTest {
    protected WebDriver driver;
    // settting up the driver - here we will be using chrome driver
    @BeforeTest
    @Parameters("browser")
    public void setDriver(String browser) throws MalformedURLException {
        // driver setup
        if (browser.equalsIgnoreCase("chrome")) {
            this.driver = getChromeRemoteDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            this.driver = getFirefoxRemoteDriver();
        }
    }

    private WebDriver getChromeRemoteDriver() throws MalformedURLException {
        // Chrome options
        Capabilities capabilities = new ChromeOptions();
        URL url = new URL("http://localhost:4444/wd/hub");
        return new RemoteWebDriver(url, capabilities);
    }

    private WebDriver getFirefoxRemoteDriver() throws MalformedURLException {
        // Firefox options
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