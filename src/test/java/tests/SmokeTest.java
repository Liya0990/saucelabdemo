package tests;
import base.UserLogin;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.fetch.model.AuthRequired;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import pages.LoginPage;
import utils.Automation;
import utils.DriverUtil;
import utils.TestDetector;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Listeners(utils.TestDetector.class)
public class SmokeTest extends UserLogin {
    private static ExtentTest tcs= TestDetector.getCurrentTestCaseSection();


    @Test
    public void VerifyUserSuccessfullyLogin(){

        // ---- Test  date
        String expectedTitle="Swag Labs";
        String expectedLoginButtonText="Login";
        String username="standard_user";
        String password="secret_sauce";
        String expectedDefaultDropDownText="Name (A to Z)";
        By loc_price= By.className("inventory_item_price");

        // ----Test Steps
        LoginPage login=new LoginPage();
        login.open();
        boolean isLoginPageTitleIsVisible= login.loginPageTitleIsVisible();
        String acrualLoginButtonText=login.getLoginButtonAttribute();
        System.out.println("the text: "+acrualLoginButtonText);
//      String actual_title=login.getTitle();
//      System.out.println("the actual title: "+actual_title);

        login.logIn(username,password);





        HomePage homePage=new HomePage();
        String textOfDefaultDropDown=homePage.getTextOfDefaultDropDown();

        homePage.addFirstProductToChart();
        String productInCart=homePage.getCartBadgeValue();
        Boolean isEqualToOne=productInCart.equals("1");
        homePage.addLastProductToChart();
        productInCart=homePage.getCartBadgeValue();
        boolean isEqualToTwo=productInCart.equals("2");

        homePage.RemoveTheFirstProductFromTheCart();
        productInCart=homePage.getCartBadgeValue();

        boolean isCartBadgeValueDropToOne=productInCart.equals("1");

        homePage.clickCart();
        boolean isTheAddedProductIsAvailableInChart=
                homePage.verifyTheAddedProductIsAvailableInChart();

        homePage.clickContinueShoppingButton();

        // before filter capture the price
        List<Double> beforeFilterPriceList=Automation.getPriceList(loc_price);

        homePage.selectByOption("Price (low to high)");

        // after filter capture the price
        List<Double> afterFilterPriceList=Automation.getPriceList(loc_price);
        Collections.sort(beforeFilterPriceList);

        //  ----Test Assertion
        Assert.assertTrue(isLoginPageTitleIsVisible);
//      Assert.assertEquals(actual_title,expectedTitle);
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(acrualLoginButtonText,expectedLoginButtonText,"button text doesnt match");
        //Assert.assertEquals(acrualLoginButtonText,expectedLoginButtonText);
        Assert.assertEquals(textOfDefaultDropDown,expectedDefaultDropDownText);
        Assert.assertTrue(isEqualToOne);
        Assert.assertTrue(isEqualToTwo);
        Assert.assertTrue(isCartBadgeValueDropToOne);
        Assert.assertTrue(isTheAddedProductIsAvailableInChart);

        Assert.assertEquals(beforeFilterPriceList,afterFilterPriceList);
        softAssert.assertAll();
    }

//    @DataProvider(name = "loginData")
//    public Object[][] loginTestData(){
//        return new Object[][]{
//                {"standard_user","secret_sauce"} ,
//
//        };
//
//
//    }
}// end :: class


