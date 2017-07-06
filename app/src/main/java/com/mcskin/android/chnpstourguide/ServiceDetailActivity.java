package com.mcskin.android.chnpstourguide;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;



public class ServiceDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_detail);

        //Get the properties of the Place Object from the intent
        Bundle bundle = getIntent().getExtras();
        String serviceName = bundle.getString(getString(R.string.title_var));
        String serviceNote = bundle.getString(getString(R.string.note_var));
        String serviceDescription = bundle.getString(getString(R.string.description_var));
        int serviceImage = bundle.getInt(getString(R.string.image_var));

        //Set the name of the place as the title of the screen
        this.setTitle(serviceName);



        //Activate Up Button to enable the navigation back to the MainActivity
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Set the Title of the service to the Title in the activity_place_details.xml
        TextView titleTextView = (TextView)findViewById(R.id.service_detail_title);
        titleTextView.setText(serviceName);


        //Set the Title of the service to the Title in the activity_place_details.xml
        TextView descriptionTextView = (TextView)findViewById(R.id.service_detail_description);
        descriptionTextView.setText(serviceDescription);

        //Set the Image of the service to the Image in the activity_place_details.xml
        ImageView imageView = (ImageView) findViewById(R.id.service_detail_image);
        imageView.setImageResource(serviceImage);

    }
}
