package Model;

import android.util.Log;

import org.json.JSONObject;

/**
 * Created by brandonholderman on 9/16/17.
 */

public class BHTweet {
    private static final String TAG = "BHTweet";

    public String text;
    public String id;

    public BHUser user;

    public BHTweet(JSONObject tweetObject) {
        try {
            this.text = tweetObject.getString("text");
            this.id = tweetObject.getString("id_str");

            this.user = new BHUser(tweetObject.getJSONObject("user"));
        } catch (Exception exception) {
            Log.d(TAG, "BHTweet: Tweet Creation Exception - " + exception);
        }
    }
}
