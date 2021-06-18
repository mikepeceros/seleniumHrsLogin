package com.hrs.runners;

import com.hrs.pages.loginPage;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

@CucumberOptions(plugin = {"pretty",
        "json:target/cucumber_json_reports/home-page.json",
        "json:target/cucumber-json/cucumber.json",
        "html:target/home-page-html"},
        features = {"src/test/resources/features/hrs/"},
        tags = { "@UserLogin" },
        glue = { "com.hrs.steps"})

public class AppTestRun extends AbstractTestNGCucumberTests {
    static private RemoteWebDriver webDriver;
    protected static loginPage loginPage;
    private final String screenshotsFolder = "./target/screenshots/";

    public AppTestRun(){}

    public void initPages(RemoteWebDriver webDriver) {
        loginPage = new loginPage(webDriver);
    }

    @BeforeTest
    public void cleanResources(){

    }

    @BeforeMethod
    @Parameters({ "browser" })
    public void startBrowser(String browser) throws Exception {
        switch (browser.toLowerCase()){
            case "chrome":
                startChrome();
                break;
            case "firefox":
                startFirefox();
                break;
            default:
                break;
        }
    }

    @AfterMethod
    public void quitDriver() throws Exception {
        if (webDriver != null) {
            webDriver.quit();
        }
    }

    public RemoteWebDriver startChrome(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        try{
            WebDriverManager.chromedriver().setup();
            webDriver = new ChromeDriver(options);
            webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            initPages(webDriver);
        }catch (Exception e){
            //TODO
        }
        return webDriver;
    }

    public RemoteWebDriver startFirefox(){
        try{
            WebDriverManager.firefoxdriver().setup();
            webDriver = new FirefoxDriver();
            webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            webDriver.manage().window().maximize();
            initPages(webDriver);
        }catch (Exception e){
            //TODO
        }
        return webDriver;
    }
}