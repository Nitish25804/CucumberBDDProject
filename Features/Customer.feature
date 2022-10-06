Feature: Customer

@Sanity
Scenario: Add New Customer
  Given User Lunch Chrome Browser
  When User Open URL "https://admin-demo.nopcommerce.com/login"
  And User Enter Email as "admin@yourstore.com" and Password as "admin"
  And Click On Login
  Then User Can View Dashboard
  When User Click On Customers Menu
  And Click On The Customer Menu Itoms
  And Click On Add New button
  Then User Can View Add New Customer Page
  When User Enter Customer Info
  And Click On The Save button
  Then User Can view Conformation Message "The new customer has been added successfully."
  And Close The Browser
