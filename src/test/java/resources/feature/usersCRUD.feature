Feature: User Swagger application
  As a user I want to test User Application

  Scenario Outline: User CRUD test
    Given User application is running
    When I create new user by providing the information id "<id>" username "<username>" firstname "<firstname>" lastname "<lastname>" email "<email>" password "<password>" phone "<phone>" status "<userstatus>"
    Then I verify that the user is created with "<username>"
    And I update user with username "<username>"
    And I verify that user is updated
    And I delete user that created
    Then I verify user is deleted
    Examples:
      | id  | username | firstname | lastname | email           | password | phone      | userstatus |
      | 521 | test001  | pdd       | marko    | mar@example.com | prime123 | 4252524152 | 85         |
      | 585 | test005  | Kdd       | jocopo   | joc@example.com | prad123  | 5236251484 | 52         |