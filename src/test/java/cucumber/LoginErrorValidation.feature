Feature: Error Validation

Scenario Outline: Purchase and submit the Order

Given launch the E-Commerce Site
When Login using username <user> and <password>
Then "Incorrect email or password." is displayed

Examples:
|user						|password		|
|johnhillnhorr01@gmail.com	|Testing1234	|

