package Model;

import android.nfc.Tag;
import android.util.Log;

import org.json.JSONObject;

import static android.content.ContentValues.TAG;

/**
 * Created by brandonholderman on 9/16/17.
 */

public class BHUser {
    public String name;
    public String profileImageUrl;
    public String location;

    public BHUser(JSONObject userObject) {
        try {
            this.name = userObject.getString("name");
            this.profileImageUrl = userObject.getString("profile_image_url_https");
            this.location = userObject.getString("location");

        } catch (Exception exception) {
            Log.d(TAG, "BHUser: User Creation Exception - " + exception);
        }
    }
}
