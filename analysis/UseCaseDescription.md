# Use cases

## Cancelling in Use Cases:  not an extension or exception since the option is always there and no data will be inserted into the DB before the confirmation is given.

## Log in
| Name: | _Log in_ |
|----|----|
| Actor: | Staff Member |
| Description: | The Actor logs into the platform. |
| Pre-condition: | The Actor is already registered.  |
| Scenario: |1. The System displays a login page with fields for username and password. |
|  | 2. The Actor enters a username and password. |
|  | 3. The System allows access to platform. |
| Results: | The Actor gets access to platform. |
| Exceptions: | 3.a. The System informs the user that the combination of username/password is invalid. |
|  | 3.a.1. Return to step 1.  |

## Log out
| Name: | _Log out_ |
|----|----|
| Actor: | Staff Member |
| Description: | The Actor logs out of the platform. |
| Pre-condition: | The Actor has logged in. |
| Scenario: | 1. The Actor indicates they want to log out. |
|  | 2. The System asks for confirmation. |
|  | 3. The Actor confirms his logout request. |
|  | 4. The System displays a login page. |
| Results: | The Actor loses access to platform. |
| Exceptions: | 3.a. The actor decides to not log out. |
|  | 3.a.1. Actor denies the request  |
|  | 3.a.2. Actor keeps access. Use Case ends here.  |

## Register sales officer or sales employee
| Name: | _Register sales officer or sales employee_ |
|----|----|
| Actor: | Sales Manager | 
| Description: | A new Sales Officer/ Employee gets registered on the platform. |
| Pre-condition: | The Sales Manager has logged in. |
| Scenario: | 1. The Actor indicates he wants to create a new account for a staff member. |
| | 2. The System asks the actor what kind of account he wants to create. |
| | 3. The Actor indicates that they want to register a new Sales Officer. |
| | 4. The System offers an opportunity to enter personal information (name, password, company mail address). |
| | 5. The Actor enters personal information. |
| | 6. If the Account doesn't exist yet and the password is sufficient, the system inputs the personal information of the account into the database. |
| Results: | The Staff Member has been successfully registered. |
| Exceptions: | 6.a The Staff Member has already been registered. |
| | 6.a.1. The System informs the manager that the Staff Member already exists in the database. |
| | 6.a.2. Use case ends here. |
| | 6.b. Password is insufficient. |
| | 6.b.1. The System indicates that the password does not fulfill the requirements. |
| | 6.b.2. Return to step 3. |
| Extension: | 3.a. The Actor indicates that they want to register a new Sales Employee. |
| | 3.a.1. Go to step 4. |


## Register flight
| Name: | _Register upcoming flights_ |
|----|----|
| Actor: | Sales Officer |
| Description: | The Sales Officer registers an upcoming flight. |
| Pre-condition: | The Sales Officer has logged in. |
| Scenario: | 1. The Actor indicates that they want to register a new flight. |
| | 2. The system offers offers options for a flight (Arrival, Departure, Locations, Plane, Price). |
| | 3. The actor choses all flight information. |
| | 4. The actor confirms the changes.
| | 5. The system makes the flight available for booking. |
| Results: | The Actor has successfully registered a flight. |



## Update flight
| Name: | _Update  upcoming flights_ |
|----|----|
| Actor: | Sales Officer |
| Description: | The information regarding an upcoming flight need to be altered. |
| Pre-condition: | The Sales Officer has logged in and  a flight has been found. |
| Scenario: | 1. The system displays an option to update the flight. |
| | 2. The Actor selects to update the flight Information(Arrival, Departure, Locations, Plane, Price, Delete). |
| | 3. The System displays form with all flight information. |
| | 4. The Actor choses different options confirms all desired information. |
| | 5. The System shows a succes message. |
| Results: | The Actor has successfully updated the  flight. |
| Extensions: |  |


## Delete flight
| Name: | Delete  upcoming flights_ |
|----|----|
| Actor: | Sales Officer |
| Description: | The flight should be deleted . |
| Pre-condition: | The Sales Officer has logged in and  a flight has been found. |
| Scenario: | 1. The system displays options to delete the flight. |
| | 2. The Actor selects to delete the flight . |
| | 3. The System displays confirmation window |
| | 4. The Actor selects to delete the flight. |
| | 5. The System shows succes message. |
| Results: | The Actor has successfully deleted the  flight. |
| Extensions: |  |
| Exceptions: | 4.a. The Actor selects cancel. |
| | 4.a.1. The use case ends here. |

