@commonFeature
Feature: Validating Common scenarios

Background: user is in landing page
Given user is in the landing page

Scenario Outline: Validating multiple products
Given user select <product> from products
And user enter <zipcode> in zipcode
And user click 'start a quote' button
Then user will be in a page title 'Step 1 of 9'
Examples:
|product		|zipcode|
|'Auto'			|'11418'|
|'Homeowners'	|'11417'|