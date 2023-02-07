package android.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {

    TextView mbookNamesTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mbookNamesTextView = (TextView) findViewById(R.id.bookNames);

        String[] bookNames = BookCollection.getBookNames();

        for (String bookName : bookNames) {
            mbookNamesTextView.append(bookName + "\n\n\n");

        }
    }
}