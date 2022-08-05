package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import utils.Automation;

import utils.DriverUtil;

import utils.Automation.*;

import java.util.Map;

@Listeners(utils.TestDetector.class)
public class SmokeTest {


    @Test
    public void VerifyUserSuccessfullyLogin(){
        // ---- Test  date
        String expectedTitle="SwagLabs";
        String expectedLoginButtonText="LOGIN";
        String username="standard_user";
        String password="secret_sauce";
        String expectedDefaultDropDownText="NAME (A-Z)";



        // ----Test Steps
        DriverUtil.openBrowser("chrome");
        WebDriver driver=DriverUtil.getDriver();
        Automation.init(driver);

        LoginPage login=new LoginPage();
        login.open();
        login.enterUserName(username);
        login.enterPassword(password);
        login.clickLoginButton();

        String actual_title=login.getTitle();
        System.out.println(actual_title);
       
//        String loginButtonText=login.getLoginButtonText();
//
//        boolean isLoginButtonTextCapitalized =
//                Automation.isStringUpperCase(loginButtonText);
//
//        HomePage homePage=new HomePage();
//        String textOfDefaultDropDown=homePage.getTextOfDefaultDropDown();
//
//        //-------------------------------------
//        homePage.addFirstProductToChart();
//        String productInCart=homePage.getCartBadgeValue();
//        Boolean isEqualToOne=productInCart.equals("1");
//        homePage.addLastProductToChart();
//        boolean isEqualToTwo=productInCart.equals("2");
//
//
//
//        //?????????????????????
//        //?????????????????????
//        //?????????????????????
//
//
//        homePage.clickCart();
//        //????
//        homePage.clickContinueShoppingButton();
//        homePage.clickRemoveBackpackButton();
//        homePage.clickContinueShoppingButton();
//        homePage.selectByOption("Price (low to high)");
//
////        Map<int ,int >price=new Map<int, int>() {
////        }
//











        DriverUtil.closeBrowser();


        //----Test Assertion

//        Assert.assertEquals(actual_title,expectedTitle);
//        Assert.assertTrue(isLoginButtonTextCapitalized);
//        Assert.assertEquals(textOfDefaultDropDown,expectedDefaultDropDownText);
//        Assert.assertTrue(isEqualToOne);
//        Assert.assertTrue(isEqualToTwo);






    }

    @Test
    public void verifyUserPurchase(){
        // ---- Test  date

        // ----Test Steps
        DriverUtil.openBrowser("chrome");
        WebDriver driver=DriverUtil.getDriver();
        Automation.init(driver);

        //----Test Assertion



    }
}


