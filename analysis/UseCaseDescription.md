# Use cases

## Cancelling in Use Cases:  not an extension or exception since the option is always there and no data will be inserted into the DB before the confirmation is given.

## General Use Cases
### Log in
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

### Log out
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

## Managing Use Cases (Only Sales Manager can execute these.)

### Check key performance indicators
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

### Register route
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

### Register airport
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
| | 4.b Field was left empty. |
| | 4.b.1 System informs user that field can't be empty. |
| | 4.b.2 Return to Step 2. |

### Register sales officer or sales employee
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

### Register plane model
| Name: | _Register plane model_ |
|----|----|
| Actor: | Sales Manager |
| Description: | Sales Manager registers a plane model . |
| Pre-condition: | Sales Manager is already logged in. |
| Scenario:  | 1. The System displays the main sales manager dashboard. |
|| 2. The Actor selects the option to register a plane model. |
|| 3. The System asks the actor for information about the model (manufacturer, model number(?), max. seats, max. range, weight capactiy, speed). |
|| 4. The Actor writes down and selects the information. |
|| 5. The System tells the actor that the registration has been successfull. |
| Results: | A plane model has been added to the system. |
| Exceptions: | 5.a. Incorrect or missing information. |
| | 5.a.1. System indicates which information are missing or need to be altered. |
| | 5.a.2. Return to step 3. |
| Exceptions: | 5.b. The exact same information can be found within the already existing system. |
| | 5.b.1. Actor gets informed that this plane model already exists. |
| | 5.b.2. Return to step 3. |

### Register plane
| Name: | _Register plane_ |
|----|----|
| Actor: | Sales Manager |
| Description: | Sales Manager registers a specific plane . |
| Pre-condition: | Sales Manager is already logged in. |
| Scenario:  | 1. The System displays the main sales manager dashboard. |
|| 2. The Actor selects the option to register a plane. |
|| 3. The System allows the Actor to select a model (and type in the plane number?). |
|| 4. The Actor selects the model and types in the number. |
|| 5. The System displays a message for a successful registration of a plane. |
| Results: | A plane has been added to the system. |
| Exceptions: | 5.a. No plane model has been selected. |
| | 5.a.1. System indicates that a plane model has to be selected. |
| | 5.a.2. Return to step 3. |


## Operational Use Cases

### Register flight
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

### Update flight
| Name: | _Update upcoming flights_ |
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

### Delete flight
| Name: | _Delete upcoming flights_ |
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

### Create Price reduction
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

### Disable Price reduction
| Name: | _Disable temporary price reductions_ |
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

## Business Use Cases

### Look up upcoming flights
| Name: | _Look up upcoming flights_ |
|----|----|
| Actor: | Sales Officer, Sales Employee |
| Description: | Sales Employee looks up an upcoming flight. |
| Pre-condition: | Sales Employee is already logged in. |
| Scenario: | 1. The Actor selects the option to search for upcoming flights. |
|| 2. The System allows the user to chose flight details (Arrival airport, Departure airport, Departure date, Number of seats). |
|| 3. The Actor searches for a specific flight by using the offered flight details (if no details are given, all flights are displayed) |
|| 4. The System returns a list of matching flights. |
|| 5. The Actor selects the desired flight. |
| Results: | The System delivers flight to booking. |
| Exceptions: | 4.a. No matching flight was found. |
| | 4.a.1 The System indicates that this is the case and returns to step 2. |

### Look up a Booking
| Name: | _Look up a Booking_ |
|----|----|
| Actor: | Sales Employee |
| Description: | Sales Employee looks up a Booking. |
| Pre-condition: | Sales Employee is already logged in. |
| Scenario: | 1. The Actor selects the option to search for bookings. |
|| 2. The System allows the user to input Booking details (origin, destination, CustomerID, BookingID, CustomerName). |
|| 3. The Actor searches for a specific Booking by delivering at least one of the mentioned booking details. |
|| 4. The System returns a list of matching Bookings. |
|| 5. The Actor selects the desired Booking. |
| Results: | The System delivers flight to booking. |
| Exceptions: | 4.a. No matching Booking is found. |
|| 4.a.1 The System indicates that this is the case and returns to step 2. |

### Create booking
| **Name:** | _Create booking_ |
| --- | --- |
| Actor: | Sales Employee |
| Description: | A Sales Employee books a trip for a customer. |
| Pre-condition: | The Sales Employee is logged in. |
| Scenario: | 1. The System enables the Actor to create a ticket. |
|| 2. The Actor [creates a ticket](#Create-ticket). |
|| 3. The System displays all tickets and a total price. |
|| 4. The Actor confirms booking. |
|| 5. The System shows a success message. |
| Extensions: | 4.a The Actor chooses to add another ticket |
| | 4.a.1 return to step 1. |
| Result: | The desired trip has been booked. |
| Exceptions: | 1.a The flight has no empty seats left (Can only happen after 1st ticket was created). |
|| 1.a.1 System informs Actor that no seats are left. |
|| 1.a.2 Return to step 3. |




### Edit Booking
| Name: | _Edit certain Booking_ |
|----|----|
| Actor: | Sales Employee |
| Description: | The information regarding a certain Booking will be edited. |
| Pre-condition: | The Sales Employee has logged in and  the Booking has been found. |
| Scenario: | 1. The system displays an option to edit the booking. |
| | 2. The Actor selects to edit the booking Information(Tickets,origin ,destination, Delete). |
| | 3. The System displays form with all booking information. |
| | 4. The Actor choses different options and confirms all desired information. |
| | 5. The System shows a succes message. |
| Results: | The Actor has successfully updated the  booking. |


### Create ticket
| Name: | _Create ticket (extends "Create booking")_ |
| --- | --- |
| Actor: | Sales Employee |
| Description: | A Sales Employee creates one ticket for a customer in a booking. |
| Pre-condition: | The Sales Employee is logged in and the Actor decided to add a ticket to a booking. |
| Scenario: | 1. The System displays the options for the ticket(Extra options, seat choice, passenger data like age, name). |
|| 2. The Actor enters information and saves the changes. |
|| 3. The System displays all information regarding the ticket, including the price. |
|| 4. The Actor confirms the ticket creation |
|| 5. The system displays a success message and goes back to step 6 of [create booking](#create-booking). |
| Results: | The Actor has successfully created a ticket. |
| Extension: | 4.a. The Actor wants to change some of the information. |
|| 4.a.1 The Actor changes information in the ticket. |
|| 4.a.2 Return to step 3. |







