Feature: Actions with emails: movement and deleting

  Scenario: Moving email to Spam folder
    Given I am in Inbox folder
    And I have remembered the subject of the first email
    When I mark the first email as Spam
    And Go to Spam folder
    Then The email with the same subject is in the folder

  Scenario: Moving email to Trash folder
    Given I am in Inbox folder
    And I have remembered the subject of the first email
    When I delete the first email
    And Go to Trash folder
    Then The email with the same subject is in the folder

  Scenario: Marking email in Spam folder as NOT Spam
    Given I am in Inbox folder
    When Go to Spam folder
    And I have remembered the subject of the first email
    And I mark first email as NOT Spam
    Then The email with the same subject is not in the folder
    And Go to Inbox folder
    And The email with the same subject is in the folder

  Scenario: Moving email from Trash folder to Inbox
    Given I am in Inbox folder
    When Go to Trash folder
    And I have remembered the subject of the first email
    And I move the first email from Inbox from Trash
    And Go to Inbox folder
    Then The email with the same subject is in the folder

  Scenario: Moving email from Sent folder to Trash
    Given I am in Inbox folder
    When Go to Sent folder
    And I have remembered the subject of the first email
    And I delete the first email
    And Go to Trash folder
    Then The email with the same subject is in the folder

  Scenario: Deleting all emails in Trash folder
    Given I am in Inbox folder
    When I click Clear Trash folder link
    And Go to Trash folder
    Then The folder is empty
