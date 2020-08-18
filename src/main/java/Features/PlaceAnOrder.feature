Feature: Place an Order in Techlistic

Scenario: Automate End to End Buy Order functionality

Given User is on Techlistic Login page
When User clicks on sign in providing Username and Password
Then the Homepage is displayed
When User clicks on T-Shirts submenu under Womens menu
Then the T-Shirts list page is displayed
When User clicks on More button on 1st T-Shirt
Then the customize product page is displayed
When User adds T-Shirt by customizing and clicks on checkout
Then the Checkout page is displayed
When User Checkout the T-Shirt by confirming 
Then the order Confirmation message is displayed