@autoQuote
Feature: Auto Quote Validation

Scenario: Validating Landing Page
Given user is in the landing page
When user select 'Auto' from products
And user enter '11418' in zipcode
And user click 'start a quote' button
Then user will be in a page title 'Step 1 of 9'