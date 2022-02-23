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