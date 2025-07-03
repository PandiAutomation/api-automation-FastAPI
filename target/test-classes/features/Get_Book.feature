Feature: Get a Book using book id

 Background: Login with valid input and get the accessToken
  Given I have the API endpoint "/login"
  And I have a signup request body with id "999", email "pandisvg02@gmail.com", and password "Tamil@kan081"
  When I send a "POST" request for access token
  Then I should receive status code 200
  Then I should get the accessToken from response
  
 @Regression @Positive @POSTBOOK @Smoke  @Execute
 Scenario Outline: Get a book using book id and validate the response
  Given I have the API endpoint "/books/"
  And I hvae add the path parameter in endpoint <id>
  When I send a "GET" request
  Then I should receive status code 200
  Then I should check the get book response with feild value <id>
  Examples:
  | id  | 
  | 105 |
  
  
  @Regression @Negative @POSTBOOK @Execute
 Scenario: Try to get the book with non exists id and validate the error response
  Given I have the API endpoint "/books/"
  And I hvae add the path parameter in endpoint 3000
  When I send a "GET" request
  Then I should receive status code 404
  Then I should validate the error message "Book not found"

  
  
  
    