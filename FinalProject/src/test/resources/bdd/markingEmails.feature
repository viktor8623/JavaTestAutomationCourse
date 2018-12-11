Feature: Marking emails

  Scenario: Marking first three emails with a flag
    Given I am in Inbox folder
    When I mark first "3" emails with a flag
    And Remove all flags
    Then There are no emails marked with a flag

  Scenario: Marking first three emails with as unread
    Given I am in Inbox folder
    When I mark first "3" emails as unread
    Then I see that counter of unread emails in nav bar has value "3"
    And I remove unread marks from first "3" emails
    And I see that counter unread emails is not displayed