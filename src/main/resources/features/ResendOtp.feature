Feature: Test User Service-Resend


  Scenario Outline: User ResendOtp
    When a user resend otp
    |userId|<userId>|
   
 
    Examples: 
    |userId|
    |USUD_0_2|