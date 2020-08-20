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

Scenario: Verify that 'Add to Cart' .

Given User is on Index Page
When User clicks on T-Shirts submenu under Womens menu in Index Page
Then the T-Shirts list page is displayed
When User clicks on Add to Cart button on 1st T-Shirt
And User clicks on Proceed to Checkout
Then the Checkout page is displayed
When User clicks on Proceed to checkout in Summary tab
Then User should see Sign in tab

Scenario: Verify that 'Add to WishList' only works after login.

Given User is on Index Page
When User clicks on T-Shirts submenu under Womens menu in Index Page
Then the T-Shirts list page is displayed
When User clicks on Add to WishList Link on 1st T-Shirt
Then User should see Add to WishList Error Message

