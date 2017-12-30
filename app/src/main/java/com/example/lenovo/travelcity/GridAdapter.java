package com.example.lenovo.travelcity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by DELL_PC on 05-10-2017.
 */

public class GridAdapter extends BaseAdapter
{
    Context context;
    private final String[] values;
    private final int[] images;
    View view;
    LayoutInflater layoutinflator;

    public GridAdapter(Context context, String[] values, int[] images)
    {
        this.context = context;
        this.values = values;
        this.images = images;
    }

    @Override
    public int getCount()
    {
        return values.length;
    }

    @Override
    public Object getItem(int position)
    {
        return null;
    }

    @Override
    public long getItemId(int position)
    {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        layoutinflator = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if(convertView == null)
        {
            view = new View(context);
            view = layoutinflator.inflate(R.layout.singleitem,null);
            ImageView gridimg = (ImageView) view.findViewById(R.id.gridimg);
            TextView gridtxt = (TextView) view.findViewById(R.id.gridtxt);
            gridimg.setImageResource(images[position]);
            gridtxt.setText(values[position]);
        }
        return view;
    }
}

