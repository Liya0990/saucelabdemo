package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Automation {

    private static WebDriver driver;
    private static WebDriverWait waits;

    public static void init(WebDriver inputDriver){
        driver=inputDriver;
        waits=new WebDriverWait(inputDriver, Duration.ofSeconds(15));

    }
    public static void visit(String url){
        driver.get(url);
    }

    public static void click(By location ){
        WebElement element=
                waits.until(ExpectedConditions.visibilityOfElementLocated(location));
        element.click();
    }

    public static void type(By location, String text){
        WebElement element =
                waits.until(ExpectedConditions.visibilityOfElementLocated(location));
        element.clear();
        element.sendKeys(text);
    }

    public static String getText(By location){
        WebElement element=
                waits.until(ExpectedConditions.visibilityOfElementLocated(location));
        return element.getText();
    }

    public static boolean isVisible(By location){
        WebElement element=
                waits.until(ExpectedConditions.visibilityOfElementLocated(location));
        return element.isDisplayed();
    }

    public static void highlight(By location){
        WebElement element=
                waits.until(ExpectedConditions.visibilityOfElementLocated(location));
        String jsCode="argument[0].setAttributes('style', 'border: 3px solid red)";
        JavascriptExecutor jsEngine= (JavascriptExecutor) driver;
        jsEngine.executeScript(jsCode,element);
    }

    public static String getAttribute(By location,String attribute){
        WebElement element=
                waits.until(ExpectedConditions.visibilityOfElementLocated(location));
        String placeholderAttribute =element.getAttribute(attribute);
        return  placeholderAttribute;

    }

    public static boolean isStringUpperCase(String str){

        //convert String to char array
        char[] charArray = str.toCharArray();

        for(int i=0; i < charArray.length; i++){

            //if any character is not in upper case, return false
            if( !Character.isUpperCase( charArray[i] ))
                return false;
        }

        return true;
    }

    public static void selectDropDown(By location, String optionText ){
        WebElement element=
                waits.until(ExpectedConditions.visibilityOfElementLocated(location));
        Select dropDownSelection =new Select(element);
        dropDownSelection.selectByVisibleText(optionText);

    }
    public static String getFirstSelectedOption(By location){
        WebElement element=
                waits.until(ExpectedConditions.visibilityOfElementLocated(location));
        Select dropDownSelection =new Select(element);
       return dropDownSelection.getFirstSelectedOption().getText();



    }
    public static List<Double> getPriceList(By location){
        List<WebElement> dollarPriceList=
                driver.findElements(location);
        List<Double> priceList=new ArrayList<>();
        for(WebElement p : dollarPriceList){
            priceList.add(Double.valueOf(p.getText().replace("$","")));
        }
        return priceList;

    }




    public static void sleep(int sec){
        try {
           Thread.sleep(sec*1000);
        }catch (InterruptedException ignore){
            // do nothing
        }
    }





}
