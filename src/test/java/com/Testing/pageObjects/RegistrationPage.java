package com.Testing.pageObjects;

import com.Testing.helpers.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static org.hamcrest.MatcherAssert.assertThat;

public class RegistrationPage extends BasePage {

    public String isOnHomePage() {
        return driver.getCurrentUrl();

    }

    public void register() {

        driver.findElement(By.linkText("REGISTER")).click();
        //driver.findElement(By.cssSelector(".mouseOver>a")).click();
    }

    public void fillForm() {
        driver.findElement(By.cssSelector("input[name='firstName']")).sendKeys("himabindu");
        //driver.findElement(By.xpath("html/body/div[1]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[2]/td[2]/input")).sendKeys("himabindu");
        driver.findElement(By.cssSelector("input[name='lastName']")).sendKeys("patlolla");
        WebElement element = driver.findElement(By.cssSelector("select[name='country']"));
        Select select = new Select(element);
        select.selectByVisibleText("UNITED KINGDOM");
        driver.findElement(By.cssSelector("input#email")).sendKeys("user123");
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys("selenium");
        driver.findElement((By.cssSelector("input[name='confirmPassword']"))).sendKeys("selenium");
    }

    public void submitBtn() {
        driver.findElement((By.cssSelector("input[name='register']"))).click();
    }

    //@Then("^user should successfully register$")
    public String userSuccessfullyRegister() {
        return driver.getCurrentUrl();

    }
}
