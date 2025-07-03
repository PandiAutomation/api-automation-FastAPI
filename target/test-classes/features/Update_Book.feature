Feature: Update the Book 

 Background: Login with valid input and get the accessToken
  Given I have the API endpoint "/login"
  And I have a signup request body with id "999", email "pandisvg02@gmail.com", and password "Tamil@kan081"
  When I send a "POST" request for access token
  Then I should receive status code 200
  Then I should get the accessToken from response
  
 @Regression @Positive @PUTBOOK @Smoke @Execute
 Scenario Outline: Update the book already created and validate the response
  Given I have the API endpoint "/books/"
  And I hvae add the path parameter in endpoint <id>
  And I have a update a book with id <id>, name "<name>", author "<author>", published_year <published_year> and book_summary "<book_summary>"
  When I send a "PUT" request
  Then I should receive status code 200
  Then I should validate the update reponse with feild values <id>,"<name>","<author>",<published_year>,"<book_summary>"
  Examples:
  | id  |  name        | author         | published_year | book_summary        |
  | 105 |  The Hobbit1 | J.R.R. Tolkien | 1945           | A fantasy adventure |
  
  @Regression @Negative @PUTBOOK @Execute  
 Scenario Outline: Try Update the book with non exists and validate the error message
  Given I have the API endpoint "/books/"
  And I hvae add the path parameter in endpoint <id>
  And I have a update a book with id <id>, name "<name>", author "<author>", published_year <published_year> and book_summary "<book_summary>"
  When I send a "PUT" request
  Then I should receive status code 404
  Then I should validate the error message "Book not found"
  Examples:
  | id  |  name        | author         | published_year | book_summary        |
  | 3000 |  The Hobbit1 | J.R.R. Tolkien | 1945           | A fantasy adventure |
  

    