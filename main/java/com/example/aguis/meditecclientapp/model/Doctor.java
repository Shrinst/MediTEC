package com.example.aguis.meditecclientapp.model;

import java.util.Date;

/**
 * Created by aguis on 9/5/2017.
 */

public class Doctor {

    private String id;
    private String profileName;
    private int points;


    public Doctor() {

    }

    public Doctor(String id, String profileName, int points) {
        this.id = id;
        this.profileName = profileName;
        this.points = points;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getProfileName() {
        return profileName;
    }
    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

}