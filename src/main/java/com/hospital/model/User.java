package com.hospital.model;

public class User {
    private String logName;
    private String password;
    private String station;

    public String getLogName() {
        return logName;
    }

    public String getPassword() {
        return password;
    }

    public String getStation() {
        return station;
    }

    public User setLogName(String logName) {
        this.logName = logName;
        return this;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public User setStation(String station) {
        this.station = station;
        return this;
    }

    @Override
    public String toString() {
        return "User{" +
                "logName='" + logName + '\'' +
                ", password='" + password + '\'' +
                ", stationXpathLocator='" + station + '\'' +
                '}';
    }
}