package pages;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.By;
import utils.TestDetector;

import static utils.Automation.*;

public class LoginPage {
    private final String url="https://www.saucedemo.com/";
    private static ExtentTest tcs= TestDetector.getCurrentTestCaseSection();


    // ----Web element locations-----//
    private final  By loc_title= By.cssSelector(".login_logo");
    private final By loc_username=By.cssSelector("input#user-name");
    private final By loc_password=By.cssSelector("input#password");
    private final By loc_loginButton=By.cssSelector("input#login-button");




    // ----User Actions------------//
    public void open(){
        visit(url);
        tcs.info("User is on the sauce lab Page");
    }
    public  String getTitle(){
        String result=getText(loc_title);
        return result;
    }

    public String getLoginButtonText(){
        return getText(loc_loginButton);

    }


    public void enterUserName(String username){
        type(loc_username,username);
        tcs.info("user input username");
    }
    public void enterPassword(String password){
        type(loc_password,password);
        tcs.info("user input Password");

    }

    public void clickLoginButton(){
        click(loc_loginButton);
        tcs.info("user clicks login button");
    }

    public boolean loginPageTitleIsVisible(){
        boolean result= isVisible(loc_title);
        if (result){
            tcs.info("verified that login page title is visible ");
        }
        return result;

    }



}
