# Joke Library App

Used Gradle to build a joke-telling app, factoring functionality into libraries and flavors to keep the build simple. This app implements a Google Cloud Endpoints development server to supply the jokes. This project is part of the Android Nanodegree portfolio.

## App components

* A Java library that provides jokes
* A Google Cloud Endpoints (GCE) project that serves those jokes
* An Android Library containing an activity for displaying jokes
* An Android app that fetches jokes from the GCE module and passes them to the Android Library for display
* The free app variant displays interstitial ads between the main activity and the joke-displaying activity.

## Why this Project

As Android projects grow in complexity, it becomes necessary to customize the
behavior of the Gradle build tool, allowing automation of repetitive tasks.
Particularly, factoring functionality into libraries and creating product
flavors allow for much bigger projects with minimal added complexity.


