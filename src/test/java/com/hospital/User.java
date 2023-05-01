package com.hospital;

public class User {
    private String logName;
    private String password;
    private String stationXpathLocator;

    public String getLogName() {
        return logName;
    }

    public String getPassword() {
        return password;
    }

    public String getStationXpathLocator() {
        return stationXpathLocator;
    }

    public User setLogName(String logName) {
        this.logName = logName;
        return this;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public User setStationXpathLocator(String stationXpathLocator) {
        this.stationXpathLocator = stationXpathLocator;
        return this;
    }

    @Override
    public String toString() {
        return "User{" +
                "logName='" + logName + '\'' +
                ", password='" + password + '\'' +
                ", stationXpathLocator='" + stationXpathLocator + '\'' +
                '}';
    }
}