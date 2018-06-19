package com.example.android.quakereport;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class EarthquakeArrayAdapter extends ArrayAdapter<EarthquakeEvent> {

    public EarthquakeArrayAdapter(Activity context,List<EarthquakeEvent> eventArrayList){
        super(context,0,eventArrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemview = convertView;

        if(listItemview == null){
            listItemview = LayoutInflater.from(getContext()).inflate(R.layout.earthquake_listitem,parent,false);
        }

        EarthquakeEvent currentEvent = this.getItem(position);

        TextView magnitude = (TextView) listItemview.findViewById(R.id.magnitude);
        double mag = currentEvent.getMagnitude();
        DecimalFormat format = new DecimalFormat("0.0");
        magnitude.setText(format.format(mag));

        GradientDrawable textgradient = (GradientDrawable) magnitude.getBackground();
        int magnitudeColor = getMagnitudeColor(currentEvent.getMagnitude());
        textgradient.setColor(magnitudeColor);

        TextView locationcity = (TextView) listItemview.findViewById(R.id.cityloc);
        locationcity.setText(formatLocation(currentEvent.getCityLoc())[1]);

        TextView offsetloc = (TextView) listItemview.findViewById(R.id.offsetloc);
        offsetloc.setText(formatLocation(currentEvent.getCityLoc())[0]);

        Date dateobj = new Date(currentEvent.getTimeInMilliseconds());
        TextView date = (TextView) listItemview.findViewById(R.id.date);
        date.setText(formatDate(dateobj));

        TextView time = (TextView) listItemview.findViewById(R.id.time);
        time.setText(formatTime(dateobj));
        return listItemview;
    }

    private int getMagnitudeColor(double magnitude) {
        int magnitudecolorid;
        int floorMagnitude = (int) Math.floor(magnitude);

        switch (floorMagnitude){
            case 1:
            case 0:
                magnitudecolorid = R.color.magnitude1;
                break;
            case 2:
                magnitudecolorid = R.color.magnitude2;
                break;
            case 3:
                magnitudecolorid = R.color.magnitude3;
                break;
            case 4:
                magnitudecolorid = R.color.magnitude4;
                break;
            case 5:
                magnitudecolorid = R.color.magnitude5;
                break;
            case 6:
                magnitudecolorid = R.color.magnitude6;
                break;
            case 7:
                magnitudecolorid = R.color.magnitude7;
                break;
            case 8:
                magnitudecolorid = R.color.magnitude8;
                break;
            case 9:
                magnitudecolorid = R.color.magnitude9;
                break;
            default:
                magnitudecolorid = R.color.magnitude10plus;
        }

        return ContextCompat.getColor(getContext(),magnitudecolorid);
    }



    /**
     * Return the formatted date string (i.e. "Mar 3, 1984") from a Date object.
     */
    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }

    /**
     * Return the formatted date string (i.e. "4:30 PM") from a Date object.
     */
    private String formatTime(Date dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);
    }

    private String[] formatLocation(String loc){
        String[] returnstring = new String[2];
        if(loc.contains(",")) {
            returnstring = loc.split(",");
        }
        else{
            returnstring[0] = "Near the";
            returnstring[1] = loc;
        }
        return returnstring;
    }

}
