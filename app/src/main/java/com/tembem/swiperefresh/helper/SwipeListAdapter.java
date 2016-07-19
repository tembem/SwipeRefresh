package com.tembem.swiperefresh.helper;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.text.method.MovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.tembem.swiperefresh.R;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by jim on 19/07/16.
 */

public class SwipeListAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<Movie> movieList;
    private String[] bgColors;

    public SwipeListAdapter(Activity activity, List<Movie> movieList) {
        this.activity = activity;
        this.movieList = movieList;
        bgColors = activity.getApplicationContext().getResources().getStringArray(R.array.movie_serial_bg);
    }

    @Override
    public int getCount() {
        return movieList.size();
    }

    @Override
    public Object getItem(int i) {
        return movieList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (inflater == null) {
            inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        if (view == null) {
            view = inflater.inflate(R.layout.list_row, null);
        }

        TextView serial = (TextView)view.findViewById(R.id.serial);
        TextView title = (TextView)view.findViewById(R.id.title);

        serial.setText(String.valueOf(movieList.get(i).id));
        title.setText(String.valueOf(movieList.get(i).title));

        String color = bgColors[i % bgColors.length];
        serial.setBackgroundColor(Color.parseColor(color));

        return view;
    }
}
