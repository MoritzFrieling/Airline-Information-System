## Log in
| Name: | Actor logs in with invalid combination of email and password |
|----|----|
| Scenario: |1. System asks the Actor to enter email and password. |
|  | 2. Actor enters abc@gmail.com for email and abcabc for password. |
| Results: | System informs that the combination of email/password is invalid. |


| Name: | Actor logs in with valid combination of email and password |
|----|----|
| Scenario: |1. System asks the Actor to enter email and password. |
|  | 2. Actor enters abcefg@gmail.com for email and abcabc for password. |
| Results: | System logs the Actor in. |


## Log out

| Name: | Actor doesn't log out (Maybe pressed on the button by accident?) |
|----|----|
| Scenario: |1. Actor chooses to log out. |
|  | 2. System asks the Actor for confirmation. |
|  | 3. Actor indicates he doesn't want to log out. |
| Results: | Nothing happens |

| Name: | Actor logs out |
|----|----|
| Scenario: |1. Actor chooses to log out. |
|  | 2. System asks the Actor for confirmation. |
|  | 3. Actor indicates he wants to log out. |
|  | 4. System dispalys the login page. |
| Results: | System logs the Actor out. |

## Register Flight

| Name: | Actor enters invalid departure/arrival date while register a new flight |
|----|----|
| Scenario: |1. Actor chooses to register new flight. |
|  | 2. System asks the Actor to enter the new flight information. |
|  | 3. Actor enter 22/01/2022 for departure/arrival date 
| Results: | System indicates that the departure/arrival date is invalid. |


| Name: | Actor enters invalid flight price while register a new flight|
|----|----|
| Scenario: |1. Actor chooses to register new flight. |
|  | 2. System asks the Actor to enter the new flight information. |
|  | 3. Actor enter -300.00 for the flight price. |
| Results: | System indicates that the flight price is invalid. |

## Search flight (new use case: searching the flight by its name)

| Name: | Actor enters valid flight name for searching the flight |
|----|----|
| Scenario: |1. Actor chooses to search flight by name. |
|  | 2. System asks the Actor to enter the flight name . |
|  | 3. Actor enters AH19Q for the flight name. |
| Results: | System displays the flight information for the Actor. |

| Name: | Actor enters invalid flight name for searching the flight |
|----|----|
| Scenario: |1. Actor chooses to search flight by name. |
|  | 2. System asks the Actor to enter the flight name . |
|  | 3. Actor enters AH19 for the flight name. |
| Results: | System informs that the flight name is invalid. |

## Look up upcoming flights

| Name: | Actor enters valid information for looking up flights |
|----|----|
| Scenario: |1. Actor chooses to look up upcoming flights. |
|  | 2. System asks the Actor to enter details (Arrival airport, Departure airport, Departure date, Number of seats). |
|  | 3. Actor enter ABC for arrival airport, BCE for departure airport, 02/03/2022 for departure date, 2 for number of seats. |
| Results: | System displays the list of matching flights for the Actor. |

| Name: | Actor enters invalid information for looking up flights |
|----|----|
| Scenario: |1. Actor chooses look up upcoming flights. |
|  | 2. System asks the Actor to enter the details . |
|  | 3. Actor enter ABC for arrival airport, BCE for departure airport, 02/03/2021 for departure date, 2 for number of seats. |
| Results: | System informs that the departure date is invalid. |

| Name: | Actor enters valid information for looking up flights , but no flights are there |
|----|----|
| Scenario: |1. Actor chooses to look up upcoming flights. |
|  | 2. System asks the Actor to enter details (Arrival airport, Departure airport, Departure date, Number of seats). |
|  | 3. Actor chooses ABC for arrival airport, BCE for departure airport, 02/03/2022 for departure date, 20 for number of seats. |
| Results: | System displays an empty list since the criteria is not met for any flight. |

## Look up booking

| Name: | Actor enters valid information for looking up a booking |
|----|----|
| Scenario: |1. Actor chooses to look up upcoming bookings. |
|  | 2. System asks the Actor to enter details (origin, destination, CustomerID, BookingID, CustomerName). |
|  | 3. Actor enter ABC for arrival airport, BCE for departure airport,123 for BookingID, "Moritz" for CustomerName. |
| Results: | System displays the list of matching bookings for the Actor. |

