Feature: Сhanging of user information

  Scenario: Сreating a user, updating a field, making sure that the user updated
    Given creating a user
    Given user navigates to created user
    When user fills id input
    And fill up name input
    And fill up user name input
    And fill up email input
    And fill up address input
    And fill up phone input
    And save changes
    Then the user is updated

