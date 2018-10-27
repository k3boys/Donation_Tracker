package com.example.davidgong.donation_tracker;

import android.os.Bundle;
import android.app.Activity;
import android.widget.TextView;

public class LocationDetailActivity extends Activity {


    private Model model = Model.getInstance();
    private TextView nameText, typeText, coordinatesText, addressText, phoneNumberText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_detail);

        nameText = (TextView) findViewById(R.id.locationName);
        typeText = (TextView) findViewById(R.id.locationType);
        coordinatesText = (TextView) findViewById(R.id.locationCoordinates);
        addressText = (TextView) findViewById(R.id.locationAddress);
        phoneNumberText = (TextView) findViewById(R.id.locationPhoneNumber);

        nameText.setText(model.getActiveLocationName());
        typeText.setText(model.getActiveLocationType() + "\n");
        coordinatesText.setText("GPS Coordinates: (" + model.getActiveLocationLatatude() + "," + model.getActiveLocationLongitude() + ")");
        addressText.setText(model.getActiveLocationStreet() + "\n" + model.getActiveLocationCity() + "," + model.getActiveLocationState()
        + "," + model.getActiveLocationZip());
        phoneNumberText.setText(model.getActiveLocationPhone());
    }


}
