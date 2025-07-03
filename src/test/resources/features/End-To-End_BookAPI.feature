Feature: End to End flow to create, update, get and delete

 Background: Login with valid input and get the accessToken
  Given I have the API endpoint "/login"
  And I have a signup request body with id "999", email "pandisvg02@gmail.com", and password "Tamil@kan081"
  When I send a "POST" request for access token
  Then I should receive status code 200
  Then I should get the accessToken from response
  
 @Regression @Positive @POSTBOOK @Execute
 Scenario Outline: End to End scenario - Create the book -> get the book details -> update the same book -
 > Again get the book details -> Delete the same book -> and try to get the book
  Given I have the API endpoint "/books/"
  And I have a create a book with id <id>, name "<name>", author "<author>", published_year <published_year> and book_summary "<book_summary>"
  When I send a "POST" request
  Then I should receive status code 200
  Then I should validate the create reponse with feild values <id>,"<name>","<author>",<published_year>,"<book_summary>"
  Given I have the API endpoint "/books/"
  And I hvae add the path parameter in endpoint <id>
  When I send a "GET" request
  Then I should receive status code 200
  Then I should check the get book response with feild value <id>
  Given I have the API endpoint "/books/"
  And I hvae add the path parameter in endpoint <id>
  And I have a update a book with id <id>, name "<UpdateName>", author "<author>", published_year <published_year> and book_summary "<book_summary>"
  When I send a "PUT" request
  Then I should receive status code 200
  Then I should validate the update reponse with feild values <id>,"<UpdateName>","<author>",<published_year>,"<book_summary>"
  Given I have the API endpoint "/books/"
  And I hvae add the path parameter in endpoint <id>
  When I send a "GET" request
  Then I should receive status code 200
  Then I should check the get book response with feild value <id>
  Given I have the API endpoint "/books/"
  And I hvae add the path parameter in endpoint <id>
  When I send a "DELETE" request
  Then I should receive status code 200
  Then I should validate the successfully deleted response message "Book deleted successfully"
  Given I have the API endpoint "/books/"
  And I hvae add the path parameter in endpoint <id>
  When I send a "GET" request
  Then I should receive status code 404
  Then I should validate the error message "Book not found"
  Examples:
  | id  |  name       | UpdateName |author         | published_year | book_summary        |
  #| 106 | Moby-Dick               | Vairamuthu |Herman Melville        | 1851           | The quest for a giant white whale                 |
  | 107 | War and Peace            | Vairamuthu | Leo Tolstoy            | 1869           | A novel about the Napoleonic Wars                 |
  #| 108 | The Catcher in the Rye   | Vairamuthu | J.D. Salinger          | 1951           | A teenagers experiences in New York City         |