package com.example.davidgong.donation_tracker.Model;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class LocationManager {
    private Location activeLocation;
    private List<Location> locations;
    private static final int NAME_TOKEN = 1;
    private static final int LATITUDE_TOKEN = 2;
    private static final int LONGITUDE_TOKEN = 3;
    private static final int STREET_TOKEN = 4;
    private static final int CITY_TOKEN = 5;
    private static final int STATE_TOKEN = 6;
    private static final int ZIP_TOKEN = 7;
    private static final int TYPE_TOKEN = 8;
    private static final int PHONE_TOKEN = 9;



    public LocationManager() {
        locations = new ArrayList<>();
    }

    public LocationManager(InputStream is) {
        List<Location> locations = new ArrayList<Location>();
    }

    public void readLocations(InputStream is) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            br.readLine();
            String line;
            while((line = br.readLine()) != null) {
                String[] values = line.split(",");
                Location newLocation = new Location(
                        values[NAME_TOKEN],
                        LocationType.valueOf(values[TYPE_TOKEN].replaceAll("\\s", "_").toUpperCase()),
                        Double.parseDouble(values[LATITUDE_TOKEN]),
                        Double.parseDouble(values[LONGITUDE_TOKEN]),
                        values[STREET_TOKEN],
                        values[CITY_TOKEN],
                        values[STATE_TOKEN],
                        values[ZIP_TOKEN],
                        values[PHONE_TOKEN]);
                    locations.add(newLocation);
            }
        } catch (java.io.IOException ie) {
            //TODO : add code to fail gracefully
        }
    }

    public int numberOfLocations() {
        return locations.size();
    }

    public void setActiveLocation(int index) {
        activeLocation = locations.get(index);
    }

    public String getActiveLocationZip() {
        return activeLocation.getZip();
    }

    public String getActiveLocationState() {
        return activeLocation.getState();
    }

    public String getActiveLocationCity() {
        return activeLocation.getCity();
    }

    public String getActiveLocationStreet() {
        return activeLocation.getStreetAddress();
    }

    public double getActiveLocationLongitude() {
        return activeLocation.getLongitude();
    }

    public double getActiveLocationLatatude() {
        return activeLocation.getLatitude();
    }

    public LocationType getActiveLocationType() {
        return activeLocation.getType();
    }

    public String getActiveLocationName() {
        return activeLocation.getName();
    }

    public String getActiveLocationPhone() {
        return activeLocation.getPhoneNumber();
    }

    public List<Location> getLocations() {
        return locations;
    }
}
