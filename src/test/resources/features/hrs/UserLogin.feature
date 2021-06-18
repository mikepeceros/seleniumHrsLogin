@UserLogin

  Feature: User Login
    
    Scenario: Invalid Creds
    Given The user goes to the loginPage
      When The user inputs the username "user1" and the password "test"
      And The user clicks on the Submit button to login
      Then The Web page displays the error message "Username and/or password invalid"

    Scenario: Submit button disabled by default
      Given The user goes to the loginPage
      Then The Submit button must be disabled

    Scenario Outline: Submit button enabled once a field is filled
      Given The user goes to the loginPage
      When The user inputs the value "random" in the field "<Control>"
      Then The Submit button must be enabled
      Examples:
        | Control     |
        | userName    |
        | password    |

    Scenario Outline: Submit button disabled once a field is filled
      Given The user goes to the loginPage
      When The user inputs the value "random" in the field "<Control>"
      And The user clears the field "<Control>"
      Then The Submit button must be disabled
      Examples:
        | Control     |
        | userName    |
        | password    |

    Scenario: Empty username to reset password
      Given The user goes to the loginPage
      When The user clicks on the ForgotLink
      And The user clicks on the Submit button to reset password
      Then The Web page displays the error message "Failed to submit reset password request."

    Scenario: Reset password - successful
      Given The user goes to the loginPage
      When The user clicks on the ForgotLink
      And The user inputs the value "test" in the username
      And The user clicks on the Submit button to reset password
      Then The Web page displays the error message "Reset password request successfully submitted."