Feature: Delete User


  Scenario Outline: Delete user valid data by id
    Given Delete user valid data by <id>
    When Send request delete user by id valid data
    Then Status code should be <statusCode>
    Examples:
      | id      | statusCode |
      | 6872992 | 204        |


  Scenario Outline: Delete user valid data by invalid id
      Given Delete user valid data by invalid ID <id>
      When Send request delete user by invalid data ID
      Then Status code should be <statusCode>
      Examples:
        | id      | statusCode |
        | 1234567 | 404        |