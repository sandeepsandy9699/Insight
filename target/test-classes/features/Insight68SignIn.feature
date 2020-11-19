Feature: Insight68Feature
  User should be SignIn with valid credentials and do all functionality

  @FTC_1 @FTC
  Scenario: Validate SignIn Functionality
    Given User is on Insight68 SignIn page
    When User provides valid credentials and click on signin button
    Then User navigated to Dashboard page
    And Logout from Insight application

  @FTC_2 @FTC
  Scenario Outline: Validate the Email Error message text
    Given User is on Insight68 SignIn page
    Then User enter Invalid Email as "<Email>"
    And Validate Email Error message text

    Examples: 
      | Email |
      |       |

  @FTC_3 @FTC
  Scenario Outline: Validate the Password Error message text
    Given User is on Insight68 SignIn page
    Then User enter valid Email and invalid "<Password>"
    And validate Password Error message text

    Examples: 
      | Password |
      |          |

  @AddNewProduct
  Scenario: Create AddNewProduct in application
    Given User is on Insight68 SignIn page
    When User provides valid credentials and click on signin button
    Then Click on Products Tab
    And Click on Add New Product option
    Then Enter Product name in Product name textbox
    Then Enter Product Price in Product price textbox
    Then Select Trail duration in Trail duration Dropdown
    Then Select Product duration in Product duration Dropdown
    Then Browse the Product image
    Then Enter Product url if needed
    Then Browse the Product icon
    Then Enter Product description in Product description textbox
    And Click on Publish button

  @CreateCompany @UAT
  Scenario: Create CreateCompany in application
    Given User is on Insight68 SignIn page
    When User provides valid credentials and click on signin button
    Then Click on Company Mangement Tab
    And Click on Create Company option
    Then Select role in Dropdown
    Then Enter Company name in Company name textbox
    Then Enter First name in First name text box
    Then Enter Last name in Last name text box
    Then Enter Email Address in Email text box
    Then Enter Password in Password text box
    Then Enter Confirm Password in Confirm Password text box
    Then Click on Country dropdown and select country
    Then Click on State dropdown and select State
    Then Click on City dropdown and select City
    Then Enter Location in Location text box
    Then Enter Mobile number in Mobile number text box
    And Click on Submit button
    And Logout from Insight application
