package com.example.lenovo.travelcity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class StationAdapter extends ArrayAdapter<StationItem> {

    private final Context context;
    private final ArrayList<StationItem> itemsArrayList;

    public StationAdapter(Context context, ArrayList<StationItem> itemsArrayList) {

        super(context, R.layout.station_row, itemsArrayList);

        this.context = context;
        this.itemsArrayList = itemsArrayList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);


        View rowView = inflater.inflate(R.layout.station_row, parent, false);


        TextView StationName = (TextView) rowView.findViewById(R.id.label);

        StationName.setText(itemsArrayList.get(position).getStationName());

        return rowView;
    }
}
