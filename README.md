# EZ Bike Hire

EZ Bike Hire is an android app that I have created as part of my Mobile App Development module. It is as the title suggests a bicycle hire app. The app utilises firebase

## Login/Register

Please enter a valid email and a password with at least 6 characters

```bash
e.g. johndoe@gmail.com + pass123
```

## Main Activity

At this stage you can decide what you would like to do, if you would like some more information on the app click the button labelled "How it Works"

### How it Works

Upon starting this activity you will be greeted with a YouTube video which represents how this app would be explained.

### Check the Map

This will launch a Google Maps Activity which showcases a number of markers representing bicycle locations. If you see a suitable marker, return to the Main Activity and click the button labelled "Manage Booking"

### Manage Booking

On this screen you must enter your booking details, including the location you chose on the last screen. Choose the bike/location and the number of hours you would like to hire for from the dropdown menus. Choose a date from the DatePicker. Now click "Confirm Booking", and your booking will be saved to the Firebase Realtime Database. Click "View Bookings" if you would like to see your booking history.

###

This displays all bookings saved to the database. Unfortunately the search option is not functional here.

## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update tests as appropriate.
