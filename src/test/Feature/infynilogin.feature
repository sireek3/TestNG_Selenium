Feature: To open infyni website
Given user launch infyni website
Then user validate infyni logo
When user click on signin button
Then user navigate to signin page.
And validate Rememberme checkbox is not checked by default
Then user input incorrect user id and password
And user see error message says invalid credentials
Then user clicks on dont have an account signup link
And user successfully navigated to signup page

  url |