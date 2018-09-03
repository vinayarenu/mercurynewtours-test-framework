Feature: As a user i should be able to book a flight

  Scenario: User should be able to Register successfully
    Given user is on homepage
    When selects Register
    And enters all the required registration information
    And selects submit
    Then user should successfully register

  Scenario Outline: User should be able to book a flight journey with valid details
    Given user selects flights
    Then user should navigate to FLIGHT FINDER page
    When selects type "<Type>"
    And selects the passenger "<Passengers>"
    And selects the departing from "<Departing From>"
    And selects the month"<Arriving Month>" and date"<Arriving Date>"
    And selects arriving destination "<Arriving In>"
    And selects returning month "<Returning month>" and returning date "<Returning Date>"
    And selects service class "<Service Class>"
    And selects airline "<Airline>"
    And selects continue
    Then user should navigate to SELECT FLIGHT PAGE
    And selects continue button
    Then user should navigate to BOOK A FLIGHT PAGE
    And fills first name "<First Name>" from Passenger
    And fills last name "<Last Name>" from Passenger
    And selects meal "<Meal>" from Passenger
    And selects card type "<Card Type>" from Credit Card
    And fills number "<Number>" from Credit Card
    And selects expiration month "<Expiration Month>" from Credit Card
    And selects expiration year "<Expiration year>" from Credit Card
    And fills firstname "<First Name>" from Credit Card
    And fills middle "<Middle>" from Credit Card
    And fills last "<Last>" from Credit Card
    And ticks Ticketless Travel check box from Billing address
    And fills address "<Address>" from Billing Address
    And fills city "<City>"
    And fills state and province "<State/Province>"
    And fills postal code "<Postal Code>"
    And selects country "<Country>" from Billing address
    And ticks  Same as Billing Address check box from Delivery Address
    And selects SELECT PURCHASE button
    Then user should navigate to Flight Confirmation page
    And should view Your itinerary has been booked! message
    Examples:
      | Type      | Passengers | Departing From | Arriving Month | Arriving Date | Arriving In | Returning month | Returning Date | Service Class | Airline             | First Name | Last Name | Meal       | Card Type        | Number      | Expiration Month | Expiration year | Middle | Last | Address | City   | State/Province | Postal Code | Country        |
      | RoundTrip | 1          | London         | May            | 2             | New York    | May             | 15             | Business      | Blue Skies Airlines | Vinaya     | M         | Vegetarian | American Express | 12345678910 | 01               | 2010            | D      | M    | Flat 2  | London | London         | IG11XR      | United Kingdom |

