Feature: login

  Scenario: login details
    Given user open browser
    When user enter url
    And enter email and password
    And login
    Then verify
    And close

  