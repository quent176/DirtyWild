package fr.wcs.blablacrade;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class TripResultAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<TripResultModel> items;

    public TripResultAdapter(Context context, ArrayList<TripResultModel> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size(); //returns total of items in the list
    }

    @Override
    public Object getItem(int position) {
        return items.get(position); //returns list item at the specified position
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // inflate the layout for each list row
        if (convertView == null) {
            convertView = LayoutInflater.from(context).
                    inflate(R.layout.trip_item, parent, false);
        }

        // get current item to be displayed
        TripResultModel currentItem = (TripResultModel) getItem(position);

        // get the TextView for item name and item description
        TextView departure = (TextView)
                convertView.findViewById(R.id.texteresu1);
        TextView firstname = (TextView)
                convertView.findViewById(R.id.textres2);
        TextView price = (TextView)
                convertView.findViewById(R.id.txt);

        //sets the text for item name and item description from the current item object
        departure.setText(currentItem.getDate().toString());
        firstname.setText(currentItem.getPrenom());
        price.setText(String.valueOf(currentItem.getPrix()));

        // returns the view for the current row
        return convertView;
    }
}