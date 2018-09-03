package com.Testing.pageObjects;

import com.Testing.helpers.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class FlightSearchPage extends BasePage {

    public void selectFlights(){
        driver.findElement(By.linkText("Flights")).click();
    }

    public String isOnFlightPage() {

        return driver.getCurrentUrl();
    }

    public void selectType(String type) {
        List<WebElement> radioButton = driver.findElements(By.cssSelector("input[name='tripType']"));
        System.out.println(radioButton.size());
        for (WebElement element : radioButton) {
            if (element.getAttribute("value").equalsIgnoreCase(type)) {
                element.click();
                break;
            }
        }
    }

    public void selectPassenger(String passenger) {
        WebElement element = driver.findElement(By.cssSelector("select[name='passCount']"));
        Select select = new Select(element);
        select.selectByVisibleText(passenger);
    }

    public void selectDepartingFrom (String departing) {
        WebElement element = driver.findElement(By.cssSelector("select[name='fromPort']"));
        Select select = new Select(element);
        select.selectByVisibleText(departing);
    }

    public void selectArrivingOn(String month, String date) {
        WebElement elementMonth = driver.findElement(By.cssSelector("select[name='fromMonth']"));
        WebElement elementDate = driver.findElement(By.cssSelector("select[name='fromDay']"));
        Select select = null;
        select = new Select(elementMonth);
        select.selectByVisibleText(month);
        select = new Select(elementDate);
        select.selectByVisibleText(date);
    }

    public void selectArrivingDestination(String destination) {
        WebElement element = driver.findElement(By.cssSelector("select[name='toPort']"));
        Select select = new Select(element);
        select.selectByVisibleText(destination);
    }

    public void selectReturnMonthDate(String returnMonth, String returnDate) {
        //if (returnMonth.equals("") && retDate.equals("")) return;
        WebElement elentMonth = driver.findElement(By.cssSelector("select[name='toMonth']"));
        WebElement elentDay = driver.findElement(By.cssSelector("select[name='toDay']"));
        Select select = null;
        select = new Select(elentMonth);
        select.selectByVisibleText(returnMonth);
        select = new Select(elentDay);
        select.selectByVisibleText(returnDate);

    }


    public void serviceClass(String service) {
        List<WebElement> radBtn = driver.findElements(By.cssSelector("input[name='servClass']"));
        System.out.println(radBtn.size());
        for (WebElement element : radBtn) {
            if (element.getAttribute("value").equalsIgnoreCase(service)) {
                element.click();
                break;
            }

        }
    }
    public void selectAirline(String airline){
        WebElement element = driver.findElement(By.cssSelector("select[name='airline']"));
        Select select = new Select(element);
        select.selectByVisibleText("Blue Skies Airlines");

    }
    public void clickContine(){
        driver.findElement(By.cssSelector("input[name='findFlights']")).click();
    }
    public String isOnFlightSectPage(){
        return driver.getCurrentUrl();
    }
}