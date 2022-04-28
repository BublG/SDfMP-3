package com.example.relaxapp.ui.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.relaxapp.R;

public class NewsListAdapter extends ArrayAdapter<String> {
    private final Activity context;
    private final String[] mainTitles;

    public NewsListAdapter(Activity context, String[] mainTitles) {
        super(context, R.layout.news_item_layout, mainTitles);
        this.context = context;
        this.mainTitles = mainTitles;
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.news_item_layout, null, true);
        TextView titleText = (TextView) rowView.findViewById(R.id.block_title);
        titleText.setText(mainTitles[position]);
        return rowView;
    }
}
