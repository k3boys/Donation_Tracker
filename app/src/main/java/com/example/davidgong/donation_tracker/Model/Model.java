package com.example.davidgong.donation_tracker.Model;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

public class Model {
    //Singleton Model
    private static final Model instance = new Model();
    private LocationManager locationManager;
    private AccountManager accountManager;
    private HashMap<String, Account> accounts;

    private Model() {
        accounts = new HashMap<>();
        locationManager = new LocationManager();
        accountManager = new AccountManager();
    }

    public static Model getInstance() {
        return instance;
    }
    //LocationManager Methods
    public void readLocations(InputStream is) {
        locationManager.readLocations(is);
    }

    public int numberOfLocations() {
        return locationManager.numberOfLocations();
    }

    public void setActiveLocation(int index) {
        locationManager.setActiveLocation(index);
    }

    public String getActiveLocationZip() {
        return locationManager.getActiveLocationZip();
    }

    public String getActiveLocationState() {
        return locationManager.getActiveLocationState();
    }

    public String getActiveLocationCity() {
        return locationManager.getActiveLocationCity();
    }

    public String getActiveLocationStreet() {
        return locationManager.getActiveLocationStreet();
    }

    public double getActiveLocationLongitude() {
        return locationManager.getActiveLocationLongitude();
    }

    public double getActiveLocationLatatude() {
        return locationManager.getActiveLocationLatatude();
    }

    public String getActiveLocationType() {
        return locationManager.getActiveLocationType().toString();
    }

    public String getActiveLocationName() {
        return locationManager.getActiveLocationName();
    }

    public String getActiveLocationPhone() {
        return locationManager.getActiveLocationPhone();
    }

    public List<Location> getLocations() {
        return locationManager.getLocations();
    }

    //AccountManager Methods
    public boolean addAccount(String username, String password) {
        accounts.put(username, new Account(username, password));
        return accountManager.addAccount(username, password);
    }

    public boolean usedUsername(String username) {
        return accountManager.usedUsername(username);
    }

    public boolean isAccount(String username, String password) {
        return accountManager.isAccount(username, password);
    }

    public void loginAccount(String username) {
        accountManager.loginAccount(username);
    }
    //Account Methods
    public boolean validPassword(String password) {
        return Account.validPassword(password);
    }

    public boolean validUsername(String username) {
        return Account.validUsername(username);
    }
}
