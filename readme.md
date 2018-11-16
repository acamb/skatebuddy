# SkateBuddy : a strava-connected application that manages your wheels
This software is distributed under MIT license.

## Scope
This software manages your Strava activities and keeps track of you wheel sets, wheel rotations and statistics using
the Strava API (see https://developers.strava.com/).

You can set a threshold in km to be notified when it's time to rotate your wheels, choose a default set of wheels for the activities
and manage wheel sets for each past activity: the software will keep track of KM and how many times you rotated a set!

Common statistics like max speed,average speed, max KM per activity and average KM per activities are displayed and you can choose to import activities on demand or automatically after each login and every night. 

This is not meant to be a product, this is only an example to show usage and interaction with the Strava APIs.

## User management
Authentication is achieved with x509 client certificates,which aren't managed and validated directly by the application:
please setup an Apache server to handle certificates and pass them to the application via AJP. 

Users are identified by the common name (CN) in the certificate.

A demo user is created in test mode (build with -Penv=test) if you connect directly to the tomcat.

## Translation
The application UI is multi-language ready, but currently only localized in italian: feel free to add other languages in `frontend/assets/i18n/`.

## Build and environments
You can build with `gradle build` as usual, 2 environments are provided: test and prod, via the gradle variable `env`

`test` allows to connect directly to the tomcat, skipping clients certificates and using `localhost` as callback url for strava API.

`prod` needs Apache Server and a CA configured. In addiction you have to configure the application on Strava with correct callback urls
and set `callbackURL` and `client.home` accordly in `application_prod.properties` file.

## Strava api and tokens
Communication with the APIs requires a valid `client_id` and `client_secret`, generated from Strava (see https://developers.strava.com/ ),
you can set this value as a VM option:

`java -DclientId=XXX -DclientSecret=XXX -jar SkateBuddy.jar`

