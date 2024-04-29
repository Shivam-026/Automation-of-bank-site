package testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import base.TestBase;
public class LoginTest extends TestBase{

    @Test
    public void loginAsBankManager() throws InterruptedException{
        driver.findElement(By.cssSelector(OR.getProperty("bmlBtn"))).click();
        Thread.sleep(300);
        // Assert.assertTrue(isElementPresent(By.cssSelector(OR.getProperty("addCustBtn"))), "Login not completed");
        log.info("Bank Manager Login!!!!!");
    }
}
