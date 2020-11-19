Feature: To verify DataBase Testing

  Background: Given User establish connection with the database

  @Database
  Scenario: I want to test the database connection
    When Perform and execute the query
    Then validate the Result set
