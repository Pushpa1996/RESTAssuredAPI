Feature: UserService-Login

  Scenario Outline: User Login with Mobile Number <mobileNumber>
    When a user enters following details
    |mobileNumber|<mobileNumber>|
    |deviceName|<deviceName>|
    |deviceVersion|<deviceVersion>|
    |deviceOS|<deviceOS>|
    |deviceType|<deviceType>|
    |deviceId|<deviceId>|
    |deviceIMEINum|<deviceIMEINum>|
  
  
  
    Examples: 
      | mobileNumber | deviceName | deviceVersion  | deviceOS    | deviceType |deviceId	|deviceIMEINum|
      #| 999999931    |Vivo 1.2     | 20.1 		       | Android 10   | ANDROID    |11122222	|-|
       | 9999999317    |Oppo 8.0     | 1-.1 		       | Android 12   | ANDROID    |11122233	|E12HJKJKJK124|
       | 7888794497    |Vivo 1.2| 20.1| Android 10 | ANDROID    |11122222|E12HJKJKJK123|
       
       
  Scenario Outline: User ResendOtp
    When a user resend otp
    |userId|<userId>|
   
 
    Examples: 
    |userId|
    |USUD_0_2|