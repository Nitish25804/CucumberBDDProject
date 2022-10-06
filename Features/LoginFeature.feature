Feature: Login

@Sanity
Scenario: Sucessful Login With Valid Creanditials
  Given User Lunch Chrome Browser
  When User Open URL "https://admin-demo.nopcommerce.com/login"
  And User Enter Email as "admin@yourstore.com" and Password as "admin"
  And Click On Login  
  Then Page Title Should Be "Dashboard / nopCommerce administration"
  When User Click on Log Out Link
  Then Page Title Should Be "Your store. Login"
  And Close The Browser

@Regression  
Scenario: Sucessful Login With Valid Creanditials
  Given User Lunch Chrome Browser
  When User Open URL "https://admin-demo.nopcommerce.com/login"
  And User Enter Email as "<Email>" and Password as "<Password>"
  And Click On Login
  Then Page Title Should Be "Dashboard / nopCommerce administration"
  When User Click on Log Out Link
  Then Page Title Should Be "Your store. Login"
  And Close The Browser
  
Examples:

|Email|Password|
|admin@yourstore.com|admin|
|user@yourstore.com|admin|