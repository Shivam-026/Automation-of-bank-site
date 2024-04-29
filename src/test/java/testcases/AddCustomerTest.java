package testcases;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import base.TestBase;
import utilities.ExcelReader;
import utilities.TestUtil;

public class AddCustomerTest extends TestBase{

    @Test (dataProviderClass = ExcelReader.class ,  dataProvider = "abcde" )
    public void addCustomer(String firstName, String lastName, String postCode , String alertText) throws InterruptedException, IOException{
        // driver.findElement(By.cssSelector(OR.getProperty("bmlBtn"))).click();
        System.setProperty("org.uncommons.reportng.escape-output", "false");
        driver.findElement(By.cssSelector(OR.getProperty("addCustBtn"))).click();
        Thread.sleep(300);
        driver.findElement(By.cssSelector(OR.getProperty("firstname"))).sendKeys(firstName);
        driver.findElement(By.cssSelector(OR.getProperty("lastname"))).sendKeys(lastName);
        driver.findElement(By.cssSelector(OR.getProperty("postcode"))).sendKeys(postCode);
        TestUtil.takeScreenshot();
        driver.findElement(By.cssSelector(OR.getProperty("addbtn"))).click();
        Thread.sleep(300);
        String altText = driver.switchTo().alert().getText();
        System.out.println(altText);

        driver.switchTo().alert().accept();
        driver.switchTo().parentFrame();
        TestUtil.takeScreenshot();

        test = rep.startTest(lastName);
        test.log(LogStatus.PASS, "PASS");
        rep.endTest(test);
        rep.flush();

        Reporter.log("<a target = \"_blank\" href = \"./ss.jpg\">ss</a>");
        Reporter.log("<br>");
        Reporter.log("<a target = \"_blank\" href = \".//ss.jpg\"><img src=\"./ss.jpg\" height=200 width=200> </img></a>");
    //     Alert alert = wait.until(ExpectedConditions.alertIsPresent());
    //    Assert.assertTrue(alert.getText().contains(alertText)); 
    //    Thread.sleep(30000);
    //    alert.accept();
    //    Thread.sleep(30000);
    }  
}
