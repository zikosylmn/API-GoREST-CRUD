Feature: Create User


  Scenario: Create user with valid data
    Given Create user with json "CreateUser.json"
    When Send request post create user
    Then Status code should be 201
    And Validate json schema "CreateUserSchema.json"


  Scenario: Create user with blank name
    Given Create user with blank name "CreateUserBlankName.json"
    When Send request post create user
    Then Status code should be 422
    And Responses body field is "name" and message was "can't be blank"
    And Validate json schema "CreateUserInvalidSchema.json"


  Scenario: Create user with blank email
    Given Create user with blank email "CreateUserBlankEmail.json"
    When Send request post create user
    Then Status code should be 422
    And Responses body field is "email" and message was "can't be blank"
    And Validate json schema "CreateUserInvalidSchema.json"


  Scenario: Create user with blank gender
    Given Create user with blank gender "CreateUserBlankGender.json"
    When Send request post create user
    Then Status code should be 422
    And Responses body field is "gender" and message was "can't be blank, can be male of female"
    And Validate json schema "CreateUserInvalidSchema.json"


  Scenario: Create user with blank status
    Given Create user with blank status "CreateUserBlankStatus.json"
    When Send request post create user
    Then Status code should be 422
    And Responses body field is "status" and message was "can't be blank"
    And Validate json schema "CreateUserInvalidSchema.json"


    Scenario: Create user with duplicate name data
      Given Create user with same name "CreateUserDuplicateName.json"
      When Send request post create user
      Then Status code should be 201
      And Validate json schema "CreateUserSchema.json"


  Scenario: Create user with duplicate email data
    Given Create user with same email "CreateUserDuplicateEmail.json"
    When Send request post create user
    Then Status code should be 422
    And Responses body field is "email" and message was "has already been taken"
    And Validate json schema "CreateUserInvalidSchema.json"