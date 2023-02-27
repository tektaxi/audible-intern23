package android.example.finalproject.Utilities;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public final class NetworkUtils {

    // returns the default base url, takes no parameters - needs n
    public static URL buildURL() {
        URL baseURL = null;
        try {
            baseURL = new URL("https://raw.githubusercontent.com/tektaxi/audible-intern23/main/sampledata.json");
            System.out.println(baseURL.toString());
        }
        catch (MalformedURLException ex) {
            ex.printStackTrace();
        }

        return baseURL;

    }
//

    public static String getResponseFromHttpUrl(URL url) throws IOException {
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        try {
            InputStream in = urlConnection.getInputStream();

            Scanner scanner = new Scanner(in);
            scanner.useDelimiter("\\A");

            boolean hasInput = scanner.hasNext();
            if (hasInput) {
                return scanner.next();
            } else {
                return null;
            }
        } finally {
            urlConnection.disconnect();
        }
    }


}
