package com.Testing.pageObjects;

import com.Testing.helpers.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SelectFlightPage extends BasePage {

    public String isOnSelectFlightPage() {
        return driver.getCurrentUrl();
    }
    public void departureAirline(String selectDepartAirline){
        List<WebElement> radioBtn = driver.findElements(By.cssSelector("input[type='radio']"));
        System.out.println(radioBtn.size());
        for (WebElement element : radioBtn) {
            if (element.getAttribute("value").equalsIgnoreCase(selectDepartAirline)) {
                element.click();
                break;
            }
        }
    }
    public void returnAirline(String selectReturnAirline){
        List<WebElement> radioBtn = driver.findElements(By.cssSelector("input[type='radio']"));
        System.out.println(radioBtn.size());
        for (WebElement element : radioBtn) {
            if (element.getAttribute("value").equalsIgnoreCase(selectReturnAirline)) {
                element.click();
                break;
            }
        }
    }
    public void selectContinue(){
        driver.findElement(By.cssSelector("input[name='reserveFlights']")).click();
    }

}
