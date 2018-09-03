package com.Testing.pageObjects;

import com.Testing.helpers.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BookAFlightPage extends BasePage {

    Select select = null;

    public String isOnBookAFlightPage() {
        return driver.getCurrentUrl();
    }


    public void passengerFirstname(String firstName) {
        driver.findElement(By.cssSelector("input[name='passFirst0']")).sendKeys(firstName);
    }

    public void passengerLastName(String lastName) {
        driver.findElement(By.cssSelector("input[name='passLast0']")).sendKeys(lastName);
    }

    public void passengerMeals(String meals) {
        WebElement element = driver.findElement(By.cssSelector("select[name='pass.0.meal']"));
        select = new Select(element);
        select.selectByVisibleText(meals);
    }

    public void creditCardType(String cardType) {

        WebElement element = driver.findElement(By.cssSelector("select[name='creditCard']"));
        select = new Select(element);
        select.selectByVisibleText(cardType);
    }

    public void creditCardNumber(String cardNumber) {

        driver.findElement(By.cssSelector("input[name='creditnumber']")).sendKeys(cardNumber);
    }

    public void creditCardExpMonth(String expMonth) {


        WebElement element1 = driver.findElement(By.cssSelector("select[name='cc_exp_dt_mn']"));
        select = new Select(element1);
        select.selectByVisibleText(expMonth);
    }

    public void creditCardExpYear(String expYear) {

        WebElement element2 = driver.findElement(By.cssSelector("select[name='cc_exp_dt_yr']"));
        select = new Select(element2);
        select.selectByVisibleText(expYear);
    }

    public void creditCardFirstName(String cardFirstName) {

        driver.findElement(By.cssSelector("input[name='cc_frst_name']")).sendKeys(cardFirstName);
    }

    public void creditCardMiddleName(String cardMiddleName) {
        driver.findElement(By.cssSelector("input[name='cc_mid_name']")).sendKeys(cardMiddleName);
    }

    public void creditCardLastName(String cardLastName) {
        driver.findElement(By.cssSelector("input[name='cc_last_name']")).sendKeys(cardLastName);


    }

    public void clickOnTicketLessCheckbox() {
        WebElement checkBox = driver.findElement(By.xpath("//font[contains(text(),'Ticketless Travel')]/../input"));
        checkBox.click();
    }

    public void billingAddress(String address) {
        driver.findElement(By.cssSelector("input[name='billAddress1']")).sendKeys(address);

    }

    public void billingAddressCity(String city) {
        driver.findElement(By.cssSelector("input[name='billCity']")).sendKeys(city);
    }

    public void billingAddressState(String state) {
        driver.findElement(By.cssSelector("input[name='billState']")).sendKeys(state);
    }
    public void billingAddressPostalCode(String postalCode){
        driver.findElement(By.cssSelector("input[name='billZip']")).sendKeys(postalCode);
    }
    public void billingAddressCountry(String country){
        WebElement element = driver.findElement(By.cssSelector("select[name='billCountry']"));
        Select select = new Select(element);
        select.selectByVisibleText("UNITED KINGDOM");
    }
    public void clickOnSameasBillingAddressCheckbox(){
        WebElement checkBox = driver.findElement(By.xpath("//font[contains(text(), 'Same as Billing Address')]/../input"));
        checkBox.click();


    }
    public void clickOnSelectPurchaseBtn(){
        driver.findElement(By.cssSelector("input[name='buyFlights']")).click();
    }

}