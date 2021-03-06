package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;

import za.co.gundula.app.jokesonyouandroidservices.JokesOnYouActivity;

public class MainActivity extends AppCompatActivity {

    EndpointsAsyncTask endpointsAsyncTask;
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        // progressBar
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(View view) {
        progressBar.setVisibility(View.VISIBLE);
        endpointsAsyncTask = new EndpointsAsyncTask() {
            @Override
            protected Void doInBackground(Object... params) {
                super.doInBackground(params);
                String joke = endpointsAsyncTask.getJoke();
                Intent jokeIntent = new Intent(MainActivity.this, JokesOnYouActivity.class);
                jokeIntent.putExtra(JokesOnYouActivity.INTENT_JOKES, joke);
                startActivity(jokeIntent);
                return null;
            }

            @Override
            protected void onPostExecute(Void avoid) {
                super.onPostExecute(avoid);
                progressBar.setVisibility(View.GONE);
            }
        };
        endpointsAsyncTask.execute();
        //endpointsAsyncTask.

    }
    
}
