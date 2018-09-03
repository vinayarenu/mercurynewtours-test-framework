package com.Testing.stepsDef;

import com.Testing.helpers.BasePage;
import com.Testing.pageObjects.*;
import cucumber.api.PendingException;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.endsWith;

public class Steps {
    RegistrationPage registrationPage = new RegistrationPage();
    FlightSearchPage flightSearchPage = new FlightSearchPage();
    SelectFlightPage selectFlightPage = new SelectFlightPage();
    BookAFlightPage bookAFlightPage = new BookAFlightPage();
    FlightConfirmationPage flightConfirmationPage = new FlightConfirmationPage();


    @Before
    public void homepage() {
        BasePage.driver.get("http://newtours.demoaut.com/");
    }

    @After
    public void screenShot(Scenario scenario) throws IOException {
        if (scenario.isFailed()) {
            //take screenshot and store as a file format
            File screenshotFile = ((TakesScreenshot) BasePage.driver).getScreenshotAs(OutputType.FILE);

            //now copy the screenshot to desired location using copyFile()
            FileUtils.copyFile(screenshotFile, new File("C:\\Users\\Prashanth Reddy\\Desktop\\javaprojects\\MyNewtoursProject\\src\\test\\java\\com\\Testing\\screenshot.png"));
            BasePage.driver.quit();
        }
    }


    @Given("^user is on homepage$")
    public void user_is_on_homepage() {
        String actual = registrationPage.isOnHomePage();
        assertThat(actual, endsWith(".com/"));
    }

    @When("^selects Register$")
    public void selects_Register() {
        registrationPage.register();

    }

    @When("^enters all the required registration information$")
    public void enters_all_the_required_registration_information() {

        registrationPage.fillForm();
    }

    @When("^selects submit$")
    public void selects_submit() {
        registrationPage.submitBtn();
    }

    @Then("^user should successfully register$")
    public void user_should_successfully_register() {
        String actual = registrationPage.userSuccessfullyRegister();
        assertThat(actual, endsWith("success.php"));
    }

    @Given("^user selects flights$")
    public void userSelectsFlights() {

        flightSearchPage.selectFlights();
    }

    @Then("^user should navigate to FLIGHT FINDER page$")
    public void userShouldNavigateToFLIGHTFINDERPage() {
        String actual = flightSearchPage.isOnFlightPage();
        assertThat(actual, endsWith("php"));
    }

    @When("^selects type \"([^\"]*)\"$")
    public void selects_type(String type) {
        flightSearchPage.selectType(type);
    }

    @When("^selects the passenger \"([^\"]*)\"$")
    public void selects_the_passenger(String passenger) {
        flightSearchPage.selectPassenger(passenger);

    }

    @When("^selects the departing from \"([^\"]*)\"$")
    public void selects_the_departing_from(String departing) {
        flightSearchPage.selectDepartingFrom(departing);


    }

    @When("^selects the month\"([^\"]*)\" and date\"([^\"]*)\"$")
    public void selects_the_month_and_date(String month, String date) {
        flightSearchPage.selectArrivingOn(month, date);

    }

    @When("^selects arriving destination \"([^\"]*)\"$")
    public void selects_arriving_destination(String destination) {
        flightSearchPage.selectArrivingDestination(destination);
    }

    @When("^selects returning month \"([^\"]*)\" and returning date \"([^\"]*)\"$")
    public void selects_returning_month_and_returning_date(String returnMonth, String returnDate) {
        flightSearchPage.selectReturnMonthDate(returnMonth, returnDate);
    }

    @When("^selects service class \"([^\"]*)\"$")
    public void selects_service_class(String sClass) {
        flightSearchPage.serviceClass(sClass);
    }

    @When("^selects airline \"([^\"]*)\"$")
    public void selects_airline(String airline) {
        flightSearchPage.selectAirline(airline);
    }

    @When("^selects continue$")
    public void selects_continue() {
        flightSearchPage.clickContine();
    }

    @Then("^user should navigate to SELECT FLIGHT PAGE$")
    public void user_should_navigate_to_SELECT_FLIGHT_PAGE() {
        String actual = selectFlightPage.isOnSelectFlightPage();
        assertThat(actual, endsWith(".php"));
    }


    @Given("^selects continue button$")
    public void selects_continue_button() {
        selectFlightPage.selectContinue();
    }