## Create booking
| **Name:** | _Create booking_ |
| --- | --- |
| Actor: | Sales Employee |
| Description: | A Sales Employee books a trip for a customer. |
| Pre-condition: | The Sales Employee is logged in. |
| Scenario: | 1. The Actor chooses to create a new booking for a customer. |
|| 2. The System requests destination and origin of the journey. |
|| 3. The Actor chooses destination and origin of the journey 
|| 4. The System displays available flights. |
|| 5. The Actor chooses a flight. |
|| 6. The System enables the Actor to create a ticket. |
|| 7. The Actor creates a ticket. |
|| 8. The System displays all tickets. |
|| 9. The Actor confirms booking. |
|| 10. The System shows a success message. |
| Extensions: | 9.a The Actor chooses to add another ticket |
| | 9.a.1 return to step 6. |
| Result: | The desired trip has been booked. |
| Exceptions: | 2. The System offers to add tickets of the flight to the booking. |
|| 6. If the Actor wants to add (more) tickets, they select a flight and decide to add tickets. |
|| 7. The System creates and lists all tickets matching the actor's request or the currently selected flight. |
|| 8. The Actor selects a ticket. |
|| 9. The System offers the option to add paid options (food, luggage, seats picked) as well as the opportunity to enter a name. |
|| 10. If the Actor wants to add options, they select the options desired by the customer. |
|| 11. The Actor enters the name that is to be on the ticket given by the customer. |
|| 12. The System displays an option to save ticket information. |
|| 13. When the Actor needs to save ticket information, they select that option.|
|| 14. The System adds the information to the booking. |
|| 15. The System shows booking information, a calculated price for the booking and displays the opportunity to proceed with processing the booking.|
|| 16. The Actor decides to proceed. | 
|| 17. The System asks for confirmation. |
|| 18. The Actor indicates that everything is fine and allows proceeding. |
|| 19. The System processes the booking request. |

## Edit Booking
| Name: | Edit  certain Booking |
|----|----|
| Actor: | Sales Officer |
| Description: | The information regarding a certain Booking will be edited. |
| Pre-condition: | The Sales Officer has logged in and  the Booking has been found. |
| Scenario: | 1. The system displays an option to edit the booking. |
| | 2. The Actor selects to edit the booking Information(Tickets,origin ,destination, Delete). |
| | 3. The System displays form with all booking information. |
| | 4. The Actor choses different options and confirms all desired information. |
| | 5. The System shows a succes message. |
| Results: | The Actor has successfully updated the  booking. |

## Look up a Booking
| Name: | _Look up upcoming flights_ |
|----|----|
| Actor: | Sales Manager |
| Description: | Sales Manager looks up a Booking. |
| Pre-condition: | Sales Manager is already logged in. |
| Scenario: | 2. The Actor selects the option to search for upcoming flights. |
|| 2. The System allows the user to input Booking details (origin, destination, CustomerID, BookingID, CustomerName). |
|| 4. The Actor searches for a specific Booking by delivering at least one of the mentioned booking details. |
|| 5. The System returns a list of matching Bookings. |
|| 6. The Actor selects the desired Booking. |
| Results: | The System delivers flight to booking. |
| Exceptions: | 5.a. No matching Booking is found. |
|| 5.a.1 The System indicates that this is the case and returns to step 4. |

## Create ticket (in a booking) extends "Create Booking"
| **Name:** | _Create ticket |
| --- | --- |
| Actor: | Sales Employee |
| Description: | A Sales Employee creates one ticket for a customer in a booking. |
| Pre-condition: | The Sales Employee is logged in and the Actor decided to add a ticket to a booking. |
| Scenario: | 1. The System displays the options for the ticket(Extra options, seat choice, passenger data like age, name). |
|| 2. The Actor enters information and saves the changes. |
|| 3. The System displays all information regarding the ticket, including the price. |
|| 4. The Actor confirms the ticket creation |
|| 5. The tickets displays a success message. |
| Extension: | 4.a. The Actor wants to change some of the information. |
|| 4.a.1 The Actor changes information in the ticket. |
|| 4.a.2 Return to step 3. |



