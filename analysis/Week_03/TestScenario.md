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

| Name: | Actor logs out |
|----|----|
| Scenario: |1. Actor chooses to log out. |
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
