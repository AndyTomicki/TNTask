@run
Feature: Pass the technical test
  Scenario:
    Given I am on google website
    And I search for "TruNarrative"
    And First result is "https://trunarrative.com"
    Then Navigate to Tru Narrative website
    Then Check if Easy_Onboarding strap is present
    Then Navigate to TruNarrative Team subpage
    Then Verify if TruNarrative team consists of 9 members
    Then Check roles for the specific team members
    |Name             |Role                    |
    |John Lord        |Founder & CEO           |
    |David Eastaugh   |Chief Technology Officer|
    |Nicola Janney    |Human Resources Manager |