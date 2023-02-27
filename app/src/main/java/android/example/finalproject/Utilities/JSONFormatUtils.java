package android.example.finalproject.Utilities;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JSONFormatUtils {
    public static String[] toBookList(String rawJson) throws JSONException {
        JSONArray booksArray = new JSONObject(rawJson).getJSONArray("books");
        String[] stringArray = new String[booksArray.length()];

        for (int i = 0; i < booksArray.length(); i++) {
            JSONObject book = booksArray.getJSONObject(i);
            stringArray[i] = book.getString("title") + " by " +
                    book.getString("author");
        }
        return stringArray;
    }

}
