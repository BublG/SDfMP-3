package com.example.relaxapp.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.relaxapp.R;
import com.example.relaxapp.ui.MainActivity;
import com.example.relaxapp.ui.adapter.NewsListAdapter;

public class FeedFragment extends Fragment {

    private ListView newsListView;
    private MainActivity mainActivity;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View feedFragmentView = inflater.inflate(R.layout.fragment_feed, container, false);
        mainActivity = (MainActivity) getActivity();
        TextView usernameTextView = feedFragmentView.findViewById(R.id.username_on_feed);
        usernameTextView.setText(mainActivity.getLoggedUser().getUsername());

        newsListView = feedFragmentView.findViewById(R.id.news_listview);

        ImageView sportImageView = feedFragmentView.findViewById(R.id.sport);
        sportImageView.setOnClickListener(this::showSportNews);

        ImageView goodImageView = feedFragmentView.findViewById(R.id.good);
        goodImageView.setOnClickListener(this::showGoodNews);

        ImageView badImageView = feedFragmentView.findViewById(R.id.bad);
        badImageView.setOnClickListener(this::showBadNews);

        ImageView satisfiedImageView = feedFragmentView.findViewById(R.id.satisfied);
        satisfiedImageView.setOnClickListener(this::showSatisfiedNews);

        return feedFragmentView;
    }

    public void showSportNews(View view) {
        NewsListAdapter adapter = new NewsListAdapter(mainActivity, new String[]{"Sport", "Football", "CR7"});
        newsListView.setAdapter(adapter);
    }

    public void showGoodNews(View view) {
        NewsListAdapter adapter = new NewsListAdapter(mainActivity, new String[]{"OK!", "Good"});
        newsListView.setAdapter(adapter);
    }

    public void showBadNews(View view) {
        NewsListAdapter adapter = new NewsListAdapter(mainActivity, new String[]{"Bad news", "Death", "Rain"});
        newsListView.setAdapter(adapter);
    }

    public void showSatisfiedNews(View view) {
        NewsListAdapter adapter = new NewsListAdapter(mainActivity, new String[]{"Lab Completed"});
        newsListView.setAdapter(adapter);
    }
}