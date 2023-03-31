Feature: Address Service Tests
  Scenario: Valid Address Request
  Given a valid CEP "12345-678"
  When the Address Request is executed
  Then the Address Response should contain the expected information
  And the Shipping value should be calculated correctly

  Scenario: Invalid CEP Format
  Given an invalid CEP "1234A-567"
  When the Address Request is executed
  Then an InvalidCepException should be thrown

  Scenario: Address not found
  Given a valid CEP "00000-000"
  When the Address Request is executed
  Then a NotFoundException should be thrown

  Scenario: Unknown Error
  Given an Address Request with an unknown error
  When the Address Request is executed
  Then an UnknownException should be thrown