# Use cases

## Log in
| Name: | _Log in_ |
|----|----|
| Actor: | Staff Member |
| Description: | The Actor logs into the platform |
| Pre-condition: | Actor has registered |
| Scenario: |1. System displays log in page |
|  | 2. System asks for username and password |
|  | 3. Actor enters username and password |
|  | 4. System validates username and password |
|  | 5. System allows access to platform |
| Results: | Actor gets access to platform |
| Exceptions: | 4. System informs the user that the combination of username/password is invalid |
|  | 4.1 Return to step 2.  |

## Log out
| Name: | _Log out_ |
|----|----|
| Actor: | Staff Member |
| Description: | The Actor logs out of the platform |
| Pre-condition: | Actor has logged in |
| Scenario: | 1. Actor indicates they wants to log out |
|  | 2. System displays log in page |
| Results: | Actor loses access to platform |
| Exceptions: | None |

## Register sales officer or sales employee
| Name: | _Register sales officer or sales employee_ |
|----|----|
| Actor: | Sales Manager | 
| Description: | A new Sales Officer/ Employee gets registered on the platform |
| Pre-condition: | Sales Manager has logged in |
| Scenario: | 1. Actor indicates he wants to create a new account for a staff member |
| | 2. System asks actor what kind of account he wants to create
| | 3. Actor indicates that they want to register a new Sales Officer |
| | 4. System offers opportunity to enter personal information (name, password, company mail address)  |
| | 5. Actor enters personal information |
| | 6. If the account doesn't exist yet and the password is sufficient, the system inputs the personal information of the account into the database.  Use Case ends here.|
| Results: | Sales Officer has been successfully registered |
| Exceptions: | 6.a Sales Officer has already been registered |
| | 6.a.1 System informs the manager that the officer already exists in the database |
| | 6.a.2 Use case ends here |
| | 6.b Password is insufficient |
| | 6.b.1 System indicates that the passwort does not fullfill the requirements |
| | 6.b.2 Return to step 3|
| Extension: 3.a Actor indicates that they want to register a new Sales Employee  |
| | 3.a.1 Go to step 4 |


## Register flight
| Name: | _Register upcoming flights_ |
|----|----|
| Actor: | Sales Officer |
| Description: | The Sales Officer registers an upcoming flight |
| Pre-condition: | Sales Officer has logged in |
| Scenario: | 1. Actor indicates that they want to register a new flight |
| | 2. System offers opportunity to enter flight information(Arrival, Departure, Locations, Plane, Price?) |
| | 3. Actor enters all flight information |
| | 4. System checks whether the flight information is valid |
| | 5. System puts flight into database and makes flight available for booking |
| Results: | Actor has successfully registered a flight |
| Exceptions: | 4. Flight information is not valid and system informs the user that the flight is not valid |
| | 4.1 Return to Step 3 |



## Price reduction
| Name: | _Enable temporary price reductions_ |
|----|----|
| Actor: | Sales Officer |
| Description: | The Sales Officer reduces the price of a booking / ticket |
| Pre-condition: | Sales Officer has logged in |
| | 1. Actor indicates that they want to enable a price reduction |
| | 2. System offers opportunity to enable a discount |
| | 3. System gives Actor option to choose between a static and a dynamic price reduction |
| | 4. Actor indicates what type discount they want to enable |
| Scenario: | 5. System offers an opportunity to choose the flights the discount should be applied to |
| | 6. If Actor wants to enable a dynamic discount the System offers an opportunity to choose a messure the discount is calculated by |
| | 7. System enables the discount |
| Results: | Actor has successfully reduced price of a ticket / booking |
| Extensions: | 6a. If Actor wants to enable a static discount the System offers an opportunity to enter the discount percentage |
| | > 1. If Actor has chosen a static discount the Actor enters the discount amount |
| | > 2. return to step 7 |
| Exceptions: | If a selected flight already has a discount, the System can not apply another discount |


## Look up upcoming flights
| Name: | _Look up upcoming flights_ |
|----|----|
| Actor: | Sales Officer |
| Description: | Sales officer looks up an upcoming flight |
| Pre-condition: | Sales officer is already logged in |
| Scenario: | 1. System displays the main sales officer dashboard |
|| 2. Actor selects the option to search for a specific flight |
|| 3. System allows the user to input flight details (Arrival airport, Departure airport, Departure date, Number of seats) |
|| 4. Actor searches for a specific flight by delivering at least one of the mentioned flight details |
|| 5. System returns a list of matching flights |
|| 6. Actor selects the desired flight |
| Results: | System delivers flight to booking |
| Exceptions: | 5. If no matching flight is found, the system indicates that this is the case and returns to step 4 |

## Check key performance indicators
| Name: | _Check key performance indicators_ |
|----|----|
| Actor: | Sales Manager |
| Description: | Sales manager checks the key performance indicators |
| Pre-condition: | Sales manager is already logged in |
| Scenario:  | 1. System displays the main sales manager dashboard |
|| 2. Actor selects the option to check key performance indicators |
|| 3. System allows the Actor to select a specific route |
|| 4. Actor selects the route they want to examine |
|| 5. System displays the key performance indicators for that route |
| Results: | The sales manager gained access to various statistics, such as total revenue numbers, numbers of tickets sold in each class, and statistics on all options sold for a specific route |
