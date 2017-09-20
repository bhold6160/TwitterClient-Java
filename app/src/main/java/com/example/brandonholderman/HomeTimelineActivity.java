package com.example.brandonholderman;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
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
//        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_2);
//        tweetsListView.setAdapter(adapter);
//        ArrayList<BHTweet> showTweets = BHJson.getTweets(this, true);
//        adapter.addAll(showTweets);
//        adapter.notifyDataSetChanged();

        ArrayList<BHTweet> allTweets = BHJson.getTweets(this, true);

        TimelineAdapter adapter = new TimelineAdapter(allTweets);
        tweetsListView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        TextView textView = (TextView) view;
        Toast.makeText(this, "You clicked on " + textView.getText() + "at position " + position, Toast.LENGTH_SHORT).show();
        Log.d(TAG, "You clicked on cell number " + position);
    }

    class TimelineAdapter extends TweetListAdapter {

        public TimelineAdapter(ArrayList<BHTweet> allTweets) {
            super(allTweets);
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            BHTweet currentTweet = (BHTweet) getItem(i);
            view = getLayoutInflater().inflate(R.layout.tweet_list_item, null);

            TextView usernameView = (TextView) view.findViewById(R.id.textView_username);
            TextView tweetTextView = (TextView) view.findViewById(R.id.textView_tweet_text);

            usernameView.setText(currentTweet.user.name);
            tweetTextView.setText(currentTweet.text);

            return view;
        }
    }

    abstract class TweetListAdapter extends BaseAdapter {
        private ArrayList<BHTweet> allTweets;

        public TweetListAdapter(ArrayList<BHTweet> allTweets) {
            super();

            this.allTweets = allTweets;
        }

        @Override
        public int getCount() {
            return allTweets.size();
        }

        @Override
        public Object getItem(int i) {
            return allTweets.get(i);
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }
    }
}
