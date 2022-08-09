package tests;

import base.UserLogin;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.fetch.model.AuthRequired;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import utils.Automation;

import utils.DriverUtil;

import utils.Automation.*;
import utils.TestDetector;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Listeners(utils.TestDetector.class)
public class SmokeTest extends UserLogin {
   private String username="standard_user";
   private String password="secret_sauce";


    @Test
    public void VerifyUserSuccessfullyLogin(){
        // ---- Test  date
        String expectedTitle="Swag Labs";
        String expectedLoginButtonText="LOGIN";

        // ----Test Steps
        LoginPage login=new LoginPage();
        login.open();
        boolean isLoginPageTitleIsVisible= login.loginPageTitleIsVisible();


        // task 3
        login.enterUserName(username);
        login.enterPassword(password);
        login.clickLoginButton();


      //  ----Test Assertion
        //task 1 ,
        Assert.assertTrue(isLoginPageTitleIsVisible);
        // Assert.assertEquals(actual_title,expectedTitle);



    }
    @Test
    public void verifyLoginButtonIsCapitalize(){
        // ---- Test  date
        String expectedLoginButtonText="LOGIN";

        // ----Test Steps
        LoginPage login=new LoginPage();
        login.open();
        String acrualLoginButtonText=login.getLoginButtonAttribute();
        System.out.println("the text: "+acrualLoginButtonText);

        //boolean isLoginButtonTextCapitalized =
        //Automation.isStringUpperCase(acrualLoginButtonText);



        //  ----Test Assertion
        Assert.assertEquals(acrualLoginButtonText,expectedLoginButtonText);
       // Assert.assertTrue(isLoginButtonTextCapitalized);

    }


    @Test
    public void verifyDefaultDropdown (){
        // ---- Test  date
        String expectedDefaultDropDownText="Name (A to Z)";

        // ----Test Steps
        LoginPage login=new LoginPage();
        login.open();
        login.enterUserName(username);
        login.enterPassword(password);
        login.clickLoginButton();

        HomePage homePage=new HomePage();
        String textOfDefaultDropDown=homePage.getTextOfDefaultDropDown();

        //----Test Assertion
        Assert.assertEquals(textOfDefaultDropDown,expectedDefaultDropDownText);

    }



    @Test
    public void userAbleToPurchase(){
        // ---- Test  date
        String expectedDefaultDropDownText="Name (A to Z)";

        // ----Test Steps

        LoginPage login=new LoginPage();
        login.open();
        login.enterUserName(username);
        login.enterPassword(password);
        login.clickLoginButton();

        HomePage homePage=new HomePage();
        homePage.addFirstProductToChart();
        String productInCart=homePage.getCartBadgeValue();
        Boolean isEqualToOne=productInCart.equals("1");
        Automation.sleep(2);
        homePage.addLastProductToChart();
        Automation.sleep(2);
        productInCart=homePage.getCartBadgeValue();
        boolean isEqualToTwo=productInCart.equals("2");

        // task 9,10
        homePage.RemoveTheFirstProductFromTheCart();
        productInCart=homePage.getCartBadgeValue();
        //Verifythecartbadgehas1product
        boolean isCartBadgeValueDropToOne=productInCart.equals("1");
        Automation.sleep(2);

        homePage.clickCart();
        boolean isTheAddedProductIsAvailableInChart=
                homePage.verifyTheAddedProductIsAvailableInChart();
        Automation.sleep(2);

        homePage.clickContinueShoppingButton();
        Automation.sleep(2);

        homePage.selectByOption("Price (low to high)");
        Automation.sleep(2);

        //  ----Test Assertion
        Assert.assertTrue(isEqualToOne);
        Assert.assertTrue(isEqualToTwo);
        Assert.assertTrue(isCartBadgeValueDropToOne);
        Assert.assertTrue(isTheAddedProductIsAvailableInChart);

    }


    @Test
    public void verifyPriceSortedProperly(){
        // ---- Test  date

        By loc_price= By.className("inventory_item_price");

        // ----Test Steps
        LoginPage login=new LoginPage();
        login.open();
        login.enterUserName(username);
        login.enterPassword(password);
        login.clickLoginButton();

        // before filter capture the price
        List<Double> beforeFilterPriceList=Automation.getPriceList(loc_price);

        HomePage homePage=new HomePage();
        homePage.selectByOption("Price (low to high)");
        Automation.sleep(2);

        // after filter capture the price
        List<Double> afterFilterPriceList=Automation.getPriceList(loc_price);

        Collections.sort(beforeFilterPriceList);


        //  ----Test Assertion
        Assert.assertEquals(beforeFilterPriceList,afterFilterPriceList);

    }







}


