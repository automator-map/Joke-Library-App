package com.udacity.gradle.jokesapp;

import android.app.Application;
import android.test.ApplicationTestCase;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;


/**
 * Created by marceloabril-pro on 15-12-19.
 */

public class JokeRetrievedTest extends ApplicationTestCase<Application> {

    CountDownLatch mSignal;


    public JokeRetrievedTest() {
        super(Application.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        validateResultNonEmpty();
    }

    public void validateResultNonEmpty() {

        String joke = null;

        EndpointsAsyncTask asyncTask = new EndpointsAsyncTask();
        asyncTask.execute(getContext());

        try {
            mSignal = new CountDownLatch(1);

            // Wait for a few seconds before trying to get the result from the AsyncTask
            mSignal.await(5, TimeUnit.SECONDS);

            // Try to get the result from the AsyncTask after the elapsed time has passed
            joke = asyncTask.get();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            assertNotNull("Joke retrieved is null", joke);
            assertTrue("Joke is empty", !joke.isEmpty());
        }


    }

}
