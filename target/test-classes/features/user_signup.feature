Feature: User Signup API

 Scenario Outline: Create a new user via signup API
  Given I have the API endpoint "/signup"
  And I have a signup request body with id "<id>", email "<email>", and password "<password>"
  When I send a "POST" request
  Then I should receive status code <status>
  And the response message should be "<message>"

    Examples:
      | id  | email                  | password    | status | message                    |
      | 981 | testing@gmail.com    | test@T001   | 200    | User created successfully  |