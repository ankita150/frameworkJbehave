GmailComposeMail story

Narrative:
In order to verify my login functionality

@composemail
Scenario: Login with Valid credentials and compose a mail
Given I have opened the gmail url
When I login with username and password
Then I should be able to compose a mail
When I enter the recipient and subject
Then I should be able to click on Send Button
When I enter text in search box and click on search