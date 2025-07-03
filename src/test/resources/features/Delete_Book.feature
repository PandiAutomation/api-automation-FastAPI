Feature: Delete the book

 Background: Login with valid input and get the accessToken
  Given I have the API endpoint "/login"
  And I have a signup request body with id "999", email "pandisvg02@gmail.com", and password "Tamil@kan081"
  When I send a "POST" request for access token
  Then I should receive status code 200
  Then I should get the accessToken from response
  
 @Regression @Positive @DELETEBOOK @Smoke @Execute
 Scenario: Delete the book already created and validate the response
  Given I have the API endpoint "/books/"
  And I hvae add the path parameter in endpoint 1
  When I send a "DELETE" request
  Then I should receive status code 200
  Then I should validate the successfully deleted response message "Book deleted successfully"
  
  @Regression @Negative @DELETEBOOK @Execute
 Scenario: Try to delte the book is not exists and validate the error message
  Given I have the API endpoint "/books/"
  And I hvae add the path parameter in endpoint 300
  When I send a "DELETE" request
  Then I should receive status code 404
  Then I should validate the error message "Book not found"
  
  

    