Feature: Testing user features on swagger application
  As a user I would like to verify individual endpoint of the user application

  Scenario: I created a new user and verify if the user is added on the application
    When I create new user by providing the information id "15" username "praidp123" firstname "pradip" lastname "kakadiya" email "pradip143@gmail.com" password "pradip12345" phone "07856325154" status "15"
    Then I verify that the user is created with status 200

  Scenario: I get a new user was added successfully
    When I get a new added user with username "praidp123"
    Then I verify that the user is created with status 200

  Scenario: I update the new created user from the application
    When I update user with username "praidp123"
    Then I verify that user is updated

  Scenario: I delete created user from the application
    When I delete user that created
    Then I verify user is deleted