package Model;

import android.content.Context;
import java.io.InputStream;
import java.util.ArrayList;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;


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

            jsonString = new String(buffer, "UTF-8");
        } catch (Exception exception) {
            Log.d(TAG, "getSampleJSONAsString: " + exception);
        }
        return jsonString;
    }

    public static ArrayList<BHTweet> getTweets(Context context, Boolean useSampleJSON) {
        ArrayList<BHTweet> tweets = new ArrayList<BHTweet>();

        if(useSampleJSON == true) {

//            String tweetsJSONString = getSampleJSONAsString(context);

            try {
                JSONArray tweetsJson = new JSONArray(getSampleJSONAsString(context));

                for (int i = 0; i < tweetsJson.length(); i++) {
                    JSONObject singleTweetObject = tweetsJson.getJSONObject(i);
                    tweets.add(new BHTweet(singleTweetObject));
                }
            } catch (Exception exception) {
                Log.d(TAG, "getTweets: Exception Parsing Tweets Array - " + exception);
            }
        }
        return tweets;
    }
}
