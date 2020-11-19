Feature: To verify the Security vulnerabilities using OWSAP ZAP

  @Security
  Scenario: Identify the vulnerabilities of application
    Given User navigated to insight68 application
    When User provides credentials and click on signin button
    Then Using the OWSAP ZAP application gets scaned and generate Report
