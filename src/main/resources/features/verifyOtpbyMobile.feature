Feature: verify otp by mobile

  Scenario Outline: verify otp by mobile
  
    
   When user enter mobile details with otp
   |otp|<otp>|
   |userId|<userId>|
  |deviceName|<deviceName>|
  |deviceVersion|<deviceVersion>|
  |deviceOS|<deviceOS>|
  |deviceType|<deviceType>|
  |deviceId|<deviceId>|
  |deviceIMEINum|<deviceIMEINum>|
  
  
    Examples: 
    |otp 	|userId			|deviceName		|deviceVersion|deviceOS			|deviceType		|deviceId|deviceIMEINum|
    |9999	|USUD_0_1		|Vivo 1.2			|20.1					|Android 10		|ANDROID			|22222222|E12HJKJKJK123|
    
      
       
       
  
  