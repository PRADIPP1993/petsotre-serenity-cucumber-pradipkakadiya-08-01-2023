Feature: Testing pets features on swagger application
  As a pets I would like to verify individual endpoint of the pets application

  Scenario: I created a new pets and verify if the pets is added on the application
    When I Create NewPet By Providing The Information Category Name Photo Urls Tags Statuse
    Then I verify that the pets is created with status 200 codee

  Scenario: I get a new pets was added successfully
    When I GetA New Pet With Pet Ide
    Then I Verify That The Pet Is Createde

  Scenario: I update the new created pets from the application
    When I Update Pet With Statuse
    Then I verify that pets is updatede

  Scenario: I delete created pets from the application
    When I delete pets that createde
    Then I verify pets is deletede