    @Then("^user should navigate to BOOK A FLIGHT PAGE$")
    public void user_should_navigate_to_BOOK_A_FLIGHT_PAGE() {
        String actual = bookAFlightPage.isOnBookAFlightPage();
        assertThat(actual, endsWith("mercurypurchase.php"));


    }
    @Then("^fills first name \"([^\"]*)\" from Passenger$")
    public void fills_first_name_from_Passenger(String firstName) {
        bookAFlightPage.passengerFirstname(firstName);
    }


    @Then("^fills last name \"([^\"]*)\" from Passenger$")
    public void fills_last_name_from_Passenger(String lastName) {
        bookAFlightPage.passengerLastName(lastName);

    }

    @Then("^selects meal \"([^\"]*)\" from Passenger$")
    public void selects_meal_from_Passenger(String meals) {
        bookAFlightPage.passengerMeals(meals);
    }

    @Then("^selects card type \"([^\"]*)\" from Credit Card$")
    public void selects_card_type_from_Credit_Card(String cardType) {
        bookAFlightPage.creditCardType(cardType);
    }

    @Then("^fills number \"([^\"]*)\" from Credit Card$")
    public void fills_number_from_Credit_Card(String cardNumber) {
        bookAFlightPage.creditCardNumber(cardNumber);
    }

    @Then("^selects expiration month \"([^\"]*)\" from Credit Card$")
    public void selects_expiration_month_from_Credit_Card(String expMonth) {
        bookAFlightPage.creditCardExpMonth(expMonth);
    }

    @Then("^selects expiration year \"([^\"]*)\" from Credit Card$")
    public void selects_expiration_year_from_Credit_Card(String expYear) {
        bookAFlightPage.creditCardExpYear(expYear);
    }

    @Then("^fills firstname \"([^\"]*)\" from Credit Card$")
    public void fills_firstname_from_Credit_Card(String cardFirstName) {
        bookAFlightPage.creditCardFirstName(cardFirstName);

    }

    @Then("^fills middle \"([^\"]*)\" from Credit Card$")
    public void fills_middle_from_Credit_Card(String cardMiddleName) {
        bookAFlightPage.creditCardMiddleName(cardMiddleName);
    }

    @And("^fills last \"([^\"]*)\" from Credit Card$")
    public void fillsLastFromCreditCard(String cardLastName) {
        bookAFlightPage.creditCardLastName(cardLastName);
    }

    @Then("^ticks Ticketless Travel check box from Billing address$")
    public void ticks_Ticketless_Travel_check_box_from_Billing_address() {
        bookAFlightPage.clickOnTicketLessCheckbox();
    }

    @Then("^fills address \"([^\"]*)\" from Billing Address$")
    public void fills_address_from_Billing_Address(String address) {
        bookAFlightPage.billingAddress(address);

    }

    @Then("^fills city \"([^\"]*)\"$")
    public void fills_city(String city) {
        bookAFlightPage.billingAddressCity(city);
    }

    @Then("^fills state and province \"([^\"]*)\"$")
    public void fills_state_and_province(String state) {
        bookAFlightPage.billingAddressState(state);
    }

    @Then("^fills postal code \"([^\"]*)\"$")
    public void fills_postal_code(String postalCode) {
        bookAFlightPage.billingAddressPostalCode(postalCode);

    }

    @Then("^selects country \"([^\"]*)\" from Billing address$")
    public void selects_country_from_Billing_address(String country) {
        bookAFlightPage.billingAddressCountry(country);
    }

    @Then("^ticks  Same as Billing Address check box from Delivery Address$")
    public void ticks_Same_as_Billing_Address_check_box_from_Delivery_Address() {
        bookAFlightPage.clickOnSameasBillingAddressCheckbox();
    }

    @Then("^selects SELECT PURCHASE button$")
    public void selects_SELECT_PURCHASE_button() {
        bookAFlightPage.clickOnSelectPurchaseBtn();
    }

    @Then("^user should navigate to Flight Confirmation page$")
    public void user_should_navigate_to_Flight_Confirmation_page() {
        String actual = flightConfirmationPage.isOnFlightConfirmationpage();
        assertThat(actual, endsWith("php"));
    }


    @Then("^should view Your itinerary has been booked! message$")
    public void should_view_Your_itinerary_has_been_booked_message() {
    }



}
