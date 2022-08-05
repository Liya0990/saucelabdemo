package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverUtil {

    private  static WebDriver driver;



    public static void openBrowser(String browserType){
        boolean isChrome= browserType.equalsIgnoreCase("chrome");
        boolean isFirefox=browserType.equalsIgnoreCase("firefox");
        boolean isEdge=browserType.equalsIgnoreCase("edge");
        boolean isHeadless=browserType.equalsIgnoreCase("headless");

        if (isChrome){
            WebDriverManager.chromedriver().setup();
            driver= new ChromeDriver();

        }
        else if (isFirefox){
            WebDriverManager.firefoxdriver().setup();
            driver=new FirefoxDriver();

        }
        else if(isEdge){
            WebDriverManager.edgedriver().setup();
            driver=new EdgeDriver();

        }
        else if(isHeadless){

            ChromeOptions options=new ChromeOptions();
            options.addArguments("--headless");
            options.addArguments("--window-size = 1920,1200");
            options.addArguments("disable-extensions");
            WebDriverManager.chromedriver().setup();
            driver=new ChromeDriver(options);
        }
        else {
            WebDriverManager.chromedriver().setup();
            driver= new ChromeDriver();
        }
        driver.manage().window().maximize();



    }

    public static void closeBrowser(){
        driver.quit();

    }

    public static WebDriver getDriver(){
        return driver;
    }


}
