@commonFeature
Feature: Validating Common scenarios

Background: user is in landing page
Given user is in the landing page

Scenario Outline: Validating multiple products
* user select <product> from products
* user enter <zipcode> in zipcode
* user click 'start a quote' button
Then user will be in a page title <title>
Examples:
|product		|zipcode|title				|
|'Auto'			|'11418'|'STEP 1 OF 9'		|
|'Homeowners'	|'11417'|'Homeowners Quote'	|

@findAccount
@Smoke
@Regression
Scenario Outline: Validating Find Account functionality
Given user validate landing page steps
When user select existing user flow
Then user validate Login Page <rowNumber>
Examples:
|rowNumber|
|1|
|2|
|3|
|4|