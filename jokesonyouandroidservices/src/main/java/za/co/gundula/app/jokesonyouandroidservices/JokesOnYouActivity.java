package za.co.gundula.app.jokesonyouandroidservices;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class JokesOnYouActivity extends AppCompatActivity {

    public final static String INTENT_JOKES = "jokes_on_you";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jokes_on_you);

        Intent jokesIntent = getIntent();

        String joke = jokesIntent.getStringExtra(INTENT_JOKES);
        TextView jokeTextView = (TextView) findViewById(R.id.jokes_on_you_textview);
        if (joke != null && joke.length() != 0) {

            jokeTextView.setText(joke);
        }
    }
}
