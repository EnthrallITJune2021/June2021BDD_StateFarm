@autoQuote
Feature: Auto Quote Validation

Scenario: "Validating Landing Page"
Given user is in the landing page
When user select "Auto" from product
And insert "11418" into zipcode
And click on "start a quote" button
Then user will be in a page title "Step 1 of 9"