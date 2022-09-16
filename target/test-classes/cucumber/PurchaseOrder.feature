Feature: Purchase Order from the E-Commerce Site

Background: 
Given launch the E-Commerce Site


Scenario Outline: Purchase and submit the Order

Given Login using username <user> and <password>
When Add <product> to Cart
And Submit and click Place Order
Then Successfully purchased the <product>

Examples:
|user						|password		|product		|
|johnhillnhorr01@gmail.com	|Testing123		|IPHONE 13 PRO  |