| Name: | No booking was found |
|----|----|
| Scenario: |1. Actor chooses to look up upcoming booking. |
|  | 2. System asks the Actor to enter details (origin, destination, CustomerID, BookingID, CustomerName). |
|  | 3. Actor enter ABC for arrival airport, BCE for departure airport, for BookingID, "Mortz" for CustomerName. |
| Results: | System displays the list of matching flights for the Actor. |

## Edit booking

| Name: | Actor edits a looked up booking|
|----|----|
| Scenario: | 1. The system displays an option to edit the booking. |
|  | 2. The Actor selects to edit the booking Information(Tickets,origin ,destination, Delete?). |
|  | 2. 	3. The System displays form with all booking information. |
|  | 3. Actor changes the name  of the person from the first ticket from "Mortz Frieling" to "Moritz Frieling". |
| Results: | The Actor has successfully updated the booking. |

## Create ticket

| Name: | Actor choses to create a ticket within a booking |
|----|----|
| Scenario: | 1. The System displays the options for the ticket(Extra options, seat choice, passenger data like age, name). |
|  | 2. The Actor enters the information "no extra options", "no seat choice", "19" as age and "Mortz Frieling" as name and saves the changes. |
|  | 3. The System displays all information regarding the ticket, including the price, which is 79 euros. |
|  | 4.a Actor changes the name  of the person from the first ticket from "Mortz Frieling" to "Moritz Frieling". |
|  | 3. The System displays all information regarding the ticket, including the price, which is still 79 euros. |
|  | 4. The Actor confirms the ticket creation. |
|  | 5. The system displays a success message. |
| Results: | Ticket was created for the passenger "Moritz Frieling". |

## Register airport

| Name: | Actor registers airport, works |
|----|----|
| Scenario: |1. Actor chooses register new airport. |
|  | 2. System asks the Actor to provide information for airport name, abbreviation, city, country and coordinate. |
|  | 3. Actor enters "Shiphol" for airport name, "SHP" for abbreviation, "Amsterdam" for city, "Netherlands" for Country and "52.308056,4.764167" for the Coordinates. |
| Results: | System informs that airport has been registered. |

| Name: | Actor registers airport, works |
|----|----|
| Scenario: |1. Actor chooses register new airport. |
|  | 2. System asks the Actor to provide information for airport name, abbreviation, city, country and coordinate. |
|  | 3. Actor enters "Franz Josef Strauss" for airport name, "MUC" for abbreviation, "Munich" for city, "Germany" for Country and "48°21′14″N 011°47′10″E" for the Coordinates. 
| Results: | System informs that airport has been registered. |

| Name: | Actor registers existed airport |
|----|----|
| Scenario: |1. Actor chooses register new airport |
|  | 2. System asks the Actor to provide information for airport name, abbreviation, city, and country . |
|  | 3. Actor enters "Shiphol" for airport name, "SHP" for abbreviation, "Amsterdam" for city and "Netherlands" for country. |
| Results: | System informs that the airport already exists. |


| Name: | Actor registers airport with blank fields |
|----|----|
| Scenario: |1. Actor chooses register new airport. |
|  | 2. System asks the Actor to provide information for airport name, abbreviation, city, and country . |
|  | 3. Actor enters "abcde" for airport name, "ABC" for abbreviation, "Venlo" for city. |
| Results: | System informs that fields can not be empty. |

## Register route


| Name: | Actor registers existed route |
|----|----|
| Scenario: |1. The System displays the main sales manager dashboard. |
|  | 2. Actor choose to register route. |
|  | 3. System asks the Actor to choose destination and origin airports. |
| Results: | System informs that the route already exists. |

## Register sales officer or sales employee

| Name: | Actor registers sales officer/ sales employees successfully |
|----|----|
| Scenario: |1. The Actor indicates he wants to create a new account for a staff member. |
|  | 2. The System asks the actor what kind of account he wants to create. |
|  | 3. The Actor indicates that they want to register a new Sales Officer/Sales employee. |
|  | 4. The System offers an opportunity to enter personal information (name, password,  confirmed password, company mail address, chose one of the three positions). |
|  | 5. The Actor enters John Doe for name, 123Password for password, 123Password as confirmation,  john@abc.com for email and Sales Employee as position |
| Results: | System informs that the staff member has been successfully registered. |


