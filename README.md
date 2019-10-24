# Automation Engineer Technical test for TruNarrative

### This automated test will do the following steps:
1. Open google.com and search for "TruNarrative". If the first result is leading to"https://trunarrative.com/" test will click on it.
2. Test will check if web component containing phrase "Easy Onboarding.  Smooth Transactions.  Insightful Compliance" is present on web page
3. Test will go through the menu "More --> TruNarrative Team"
4. Test will count number of team members and compare it to number provided in the script
5. Test will look for member names and compare the names to roles provided in the script

Cucumber script [/src/test/resources/userStory.feature](https://github.com/AndyTomicki/TNTask/blob/master/src/test/resources/userStory.feature) can be edited to change data provided, like number of team members, their names and roles. Additional data can be added to the data table.

If any of the test steps fail, the whole test case will break and on that step.
This is only simple run-once test suite, no reporting is provided at the moment.

Test suite uses selenium webdriver for Chrome 78, Java 8.
