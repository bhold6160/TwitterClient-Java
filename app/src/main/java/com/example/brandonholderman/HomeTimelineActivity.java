package com.example.brandonholderman;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.brandonholderman.twitterclient.R;

import java.util.ArrayList;

import Model.BHJson;
import Model.BHTweet;

public class HomeTimelineActivity extends AppCompatActivity {

    private static final String TAG = "HomeTimelineActivity";
    private ListView tweetsListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_timeline);

        setupListView();

        ArrayList<BHTweet> allTweets = BHJson.getTweets(this, true);

        for (BHTweet tweet : allTweets) {
            Log.d(TAG, "Tweet Text: " + tweet.text);
        }
    }

    private void setupListView() {
        tweetsListView = (ListView) findViewById(R.id.tweet_list_view);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1);
        tweetsListView.setAdapter(adapter);
        ArrayList<BHTweet> showTweets = BHJson.getTweets(this, true);
        adapter.addAll(showTweets);
        adapter.notifyDataSetChanged();
    }
}
