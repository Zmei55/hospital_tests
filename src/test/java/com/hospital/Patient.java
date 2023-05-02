package com.hospital;

public class Patient {
    private String name;

    public String getName() {
        return name;
    }

    public Patient setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "name='" + name + '\'' +
                '}';
    }
}