package com.Testing.helpers;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BasePage {
    public static WebDriver driver;

    public void openBrowser(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\vinay\\Downloads\\drivers\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();

    }

    public void closeBrowser(){
        driver.quit();
    }
}
