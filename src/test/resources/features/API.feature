Feature: To verify API automation with Rest Assured

  @API_GET
  Scenario: To verify Get tenant count Rest service
    Given To initiate base uri and required headers
      | http://14.143.13.67:2137 |
    Then Create Request object for GET method
      | /admintask/users/getClientMasteruserCount/nk@maill.com |
    And Validate the Response status code and status line

  @API_GET
  Scenario: To verify Get User Details Rest service
    Given To initiate base uri and required headers
      | http://14.143.13.67:2137 |
    Then Create Request object for GET method
      | /admintask/users/getTenantCount |
    And Validate the Response status code and status line

  @API_POST
  Scenario: To verify Rest service for user registration - POST Method
    Given To initiate base uri and required headers
      | http://14.143.13.67:8093 |
    Then Create Request object creation for POST method and get Responce with following data
      | firstname | lastname | email                 | mobilenumber | extensionNumber | username              | password | passwordConfirm | country | state     | city      | authorities | EndPoint                          | contenttype      |
      | test      | user     | testuser123@gmail.com |   7702554564 |              91 | testuser121@gmail.com | testuser | testuser        | India   | Telangana | Hyderabad | ROLE_ADMIN  | /iaassmssecurity/api/registration | application/json |
      | test      | user     | testuser124@gmail.com |   7702554564 |              91 | testuser122@gmail.com | testuser | testuser        | India   | Telangana | Hyderabad | ROLE_ADMIN  | /iaassmssecurity/api/registration | application/json |
    And Validate the Response status code and status line

  @API_PUT
  Scenario: To verify Rest service - PUT Method
    Given To initiate base uri and required headers
      | http://localhost:2175 |
    Then Create Request object for PUT method
      | username | productId | endDate | EndPoint                                                            |
      |          |           |         | /paaslicense/license/extendLicense/{username}/{productId}/{endDate} |
    And Validate the Response status code and status line

  @API_DELETE
  Scenario: To verify Delete Pdoduct Rest service
    Given To initiate base uri and required headers
      | https://reqbin.com/ |
    Then Create Request object for DELETE method
      | EndPoint            |
      | /sample/delete/json |
    And Validate the Response status code and status line