| Name: | Actor registers existed sales officer/ sales employees  |
|----|----|
| Scenario: |1. The Actor indicates he wants to create a new account for a staff member. |
|  | 2. The System asks the actor what kind of account he wants to create. |
|  | 3. The Actor indicates that they want to register a new Sales Officer/Sales employee. |
|  | 4. The System offers an opportunity to enter personal information (name, password, confirmed password, company mail address, chose one of the three positions ). |
|  | 5. The Actor enters John Doe for name, 123Password for password, 123Password as confirmation,  john@abc.com for email and Sales Employee as position |
| Results: | System informs that the staff member exists in the database. |

| Name: | Actor registers sales officer/ sales employees with unaccepted password  |
|----|----|
| Scenario: |1. The Actor indicates he wants to create a new account for a staff member. |
|  | 2. The System asks the actor what kind of account he wants to create. |
|  | 3. The Actor indicates that they want to register a new Sales Officer/Sales employee. |
|  | 4. The System offers an opportunity to enter personal information (name, password,  confirmed password, company mail address, chose one of the three positions). |
|  | 5. The Actor enters John Doe for name, Password for password, Password again as confirmation, john@abc.com for email and Sales Officer as position |
| Results: | System informs that the password does not fulfill the requirement. |

## Register plane model

| Name: | Actor choses to create a plane model with missing information |
|----|----|
| Scenario:  | 1. The System displays the main sales manager dashboard. |
|| 2. The Actor selects the option to register a plane model. |
|| 3. The System asks the actor for information about the model (manufacturer, max. seats, max. range, weight capactiy, speed). |
|| 4. The Actor does not write down anything. |
|| 5. The System tells the actor that the registration has not been successfull since all fields need to be filled out. |
| Results: | Creation of the plane model unsuccessfull. |

| Name: | Actor choses to create a plan model (sucessfull) |
|----|----|
| Scenario:  | 1. The System displays the main sales manager dashboard. |
|| 2. The Actor selects the option to register a plane model. |
|| 3. The System asks the actor for information about the model (manufacturer, max. seats, max. range, weight capactiy, speed). |
|| 4. The Actor writes down "MAN" as manufacturer, "100" as max seats, "3000km" as max range, "10 kg" as max weight of luggage and "500km/h" as speed. |
|| 5. The System tells the actor that the registration has been successfull. |
| Results: | Plane model is now in  the system. |


| Name: | Actor choses to create a plane model which already exists |
|----|----|
| Scenario:  | 1. The System displays the main sales manager dashboard. |
|| 2. The Actor selects the option to register a plane model. |
|| 3. The System asks the actor for information about the model (manufacturer, max. seats, max. range, weight capactiy, speed). |
|| 4. The Actor writes down and selects the information. |
|| 5. The System tells the actor that the plane model already exists (same data exists for the specific manufacturer). |
| Results: | Creation of the plane model unsuccessfull. |



## Register plane

| Name: | Actor choses to create a plane with missing/ incorrect information |
|----|----|
| Scenario:  | 1. The System displays the main sales manager dashboard. |
|| 2. The Actor selects the option to register a plane. |
|| 3. The System allows the Actor to select a model, the number of seats and how many seats of which class there are. |
|| 4. The Actor  selects the model "Boeing-747" and does not write down the total number of seats and the number of seats for each class. |
|| 5. The System displays a message for a unsuccessful registration of a plane and informs the actor that information are missing. |

| Name: | Actor choses to create a plane (successfull) |
|----|----|
| Scenario:  | 1. The System displays the main sales manager dashboard. |
|| 2. The Actor selects the option to register a plane. |
|| 3. The System allows the Actor to select a model, the number of seats and how many seats of which class there are. |
|| 4. The Actor selects the model "Boeing-747", types in "200" as the maximum number of seats and indicates that there are 100 business class and 100 economy class seats . |
|| 5. The System displays a message for a successful registration of a plane. |
