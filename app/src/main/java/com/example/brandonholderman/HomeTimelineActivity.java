package com.example.brandonholderman;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.brandonholderman.twitterclient.R;

import java.util.ArrayList;

import Model.BHJson;
import Model.BHTweet;

public class HomeTimelineActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    private static final String TAG = "HomeTimelineActivity";
    ListView tweetsListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_timeline);

        setupListView();
        tweetsListView.setOnItemClickListener(this);

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

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        TextView textView = (TextView) view;
        Toast.makeText(this, "You clicked on " + textView.getText() + position, Toast.LENGTH_SHORT).show();
        Log.d(TAG, "You clicked on cell number " + position);
    }
}
