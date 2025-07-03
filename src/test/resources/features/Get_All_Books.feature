Feature: Login For Access Token

 Background: Login with valid input and get the accessToken
  Given I have the API endpoint "/login"
  And I have a signup request body with id "999", email "pandisvg02@gmail.com", and password "Tamil@kan081"
  When I send a "POST" request for access token
  Then I should receive status code 200
  Then I should get the accessToken from response
  
 @Regression @Positive @GETBOOK @Smoke @Execute
 Scenario: Get all the books and validate 
  Given I have the API endpoint "/books"
  When I send a "GET" request
  Then I should receive status code 200
  
  
  

    