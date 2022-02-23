# Use cases

## Log in
| Name: | _Log in_ |
|----|----|
| Actor: | Staff Member |
| Description: | The actor logs into the platform. |
| Pre-condition: | The actor is already registered.  |
| Scenario: |1. The system displays a login page. |
|  | 2. The system asks for username and password. |
|  | 3. The actor enters a username and password. |
|  | 4. The system validates username and password. |
|  | 5. The system allows access to platform. |
| Results: | The actor gets access to platform. |
| Exceptions: | 4.a. The system informs the user that the combination of username/password is invalid. |
|  | 4.a.1. Return to step 2.  |

## Log out
| Name: | _Log out_ |
|----|----|
| Actor: | Staff Member |
| Description: | The actor logs out of the platform. |
| Pre-condition: | The actor has logged in. |
| Scenario: | 1. The actor indicates they want to log out. |
|  | 2. The system displays a login page. |
| Results: | The actor loses access to platform. |
| Exceptions: | None |

## Register sales officer or sales employee
| Name: | _Register sales officer or sales employee_ |
|----|----|
| Actor: | Sales Manager | 
| Description: | A new Sales Officer/ Employee gets registered on the platform. |
| Pre-condition: | Sales Manager has logged in. |
| Scenario: | 1. The actor indicates he wants to create a new account for a staff member. |
| | 2. The system asks the actor what kind of account he wants to create. |
| | 3. The actor indicates that they want to register a new Sales Officer. |
| | 4. The system offers an opportunity to enter personal information (name, password, company mail address). |
| | 5. The actor enters personal information. |
| | 6. If the account doesn't exist yet and the password is sufficient, the system inputs the personal information of the account into the database. |
| Results: | Staff Member has been successfully registered. |
| Exceptions: | 6.a Staff Member has already been registered. |
| | 6.a.1. The system informs the manager that the Staff Member already exists in the database. |
| | 6.a.2. Use case ends here. |
| | 6.b. Password is insufficient. |
| | 6.b.1. The system indicates that the password does not fulfill the requirements. |
| | 6.b.2. Return to step 3. |
| Extension: | 3.a. The actor indicates that they want to register a new Sales Employee. |
| | 3.a.1. Go to step 4. |


## Register flight
| Name: | _Register upcoming flights_ |
|----|----|
| Actor: | Sales Officer |
| Description: | The Sales Officer registers an upcoming flight. |
| Pre-condition: | Sales Officer has logged in. |
| Scenario: | 1. The actor indicates that they want to register a new flight. |
| | 2. The system offers the opportunity to enter flight information(Arrival, Departure, Locations, Plane, Price). |
| | 3. The actor enters all flight information. |
| | 4. The system checks whether the flight information are valid. |
| | 5. The system puts the flight into a database and makes the flight available for booking. |
| Results: | The actor has successfully registered a flight. |
| Exceptions: | 4.a. Flight information are not valid and the system informs the actor that the flight is not valid. |
| | 4.a.1. Return to Step 3. |


## Update/ delete flight
| Name: | _Update or delete upcoming flights_ |
|----|----|
| Actor: | Sales Officer |
| Description: | The information regarding an upcoming flight need to be altered or the flight should be deleted for whatever reason. |
| Pre-condition: | Sales Officer has logged in and  a flight has been found. |
| Scenario: | 1. The actor indicates that they want to update a flight by pressing on a certain button. |
| | 2. The system offers opportunity to update flight information(Arrival, Departure, Locations, Plane, Price, Delete). |
| | 3. The actor enters all flight information. |
| | 4. The system checks whether the flight information are valid. |
| | 5. The system puts an updated flight into the database and makes the flight available for booking. |
| Results: | The actor has successfully updated the  flight. |
| Extensions: | 3a. If the Actor wants to delete a flight, he presses on the available button. |
| | 3.a.1. The system asks the actor if he is sure. |
| | 3.a.2. The actor confirms. Go back to step 5. |
| Exceptions: | 4.a. The flight information is not valid and the system informs the actor that the flight is not valid. |
| | 4.a.1. Return to Step 3. |

