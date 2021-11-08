@homeQuote
Feature: Validating Homeowners quote

Scenario: Validating Landing Page
Given user is in the landing page
When user select 'Home' from products
And user enter '11417' in zipcode
And user click 'start a quote' button
Then user will be in a page title 'Step 1 of 9'