## Create Price reduction
| Name: | _Enable temporary price reductions_ |
|----|----|
| Actor: | Sales Officer |
| Description: | The Sales Officer reduces the price of a flight. |
| Pre-condition: | Sales Officer has logged in and a flight has been found. |
| Scenario: | 1. The Actor indicates that they want to enable a price reduction. |
| | 3. The System gives Actor option to choose between a static and a dynamic price reduction. |
| | 4. The Actor indicates he wants to enable a dynamic discount. |
| | 6. The System offers an opportunity to select a measure the discount is calculated by (sun days at destination, duration of flight, ...). |
| | 7. The System enables the discount. |
| Results: | The Actor has successfully reduced price of a ticket / booking. |
| Extensions: | 6a. If the Actor wants to enable a static discount, the System offers an opportunity to chose discount percentage. |
| | 6.a.1. The Actor choses the discount percentage. |
| | 6.a.2. Return to step 7. |
| Exceptions: | If a selected flight already has a discount, the new discount will be enabled and the old one falls away. |


## Disable Price reduction
| Name: | Disable temporary price reductions_ |
|----|----|
| Actor: | Sales Officer |
| Description: | The Sales Officer disables the price reduction of a flight. |
| Pre-condition: | Sales Officer has logged in and a flight has been found. Furthermore, the flight has an active discount. |
| Scenario: | 1. The Actor indicates that they want to disable a price reduction. |
| | 2. The System asks Actor if he wants to disable the reduction.|
| | 4. The Actor confirms. |
| Results: | The Actor has successfully reduced price of a ticket / booking. |
| Extensions: | 4a. Actor decides to not disable the reduction. |
| | 4.a.1. Use Case ends here. |

## Look up upcoming flights
| Name: | _Look up upcoming flights_ |
|----|----|
| Actor: | Sales Employee |
| Description: | Sales Employee looks up an upcoming flight. |
| Pre-condition: | Sales Employee is already logged in. |
| Scenario: | 2. The Actor selects the option to search for upcoming flights. |
|| 2. The System allows the user to input flight details (Arrival airport, Departure airport, Departure date, Number of seats). |
|| 4. The Actor searches for a specific flight by delivering at least one of the mentioned flight details. |
|| 5. The System returns a list of matching flights. |
|| 6. The Actor selects the desired flight. |
| Results: | The System delivers flight to booking. |
| Exceptions: | 5.a. If no matching flight is found, the System indicates that this is the case and returns to step 4. |


## Check key performance indicators
| Name: | _Check key performance indicators_ |
|----|----|
| Actor: | Sales Manager |
| Description: | Sales Manager checks the key performance indicators. |
| Pre-condition: | Sales Manager is already logged in. |
| Scenario:  | 1. The System displays the main sales manager dashboard. |
|| 2. The Actor selects the option to check key performance indicators. |
|| 3. The System allows the Actor to select a specific route. |
|| 4. The Actor selects the route they want to examine. |
|| 5. The System displays the key performance indicators for that route. |
| Results: | The Sales Manager gained access to various statistics, such as total revenue numbers, numbers of tickets sold in each class, and statistics on all options sold for a specific route. |

## Register route
| Name: | _Register route_ |
|----|----|
| Actor: | Sales Manager |
| Description: | Sales Manager registers a route. |
| Pre-condition: | Sales Manager is already logged in. |
| Scenario:  | 1. The System displays the main sales manager dashboard. |
|| 2. The Actor selects the option to register a route. |
|| 3. The System allows the Actor to chose specific route details (destination, origin, length will be derived from airports) . |
|| 4. The Actor selects the route details. |
|| 5. The System saves the route. |
| Results: | The Sales Manager created a route. |
| Exceptions: | 5.a. The flight information are not valid. |
| | 5.a.1. The System informs the actor that the route is not valid. |
| | 5.a.2. Return to Step 3. |
| | 5.b. The flight already exists. |
| | 5.b.1. The system informs the actor that the route already exists. |
| | 5.b.1. Return to Step 3. |

## Register airport
| Name: | _Register airport_ |
|----|----|
| Actor: | Sales Manager |
| Description: | The Sales Manager registers new airport. |
| Pre-condition: | The Sales Manager has logged in. |
| Scenario: | 1. The Actor wants to register new airport. |
| | 2. The system asks the actor to provide information (airport name, abbreviation, city, and country). |
| | 3. The actor enters all the requested information. |
| | 4. The system adds new airport. |
| | 5. The system inform the actor that new airport has been added. |
| Results: | The Actor has successfully registered a new airport. |
| Exceptions: | 4.a Airport already exists. |
| | 4.a.1 System informs User that the airport already exists. |
| | 4.a.2 Use case ends here. |
| | 4.b field was left empty. |
| | 4.b.1 System informs user that field can't be empty. |
| | 4.b.2 Return to Step 2. |