## Create booking
| **Name:** | _Create booking_ |
| --- | --- |
| Actor: | Sales Employee |
| Description: | A Sales Employee books a trip for a customer. |
| Pre-condition: | Sales Employee is logged in. |
| Scenario: | 1. The actor chooses to create a new booking for a customer. |
|| 2. System requests destination and origin of the journey. |
|| 3. Actor choose destination and origin of the journey 
|| 4. System displays aviable flights. |
|| 5. Actor choose a flight. |
|| 6. System displays input fields for personal information and extra options |
|| 7. Actor enters information of the customer and confirms. |
|| 8. System displays all information regarding the booking. |
|| 9. Actor confirms booking. |
|| 10. System creates booking. |
| Extensions: | 7.a Actor choose to add another ticket |
| | 7.a.1 return to step 6. |
| Result: | The desired trip has been booked. |
| Exceptions: | |
|||

|| 2. The system offers to add tickets of the flight to the booking. |
|| 6. If the Actor wants to add (more) tickets, they select a flight and decide to add tickets. |
|| 7. The system creates and lists all tickets matching the actor's request or the currently selected flight. |
|| 8. The actor selects a ticket. |
|| 9. The system offers the option to add paid options (food, luggage, seats picked) as well as the opportunity to enter a name. |
|| 10. If the Actor wants to add options, they select the options desired by the customer. |
|| 11. The Actor enters the name that is to be on the ticket given by the customer. |
|| 12. The system displays an option to save ticket information. |
|| 13. When the Actor needs to save ticket information, they select that option.|
|| 14. The system adds the information to the booking. |
|| 15. The system shows booking information, a calculated price for the booking and displays the opportunity to proceed with processing the booking.|
|| 16. The actor decides to proceed. | 
|| 17. The system asks for confirmation. |
|| 18. Actor indicates that everything is fine and allows proceeding. |
|| 19. The system processes the booking request. |

## Create Price reduction
| Name: | _Enable temporary price reductions_ |
|----|----|
| Actor: | Sales Officer |
| Description: | The Sales Officer reduces the price of a flight. |
| Pre-condition: | Sales Officer has logged in. |
| Scenario: | 1. The actor indicates that they want to enable a price reduction. |
| | 2. The system offers the opportunity to enable a discount. |
| | 3. The system gives Actor option to choose between a static and a dynamic price reduction. |
| | 4. The actor indicates what type of discount they want to enable. |
| | 5. The system offers an opportunity to pick the flights the discount should be applied to. |
| | 6. If the actor wants to enable a dynamic discount, the System offers an opportunity to select a measure the discount is calculated by. |
| | 7. The system enables the discount. |
| Results: | The actor has successfully reduced price of a ticket / booking. |
| Extensions: | 6a. If the Actor wants to enable a static discount, the System offers an opportunity to enter the discount percentage. |
| | 6.a.1. If the Actor has decided on a static discount, the Actor enters the discount amount. |
| | 6.a.2. Return to step 7. |
| Exceptions: | If a selected flight already has a discount, the System can not apply another discount. |


## Look up upcoming flights
| Name: | _Look up upcoming flights_ |
|----|----|
| Actor: | Sales Employee |
| Description: | Sales Employee looks up an upcoming flight. |
| Pre-condition: | Sales Employee is already logged in. |
| Scenario: | 1. The system displays the main Sales Employee dashboard. |
|| 2. The actor selects the option to search for a upcoming flights. |
|| 3. The system allows the user to input flight details (Arrival airport, Departure airport, Departure date, Number of seats). |
|| 4. The actor searches for a specific flight by delivering at least one of the mentioned flight details. |
|| 5. The system returns a list of matching flights. |
|| 6. The actor selects the desired flight. |
| Results: | The system delivers flight to booking. |
| Exceptions: | 5.a. If no matching flight is found, the system indicates that this is the case and returns to step 4. |


## Check key performance indicators
| Name: | _Check key performance indicators_ |
|----|----|
| Actor: | Sales Manager |
| Description: | Sales manager checks the key performance indicators. |
| Pre-condition: | Sales manager is already logged in. |
| Scenario:  | 1. The system displays the main sales manager dashboard. |
|| 2. The actor selects the option to check key performance indicators. |
|| 3. The system allows the Actor to select a specific route. |
|| 4. The actor selects the route they want to examine. |
|| 5. The system displays the key performance indicators for that route. |
| Results: | The sales manager gained access to various statistics, such as total revenue numbers, numbers of tickets sold in each class, and statistics on all options sold for a specific route. |

