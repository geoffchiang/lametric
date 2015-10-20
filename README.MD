# Java client for LaMetric Time

## Instructions
* Go to the LaMetric developer portal and click the "Create New App" button.  Select an "Indicator App".
* On the app creation screen, add as many frames as you require.  Make sure you add the right type of frame for each piece of data that you want to push to your app.
* In the "Select communication type" section, select "Push".
* Click the "Next" button
* Pick an icon for you app (or create one), give you app a name and a description.  Make sure that the "Private app" checkbox is checked, and click the "Save" button.
* On the next page you'll see some details about your unpublished app.  The URL value for the "Push URL" item will contain you app ID - it's the bit matching "com.lametric.<bunch of alphanumeric characters>, but not including the "/1" at the end of the URL (that's the app version).  Copy the app ID and record it somewhere.
* Copy the "Access token" value as well, you'll need that too.
* Click the "Publish" button near the top of the page.  You should receive an email notification in about a minute confirming that your app has been published.
* Open the LaMetric app on your mobile device.  Select your device to see the installed apps, then select the "+" button to add a new app.
* After the store loads, hit the "All" drop-down at the top of the screen, then select "Private".  Your app should be displayed.  Select the "Add" button to install it.  When it is done, your LaMetric should display your app, cycling through the frames you configured when creating the app.
* Download the code in this project and open Main.java in an editor.  Replace the values of the APP_ID and ACCESS_TOKEN constants with the values that you recorded earlier.
* Modify the lines creating frames to match the frames that you configured when creating the app:
** Name/Metric frames = TextFrame class (the Name and Metric frames seem to be the same, but the latter specifically uses the green arrow #120, red arrow #120 and blue equals #401 icons).
** Goal frame = GoalDataFrame class
** Sparkline frame = SparklineFrame class
* Make sure that the index values for each of your frames is correct.
* Run the Main class.  Once it is complete, your LaMetric should display the updated data.

## Gotchas
* I'm not entirely sure why, but whatever you set the first value in Sparkline chart data to, it always seems to come out as zero on the LaMetric.
