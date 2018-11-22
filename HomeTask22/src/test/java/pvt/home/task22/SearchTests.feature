Feature: Test search results

  Scenario Outline: Test amount of search results
    Given I am on main application page
    When I enter "<city>" and "<checkInDaysFromToday>" and run the search
    Then I see at least one result of the search
    Examples:
          | city   | checkInDaysFromToday |
          | Moscow | 1                    |
          | Moscow | 2                    |

  Scenario Outline: Test rating of the best offer
    Given I am on main application page
    When I enter "<city>" and "<checkInDaysFromToday>" and run the search
     And I am clicking Top Reviewed option on the result page
     And I open the first offer
    Then I see that rating of the hotel >= 9
    Examples:
          | city   | checkInDaysFromToday |
          | Moscow | 1                    |
          | Moscow | 2                    |