package com.Testing.pageObjects;

import com.Testing.helpers.BasePage;

public class FlightConfirmationPage extends BasePage {

    public String isOnFlightConfirmationpage(){
        return driver.getCurrentUrl();
    }

}
