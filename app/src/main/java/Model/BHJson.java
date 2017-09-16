package Model;

import android.content.Context;
import java.io.InputStream;
import android.util.Log;


/**
 * Created by brandonholderman on 9/16/17.
 */

public class BHJson {
    private static final String TAG = "BHJson";

    public static String getSampleJSONAsString(Context context) {
        StringBuilder stringBuilder= new StringBuilder();

        String jsonString = null;

        try {
            InputStream stream = context.getAssets().open("Tweet.json");
//            Integer jsonDataLength = stream.available();

            byte[] buffer = new byte[stream.available()];

            stream.read(buffer);
            stream.close();

            jsonString = new String(buffer, "UTF-8")
        } catch (Exception exception) {
            Log.d(TAG, "getSampleJSONAsString: " + exception);
        }
        return jsonString;
    }
}
