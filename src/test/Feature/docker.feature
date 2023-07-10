Feature: To validate Docker website logo
Scenario Outline: check the Docker logo and validate it
Given user launch Docker website with URL as "<url>"
Then user validate Docker logo
And user validate signIn link
And user validate Get Started link
And user validate the Products dropdown by Hovering it
And user scroll down to bottom of the page and validate "Accelerate your application development today."
And user validate all the social media links


Examples:
|url|
|https://www.docker.com/|




