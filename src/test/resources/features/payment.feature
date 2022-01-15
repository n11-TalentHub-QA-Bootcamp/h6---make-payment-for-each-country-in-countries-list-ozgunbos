#make a payment to three different client
# client countries CN, USA, JPN
# client amounts 10, 20, 30
# for each payment user's balance should be checked.

# scenario
# make payment for each country in countries list
#logout test
Feature: make a payment to three different client
#@step1
#Scenario:make a payment to three different client
#When User login with user valid credentails
#And  User make a deposit entering payment details
#Then  User should check to balance

  @step1
  Scenario Outline: make a payment
    When  user login
    And   user make deposit via "<mobilPhone>" "<firstname>" "<amount>" "<user>"
    Then user should check if it is ok or not
    And user will logout from the app
    Examples:

      | mobilPhone  | firstname           | amount  | user          |
      | 1234        | dummyName           | 10      | China         |
      | 1235        | dummyName           | 20      | USA           |
      | 1236        | dummyName           | 30      | India         |
      | 1237        | dummyName           | 5       | Iceland       |
      | 1238        | dummyName           | 10      | Greenland     |
      | 1239        | dummyName           | 2       | Switzerland   |
      | 1240        | dummyName           | 7       | Norway        |
      | 1241        | dummyName           | 10      | New Zealand   |
      | 1242        | dummyName           | 5       | Greece        |
      | 1243        | dummyName           | 2       | Italy         |
      | 1244        | dummyName           | 3       | Ireland       |
      | 1245        | dummyName           | 1       | Japan         |
      | 1246        | dummyName           | 7       | France        |
      | 1247        | dummyName           | 9       | Russia        |
      | 1248        | dummyName           | 10      | Australlia    |
      | 1249        | dummyName           | 3       | Canada        |






