package pages;

import org.bouncycastle.crypto.agreement.srp.SRP6Client;
import org.openqa.selenium.By;
import utils.Automation;

import static utils.Automation.*;

public class HomePage {

    // Web Element location
    By loc_dropdown= By.cssSelector(".product_sort_container");
    By loc_first_product=By.cssSelector("button#add-to-cart-sauce-labs-backpack");
    By loc_last_product=By.cssSelector("button#add-to-cart-test\\.allthethings\\(\\)-t-shirt-\\(red\\)");
    By loc_cart_badge=By.cssSelector(".shopping_cart_badge");
    By loc_cart=By.cssSelector(".shopping_cart_link");
    By loc_continue_shopping_button=By.cssSelector("button#continue-shopping");
    By loc_backpack_remove_button=By.cssSelector("button#remove-sauce-labs-backpack");


    // User Actions
    public String getTextOfDefaultDropDown(){
       return getFirstSelectedOption(loc_dropdown);
       //return getText(loc_default_dropdown);
    }
    public void addFirstProductToChart(){
        click(loc_first_product);
    }
    public void addLastProductToChart(){
        click(loc_last_product);
    }

    public String getCartBadgeValue(){
        return getText(loc_cart_badge);
    }

    public void clickCart(){
        click(loc_cart);
    }

    public  void clickContinueShoppingButton(){
        click(loc_continue_shopping_button);
    }

    public void clickRemoveBackpackButton(){
        click(loc_backpack_remove_button);
    }

    public void selectByOption(String option){
        selectDropDown(loc_dropdown,option);
    }




}
