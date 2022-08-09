package pages;

import com.aventstack.extentreports.ExtentTest;
import org.bouncycastle.crypto.agreement.srp.SRP6Client;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.Automation;
import utils.TestDetector;

import java.util.List;

import static utils.Automation.*;

public class HomePage {

    private static ExtentTest tcs= TestDetector.getCurrentTestCaseSection();


    // Web Element location
    By loc_dropdown= By.cssSelector(".product_sort_container");
    By loc_first_product=By.cssSelector("button#add-to-cart-sauce-labs-backpack");
    By loc_last_product=By.cssSelector("button#add-to-cart-test\\.allthethings\\(\\)-t-shirt-\\(red\\)");
    By loc_cart_badge=By.cssSelector(".shopping_cart_badge");
    By loc_cart=By.cssSelector(".shopping_cart_link");
    By loc_continue_shopping_button=By.cssSelector("button#continue-shopping");
    By loc_remove_first_product=By.cssSelector("button#remove-sauce-labs-backpack");
    By loc_product_added_in_char_name=By.cssSelector(".inventory_item_name");


    // User Actions
    public String getTextOfDefaultDropDown(){
      String result= getFirstSelectedOption(loc_dropdown);
      tcs.info("verify the default drop down option as expected");
      return result;
    }
    public void addFirstProductToChart(){
        click(loc_first_product);
        tcs.info("added first product to chat");
    }
    public void addLastProductToChart(){
        click(loc_last_product);
        tcs.info("added last product to chart");
    }

    public void RemoveTheFirstProductFromTheCart(){
        click(loc_remove_first_product);
        tcs.info("remove first product from the chart");
    }
    public boolean verifyTheAddedProductIsAvailableInChart(){
        boolean result= isVisible(loc_product_added_in_char_name);
        if(result){
            tcs.info("verified the added product is availeble in chart");
        }
            return result;

    }


    public String getCartBadgeValue(){
        return getText(loc_cart_badge);
    }

    public void clickCart(){
        click(loc_cart);
        tcs.info("user licks cart icon");
    }

    public  void clickContinueShoppingButton(){
        click(loc_continue_shopping_button);
        tcs.info("user clicks on continue shopping button");
    }


    public void selectByOption(String option){
        selectDropDown(loc_dropdown,option);
    }

}// end: class






