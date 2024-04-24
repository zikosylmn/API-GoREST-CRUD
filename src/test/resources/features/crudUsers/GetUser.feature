Feature: Get User


  Scenario Outline: Get user data by id
    Given Get user data by <id>
    When Send request get user
    Then Status code should be <statusCode>
    And Validate json schema "CreateUserSchema.json"
    Examples:
      | id     | statusCode |
      | 6872998 | 200        |


  Scenario: Get all user data
      Given Get all user data
      When Send request get all user
      Then Status code should be 200


    Scenario Outline: Get user data invalid id
      Given Get user data invalid <id>
      When Send request get user
      Then Status code should be <statusCode>
      And Responses body message is "Resource not found"
      And Validate json schema "GetUserInvalidSchema.json"
      Examples:
        | id      | statusCode |
        | 1234567 | 404        |
        | 123abcd | 404        |

