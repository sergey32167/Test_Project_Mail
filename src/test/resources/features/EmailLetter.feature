Feature: Creating email letters.

  Background:
    Given User with 'username' and 'password' is logged in
    And User cleans mailbox

  Scenario: Validate success modal window when message is send
    When User selects 'Написать себе' option from dropdown menu
    And User writes 'Hello Sergey' message in form
    And User clicks send message button
    Then User validates success message 'Письмо отправлено'

  Scenario: Validate received count messages icon
    When User selects 'Написать себе' option from dropdown menu
    And User writes 'Hello Sergey' message in form
    And User clicks send message button and wait for invisibility modal window 'Письмо отправлено'
    Then User validates count '1' of received messages on top menu bar
    And User validates count '1' of received messages on 'Письма себе' tab


  Scenario: Validate from whom received message on 'Входящие'
    When User clicks 'Входящие' button
    And User selects 'Написать себе' option from dropdown menu
    And User writes 'Hello Sergey' message in form
    And User clicks send message button and wait for invisibility modal window 'Письмо отправлено'
    And User expands 'ПИСЬМА СЕБЕ' row
    Then User validates received row message from 'Сергей Сергкй'


  Scenario: Validate that after deleting the letter appears in the 'Корзина'
    When User clicks 'Входящие' button
    And User selects 'Написать себе' option from dropdown menu
    And User writes 'Hello Sergey' message in form
    And User clicks send message button and wait for invisibility modal window 'Письмо отправлено'
    And User cleans mailbox
    And User clicks basket button
    Then User validates received row message from 'Сергей Сергкй'
@Run
  Scenario: Validate that the message text is expected
    When User clicks 'Входящие' button
    And User selects 'Написать себе' option from dropdown menu
    And User writes 'Hello Sergey' message in form
    And User writes 'Hello' massage in theme
    And User clicks send message button and wait for invisibility modal window 'Письмо отправлено'
    And User expands 'ПИСЬМА СЕБЕ' row
    And User clicks on message 'Сергей Сергкй'
    Then User validates received message with expected text 'Hello Sergey' and theme 'Hello'