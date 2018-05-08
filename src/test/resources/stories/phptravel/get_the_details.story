Meta: Get Details
Narrative:

As a user dsd
I want to perform an action sd
So that I can achieve a business goal

Scenario:  Booking
Given select "Toronto" as the City
Given optional: Change the dates. (You can leave as default)
Given choose 3 Adults and 2 Childs
When do the search
Then get the Number of Results(Optional).. If 0 Results go back using the browser navigation
When do the search again same values except the city, leave empty
When get the number of Results(Optional)
When choose any of the results and click Details
When wait for the page to load
Then get the details text and store in a variable to display on your output console