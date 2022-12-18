package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utils.Utils;

public class DriverManager {
    private WebDriver driver;
    private String browser = Utils.dotEnv().get("BROWSER", "chrome");

    private static DriverManager instance = new DriverManager();
    public static DriverManager getInstance(){

        return instance;
    }

    private DriverManager(){}

    public WebDriver setDriver(){
        if(browser.equalsIgnoreCase("chrome")){
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        }else if (browser.equalsIgnoreCase("edge")){
            driver = new EdgeDriver();
        }
        driver.manage().window().maximize();
        return driver;
    }

}
