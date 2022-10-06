Feature: SearchC

@Regression
Scenario: Search Customer By Email
  Given User Lunch Chrome Browser
  When User Open URL "https://admin-demo.nopcommerce.com/login"
  And User Enter Email as "admin@yourstore.com" and Password as "admin"
  And Click On Login
  Then User Can View Dashboard
  And Click On The Customer Menu Itoms
  And Enter Customer Email
  When Click On Search button
  Then User Should Found Email In Search Table
  And Close The Browser
  

@Rgression
Scenario: Search Customer By Name
  Given User Lunch Chrome Browser
  When User Open URL "https://admin-demo.nopcommerce.com/login"
  And User Enter Email as "admin@yourstore.com" and Password as "admin"
  And Click On Login
  Then User Can View Dashboard
  When User Click On Customers Menu
  And Click On The Customer Menu Itoms
  And Enter Customer First Name
  And Enter Customer Last Name
  When Click On Search button
  Then User Should Found Name In Search Table
  And Close The Browser