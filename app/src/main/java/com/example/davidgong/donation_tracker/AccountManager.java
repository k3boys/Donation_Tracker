package com.example.davidgong.donation_tracker;

import java.util.HashMap;

public class AccountManager {
    private Account activeAccount;
    private HashMap<String, Account> accounts;

    public AccountManager() {
        accounts = new HashMap<>();
    }

    public boolean addAccount(String username, String password) {
        if (!usedUsername(username)) {
            accounts.put(username, new Account(username, password));
            return true;
        }
        return false;
    }

    public boolean usedUsername(String username) {
        username = username.toLowerCase();
        return accounts.containsKey(username);
    }

    public boolean isAccount(String username, String password) {
        return accounts.containsKey(username) && accounts.get(username).getPassword().equals(password);
    }

    public void loginAccount(String username) {
        activeAccount = accounts.get(username);
    }
}
