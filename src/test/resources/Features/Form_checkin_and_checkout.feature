Feature: User Interaction and Checkout

    Scenario: User goes through login, form submission, and checkout process
        Given the user is on the login page
        When the user enters valid username and password
        And the user clicks the login button

        When the user clicks the Check button
        Then the user should be navigated to the site list
        And the user clicks the Automation Bot site

        When the user enters data in the first form
        And submits the form
        Then the user should see a confirmation for the first form

        When the user enters data in the second form
        And submits the form
        Then the user should see a confirmation for the second form

        When the user enters data in the third form
        And submits the form
        Then the user should see a confirmation for the third form

        When the user clicks the Checkout button
        Then a confirmation pop-up should appear
        When the user confirms Yes
        Then the user should be checked out and see a checkout confirmation

        When the user clicks the Logout button
        Then the user should be logged out and redirected to the login page







