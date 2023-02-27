package android.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;
import android.example.finalproject.Utilities.JSONFormatUtils;
import android.example.finalproject.Utilities.NetworkUtils;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;
import org.json.JSONException;
import java.io.IOException;
import java.net.URL;
public class MainActivity extends AppCompatActivity {

    TextView mbookNamesTextView;
    // view related stuff in MainActivity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mbookNamesTextView = (TextView) findViewById(R.id.bookNames);
        mbookNamesTextView.setText("loading...");

        new FetchBooksTask().execute();

    }
    public class FetchBooksTask extends AsyncTask<String, Void, String[]> {
        // move to separate tasks class when converting to MVP/MVVM
        @Override
        protected void onPreExecute() {
            mbookNamesTextView.setText("");
        }
        @Override
        protected String[] doInBackground(String... params) {
            URL bookRequestURL = NetworkUtils.buildURL();

            try {
                String jsonResponse = NetworkUtils.getResponseFromHttpUrl(bookRequestURL);
                String[] bookArray = JSONFormatUtils.toBookList(jsonResponse);
                return bookArray;
            }
            catch (IOException | JSONException e) {
                e.printStackTrace();
            }
            return null;
        }
        @Override
        protected void onPostExecute(String[] data) {
            for (String book : data) {
                mbookNamesTextView.append(book + "\n");
            }
        }
    }
}