package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner.stdDSA;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.TestRunner;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ExtentManager;

public class TestBase {
    public static WebDriver driver;
    public static Properties config = new Properties();
    public static Properties OR = new Properties();
    public static FileInputStream fis;
    public static Logger log = Logger.getLogger(TestBase.class.getName());
    public static WebDriverWait wait;
    public ExtentReports rep = ExtentManager.getInstance();
    public static ExtentTest test;

    @BeforeSuite
    public void setUp() throws IOException {

        System.setProperty("webdriver.http.factory", "jdk-http-client");
        PropertyConfigurator.configure("./src/test/log4j.properties");

        if (driver == null) {
            FileInputStream fis = new FileInputStream(
                    System.getProperty("user.dir") + "/src/test/resources/properties/Config.properties");
            config.load(fis);

            log.info("Config file loaded!!!!!");

            FileInputStream fs = new FileInputStream(
                    System.getProperty("user.dir") + "/src/test/resources/properties/OR.properties");
            OR.load(fs);
            log.info("OR file loaded!!!!!");

        }

        if (config.getProperty("browser").equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            this.driver = new ChromeDriver();
            log.info("Chrome driver Launched!!!!!");
            driver.manage().window().maximize();
            driver.get(config.getProperty("testsiteurl"));
            log.info("Link:- " + config.getProperty("testsiteurl") + " Launched!!!!!");
        }

        else if (config.getProperty("browser").equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            WebDriver driver = new FirefoxDriver();
            driver.manage().window().maximize();
            driver.get(config.getProperty("testsiteurl"));
        }
    }

    public boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    @AfterSuite
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
        log.info("Testing done driver close!!!!!");
    }
}