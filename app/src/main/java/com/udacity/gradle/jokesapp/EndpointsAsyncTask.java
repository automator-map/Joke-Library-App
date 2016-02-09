package com.udacity.gradle.jokesapp;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

import com.example.android.jokedisplay.JokeDisplay;
import com.example.backend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;


import java.io.IOException;

/**
 * Created by marceloabril-pro on 15-12-19.
 */
class EndpointsAsyncTask extends AsyncTask<Context, Void, String> {
    private static MyApi myApiService = null;
    private static Context mContext;

    @Override
    protected String doInBackground(Context ... params) {
        if(myApiService == null) {  // Only do this once

            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                    .setRootUrl("https://udacity-backend-project.appspot.com/_ah/api/");

            mContext = params[0];

            // end options for devappserver

            myApiService = builder.build();
        }

        try {
            return myApiService.tellJoke().execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        //Toast.makeText(context, result, Toast.LENGTH_LONG).show();

        Intent intent = new Intent(mContext, JokeDisplay.class);
        intent.putExtra(JokeDisplay.JOKE_KEY, result);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        mContext.startActivity(intent);

    }
}
