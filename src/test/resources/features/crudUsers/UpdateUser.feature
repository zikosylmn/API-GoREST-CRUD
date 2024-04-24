Feature: Update User


  Scenario Outline: Update user by id
    Given Update user "UpdateUser1.json" by <valid_id>
    When Send request update user
    Then Status code should be <statusCode>
    And Validate json schema "CreateUserSchema.json"
    Examples:
      | valid_id | statusCode |
      | 6872997  | 200        |


  Scenario Outline: Update User with Invalid Data
      Given Update user with invalid ID "<invalid_id>" and json is "<file_json>"
      When Send request update user with invalid ID
      Then Status code should be <statusCode>
      And Responses body message is "Resource not found"
      And Validate json schema "UpdateUserInvalidSchema.json"
      Examples:
        | invalid_id | file_json        | statusCode |
        | 1234567    | UpdateUser1.json | 404        |
        | abc1234    | UpdateUser1.json | 404        |


      Scenario Outline: Update User with Invalid Authorization
        Given Update valid user ID <valid_id> and JSON file "<json_file>"
        When Send request update valid user ID without valid authorization
        Then Status code should be <statusCode>
        Examples:
          | valid_id | json_file            | statusCode |
          | 6872996  | UpdateUserBlank.json | 200        |
          | 6872995    | UpdateUserBlank.json | 200        |


  Scenario Outline: Update user with blank name
          Given Update valid user ID <valid_id> and JSON file "<json_file>"
          When Send request update valid user ID with blank name
          Then Status code should be <statusCode>
          And Validate json schema "UpdateUserBlankSchema.json"
          Examples:
            | valid_id | json_file                | statusCode |
            | 6872996  | UpdateUserBlankName.json | 422        |
            | 6872995   | UpdateUserBlankName.json | 422        |


  Scenario Outline: Update user with blank email
    Given Update valid user ID <valid_id> and JSON file "<json_file>"
    When Send request update valid user ID with blank email
    Then Status code should be <statusCode>
    And Validate json schema "UpdateUserBlankSchema.json"
    Examples:
      | valid_id | json_file                 | statusCode |
      | 6872996  | UpdateUserBlankEmail.json | 422        |
      | 6872995  | UpdateUserBlankEmail.json | 422        |


  Scenario Outline: Update user with blank gender
    Given Update valid user ID <valid_id> and JSON file "<json_file>"
    When Send request update valid user ID with blank gender
    Then Status code should be <statusCode>
    And Validate json schema "UpdateUserBlankSchema.json"
    Examples:
      | valid_id | json_file                  | statusCode |
      | 6872996  | UpdateUserBlankGender.json | 422        |
      | 6872995   | UpdateUserBlankGender.json | 422        |


  Scenario Outline: Update user with blank status
    Given Update valid user ID <valid_id> and JSON file "<json_file>"
    When Send request update valid user ID with blank status
    Then Status code should be <statusCode>
    And Validate json schema "UpdateUserBlankSchema.json"
    Examples:
      | valid_id | json_file                  | statusCode |
      | 6872996  | UpdateUserBlankStatus.json | 422        |
      | 6872995   | UpdateUserBlankStatus.json | 422        |