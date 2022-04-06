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
