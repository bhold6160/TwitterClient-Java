package com.example.brandonholderman;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.brandonholderman.twitterclient.R;

import java.util.ArrayList;

import Model.BHJson;
import Model.BHTweet;

public class HomeTimelineActivity extends AppCompatActivity {

    private static final String TAG = "HomeTimelineActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_timeline);

        ArrayList<BHTweet> allTweets = BHJson.getTweets(this, true);

        for (BHTweet tweet : allTweets) {
            Log.d(TAG, "Tweet Text: " + tweet.text);
        }
    }
}
