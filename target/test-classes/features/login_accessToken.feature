Feature: Login For Access Token

@Execute
 Scenario Outline: Login with valid input and get the accessToken
  Given I have the API endpoint "/login"
  And I have a signup request body with id "<id>", email "<email>", and password "<password>"
  When I send a "POST" request
  Then I should receive status code <status>
  Then I should get the accessToken from response

    Examples:
      | id  | email                   | password       | status | 
      | 999 | pandisvg02@gmail.com    | Tamil@kan081   | 200    | 