package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.os.AsyncTask;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;

import za.co.gundula.app.backend.myApi.MyApi;

/**
 * Created by kgundula on 2016/11/11.
 */

public class EndpointsAsyncTask extends AsyncTask<Object, Object, Void> {

    private static MyApi myApi = null;
    private Context context;
    String joke = "";

    @Override
    protected Void doInBackground(Object... params) {

        if (myApi == null) {
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                    .setRootUrl("https://jokesonyou-149509.appspot.com/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> request) throws IOException {

                        }
                    });
            builder.setApplicationName("jokesonyou-149509");
            myApi = builder.build();
        }

        try {
            joke = myApi.getJoke().execute().getData();
        } catch (IOException io) {
            io.printStackTrace();
        }

        return null;

    }

    @Override
    protected void onPostExecute(Void avoid) {
        super.onPostExecute(avoid);
    }

    public String getJoke() {
        return joke;
    }


}
