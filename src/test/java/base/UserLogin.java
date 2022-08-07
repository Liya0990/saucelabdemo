package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.LoginPage;
import utils.Automation;
import utils.Automation.*;
import utils.DriverUtil;

public class UserLogin {

    @BeforeMethod
    public void userLogin(){
        DriverUtil.openBrowser("chrome");
        WebDriver driver=DriverUtil.getDriver();
        Automation.init(driver);



    }

    @AfterMethod
    public void closeBrowser(){
        DriverUtil.closeBrowser();
    }

}
