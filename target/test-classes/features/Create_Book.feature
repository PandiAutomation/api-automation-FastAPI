Feature: Create the Book

 Background: Login with valid input and get the accessToken
  Given I have the API endpoint "/login"
  And I have a signup request body with id "999", email "pandisvg02@gmail.com", and password "Tamil@kan081"
  When I send a "POST" request for access token
  Then I should receive status code 200
  Then I should get the accessToken from response
  
 @Regression @Positive @POSTBOOK @Smoke @Execute
 Scenario Outline: Create a book and validate the response 
  Given I have the API endpoint "/books/"
  And I have a create a book with id <id>, name "<name>", author "<author>", published_year <published_year> and book_summary "<book_summary>"
  When I send a "POST" request
  Then I should receive status code 200
  Then I should validate the create reponse with feild values <id>,"<name>","<author>",<published_year>,"<book_summary>"
  Examples:
  | id  |  name       | author         | published_year | book_summary        |
  #| 102 | To Kill a Mockingbird   | Harper Lee             | 1960           | A novel on racial injustice                       |
  #| 103 | King                    | George Orwell          | 1949           | A dystopian future under totalitarian rule        |
  #| 104 | Pride and Prejudice      | Jane Austen            | 1813           | A classic romantic novel                          |
  #| 105 | The Great Gatsby         | F. Scott Fitzgerald    | 1925           | A story of wealth, love, and tragedy              |
  #| 106 | Moby-Dick               | Herman Melville        | 1851           | The quest for a giant white whale                 |
  #| 107 | War and Peace            | Leo Tolstoy            | 1869           | A novel about the Napoleonic Wars                 |
  | 108 | The Catcher in the Rye   | J.D. Salinger          | 1951           | A teenagers experiences in New York City         |
  #| 109 | The Alchemist            | Paulo Coelho           | 1988           | A shepherds journey to find treasure             |
  #| 110 | The Lord of the Rings    | J.R.R. Tolkien         | 1954           | Epic fantasy adventure in Middle-earth            |  
   
  

@Regression @Negative @POSTBOOK @Execute
 Scenario Outline: Try to create a duplicate book
  Given I have the API endpoint "/books/"
  And I have a create a book with id <id>, name "<name>", author "<author>", published_year <published_year> and book_summary "<book_summary>"
  When I send a "POST" request
  Then I should receive status code 500
  Examples:
  | id  |  name       | author         | published_year | book_summary        |
  | 102 | To Kill a Mockingbird   | Harper Lee             | 1960           | A novel on racial injustice                       |
    