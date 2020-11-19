$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Insight68SignIn.feature");
formatter.feature({
  "line": 1,
  "name": "Insight68Feature",
  "description": "User should be SignIn with valid credentials and do all functionality",
  "id": "insight68feature",
  "keyword": "Feature"
});
formatter.before({
  "duration": 8808262,
  "status": "passed"
});
formatter.scenario({
  "line": 5,
  "name": "Validate SignIn Functionality",
  "description": "",
  "id": "insight68feature;validate-signin-functionality",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 4,
      "name": "@FTC_1"
    },
    {
      "line": 4,
      "name": "@FTC"
    }
  ]
});
formatter.step({
  "line": 6,
  "name": "User is on Insight68 SignIn page",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "User provides valid credentials and click on signin button",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "User navigated to Dashboard page",
  "keyword": "Then "
});
formatter.step({
  "line": 9,
  "name": "Logout from Insight application",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "68",
      "offset": 18
    }
  ],
  "location": "StepDefinition.user_is_on_Insight_SignIn_page(int)"
});
formatter.result({
  "duration": 23296842513,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition.user_provides_valid_credentials_and_click_on_signin_button()"
});
formatter.result({
  "duration": 1704638537,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition.user_navigated_to_Dashboard_page()"
});
formatter.result({
  "duration": 10517057805,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition.logout_from_Insight_application()"
});
formatter.result({
  "duration": 5444348788,
  "status": "passed"
});
formatter.after({
  "duration": 803330334,
  "status": "passed"
});
formatter.scenarioOutline({
  "line": 12,
  "name": "Validate the Email Error message text",
  "description": "",
  "id": "insight68feature;validate-the-email-error-message-text",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 11,
      "name": "@FTC_2"
    },
    {
      "line": 11,
      "name": "@FTC"
    }
  ]
});
formatter.step({
  "line": 13,
  "name": "User is on Insight68 SignIn page",
  "keyword": "Given "
});
formatter.step({
  "line": 14,
  "name": "User enter Invalid Email as \"\u003cEmail\u003e\"",
  "keyword": "Then "
});
formatter.step({
  "line": 15,
  "name": "Validate Email Error message text",
  "keyword": "And "
});
formatter.examples({
  "line": 17,
  "name": "",
  "description": "",
  "id": "insight68feature;validate-the-email-error-message-text;",
  "rows": [
    {
      "cells": [
        "Email"
      ],
      "line": 18,
      "id": "insight68feature;validate-the-email-error-message-text;;1"
    },
    {
      "cells": [
        ""
      ],
      "line": 19,
      "id": "insight68feature;validate-the-email-error-message-text;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 2060242,
  "status": "passed"
});
formatter.scenario({
  "line": 19,
  "name": "Validate the Email Error message text",
  "description": "",
  "id": "insight68feature;validate-the-email-error-message-text;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 11,
      "name": "@FTC"
    },
    {
      "line": 11,
      "name": "@FTC_2"
    }
  ]
});
formatter.step({
  "line": 13,
  "name": "User is on Insight68 SignIn page",
  "keyword": "Given "
});
formatter.step({
  "line": 14,
  "name": "User enter Invalid Email as \"\"",
  "matchedColumns": [
    0
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 15,
  "name": "Validate Email Error message text",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "68",
      "offset": 18
    }
  ],
  "location": "StepDefinition.user_is_on_Insight_SignIn_page(int)"
});
formatter.result({
  "duration": 21866822681,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "",
      "offset": 29
    }
  ],
  "location": "StepDefinition.user_enter_Invalid_Email_as(String)"
});
formatter.result({
  "duration": 504815339,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition.validate_Email_Error_message_text()"
});
formatter.result({
  "duration": 98707196,
  "status": "passed"
});
formatter.after({
  "duration": 729780352,
  "status": "passed"
});
formatter.scenarioOutline({
  "line": 22,
  "name": "Validate the Password Error message text",
  "description": "",
  "id": "insight68feature;validate-the-password-error-message-text",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 21,
      "name": "@FTC_3"
    },
    {
      "line": 21,
      "name": "@FTC"
    }
  ]
});
formatter.step({
  "line": 23,
  "name": "User is on Insight68 SignIn page",
  "keyword": "Given "
});
formatter.step({
  "line": 24,
  "name": "User enter valid Email and invalid \"\u003cPassword\u003e\"",
  "keyword": "Then "
});
formatter.step({
  "line": 25,
  "name": "validate Password Error message text",
  "keyword": "And "
});
formatter.examples({
  "line": 27,
  "name": "",
  "description": "",
  "id": "insight68feature;validate-the-password-error-message-text;",
  "rows": [
    {
      "cells": [
        "Password"
      ],
      "line": 28,
      "id": "insight68feature;validate-the-password-error-message-text;;1"
    },
    {
      "cells": [
        ""
      ],
      "line": 29,
      "id": "insight68feature;validate-the-password-error-message-text;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 1240275,
  "status": "passed"
});
formatter.scenario({
  "line": 29,
  "name": "Validate the Password Error message text",
  "description": "",
  "id": "insight68feature;validate-the-password-error-message-text;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 21,
      "name": "@FTC"
    },
    {
      "line": 21,
      "name": "@FTC_3"
    }
  ]
});
formatter.step({
  "line": 23,
  "name": "User is on Insight68 SignIn page",
  "keyword": "Given "
});
formatter.step({
  "line": 24,
  "name": "User enter valid Email and invalid \"\"",
  "matchedColumns": [
    0
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 25,
  "name": "validate Password Error message text",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "68",
      "offset": 18
    }
  ],
  "location": "StepDefinition.user_is_on_Insight_SignIn_page(int)"
});
formatter.result({
  "duration": 24972361538,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "",
      "offset": 36
    }
  ],
  "location": "StepDefinition.user_enter_valid_Email_and_invalid(String)"
});
formatter.result({
  "duration": 948239520,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition.validate_Password_Error_message_text()"
});
formatter.result({
  "duration": 24629816,
  "status": "passed"
});
formatter.after({
  "duration": 791366791,
  "status": "passed"
});
});