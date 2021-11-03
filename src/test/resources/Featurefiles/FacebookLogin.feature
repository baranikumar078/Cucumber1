Feature: Validate the Facebook Login Detail
Scenario: Validate Login with Invalid Username and Invalid Password
Given The User should launch the Chrome Browser
When The User should type the Url
And The User should maximize the windows
And The User should type the Invalid Username Invalid Password
And The User should Click the Login button
Then The User should Navigate to Incorrect Credential page

Scenario Outline:  Validate Login with Invalid Username and valid Password
Given The User should launch the Chrome Browser
When The User should type the Url
And The User should maximize the windows
And The User should get the Title of the Current Webpage
And The User should type the Invalid Username"<User>" valid Password"<Pass>"
And The User should Click the Login button
Then The User should Navigate to Incorrect Credential page

Examples:
|User|Pass|
|Barani|djf@12345|
|Karthik|wbfb@123134|
#|Nanda|48964@qbewd|
#|Krish|211@dfn6556|
#|Susan|785451@fnsk|
#|Anitha|7846@jefwie|
#|Suganya|7435@bfrf|
#|Muthazhagan|bfsugre@24754|
#|Santhosh|12345@sdnkjedb|
