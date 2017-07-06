package com.mcskin.android.chnpstourguide;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by McSkin on 17/06/2017.
 */

public class ServiceAdapter extends ArrayAdapter<Service> {

    private Context context = getContext();


    /** Resource ID for the background color for list of services */
    private int mColorResourceId;

    public ServiceAdapter(Activity context, ArrayList<Service> services, int colorResourceId) {
        // Initialize the ArrayAdapter's internal storage for the context and the list.
        super(context, 0, services);
        mColorResourceId = colorResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link Service} object located at this position in the list
        Service currentService = getItem(position);

        //Get the object's properties
        String titleHead = currentService.getTitleHead();
        String note = currentService.getNote();
        String noteDescription = currentService.getNoteDescription();
        int imageResourceID = currentService.getImageResourceId();


        // Find the TextView in the list_item.xml layout with the title head
        TextView titleTextView = (TextView)listItemView.findViewById(R.id.title_text_view);
        // Get the title head of the current Service object and
        // set this text on the title head TextView
        titleTextView.setText(titleHead);

        // Find the TextView in the list_item.xml layout with the note description
        TextView noteTextView =  (TextView)listItemView.findViewById(R.id.note_text_view);
        // Get the note description from the current Service object and
        // set this text on the note description TextView
        noteTextView.setText(note);

        // Find the ImageView in the list_item.xml layout with the ID image
        final ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);
        // Check if an image is provided for this word or not
        if (currentService.hasImage()) {
            // If an image is available, display the provided image based on the resource ID
            imageView.setImageResource(imageResourceID);
            // Make sure the view is visible
            imageView.setVisibility(View.VISIBLE);
        } else {
            // Otherwise hide the ImageView (set visibility to GONE)
            imageView.setVisibility(View.GONE);
        }

        // Set the theme color for the list item
        View textContainer = (View)listItemView.findViewById(R.id.text_container);
        // Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        // Set the background color of the text container View
        textContainer.setBackgroundColor(color);

        final Intent itemIntent = new Intent(context, ServiceDetailActivity.class);

        //Put the properties of the Object to the intent
        itemIntent.putExtra(context.getString(R.string.title_var), titleHead);
        itemIntent.putExtra(context.getString(R.string.note_var), note);
        itemIntent.putExtra(context.getString(R.string.description_var), noteDescription);
        itemIntent.putExtra(context.getString(R.string.image_var), imageResourceID);


        //Start the intent if the user taps on the list item
        listItemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(itemIntent);
            }
        });

      // Return the whole list item layout
        return listItemView;
    }

}

