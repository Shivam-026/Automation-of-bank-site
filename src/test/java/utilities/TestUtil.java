package utilities;


import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import base.TestBase;

public class TestUtil extends TestBase {
    
     public static void takeScreenshot() throws IOException {
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshotFile, new File(".//target/surefire-reports/html/ss.jpg"));


       
}
}
