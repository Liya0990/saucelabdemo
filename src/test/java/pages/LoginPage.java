package pages;

import org.openqa.selenium.By;

import static utils.Automation.*;

public class LoginPage {
    private final String url="https://www.saucedemo.com/";

    // ----Web element locations-----//
    private final  By loc_title= By.xpath("/html//div[@id='header_container']//div[@class='app_logo']");
    private final By loc_username=By.cssSelector("input#user-name");
    private final By loc_password=By.cssSelector("input#password");
    private final By loc_loginButton=By.cssSelector("input#login-button");




    // ----User Actions------------//
    public void open(){
        visit(url);
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
    }
    public void enterPassword(String password){
        type(loc_password,password);
    }

    public void clickLoginButton(){
        click(loc_loginButton);
    }



}
