Feature: Creating email letters.

  Background:
    Given User with 'username' and 'password' is logged in
    And User cleans mailbox



  Scenario: Write yourself letter
    When User selects 'Написать себе' option from dropdown menu
    And User writes 'Hello Sergey' message in form
    And User clicks send message button and and wait for invisibility modal window 'Письмо отправлено'
    Then User validates count '1' of received messages on top menu bar
    And User validates count '1' of received messages on 'Письма себе' tab

