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
    private final String username = "standard_user";
    private final String password = "secret_sauce";

    // task 1 (NavigatetoSaucedemoVerifythetitleasSwagLabs)
    // task 3(Loginwithstandard_user&secret_sauce)
    @Test
    public void VerifyUserSuccessfullyLogin() {
        // ---- Test  date
        String expectedTitle = "Swag Labs";
        String expectedLoginButtonText = "LOGIN";

        // ----Test Steps
        LoginPage login = new LoginPage();
        login.open();
        boolean isLoginPageTitleIsVisible = login.loginPageTitleIsVisible();

        // String actual_title=login.getTitle();
        //  System.out.println("the actual title: "+actual_title);
        // task 3
        login.enterUserName(username);
        login.enterPassword(password);
        login.clickLoginButton();


        //  ----Test Assertion
        //task 1 ,
        Assert.assertTrue(isLoginPageTitleIsVisible);
        // Assert.assertEquals(actual_title,expectedTitle);


    }
}


