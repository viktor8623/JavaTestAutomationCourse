Feature: Sending emails

  Scenario Outline: Sending email to a single recipient
    Given I am in Inbox folder
    When I send new email with "<receiver>", "<subject>", "<emailBody>"
    And Go to Sent folder
    Then The email with "<subject>" is in the first row

    Examples:
      | receiver              | subject           | emailBody         |
      | test@mailinator.com   | Message to friend | Just some text... |

  Scenario: Sending email to multiple receivers
    Given I am in Inbox folder
    Then I send new email from data base to multiple receivers

